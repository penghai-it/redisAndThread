package it.ph.com.redistest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import it.ph.com.redistest.model.SysUser;

import java.util.List;

/**
 * @author PH
 * @时间： 2022/11/8
 * @描述：
 */
public interface SysUserService extends IService<SysUser> {
    int insert(SysUser sysUser);

    List<SysUser> select(SysUser sysUser);

    int delete(SysUser sysUser);

    int update(SysUser sysUser);

    int updateByid(SysUser sysUser);
}
