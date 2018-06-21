package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "sys_dictionary_type")
public class SysDictionaryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 字典类型名称
     */
    @Column(name = "dictionary_type_name")
    private String dictionaryTypeName;

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
     * 获取字典类型名称
     *
     * @return dictionary_type_name - 字典类型名称
     */
    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    /**
     * 设置字典类型名称
     *
     * @param dictionaryTypeName 字典类型名称
     */
    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName;
    }
}