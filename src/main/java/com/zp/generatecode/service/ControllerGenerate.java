package com.zp.generatecode.service;

import com.zp.generatecode.model.Table;

import java.io.File;

/**
 * @Author zp
 * @create 2021/2/20 11:22
 */
public class ControllerGenerate extends AbstractGenerateCode {
    private Table table;

    public ControllerGenerate(Table table) {
        this.table = table;
    }

    @Override
    String getFileName() {
        return table.getControllerName();
    }

    @Override
    String getSubDir() {
        return "controller" + File.separator;
    }
}
