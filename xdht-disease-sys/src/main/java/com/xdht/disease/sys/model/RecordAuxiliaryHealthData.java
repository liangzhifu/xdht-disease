package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_auxiliary_health_data")
public class RecordAuxiliaryHealthData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 工作场所办公室（控制室、办公室）
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）
     */
    @Column(name = "hygienic_room")
    private String hygienicRoom;

    /**
     * 生活用室（休息室、食堂、厕所等）
     */
    @Column(name = "living_room")
    private String livingRoom;

    /**
     * 卫生室调查表ID
     */
    @Column(name = "auxiliary_health_id")
    private Long auxiliaryHealthId;

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
     * 获取部门id
     *
     * @return office_id - 部门id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门id
     *
     * @param officeId 部门id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取工作场所办公室（控制室、办公室）
     *
     * @return work_place - 工作场所办公室（控制室、办公室）
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置工作场所办公室（控制室、办公室）
     *
     * @param workPlace 工作场所办公室（控制室、办公室）
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * 获取车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）
     *
     * @return hygienic_room - 车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）
     */
    public String getHygienicRoom() {
        return hygienicRoom;
    }

    /**
     * 设置车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）
     *
     * @param hygienicRoom 车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）
     */
    public void setHygienicRoom(String hygienicRoom) {
        this.hygienicRoom = hygienicRoom;
    }

    /**
     * 获取生活用室（休息室、食堂、厕所等）
     *
     * @return living_room - 生活用室（休息室、食堂、厕所等）
     */
    public String getLivingRoom() {
        return livingRoom;
    }

    /**
     * 设置生活用室（休息室、食堂、厕所等）
     *
     * @param livingRoom 生活用室（休息室、食堂、厕所等）
     */
    public void setLivingRoom(String livingRoom) {
        this.livingRoom = livingRoom;
    }

    public Long getAuxiliaryHealthId() {
        return auxiliaryHealthId;
    }

    public void setAuxiliaryHealthId(Long auxiliaryHealthId) {
        this.auxiliaryHealthId = auxiliaryHealthId;
    }


}