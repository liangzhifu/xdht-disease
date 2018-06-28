package com.xdht.disease.sys.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "record_building_base_data")
public class RecordBuildingBaseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 建筑物基本情况id
     */
    @Column(name = "building_base_id")
    private Long buildingBaseId;

    /**
     * 建筑物名称
     */
    @Column(name = "building_name")
    private String buildingName;

    /**
     * 结构
     */
    private String structure;

    /**
     * 层数
     */
    private Long layers;

    /**
     * 建筑面积（m2）
     */
    @Column(name = "built_up_area")
    private Long builtUpArea;

    /**
     * 采光方式
     */
    @Column(name = "lighting_mode")
    private String lightingMode;

    /**
     * 照明方式
     */
    @Column(name = "lighting_system")
    private String lightingSystem;

    /**
     * 照明灯具
     */
    @Column(name = "lighting_lamps")
    private String lightingLamps;

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
     * 获取建筑物名称
     *
     * @return building_name - 建筑物名称
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置建筑物名称
     *
     * @param buildingName 建筑物名称
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * 获取结构
     *
     * @return structure - 结构
     */
    public String getStructure() {
        return structure;
    }

    /**
     * 设置结构
     *
     * @param structure 结构
     */
    public void setStructure(String structure) {
        this.structure = structure;
    }

    /**
     * 获取层数
     *
     * @return layers - 层数
     */
    public Long getLayers() {
        return layers;
    }

    /**
     * 设置层数
     *
     * @param layers 层数
     */
    public void setLayers(Long layers) {
        this.layers = layers;
    }

    /**
     * 获取建筑面积（m2）
     *
     * @return built_up_area - 建筑面积（m2）
     */
    public Long getBuiltUpArea() {
        return builtUpArea;
    }

    /**
     * 设置建筑面积（m2）
     *
     * @param builtUpArea 建筑面积（m2）
     */
    public void setBuiltUpArea(Long builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    /**
     * 获取采光方式
     *
     * @return lighting_mode - 采光方式
     */
    public String getLightingMode() {
        return lightingMode;
    }

    /**
     * 设置采光方式
     *
     * @param lightingMode 采光方式
     */
    public void setLightingMode(String lightingMode) {
        this.lightingMode = lightingMode;
    }

    /**
     * 获取照明方式
     *
     * @return lighting_system - 照明方式
     */
    public String getLightingSystem() {
        return lightingSystem;
    }

    /**
     * 设置照明方式
     *
     * @param lightingSystem 照明方式
     */
    public void setLightingSystem(String lightingSystem) {
        this.lightingSystem = lightingSystem;
    }

    /**
     * 获取照明灯具
     *
     * @return lighting_lamps - 照明灯具
     */
    public String getLightingLamps() {
        return lightingLamps;
    }

    /**
     * 设置照明灯具
     *
     * @param lightingLamps 照明灯具
     */
    public void setLightingLamps(String lightingLamps) {
        this.lightingLamps = lightingLamps;
    }

    public Long getBuildingBaseId() {
        return buildingBaseId;
    }

    public void setBuildingBaseId(Long buildingBaseId) {
        this.buildingBaseId = buildingBaseId;
    }


}