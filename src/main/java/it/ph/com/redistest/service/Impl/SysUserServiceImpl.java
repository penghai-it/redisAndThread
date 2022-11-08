package it.ph.com.redistest.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.netty.util.internal.StringUtil;
import it.ph.com.redistest.mapper.SysUserMapper;
import it.ph.com.redistest.model.SysUser;
import it.ph.com.redistest.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;

/**
 * @author PH
 * @时间： 2022/11/8
 * @描述：
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public boolean saveBatch(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysUser entity) {
        return false;
    }

    @Override
    public SysUser getOne(Wrapper<SysUser> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysUser> queryWrapper) {
        return new HashMap<>();
    }

    @Override
    public <V> V getObj(Wrapper<SysUser> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysUser> getBaseMapper() {
        return null;
    }

    /**
     * @param sysUser user对象
     * @return: int
     * @创建者: PH
     * @时间: 2022/11/8
     * @描述:插入user数据
     **/

    @Override
    public int insert(SysUser sysUser) {
        sysUser.setDeptId(105);
        sysUser.setUserName("test");
        sysUser.setNickName("若依");
        sysUser.setUserType(0);
        sysUser.setEmail("564990676@qq.com");
        sysUser.setPhonenumber(12345678901L);
        sysUser.setSex(1);
        sysUser.setAvatar("http://192.168.2.106:9000/gla-bucket/2022/10/25/8056beb8-de4c-40db-af37-c548160dd423.jpg");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        sysUser.setPassword(passwordEncoder.encode(String.valueOf((Math.random() * 900000) + 100000)));
        sysUser.setStatus(0);
        sysUser.setLoginIp("127.0.0.1");
        sysUser.setLoginDate(new Date());
        sysUser.setCreateBy("admin");
        sysUser.setCreateTime(new Date());
        sysUser.setRemark("最牛逼的人");
        return sysUserMapper.insert(sysUser);
    }

    /**
     * @param sysUser user对象
     * @return: java.util.List<it.ph.com.redistest.model.SysUser>
     * @创建者: PH
     * @时间: 2022/11/8
     * @描述:根据条件查询
     **/

    @Override
    public List<SysUser> select(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq(!StringUtil.isNullOrEmpty(sysUser.getUserName()), "user_name", sysUser.getUserName()).eq(!StringUtil.isNullOrEmpty(sysUser.getEmail()), "email", sysUser.getEmail());
        return sysUserMapper.selectList(queryWrapper);
    }

    /**
     * @param sysUser user对象
     * @return: int
     * @创建者: PH
     * @时间: 2022/11/8
     * @描述:根据条件删除数据没有条件就删除所有数据
     **/

    @Override
    public int delete(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq(sysUser.getUserId() != null, "user_id", sysUser.getUserId());
        return sysUserMapper.delete(queryWrapper);
    }

    /**
     * @param sysUser user对象
     * @return: int
     * @创建者: PH
     * @时间: 2022/11/8
     * @描述:根据条件更新user数据
     **/

    @Override
    public int update(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq(sysUser.getUserId() != null, "user_id", sysUser.getUserId());
        return sysUserMapper.update(sysUser, queryWrapper);
    }

    /**
     * @param sysUser user对象
     * @return: int
     * @创建者: PH
     * @时间: 2022/11/8
     * @描述:根据userId进行更新数据
     **/

    @Override
    public int updateByid(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        sysUser.setLoginDate(new Date());
        return sysUserMapper.updateById(sysUser);
    }
}
