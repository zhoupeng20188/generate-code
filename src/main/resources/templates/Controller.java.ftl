package ${packageName}.controller;

import ${packageName}.model.${modelName};
import ${packageName}.service.${serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ${controllerName} {
    @Autowired
    private ${serviceName} ${serviceName?uncap_first};

    @GetMapping("/get")
    public ${modelName} selectByPrimaryKey(int id) {
        return ${serviceName?uncap_first}.selectByPrimaryKey(id);
    }

    @GetMapping("/delete")
    public int deleteByPrimaryKey(int id) {
        return ${serviceName?uncap_first}.deleteByPrimaryKey(id);
    }

    @PostMapping("/insert")
    int insert(@RequestBody ${modelName} record) {
        return ${serviceName?uncap_first}.insert(record);
    }

    @PostMapping("/update")
    int updateByPrimaryKey(@RequestBody ${modelName} record) {
        return ${serviceName?uncap_first}.updateByPrimaryKey(record);
    }

}