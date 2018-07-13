package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "record_individual_noise")
public class RecordIndividualNoise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 车间
     */
    private String workshop;

    /**
     * 岗位
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 主要停留地点
     */
    @Column(name = "stop_place")
    private String stopPlace;

    /**
     * 接触时间
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "contact_time")
    private Date contactTime;

    /**
     * 8h（或40h）等效声级[dB(A)]
     */
    @Column(name = "sound_level")
    private Integer soundLevel;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

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
     * 获取车间
     *
     * @return workshop - 车间
     */
    public String getWorkshop() {
        return workshop;
    }

    /**
     * 设置车间
     *
     * @param workshop 车间
     */
    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    /**
     * 获取岗位
     *
     * @return post_id - 岗位
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置岗位
     *
     * @param postId 岗位
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取主要停留地点
     *
     * @return stop_place - 主要停留地点
     */
    public String getStopPlace() {
        return stopPlace;
    }

    /**
     * 设置主要停留地点
     *
     * @param stopPlace 主要停留地点
     */
    public void setStopPlace(String stopPlace) {
        this.stopPlace = stopPlace;
    }

    /**
     * 获取接触时间
     *
     * @return contact_time - 接触时间
     */
    public Date getContactTime() {
        return contactTime;
    }

    /**
     * 设置接触时间
     *
     * @param contactTime 接触时间
     */
    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    /**
     * 获取8h（或40h）等效声级[dB(A)]
     *
     * @return sound_level - 8h（或40h）等效声级[dB(A)]
     */
    public Integer getSoundLevel() {
        return soundLevel;
    }

    /**
     * 设置8h（或40h）等效声级[dB(A)]
     *
     * @param soundLevel 8h（或40h）等效声级[dB(A)]
     */
    public void setSoundLevel(Integer soundLevel) {
        this.soundLevel = soundLevel;
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
}