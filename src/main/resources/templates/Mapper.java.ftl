package ${packageName}.mapper;

import ${packageName}.model.${modelName};

public interface ${mapperName} {

    int deleteByPrimaryKey(int id);

    int insert(${modelName} record);

    ${modelName} selectByPrimaryKey(int id);

    int updateByPrimaryKey(${modelName} record);

}