package com.zp.generatecode.model;

import java.util.List;

/**
 * @Author zp
 * @create 2021/2/19 16:21
 */
public class Table {
    private String tableName;
    private String modelName;
    private String serviceName;
    private String mapperName;
    private String controllerName;
    private String packageName;
    private List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", mapperName='" + mapperName + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", columns=" + columns +
                '}';
    }
}
