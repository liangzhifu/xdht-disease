package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Table(name = "record_employee_summary")
public class RecordEmployeeSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 职工ID
     */
    @Column(name = "emp_id")
    private Long empId;

    /**
     * 部门ID
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 工种
     */
    @Column(name = "work_type")
    private Long workType;

    /**
     * 检查日期
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "inspect_date")
    private Date inspectDate;

    /**
     * 0：初检  1：复检
     */
    private String inspect;

    /**
     * 接噪工龄
     */
    @Column(name = "contact_time")
    private Integer contactTime;

    /**
     * 职业病危害因素
     */
    @Column(name = "hazard_factor")
    private String hazardFactor;

    /**
     * 血压收缩压
     */
    @Column(name = "blood_pressure_shrink")
    private Long bloodPressureShrink;

    /**
     * 血压舒张压
     */
    @Column(name = "blood_pressure_diastole")
    private Long bloodPressureDiastole;

    /**
     * 心脏
     */
    private String heart;

    /**
     * 肺
     */
    private String lungs;

    /**
     * 皮肤粘膜
     */
    @Column(name = "skin_mucous_membrane")
    private String skinMucousMembrane;

    /**
     * 浅表淋巴结
     */
    @Column(name = "lymph_node")
    private String lymphNode;

    /**
     * 甲状腺
     */
    @Column(name = "thyroid_gland")
    private String thyroidGland;

    /**
     * 耳朵
     */
    private String ear;

    /**
     * 白细胞×109/L
     */
    @Column(name = "white_blood_cell")
    private Long whiteBloodCell;

    /**
     * 中性粒细胞计数×109/L
     */
    @Column(name = "neutrophile_granulocyte")
    private Long neutrophileGranulocyte;

    /**
     * 红细胞计数×1012/L
     */
    @Column(name = "red_blood_cell")
    private Long redBloodCell;

    /**
     * 血色素g/L
     */
    private Long hemoglobin;

    /**
     * 血小板×109/L
     */
    private Long platelet;

    /**
     * 白细胞（尿）
     */
    @Column(name = "white_blood_cell_urine")
    private String whiteBloodCellUrine;

    /**
     * 尿蛋白
     */
    @Column(name = "urine_protein")
    private String urineProtein;

    /**
     * 尿潜血
     */
    @Column(name = "urine_occult_blood")
    private String urineOccultBlood;

    /**
     * 尿糖
     */
    @Column(name = "urine_sugar")
    private String urineSugar;

    /**
     * ALTU/L
     */
    @Column(name = "ALTU_L")
    private String altuL;

    /**
     * 心电图
     */
    private String electrocardiogram;

    @Column(name = "dbhl_500_l")
    private Long dbhl500L;

    @Column(name = "dbhl_1k_l")
    private Long dbhl1kL;

    @Column(name = "dbhl_2k_l")
    private Long dbhl2kL;

    @Column(name = "dbhl_3k_l")
    private Long dbhl3kL;

    @Column(name = "dbhl_4k_l")
    private Long dbhl4kL;

    @Column(name = "dbhl_6k_l")
    private Long dbhl6kL;

    @Column(name = "dbhl_500_r")
    private Long dbhl500R;

    @Column(name = "dbhl_1k_r")
    private Long dbhl1kR;

    @Column(name = "dbhl_2k_r")
    private Long dbhl2kR;

    @Column(name = "dbhl_3k_r")
    private Long dbhl3kR;

    @Column(name = "dbhl_4k_r")
    private Long dbhl4kR;

    @Column(name = "dbhl_6k_r")
    private Long dbhl6kR;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

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
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

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
     * 获取职工ID
     *
     * @return emp_id - 职工ID
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * 设置职工ID
     *
     * @param empId 职工ID
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * 获取部门ID
     *
     * @return office_id - 部门ID
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门ID
     *
     * @param officeId 部门ID
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取工种
     *
     * @return work_type - 工种
     */
    public Long getWorkType() {
        return workType;
    }

    /**
     * 设置工种
     *
     * @param workType 工种
     */
    public void setWorkType(Long workType) {
        this.workType = workType;
    }

    /**
     * 获取接噪工龄
     *
     * @return contact_time - 接噪工龄
     */
    public Integer getContactTime() {
        return contactTime;
    }

    /**
     * 设置接噪工龄
     *
     * @param contactTime 接噪工龄
     */
    public void setContactTime(Integer contactTime) {
        this.contactTime = contactTime;
    }

    /**
     * 获取职业病危害因素
     *
     * @return hazard_factor - 职业病危害因素
     */
    public String getHazardFactor() {
        return hazardFactor;
    }

    /**
     * 设置职业病危害因素
     *
     * @param hazardFactor 职业病危害因素
     */
    public void setHazardFactor(String hazardFactor) {
        this.hazardFactor = hazardFactor;
    }

    /**
     * 获取血压收缩压
     *
     * @return blood_pressure_shrink - 血压收缩压
     */
    public Long getBloodPressureShrink() {
        return bloodPressureShrink;
    }

    /**
     * 设置血压收缩压
     *
     * @param bloodPressureShrink 血压收缩压
     */
    public void setBloodPressureShrink(Long bloodPressureShrink) {
        this.bloodPressureShrink = bloodPressureShrink;
    }

    /**
     * 获取血压舒张压
     *
     * @return blood_pressure_diastole - 血压舒张压
     */
    public Long getBloodPressureDiastole() {
        return bloodPressureDiastole;
    }

    /**
     * 设置血压舒张压
     *
     * @param bloodPressureDiastole 血压舒张压
     */
    public void setBloodPressureDiastole(Long bloodPressureDiastole) {
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
     * 获取白细胞×109/L
     *
     * @return white_blood_cell - 白细胞×109/L
     */
    public Long getWhiteBloodCell() {
        return whiteBloodCell;
    }

    /**
     * 设置白细胞×109/L
     *
     * @param whiteBloodCell 白细胞×109/L
     */
    public void setWhiteBloodCell(Long whiteBloodCell) {
        this.whiteBloodCell = whiteBloodCell;
    }

    /**
     * 获取中性粒细胞计数×109/L
     *
     * @return neutrophile_granulocyte - 中性粒细胞计数×109/L
     */
    public Long getNeutrophileGranulocyte() {
        return neutrophileGranulocyte;
    }

    /**
     * 设置中性粒细胞计数×109/L
     *
     * @param neutrophileGranulocyte 中性粒细胞计数×109/L
     */
    public void setNeutrophileGranulocyte(Long neutrophileGranulocyte) {
        this.neutrophileGranulocyte = neutrophileGranulocyte;
    }

    /**
     * 获取红细胞计数×1012/L
     *
     * @return red_blood_cell - 红细胞计数×1012/L
     */
    public Long getRedBloodCell() {
        return redBloodCell;
    }

    /**
     * 设置红细胞计数×1012/L
     *
     * @param redBloodCell 红细胞计数×1012/L
     */
    public void setRedBloodCell(Long redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    /**
     * 获取血色素g/L
     *
     * @return hemoglobin - 血色素g/L
     */
    public Long getHemoglobin() {
        return hemoglobin;
    }

    /**
     * 设置血色素g/L
     *
     * @param hemoglobin 血色素g/L
     */
    public void setHemoglobin(Long hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    /**
     * 获取血小板×109/L
     *
     * @return platelet - 血小板×109/L
     */
    public Long getPlatelet() {
        return platelet;
    }

    /**
     * 设置血小板×109/L
     *
     * @param platelet 血小板×109/L
     */
    public void setPlatelet(Long platelet) {
        this.platelet = platelet;
    }

    /**
     * 获取白细胞（尿）
     *
     * @return white_blood_cell_urine - 白细胞（尿）
     */
    public String getWhiteBloodCellUrine() {
        return whiteBloodCellUrine;
    }

    /**
     * 设置白细胞（尿）
     *
     * @param whiteBloodCellUrine 白细胞（尿）
     */
    public void setWhiteBloodCellUrine(String whiteBloodCellUrine) {
        this.whiteBloodCellUrine = whiteBloodCellUrine;
    }

    /**
     * 获取尿蛋白
     *
     * @return urine_protein - 尿蛋白
     */
    public String getUrineProtein() {
        return urineProtein;
    }

    /**
     * 设置尿蛋白
     *
     * @param urineProtein 尿蛋白
     */
    public void setUrineProtein(String urineProtein) {
        this.urineProtein = urineProtein;
    }

    /**
     * 获取尿潜血
     *
     * @return urine_occult_blood - 尿潜血
     */
    public String getUrineOccultBlood() {
        return urineOccultBlood;
    }

    /**
     * 设置尿潜血
     *
     * @param urineOccultBlood 尿潜血
     */
    public void setUrineOccultBlood(String urineOccultBlood) {
        this.urineOccultBlood = urineOccultBlood;
    }

    /**
     * 获取尿糖
     *
     * @return urine_sugar - 尿糖
     */
    public String getUrineSugar() {
        return urineSugar;
    }

    /**
     * 设置尿糖
     *
     * @param urineSugar 尿糖
     */
    public void setUrineSugar(String urineSugar) {
        this.urineSugar = urineSugar;
    }

    /**
     * 获取ALTU/L
     *
     * @return ALTU_L - ALTU/L
     */
    public String getAltuL() {
        return altuL;
    }

    /**
     * 设置ALTU/L
     *
     * @param altuL ALTU/L
     */
    public void setAltuL(String altuL) {
        this.altuL = altuL;
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
     * @return dbhl_500_l
     */
    public Long getDbhl500L() {
        return dbhl500L;
    }

    /**
     * @param dbhl500L
     */
    public void setDbhl500L(Long dbhl500L) {
        this.dbhl500L = dbhl500L;
    }

    /**
     * @return dbhl_1k_l
     */
    public Long getDbhl1kL() {
        return dbhl1kL;
    }

    /**
     * @param dbhl1kL
     */
    public void setDbhl1kL(Long dbhl1kL) {
        this.dbhl1kL = dbhl1kL;
    }

    /**
     * @return dbhl_2k_l
     */
    public Long getDbhl2kL() {
        return dbhl2kL;
    }

    /**
     * @param dbhl2kL
     */
    public void setDbhl2kL(Long dbhl2kL) {
        this.dbhl2kL = dbhl2kL;
    }

    /**
     * @return dbhl_3k_l
     */
    public Long getDbhl3kL() {
        return dbhl3kL;
    }

    /**
     * @param dbhl3kL
     */
    public void setDbhl3kL(Long dbhl3kL) {
        this.dbhl3kL = dbhl3kL;
    }

    /**
     * @return dbhl_4k_l
     */
    public Long getDbhl4kL() {
        return dbhl4kL;
    }

    /**
     * @param dbhl4kL
     */
    public void setDbhl4kL(Long dbhl4kL) {
        this.dbhl4kL = dbhl4kL;
    }

    /**
     * @return dbhl_6k_l
     */
    public Long getDbhl6kL() {
        return dbhl6kL;
    }

    /**
     * @param dbhl6kL
     */
    public void setDbhl6kL(Long dbhl6kL) {
        this.dbhl6kL = dbhl6kL;
    }

    /**
     * @return dbhl_500_r
     */
    public Long getDbhl500R() {
        return dbhl500R;
    }

    /**
     * @param dbhl500R
     */
    public void setDbhl500R(Long dbhl500R) {
        this.dbhl500R = dbhl500R;
    }

    /**
     * @return dbhl_1k_r
     */
    public Long getDbhl1kR() {
        return dbhl1kR;
    }

    /**
     * @param dbhl1kR
     */
    public void setDbhl1kR(Long dbhl1kR) {
        this.dbhl1kR = dbhl1kR;
    }

    /**
     * @return dbhl_2k_r
     */
    public Long getDbhl2kR() {
        return dbhl2kR;
    }

    /**
     * @param dbhl2kR
     */
    public void setDbhl2kR(Long dbhl2kR) {
        this.dbhl2kR = dbhl2kR;
    }

    /**
     * @return dbhl_3k_r
     */
    public Long getDbhl3kR() {
        return dbhl3kR;
    }

    /**
     * @param dbhl3kR
     */
    public void setDbhl3kR(Long dbhl3kR) {
        this.dbhl3kR = dbhl3kR;
    }

    /**
     * @return dbhl_4k_r
     */
    public Long getDbhl4kR() {
        return dbhl4kR;
    }

    /**
     * @param dbhl4kR
     */
    public void setDbhl4kR(Long dbhl4kR) {
        this.dbhl4kR = dbhl4kR;
    }

    /**
     * @return dbhl_6k_r
     */
    public Long getDbhl6kR() {
        return dbhl6kR;
    }

    /**
     * @param dbhl6kR
     */
    public void setDbhl6kR(Long dbhl6kR) {
        this.dbhl6kR = dbhl6kR;
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
     * 获取更新人
     *
     * @return upadte_by - 更新人
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

    public Date getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public String getInspect() {
        return inspect;
    }

    public void setInspect(String inspect) {
        this.inspect = inspect;
    }
}