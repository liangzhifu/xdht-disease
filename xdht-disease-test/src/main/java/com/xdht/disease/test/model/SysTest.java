package com.xdht.disease.test.model;

import javax.persistence.*;

@Table(name = "sys_test")
public class SysTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 测试名称
     */
    @Column(name = "test_name")
    private String testName;

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
     * 获取测试名称
     *
     * @return test_name - 测试名称
     */
    public String getTestName() {
        return testName;
    }

    /**
     * 设置测试名称
     *
     * @param testName 测试名称
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }
}