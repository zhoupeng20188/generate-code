package com.zp.generatecode.controller;

import com.zp.generatecode.model.DB;
import com.zp.generatecode.model.ResBean;
import com.zp.generatecode.utils.DBUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

/**
 * @Author zp
 * @create 2021/2/19 15:51
 */
@RestController
public class GenerateCodeController {

    @RequestMapping("/db")
    public ResBean db(@RequestBody DB db){
        final Connection connection = DBUtil.getConnection(db);
        if(connection == null) {
            return ResBean.error("数据库连接失败");
        }
        return ResBean.error("数据库连接成功");
    }
}
