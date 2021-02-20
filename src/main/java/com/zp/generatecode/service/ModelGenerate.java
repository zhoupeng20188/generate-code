package com.zp.generatecode.service;

import com.zp.generatecode.model.Table;

import java.io.File;

/**
 * @Author zp
 * @create 2021/2/20 11:22
 */
public class ModelGenerate extends AbstractGenerateCode {
    private Table table;

    public ModelGenerate(Table table) {
        this.table = table;
    }

    @Override
    String getFileName() {
        return table.getModelName();
    }
    @Override
    String getSubDir() {
        return "model" + File.separator;
    }
}
