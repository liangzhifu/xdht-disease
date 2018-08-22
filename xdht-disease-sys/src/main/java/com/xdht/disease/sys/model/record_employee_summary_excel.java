package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.xdht.disease.common.annotation.ExcelImport;

import java.util.Date;
import javax.persistence.*;

public class record_employee_summary_excel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 部门/车间id
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 工种
     */
    @Column(name = "work_type_id")
    private Long workTypeId;
/*
* 检查日期
* */
    @ExcelImport
    @Column(name = "inspect_date")
    private Date inspectDate;

    /*
    * 职业病危害因素
    * */
    @ExcelImport
    @Column(name = "hazard_factor")
    private String  hazardFactor;

    /*
    身份证号*/
    @ExcelImport
    private  String empIdentityNumber;

    /**
     * 公司名称
     */
    @ExcelImport
    private String company;

    /**
     * 部门/车间

     */
    @ExcelImport
    private String post;

    /**
     * 工种
     */
    @ExcelImport
    @Column(name = "work_type")
    private String workType;

    /**
     * 姓名
     */
    @ExcelImport
    private String name;

    /**
     * 性别
     */
    @ExcelImport
    private String sex;

    /**
     * 年龄
     */
    @ExcelImport
    private Integer age;

    /**
     * 接害工龄




     */
    @ExcelImport
    @Column(name = "contact_time")
    private Integer contactTime;

    /**
     * 血压收缩压
     */
    @ExcelImport
    @Column(name = "blood_pressure_shrink")
    private String bloodPressureShrink;

    /**
     * 血压舒张压
     */
    @ExcelImport
    @Column(name = "blood_pressure_diastole")
    private String bloodPressureDiastole;

    /**
     * 心脏
     */
    @ExcelImport
    private String heart;

    /**
     * 肺
     */
    @ExcelImport
    private String lungs;

    /**
     * 皮肤粘膜
     */
    @ExcelImport
    @Column(name = "skin_mucous_membrane")
    private String skinMucousMembrane;

    /**
     * 浅表淋巴结


     */
    @ExcelImport
    @Column(name = "lymph_node")
    private String lymphNode;

    /**
     * 甲状腺


     */
    @ExcelImport
    @Column(name = "thyroid_gland")
    private String thyroidGland;

    /**
     * 耳朵
     */
    @ExcelImport
    private String ear;

    /**
     * 鼻子
     */
    @ExcelImport
    private String nose;

    /**
     * 喉咙
     */
    @ExcelImport
    private String throat;

    /**
     * 前庭功能检查
     */
    @ExcelImport
    @Column(name = "vestibular_function")
    private String vestibularFunction;

    /**
     * 白细胞×109/L
     */
    @ExcelImport
    @Column(name = "white_blood_cell")
    private String whiteBloodCell;

    /**
     * 中性粒细胞计数×109/L
     */
    @ExcelImport
    @Column(name = "neutrophile_granulocyte")
    private String neutrophileGranulocyte;

    /**
     * 红细胞计数×1012/L
     */
    @ExcelImport
    @Column(name = "red_blood_cell")
    private String redBloodCell;

    /**
     * 血色素g/L
     */
    @ExcelImport
    private String hemoglobin;

    /**
     * 血小板×109/L
     */
    @ExcelImport
    private String platelet;

    /**
     * 心电图
     */
    @ExcelImport
    private String electrocardiogram;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_500_l")
    private String dbhl500L;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_1k_l")
    private String dbhl1kL;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_2k_l")
    private String dbhl2kL;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_3k_l")
    private String dbhl3kL;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_4k_l")
    private String dbhl4kL;

    /**
     * 纯音听阈测试-左
     */
    @ExcelImport
    @Column(name = "dbhl_6k_l")
    private String dbhl6kL;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_500_r")
    private String dbhl500R;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_1k_r")
    private String dbhl1kR;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_2k_r")
    private String dbhl2kR;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_3k_r")
    private String dbhl3kR;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_4k_r")
    private String dbhl4kR;

    /**
     * 纯音听阈测试-右
     */
    @ExcelImport
    @Column(name = "dbhl_6k_r")
    private String dbhl6kR;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 状态（0正常 1删除）
     */
    private String status;
    /*
    *0：初检  1：复检
    * */
    @Column(name = "inspect")
   private String inspect;
    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门/车间id
     *
     * @return post_id - 部门/车间id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置部门/车间id
     *
     * @param postId 部门/车间id
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取工种
     *
     * @return work_type_id - 工种
     */
    public Long getWorkTypeId() {
        return workTypeId;
    }

    /**
     * 设置工种
     *
     * @param workTypeId 工种
     */
    public void setWorkTypeId(Long workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getEmpIdentityNumber() {
        return empIdentityNumber;
    }

    public void setEmpIdentityNumber(String empIdentityNumber) {
        this.empIdentityNumber = empIdentityNumber;
    }
    /**
     * 获取公司名称
     *
     * @return company - 公司名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司名称
     *
     * @param company 公司名称
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取部门/车间




     *
     * @return post - 部门/车间




     */
    public String getPost() {
        return post;
    }

    /**
     * 设置部门/车间




     *
     * @param post 部门/车间




     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取工种
     *
     * @return  work_type - 工种
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * 设置工种
     *
     * @param workType 工种
     */
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Date getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public String getHazardFactor() {
        return hazardFactor;
    }

    public void setHazardFactor(String hazardFactor) {
        this.hazardFactor = hazardFactor;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取接害工龄




     *
     * @return contact_time - 接害工龄




     */
    public Integer getContactTime() {
        return contactTime;
    }

    /**
     * 设置接害工龄




     *
     * @param contactTime 接害工龄




     */
    public void setContactTime(Integer contactTime) {
        this.contactTime = contactTime;
    }

    /**
     * 获取血压收缩压
     *
     * @return blood_pressure_shrink - 血压收缩压
     */
    public String getBloodPressureShrink() {
        return bloodPressureShrink;
    }

    /**
     * 设置血压收缩压
     *
     * @param bloodPressureShrink 血压收缩压
     */
    public void setBloodPressureShrink(String bloodPressureShrink) {
        this.bloodPressureShrink = bloodPressureShrink;
    }

    /**
     * 获取血压舒张压
     *
     * @return blood_pressure_diastole - 血压舒张压
     */
    public String getBloodPressureDiastole() {
        return bloodPressureDiastole;
    }

    /**
     * 设置血压舒张压
     *
     * @param bloodPressureDiastole 血压舒张压
     */
    public void setBloodPressureDiastole(String bloodPressureDiastole) {
        this.bloodPressureDiastole = bloodPressureDiastole;
    }

    /**
     * 获取心脏
     *
     * @return heart - 心脏
     */
    public String getHeart() {
        return heart;
    }

    /**
     * 设置心脏
     *
     * @param heart 心脏
     */
    public void setHeart(String heart) {
        this.heart = heart;
    }

    /**
     * 获取肺
     *
     * @return lungs - 肺
     */
    public String getLungs() {
        return lungs;
    }

    /**
     * 设置肺
     *
     * @param lungs 肺
     */
    public void setLungs(String lungs) {
        this.lungs = lungs;
    }

    /**
     * 获取皮肤粘膜
     *
     * @return skin_mucous_membrane - 皮肤粘膜
     */
    public String getSkinMucousMembrane() {
        return skinMucousMembrane;
    }

    /**
     * 设置皮肤粘膜
     *
     * @param skinMucousMembrane 皮肤粘膜
     */
    public void setSkinMucousMembrane(String skinMucousMembrane) {
        this.skinMucousMembrane = skinMucousMembrane;
    }

    /**
     * 获取浅表淋巴结


     *
     * @return lymph_node - 浅表淋巴结


     */
    public String getLymphNode() {
        return lymphNode;
    }

    /**
     * 设置浅表淋巴结


     *
     * @param lymphNode 浅表淋巴结


     */
    public void setLymphNode(String lymphNode) {
        this.lymphNode = lymphNode;
    }

    /**
     * 获取甲状腺


     *
     * @return thyroid_gland - 甲状腺


     */
    public String getThyroidGland() {
        return thyroidGland;
    }

    /**
     * 设置甲状腺


     *
     * @param thyroidGland 甲状腺


     */
    public void setThyroidGland(String thyroidGland) {
        this.thyroidGland = thyroidGland;
    }

    /**
     * 获取耳朵
     *
     * @return ear - 耳朵
     */
    public String getEar() {
        return ear;
    }

    /**
     * 设置耳朵
     *
     * @param ear 耳朵
     */
    public void setEar(String ear) {
        this.ear = ear;
    }

    /**
     * 获取鼻子
     *
     * @return nose - 鼻子
     */
    public String getNose() {
        return nose;
    }

    /**
     * 设置鼻子
     *
     * @param nose 鼻子
     */
    public void setNose(String nose) {
        this.nose = nose;
    }

    /**
     * 获取喉咙
     *
     * @return throat - 喉咙
     */
    public String getThroat() {
        return throat;
    }

    /**
     * 设置喉咙
     *
     * @param throat 喉咙
     */
    public void setThroat(String throat) {
        this.throat = throat;
    }

    /**
     * 获取前庭功能检查
     *
     * @return vestibular_function - 前庭功能检查
     */
    public String getVestibularFunction() {
        return vestibularFunction;
    }

    /**
     * 设置前庭功能检查
     *
     * @param vestibularFunction 前庭功能检查
     */
    public void setVestibularFunction(String vestibularFunction) {
        this.vestibularFunction = vestibularFunction;
    }

    /**
     * 获取白细胞×109/L
     *
     * @return white_blood_cell - 白细胞×109/L
     */
    public String getWhiteBloodCell() {
        return whiteBloodCell;
    }

    /**
     * 设置白细胞×109/L
     *
     * @param whiteBloodCell 白细胞×109/L
     */
    public void setWhiteBloodCell(String whiteBloodCell) {
        this.whiteBloodCell = whiteBloodCell;
    }

    /**
     * 获取中性粒细胞计数×109/L
     *
     * @return neutrophile_granulocyte - 中性粒细胞计数×109/L
     */
    public String getNeutrophileGranulocyte() {
        return neutrophileGranulocyte;
    }

    /**
     * 设置中性粒细胞计数×109/L
     *
     * @param neutrophileGranulocyte 中性粒细胞计数×109/L
     */
    public void setNeutrophileGranulocyte(String neutrophileGranulocyte) {
        this.neutrophileGranulocyte = neutrophileGranulocyte;
    }

    /**
     * 获取红细胞计数×1012/L
     *
     * @return red_blood_cell - 红细胞计数×1012/L
     */
    public String getRedBloodCell() {
        return redBloodCell;
    }

    /**
     * 设置红细胞计数×1012/L
     *
     * @param redBloodCell 红细胞计数×1012/L
     */
    public void setRedBloodCell(String redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    /**
     * 获取血色素g/L
     *
     * @return hemoglobin - 血色素g/L
     */
    public String getHemoglobin() {
        return hemoglobin;
    }

    /**
     * 设置血色素g/L
     *
     * @param hemoglobin 血色素g/L
     */
    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    /**
     * 获取血小板×109/L
     *
     * @return platelet - 血小板×109/L
     */
    public String getPlatelet() {
        return platelet;
    }

    /**
     * 设置血小板×109/L
     *
     * @param platelet 血小板×109/L
     */
    public void setPlatelet(String platelet) {
        this.platelet = platelet;
    }

    /**
     * 获取心电图
     *
     * @return electrocardiogram - 心电图
     */
    public String getElectrocardiogram() {
        return electrocardiogram;
    }

    /**
     * 设置心电图
     *
     * @param electrocardiogram 心电图
     */
    public void setElectrocardiogram(String electrocardiogram) {
        this.electrocardiogram = electrocardiogram;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_500_l - 纯音听阈测试-左
     */
    public String getDbhl500L() {
        return dbhl500L;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl500L 纯音听阈测试-左
     */
    public void setDbhl500L(String dbhl500L) {
        this.dbhl500L = dbhl500L;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_1k_l - 纯音听阈测试-左
     */
    public String getDbhl1kL() {
        return dbhl1kL;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl1kL 纯音听阈测试-左
     */
    public void setDbhl1kL(String dbhl1kL) {
        this.dbhl1kL = dbhl1kL;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_2k_l - 纯音听阈测试-左
     */
    public String getDbhl2kL() {
        return dbhl2kL;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl2kL 纯音听阈测试-左
     */
    public void setDbhl2kL(String dbhl2kL) {
        this.dbhl2kL = dbhl2kL;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_3k_l - 纯音听阈测试-左
     */
    public String getDbhl3kL() {
        return dbhl3kL;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl3kL 纯音听阈测试-左
     */
    public void setDbhl3kL(String dbhl3kL) {
        this.dbhl3kL = dbhl3kL;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_4k_l - 纯音听阈测试-左
     */
    public String getDbhl4kL() {
        return dbhl4kL;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl4kL 纯音听阈测试-左
     */
    public void setDbhl4kL(String dbhl4kL) {
        this.dbhl4kL = dbhl4kL;
    }

    /**
     * 获取纯音听阈测试-左
     *
     * @return dbhl_6k_l - 纯音听阈测试-左
     */
    public String getDbhl6kL() {
        return dbhl6kL;
    }

    /**
     * 设置纯音听阈测试-左
     *
     * @param dbhl6kL 纯音听阈测试-左
     */
    public void setDbhl6kL(String dbhl6kL) {
        this.dbhl6kL = dbhl6kL;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_500_r - 纯音听阈测试-右
     */
    public String getDbhl500R() {
        return dbhl500R;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl500R 纯音听阈测试-右
     */
    public void setDbhl500R(String dbhl500R) {
        this.dbhl500R = dbhl500R;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_1k_r - 纯音听阈测试-右
     */
    public String getDbhl1kR() {
        return dbhl1kR;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl1kR 纯音听阈测试-右
     */
    public void setDbhl1kR(String dbhl1kR) {
        this.dbhl1kR = dbhl1kR;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_2k_r - 纯音听阈测试-右
     */
    public String getDbhl2kR() {
        return dbhl2kR;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl2kR 纯音听阈测试-右
     */
    public void setDbhl2kR(String dbhl2kR) {
        this.dbhl2kR = dbhl2kR;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_3k_r - 纯音听阈测试-右
     */
    public String getDbhl3kR() {
        return dbhl3kR;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl3kR 纯音听阈测试-右
     */
    public void setDbhl3kR(String dbhl3kR) {
        this.dbhl3kR = dbhl3kR;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_4k_r - 纯音听阈测试-右
     */
    public String getDbhl4kR() {
        return dbhl4kR;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl4kR 纯音听阈测试-右
     */
    public void setDbhl4kR(String dbhl4kR) {
        this.dbhl4kR = dbhl4kR;
    }

    /**
     * 获取纯音听阈测试-右
     *
     * @return dbhl_6k_r - 纯音听阈测试-右
     */
    public String getDbhl6kR() {
        return dbhl6kR;
    }

    /**
     * 设置纯音听阈测试-右
     *
     * @param dbhl6kR 纯音听阈测试-右
     */
    public void setDbhl6kR(String dbhl6kR) {
        this.dbhl6kR = dbhl6kR;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
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
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取状态（0正常 1删除）
     *
     * @return status - 状态（0正常 1删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除）
     *
     * @param status 状态（0正常 1删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getInspect() {
        return inspect;
    }

    public void setInspect(String inspect) {
        this.inspect = inspect;
    }
}