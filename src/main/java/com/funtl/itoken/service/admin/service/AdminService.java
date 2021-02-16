package com.funtl.itoken.service.admin.service;


import com.funtl.itoken.common.domain.TbSysUser;


public interface AdminService {




    public void register(TbSysUser tbSysUser) ;

    /*
    * 登录
    *
    * */
    public TbSysUser login(String loginCode, String plantpassword) ;

}
