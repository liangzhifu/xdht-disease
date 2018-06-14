package com.xdht.disease.third.model;

import javax.persistence.*;

@Table(name = "sys_third")
public class SysThird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 第三方名称
     */
    @Column(name = "third_name")
    private String thirdName;

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
     * 获取第三方名称
     *
     * @return third_name - 第三方名称
     */
    public String getThirdName() {
        return thirdName;
    }

    /**
     * 设置第三方名称
     *
     * @param thirdName 第三方名称
     */
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }
}