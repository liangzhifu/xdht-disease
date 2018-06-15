package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysCompanyRequest {

    @ApiModelProperty(value = "单位id")
    private Long id;

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "国民经济行业")
    private String nationalEconomicIndustry;

    @ApiModelProperty(value = "单位性质")
    private String companyNature;

    @ApiModelProperty(value = "职业病危害类别")
    private String industrialDiseaseCategory;

    @ApiModelProperty(value = "所属管辖")
    private String belongToJurisdiction;

    @ApiModelProperty(value = "经济类型")
    private String economicType;

    @ApiModelProperty(value = "联系电话")
    private String contactNumber;

    @ApiModelProperty(value = "传真电话")
    private String faxPhone;

    @ApiModelProperty(value = "法定代表人")
    private String legalRepresentative;

    @ApiModelProperty(value = "联系人姓名")
    private String contactUsername;

    @ApiModelProperty(value = "单位注册地址")
    private String registeredAddress;

    @ApiModelProperty(value = "实际经营地址")
    private String actualOperateAddress;

    @ApiModelProperty(value = "单位网址")
    private String companyUrl;

    @ApiModelProperty(value = "成立日期")
    private Date establishDate;

    @ApiModelProperty(value = "生产规模")
    private String productionScale;

    @ApiModelProperty(value = "主要产品")
    private String mainProducts;

    @ApiModelProperty(value = "主要原辅料")
    private String mainRawMaterials;

    @ApiModelProperty(value = "职业病危害因素")
    private String occupationalHazardFactors;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
}
