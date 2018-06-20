package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_company")
public class SysCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 单位名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 国民经济行业
     */
    @Column(name = "national_economic_industry")
    private String nationalEconomicIndustry;

    /**
     * 单位性质
     */
    @Column(name = "company_nature")
    private String companyNature;

    /**
     * 职业病危害类别
     */
    @Column(name = "industrial_disease_category")
    private String industrialDiseaseCategory;

    /**
     * 所属管辖
     */
    @Column(name = "belong_to_jurisdiction")
    private String belongToJurisdiction;

    /**
     * 经济类型
     */
    @Column(name = "economic_type")
    private String economicType;

    /**
     * 联系电话
     */
    @Column(name = "contact_number")
    private String contactNumber;

    /**
     * 传真电话
     */
    @Column(name = "fax_phone")
    private String faxPhone;

    /**
     * 法定代表人
     */
    @Column(name = "legal_representative")
    private String legalRepresentative;

    /**
     * 联系人姓名
     */
    @Column(name = "contact_userName")
    private String contactUsername;

    /**
     * 单位注册地址
     */
    @Column(name = "registered_address")
    private String registeredAddress;

    /**
     * 实际经营地址
     */
    @Column(name = "actual_operate_address")
    private String actualOperateAddress;

    /**
     * 单位网址
     */
    @Column(name = "company_url")
    private String companyUrl;

    /**
     * 成立日期
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "establish_date")
    private Date establishDate;

    /**
     * 生产规模
     */
    @Column(name = "production_scale")
    private String productionScale;

    /**
     * 主要产品
     */
    @Column(name = "main_products")
    private String mainProducts;

    /**
     * 主要原辅料
     */
    @Column(name = "main_raw_materials")
    private String mainRawMaterials;

    /**
     * 职业病危害因素
     */
    @Column(name = "occupational_hazard_factors")
    private String occupationalHazardFactors;

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
     * 获取单位名称
     *
     * @return company_name - 单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置单位名称
     *
     * @param companyName 单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取国民经济行业
     *
     * @return national_economic_industry - 国民经济行业
     */
    public String getNationalEconomicIndustry() {
        return nationalEconomicIndustry;
    }

    /**
     * 设置国民经济行业
     *
     * @param nationalEconomicIndustry 国民经济行业
     */
    public void setNationalEconomicIndustry(String nationalEconomicIndustry) {
        this.nationalEconomicIndustry = nationalEconomicIndustry;
    }

    /**
     * 获取单位性质
     *
     * @return company_nature - 单位性质
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * 设置单位性质
     *
     * @param companyNature 单位性质
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    /**
     * 获取职业病危害类别
     *
     * @return industrial_disease_category - 职业病危害类别
     */
    public String getIndustrialDiseaseCategory() {
        return industrialDiseaseCategory;
    }

    /**
     * 设置职业病危害类别
     *
     * @param industrialDiseaseCategory 职业病危害类别
     */
    public void setIndustrialDiseaseCategory(String industrialDiseaseCategory) {
        this.industrialDiseaseCategory = industrialDiseaseCategory;
    }

    /**
     * 获取所属管辖
     *
     * @return belong_to_jurisdiction - 所属管辖
     */
    public String getBelongToJurisdiction() {
        return belongToJurisdiction;
    }

    /**
     * 设置所属管辖
     *
     * @param belongToJurisdiction 所属管辖
     */
    public void setBelongToJurisdiction(String belongToJurisdiction) {
        this.belongToJurisdiction = belongToJurisdiction;
    }

    /**
     * 获取经济类型
     *
     * @return economic_type - 经济类型
     */
    public String getEconomicType() {
        return economicType;
    }

    /**
     * 设置经济类型
     *
     * @param economicType 经济类型
     */
    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }

    /**
     * 获取联系电话
     *
     * @return contact_number - 联系电话
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 设置联系电话
     *
     * @param contactNumber 联系电话
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * 获取传真电话
     *
     * @return fax_phone - 传真电话
     */
    public String getFaxPhone() {
        return faxPhone;
    }

    /**
     * 设置传真电话
     *
     * @param faxPhone 传真电话
     */
    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    /**
     * 获取法定代表人
     *
     * @return legal_representative - 法定代表人
     */
    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param legalRepresentative 法定代表人
     */
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    /**
     * 获取联系人姓名
     *
     * @return contact_userName - 联系人姓名
     */
    public String getContactUsername() {
        return contactUsername;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactUsername 联系人姓名
     */
    public void setContactUsername(String contactUsername) {
        this.contactUsername = contactUsername;
    }

    /**
     * 获取单位注册地址
     *
     * @return registered_address - 单位注册地址
     */
    public String getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * 设置单位注册地址
     *
     * @param registeredAddress 单位注册地址
     */
    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    /**
     * 获取实际经营地址
     *
     * @return actual_operate_address - 实际经营地址
     */
    public String getActualOperateAddress() {
        return actualOperateAddress;
    }

    /**
     * 设置实际经营地址
     *
     * @param actualOperateAddress 实际经营地址
     */
    public void setActualOperateAddress(String actualOperateAddress) {
        this.actualOperateAddress = actualOperateAddress;
    }

    /**
     * 获取单位网址
     *
     * @return company_url - 单位网址
     */
    public String getCompanyUrl() {
        return companyUrl;
    }

    /**
     * 设置单位网址
     *
     * @param companyUrl 单位网址
     */
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    /**
     * 获取成立日期
     *
     * @return establish_date - 成立日期
     */
    public Date getEstablishDate() {
        return establishDate;
    }

    /**
     * 设置成立日期
     *
     * @param establishDate 成立日期
     */
    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    /**
     * 获取生产规模
     *
     * @return production
_scale - 生产规模
     */
    public String getProductionScale() {
        return productionScale;
    }

    /**
     * 设置生产规模
     *
     * @param productionScale 生产规模
     */
    public void setProductionScale(String productionScale) {
        this.productionScale = productionScale;
    }

    /**
     * 获取主要产品
     *
     * @return main_products - 主要产品
     */
    public String getMainProducts() {
        return mainProducts;
    }

    /**
     * 设置主要产品
     *
     * @param mainProducts 主要产品
     */
    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
    }

    /**
     * 获取主要原辅料
     *
     * @return main_raw_materials - 主要原辅料
     */
    public String getMainRawMaterials() {
        return mainRawMaterials;
    }

    /**
     * 设置主要原辅料
     *
     * @param mainRawMaterials 主要原辅料
     */
    public void setMainRawMaterials(String mainRawMaterials) {
        this.mainRawMaterials = mainRawMaterials;
    }

    /**
     * 获取职业病危害因素
     *
     * @return occupational_hazard_factors - 职业病危害因素
     */
    public String getOccupationalHazardFactors() {
        return occupationalHazardFactors;
    }

    /**
     * 设置职业病危害因素
     *
     * @param occupationalHazardFactors 职业病危害因素
     */
    public void setOccupationalHazardFactors(String occupationalHazardFactors) {
        this.occupationalHazardFactors = occupationalHazardFactors;
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