package com.zp.generatecode.service;

import com.google.common.base.CaseFormat;
import com.zp.generatecode.model.Column;
import com.zp.generatecode.model.Table;
import com.zp.generatecode.utils.DBUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateService {
    @Value("${output.dir}")
    private String outputDir;

    Configuration cfg = null;
    {
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setTemplateLoader(new ClassTemplateLoader(GenerateService.class, "/templates"));
        cfg.setDefaultEncoding("UTF-8");
    }

    public Boolean generate(List<Table> list) {
        try {
            Connection connection = DBUtil.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            for (Table table : list) {
                ResultSet columns = metaData.getColumns(connection.getCatalog(), null, table.getTableName(), null);
                ResultSet primaryKeys = metaData.getPrimaryKeys(connection.getCatalog(), null, table.getTableName());
                List<Column> columnList = new ArrayList<>();
                List<String> pkList = new ArrayList<>();
                while(primaryKeys.next()){
                    String pkName = primaryKeys.getString("COLUMN_NAME");
                    pkList.add(pkName);
                }
                table.setPrimaryKeys(pkList);
                while(columns.next()) {
                    String column_name = columns.getString("COLUMN_NAME");
                    String type_name = columns.getString("TYPE_NAME");
                    String remarks = columns.getString("REMARKS");
                    Column column = new Column();
                    column.setColumnName(column_name);
                    column.setType(type_name);
                    column.setRemark(remarks);
                    column.setPropertyName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, column_name));

                    primaryKeys.first();
                    while(primaryKeys.next()){
                        String pkName = primaryKeys.getString("COLUMN_NAME");
                        if(pkName.equals(column_name)){
                            column.setPrimary(true);
                        }
                    }

                    columnList.add(column);
                    table.setColumns(columnList);
                }
                Template modelTemplate = cfg.getTemplate("Model.java.ftl");
                Template mapperTemplate = cfg.getTemplate("Mapper.java.ftl");
                Template mapperXmlTemplate = cfg.getTemplate("Mapper.xml.ftl");
                Template serviceTemplate = cfg.getTemplate("Service.java.ftl");
                Template controllerTemplate = cfg.getTemplate("Controller.java.ftl");
                // 生成model
                generateCode(table, modelTemplate, new ModelGenerate(table));
                // 生成mapper
                generateCode(table, mapperTemplate, new MapperGenerate(table));
                // 生成mapper xml
                generateCode(table, mapperXmlTemplate, new MapperGenerate(table));
                // 生成service
                generateCode(table, serviceTemplate, new ServiceGenerate(table));
                // 生成controller
                generateCode(table, controllerTemplate, new ControllerGenerate(table));

            }
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    private void generateCode(Table table, Template modelTemplate, AbstractGenerateCode abstractGenerateCode) {
        abstractGenerateCode.generateCode(table, modelTemplate, outputDir);
    }
}
