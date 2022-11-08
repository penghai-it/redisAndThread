package it.ph.com.redistest.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SysUser
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自动递增
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * dept_id
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * user_name
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * nick_name
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * user_type
     */
    @TableField(value = "user_type")
    private Integer userType;

    /**
     * email
     */
    @TableField(value = "email")
    private String email;

    /**
     * phonenumber
     */
    @TableField(value = "phonenumber")
    private Long phonenumber;

    /**
     * sex
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * avatar
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * password
     */
    @TableField(value = "password")
    private String password;

    /**
     * status
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * del_flag
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     * login_ip
     */
    @TableField(value = "login_ip")
    private String loginIp;

    /**
     * login_date
     */
    @TableField(value = "login_date")
    private Date loginDate;

    /**
     * create_by
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * create_time
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * update_by
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * update_time
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * remark
     */
    @TableField(value = "remark")
    private String remark;

}
