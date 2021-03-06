package ${packageName}.model;

import java.util.Date;

public class ${modelName} {

    <#if columns??>
        <#list columns as column>
    /**
    * <#if column.remark != ''>${column.remark}<#else>${column.propertyName?uncap_first}</#if>
    */
            <#if column.type='VARCHAR' || column.type='CHAR' || column.type='TEXT'>
    private String ${column.propertyName?uncap_first};
            </#if>
            <#if column.type='INT'>
    private Integer ${column.propertyName?uncap_first};
            </#if>
            <#if column.type='DATETIME'>
    private Date ${column.propertyName?uncap_first};
            </#if>
            <#if column.type='BIGINT'>
    private Long ${column.propertyName?uncap_first};
            </#if>
            <#if column.type='DOUBLE'>
    private Double ${column.propertyName?uncap_first};
            </#if>
            <#if column.type='BIT'>
    private Boolean ${column.propertyName?uncap_first};
            </#if>
        </#list>
    </#if>

    <#if columns??>
        <#list columns as column>
            <#if column.type='VARCHAR' || column.type='CHAR' || column.type='TEXT'>
    public String get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    public void set${column.propertyName}(String ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
            <#if column.type='INT'>
    public Integer get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    public void set${column.propertyName}(Integer ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
            <#if column.type='DATETIME'>
    public Date get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    public void set${column.propertyName}(Date ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
            <#if column.type='BIGINT'>
    public Long get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    private void set${column.propertyName}(Long ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
            <#if column.type='DOUBLE'>
    public Double get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    public void set${column.propertyName}(Double ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
            <#if column.type='BIT'>
    public Boolean get${column.propertyName}() {
        return ${column.propertyName?uncap_first};
    }
    public void set${column.propertyName}(Boolean ${column.propertyName?uncap_first}) {
        this.${column.propertyName?uncap_first} = ${column.propertyName?uncap_first};
    }
            </#if>
        </#list>
    </#if>

}