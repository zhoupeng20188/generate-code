package com.zp.generatecode.service;

import com.zp.generatecode.model.Table;

import java.io.File;

/**
 * @Author zp
 * @create 2021/2/20 11:22
 */
public class ServiceGenerate extends AbstractGenerateCode {
    private Table table;

    public ServiceGenerate(Table table) {
        this.table = table;
    }

    @Override
    String getFileName() {
        return table.getServiceName();
    }

    @Override
    String getSubDir() {
        return "service" + File.separator;
    }
}
