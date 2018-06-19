package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_product_data")
public class RecordProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "company_office_id")
    private Long companyOfficeId;

    /**
     * 工艺过程
     */
    @Column(name = "process_name")
    private String processName;

    /**
     * 类别（原料、辅料、中间产品、产品等）
     */
    @Column(name = "product_type")
    private String productType;

    /**
     * 名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 形态
     */
    @Column(name = "product_shape")
    private String productShape;

    /**
     * 主要化学成分
     */
    @Column(name = "chemical_composition")
    private String chemicalComposition;

    /**
     * 存储方式
     */
    @Column(name = "storage_mode")
    private String storageMode;

    /**
     * 输送方式
     */
    @Column(name = "transport_mode")
    private String transportMode;

    /**
     * 年用量或产量
     */
    @Column(name = "annual_amount")
    private String annualAmount;

    /**
     * 关联id
     */
    @Column(name = "relation_id")
    private Long relationId;

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
     * 获取部门ID
     *
     * @return company_office_id - 部门ID
     */
    public Long getCompanyOfficeId() {
        return companyOfficeId;
    }

    /**
     * 设置部门ID
     *
     * @param companyOfficeId 部门ID
     */
    public void setCompanyOfficeId(Long companyOfficeId) {
        this.companyOfficeId = companyOfficeId;
    }

    /**
     * 获取工艺过程
     *
     * @return process_name - 工艺过程
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 设置工艺过程
     *
     * @param processName 工艺过程
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 获取类别（原料、辅料、中间产品、产品等）
     *
     * @return product_type - 类别（原料、辅料、中间产品、产品等）
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置类别（原料、辅料、中间产品、产品等）
     *
     * @param productType 类别（原料、辅料、中间产品、产品等）
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 获取名称
     *
     * @return product_name - 名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置名称
     *
     * @param productName 名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取形态
     *
     * @return product_shape - 形态
     */
    public String getProductShape() {
        return productShape;
    }

    /**
     * 设置形态
     *
     * @param productShape 形态
     */
    public void setProductShape(String productShape) {
        this.productShape = productShape;
    }

    /**
     * 获取主要化学成分
     *
     * @return chemical_composition - 主要化学成分
     */
    public String getChemicalComposition() {
        return chemicalComposition;
    }

    /**
     * 设置主要化学成分
     *
     * @param chemicalComposition 主要化学成分
     */
    public void setChemicalComposition(String chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    }

    /**
     * 获取存储方式
     *
     * @return storage_mode - 存储方式
     */
    public String getStorageMode() {
        return storageMode;
    }

    /**
     * 设置存储方式
     *
     * @param storageMode 存储方式
     */
    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode;
    }

    /**
     * 获取输送方式
     *
     * @return transport_mode - 输送方式
     */
    public String getTransportMode() {
        return transportMode;
    }

    /**
     * 设置输送方式
     *
     * @param transportMode 输送方式
     */
    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    /**
     * 获取年用量或产量
     *
     * @return annual_amount - 年用量或产量
     */
    public String getAnnualAmount() {
        return annualAmount;
    }

    /**
     * 设置年用量或产量
     *
     * @param annualAmount 年用量或产量
     */
    public void setAnnualAmount(String annualAmount) {
        this.annualAmount = annualAmount;
    }

    /**
     * 获取关联id
     * @return relationId
     */
    public Long getRelationId() {
        return relationId;
    }

    /** 设置关联id
     * @param relationId
     */
    public void setRelationId(Long relationId) { this.relationId = relationId; }
}