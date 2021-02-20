package com.zp.generatecode.service;

import com.zp.generatecode.model.Table;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Author zp
 * @create 2021/2/20 11:19
 */
public abstract class AbstractGenerateCode {
    public void generateCode(Object table, Template modelTemplate, String outputDir) {
        try {
            String dir = outputDir + getSubDir();
            File folder = new File(dir);
            if(!folder.exists()) {
                folder.mkdir();
            }
            FileOutputStream fos = new FileOutputStream(dir + getFileName()+  modelTemplate.getName()
                    .replace("Model", "")
                    .replace("Mapper", "")
                    .replace("Service", "")
                    .replace("Controller", "")
                    .replace(".ftl", ""));
            OutputStreamWriter out = new OutputStreamWriter(fos);
            // 渲染模板
            modelTemplate.process(table, out);
            fos.close();
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    abstract String getFileName();

    abstract String getSubDir();
}
