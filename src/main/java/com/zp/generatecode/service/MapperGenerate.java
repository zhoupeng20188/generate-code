package com.zp.generatecode.service;

import com.zp.generatecode.model.Table;

import java.io.File;

/**
 * @Author zp
 * @create 2021/2/20 11:22
 */
public class MapperGenerate extends AbstractGenerateCode {
    private Table table;

    public MapperGenerate(Table table) {
        this.table = table;
    }

    @Override
    String getFileName() {
        return table.getMapperName();
    }

    @Override
    String getSubDir() {
        return "mapper" + File.separator;
    }
}
