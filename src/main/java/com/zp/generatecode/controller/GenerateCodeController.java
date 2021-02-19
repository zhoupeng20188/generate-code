package com.zp.generatecode.controller;

import com.google.common.base.CaseFormat;
import com.zp.generatecode.model.DB;
import com.zp.generatecode.model.ResBean;
import com.zp.generatecode.model.Table;
import com.zp.generatecode.utils.DBUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author zp
 * @create 2021/2/19 15:51
 */
@RestController
public class GenerateCodeController {

    @RequestMapping("/db")
    public ResBean db(@RequestBody DB db) {
        final Connection connection = DBUtil.initDB(db);
        if (connection == null) {
            return ResBean.error("数据库连接失败");
        }
        return ResBean.error("数据库连接成功");
    }

    @RequestMapping("/config")
    public ResBean config(@RequestBody Map<String, String> map) {
        String packageName = map.get("packageName");
        Connection connection = DBUtil.getConnection();
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tableCls = metaData.getTables(connection.getCatalog(), null, null, null);
            List<Table> tables = new ArrayList<>();
            while(tableCls.next()){
                Table table = new Table();
                table.setPackageName(packageName);
                String table_name = tableCls.getString("TABLE_NAME");
                table.setTableName(table_name);
                String modelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table_name);
                table.setModelName(modelName);
                table.setMapperName(modelName + "Mapper");
                table.setServiceName(modelName + "Service");
                table.setControllerName(modelName + "Controller");
                tables.add(table);
            }
            return ResBean.ok("配置成功", tables);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResBean.error("配置失败");
    }
}
