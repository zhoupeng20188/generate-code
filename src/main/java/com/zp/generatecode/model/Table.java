package com.zp.generatecode.model;

import java.util.List;

/**
 * @Author zp
 * @create 2021/2/19 16:21
 */
public class Table {
    private String tableName;
    private String modelName;
    private String ServiceName;
    private String MapperName;
    private String ControllerName;
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
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getMapperName() {
        return MapperName;
    }

    public void setMapperName(String mapperName) {
        MapperName = mapperName;
    }

    public String getControllerName() {
        return ControllerName;
    }

    public void setControllerName(String controllerName) {
        ControllerName = controllerName;
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
                ", ServiceName='" + ServiceName + '\'' +
                ", MapperName='" + MapperName + '\'' +
                ", ControllerName='" + ControllerName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", columns=" + columns +
                '}';
    }
}
