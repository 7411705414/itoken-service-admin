package com.funtl.itoken.service.admin.controller;


import com.ctc.wstx.util.StringUtil;
import com.funtl.itoken.common.domain.TbSysUser;
import com.funtl.itoken.common.dto.BaseResult;
import com.funtl.itoken.service.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService ;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public BaseResult login(String loginCode, String password){
        BaseResult baseResult = checkLogin(loginCode, password) ;

        if (baseResult != null){
            return baseResult ;
        }
        TbSysUser tbSysUser = adminService.login(loginCode, password) ;

        if (tbSysUser != null){

            return BaseResult.ok(tbSysUser) ;
        }else{
            return BaseResult.notok(Lists.newArrayList(new BaseResult.Error("", "登陆失败"))) ;
        }

    }



    private BaseResult checkLogin(String loginCode, String password) {
        BaseResult baseResult = null;
        List<BaseResult.Error> errors = Lists.newArrayList();

        if (StringUtils.isBlank(loginCode) || StringUtils.isBlank(password)) {
            baseResult = BaseResult.notok(Lists.newArrayList(
                    new BaseResult.Error("loginCode", "登陆账户不能为空"),
                    new BaseResult.Error("password", "密码不能为空")

            ));
        }
        return baseResult;
    }




}
