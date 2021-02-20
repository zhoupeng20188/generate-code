<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.mapper.${mapperName}">
    <sql id="Base_Column_List">
        <#if columns??>
<#list columns as column><#if column_index = 0>${column.columnName}<#else> ,${column.columnName}</#if></#list>
        </#if>
    </sql>
    <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultType="${packageName}.model.${modelName}">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where
        <#if primaryKeys??>
            <#list primaryKeys as pk>
                <#if pk_index = 0>
            ${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                <#else>
            ,$${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                </#if>
            </#list>
        </#if>
    </select>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
        delete from ${tableName}
        where
        <#if primaryKeys??>
            <#list primaryKeys as pk>
                <#if pk_index = 0>
            ${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                <#else>
            ,$${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                </#if>
            </#list>
        </#if>
    </delete>
    <insert id="insert" parameterType="${packageName}.model.${modelName}">
        insert into ${tableName} (<#list columns as column><#if column_index = 0>${column.columnName}<#else> ,${column.columnName}</#if></#list>)
        values (<#list columns as column><#if column_index = 0><#noparse>#{</#noparse>${column.propertyName},jdbcType=${(column.type == "INT")?string("INTEGER",column.type)}<#noparse>}</#noparse><#else> ,<#noparse>#{</#noparse>${column.propertyName},jdbcType=${(column.type == "INT")?string("INTEGER",column.type)}<#noparse>}</#noparse></#if></#list>)
    </insert>
    <update id="updateByPrimaryKey" parameterType="${packageName}.model.${modelName}">
        update ${tableName}
        set <#list columns as column><#if column_index = 0>${column.columnName} = <#noparse>#{</#noparse>${column.propertyName},jdbcType=${(column.type == "INT")?string("INTEGER",column.type)}<#noparse>}</#noparse><#else> ,${column.columnName} = <#noparse>#{</#noparse>${column.propertyName},jdbcType=${(column.type == "INT")?string("INTEGER",column.type)}<#noparse>}</#noparse></#if></#list>
        where
        <#if primaryKeys??>
            <#list primaryKeys as pk>
                <#if pk_index = 0>
            ${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                <#else>
            ,$${pk} = <#noparse>#{</#noparse>id,jdbcType=INTEGER<#noparse>}</#noparse>
                </#if>
            </#list>
        </#if>
    </update>
</mapper>