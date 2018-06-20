package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "sys_work_type")
public class SysWorkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 工种名称
     */
    private String name;

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
     * 获取工种名称
     *
     * @return name - 工种名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置工种名称
     *
     * @param name 工种名称
     */
    public void setName(String name) {
        this.name = name;
    }
}