package com.lsp.controller;

import com.lsp.config.swagger.ApiResponseFields;
import com.lsp.config.swagger.ApiResponseObject;
import com.lsp.config.swagger.ApiResponseProperty;
import com.lsp.entity.Person;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * Created by lsp on 2019/12/22.
 */
@RestController
@Api(description = "用户接口")
public class IController {

    /**
     * 查看用户详情
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/select/{id}")
    @ApiOperation(value = "查看用户详情",notes = "使用说明")
    @ApiResponseFields(fields = {"id","first_name"})
    public Person select(@ApiParam(name="用户id") @PathVariable int id){
        return null;
    }


    @PutMapping("/put/{id}")
    @ApiOperation(value = "更新用户信息",notes = "使用说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",paramType = "path",dataType = "MAP_>"),
            @ApiImplicitParam(name = "username",value="用户名",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "password",value="密码",paramType = "query",dataType = "string")
    })
    @ApiResponseObject(properties = {
            @ApiResponseProperty(name = "username",description = "用户名",type = "string"),
            @ApiResponseProperty(name = "email",description = "用户邮箱",type = "string"),
            @ApiResponseProperty(name = "address",description = "用户住址",type = "string"),
    })
    public Map<String,Object> put(@ApiIgnore @PathVariable String id,
                                  @ApiIgnore @RequestParam java.util.Map<String,Object> params){
        System.out.println(params);
        return null;
    }
}

