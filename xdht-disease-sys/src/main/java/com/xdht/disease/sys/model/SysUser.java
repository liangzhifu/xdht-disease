package com.xdht.disease.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录账号
     */
    @Column(name = "login_code")
    private String loginCode;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 办公电话
     */
    private String phone;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 绑定的微信号
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

    /**
     * 管理员类型（0非管理员 1系统管理员
     */
    @Column(name = "mgr_type")
    private String mgrType;

    /**
     * 最后登陆IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;


    /**
     * 关联职工id
     */
    @Column(name = "emp_id")
    private Long empId;

    /**
     * 获取员工关联id
     * @return 员工关联id
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * 设置员工关联id
     * @param empId 员工关联id
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录账号
     *
     * @return login_code - 登录账号
     */
    public String getLoginCode() {
        return loginCode;
    }

    /**
     * 设置登录账号
     *
     * @param loginCode 登录账号
     */
    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取办公电话
     *
     * @return phone - 办公电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置办公电话
     *
     * @param phone 办公电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户性别
     *
     * @return sex - 用户性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取头像路径
     *
     * @return avatar - 头像路径
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像路径
     *
     * @param avatar 头像路径
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取个性签名
     *
     * @return sign - 个性签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置个性签名
     *
     * @param sign 个性签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取绑定的微信号
     *
     * @return wx_openid - 绑定的微信号
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置绑定的微信号
     *
     * @param wxOpenid 绑定的微信号
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * 获取管理员类型（0非管理员 1系统管理员
     *
     * @return mgr_type - 管理员类型（0非管理员 1系统管理员
     */
    public String getMgrType() {
        return mgrType;
    }

    /**
     * 设置管理员类型（0非管理员 1系统管理员
     *
     * @param mgrType 管理员类型（0非管理员 1系统管理员
     */
    public void setMgrType(String mgrType) {
        this.mgrType = mgrType;
    }

    /**
     * 获取最后登陆IP
     *
     * @return last_login_ip - 最后登陆IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最后登陆IP
     *
     * @param lastLoginIp 最后登陆IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最后登陆时间
     *
     * @return last_login_date - 最后登陆时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 设置最后登陆时间
     *
     * @param lastLoginDate 最后登陆时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 获取状态（0正常 1删除 2停用 3冻结）
     *
     * @return status - 状态（0正常 1删除 2停用 3冻结）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用 3冻结）
     *
     * @param status 状态（0正常 1删除 2停用 3冻结）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}