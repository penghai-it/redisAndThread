package it.ph.com.redistest.controller;

import it.ph.com.redistest.model.SysUser;
import it.ph.com.redistest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PH
 * @时间： 2022/11/8
 * @描述：
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @PostMapping("test")
    public int insert(SysUser entity) {
        return sysUserService.insert(entity);
    }

    @GetMapping("test1")
    public List<SysUser> select(SysUser sysUser) {
        return sysUserService.select(sysUser);
    }

    @GetMapping("test2")
    public int delete(SysUser sysUser) {
        return sysUserService.delete(sysUser);
    }

    @PostMapping("test3")
    public int update(SysUser sysUser) {
        return sysUserService.update(sysUser);
    }

    @PostMapping("test4")
    public int updateByid(SysUser sysUser) {
        return sysUserService.updateByid(sysUser);
    }
}