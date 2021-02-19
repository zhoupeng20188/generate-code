package com.zp.generatecode.model;

/**
 * @Author zp
 * @create 2021/2/19 16:19
 */
public class Column {
    /**
     * java中属性名
     */
    private String propertyName;
    /**
     * 数据库中字段名
     */
    private String ColumnName;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 是否为主键
     */
    private Boolean isPrimary;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    @Override
    public String toString() {
        return "Column{" +
                "propertyName='" + propertyName + '\'' +
                ", ColumnName='" + ColumnName + '\'' +
                ", type='" + type + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
