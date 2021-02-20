package ${packageName}.service;

import ${packageName}.model.${modelName};
import ${packageName}.mapper.${mapperName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${serviceName} {
    @Autowired
    private ${mapperName} ${mapperName?uncap_first};

    public ${modelName} selectByPrimaryKey(int id) {
        return ${mapperName?uncap_first}.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(int id) {
        return ${mapperName?uncap_first}.deleteByPrimaryKey(id);
    }

    public int insert(${modelName} record) {
        return ${mapperName?uncap_first}.insert(record);
    }

    public int updateByPrimaryKey(${modelName} record) {
        return ${mapperName?uncap_first}.updateByPrimaryKey(record);
    }

}