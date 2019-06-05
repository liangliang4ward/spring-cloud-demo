package com.xzl.demo.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.time.LocalDate;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author auto-generator
* @since 2019-06-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class WxbLift implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId(value = "guid", type = IdType.AUTO)
    private Integer guid;

            /**
            * 电梯注册编码
            */
    private String registerCode;

            /**
            * 电梯识别码
            */
    private String idCode;

            /**
            * 省编码
            */
    private String provinceCode;

            /**
            * 市编码
            */
    private String cityCode;

            /**
            * 区编码
            */
    private String townCode;

            /**
            * 街道编码
            */
    private String streetCode;

            /**
            * 省-市-区-街道
            */
    private String regiName;

            /**
            * 所在场所编码
            */
    private String locationGuid;

            /**
            * 所在场所名称
            */
    private String locationName;

            /**
            * locationType
            */
    private String locationType;

            /**
            * 场所类型名称
            */
    private String locationTypeName;

            /**
            * 场所详细地址
            */
    private String locationAddress;

            /**
            * 内部电梯编号
            */
    private String liftCode;

            /**
            * 使用单位主键
            */
    private Integer unitGuid;

            /**
            * 使用单位名称
            */
    private String unitName;

            /**
            * 楼幢梯号
            */
    private String liftName;

            /**
            * 使用类型
            */
    private Integer useType;

            /**
            * 使用类型名称
            */
    private String useTypeName;

            /**
            * 电梯类型
            */
    private String liftType;

            /**
            * 电梯类型名称
            */
    private String liftTypeName;

            /**
            * 状态
            */
    private String status;

            /**
            * 电梯型号
            */
    private String liftModel;

            /**
            * 层数
            */
    private Integer floorNum;

            /**
            * 站数
            */
    private Integer stationNum;

            /**
            * 门数
            */
    private Integer doorNum;

            /**
            * 拖动方式
            */
    private String controllerMode;

            /**
            * 额定载重
            */
    private String limitWeight;

            /**
            * 额定速度
            */
    private String limitSpeed;

            /**
            * 制造单位
            */
    private String makeCompany;

            /**
            * 制造单位名称
            */
    private String makeCompanyName;

            /**
            * 制造日期
            */
    private LocalDate madeTime;

            /**
            * 制造地址
            */
    private String makeAddress;

            /**
            * 许可证号
            */
    private String makePermit;

            /**
            * 品牌编码（数据字典位置）
            */
    private String brandCode;

            /**
            * 品牌名称
            */
    private String brandName;

            /**
            * 产权单位
            */
    private String propertyUnit;

            /**
            * 安装单位
            */
    private String installUnit;

            /**
            * 安装单位地址
            */
    private String installUnitAddress;

            /**
            * 检验单位
            */
    private String inspectionUnit;

            /**
            * 大修日期
            */
    private LocalDate overhaulTime;

            /**
            * 上次维修日期
            */
    private LocalDate lastOverhaulTime;

            /**
            * 投用日期
            */
    private LocalDate useStartTime;

            /**
            * 维保单位
            */
    private Integer maintainEnter;

            /**
            * 维保单位名称
            */
    private String maintainEnterName;

            /**
            * 维保单位地址
            */
    private String maintainEnterAddress;

            /**
            * 电梯维护人
            */
    private String maintainOper;

            /**
            * 电梯维护电话
            */
    private String maintainPhone;

            /**
            * 经度
            */
    private String lon;

            /**
            * 纬度
            */
    private String lat;

            /**
            * 出厂编号
            */
    private String exFactoryCode;

            /**
            * 使用单位地址
            */
    private String unitAddress;

            /**
            * 使用状态名称
            */
    private String useStatusName;

            /**
            * 拖动方式编码
            */
    private String controllerModeCode;

            /**
            * 物联网接入标志位
            */
    private Integer connectNetFlag;

            /**
            * 电梯编码
            */
    private String liftNo;

            /**
            * 责任人
            */
    private String chargeOper;

            /**
            * 责任人电话
            */
    private String chargePhone;

            /**
            * 注册单位
            */
    private Integer registerDepartment;

            /**
            * 注册单位名称
            */
    private String registerDepartmentName;

            /**
            * 检验单位
            */
    private Integer checkUnit;

            /**
            * 检验单位名称
            */
    private String checkUnitName;

            /**
            * 消防单位
            */
    private Integer fireEnter;

            /**
            * 消防单位名称
            */
    private String fireEnterName;

            /**
            * 96333中心
            */
    private Integer liftManageCenter;

            /**
            * 96333中心名称
            */
    private String liftManageCenterName;

            /**
            * 楼号
            */
    private String floorNo;

            /**
            * 单元号
            */
    private String partNo;

            /**
            * 电梯号
            */
    private String elevatorNo;

            /**
            * 是否有屏 1-有 2-无
            */
    private String isHaveScreen;

            /**
            * 设备名称
            */
    private String liftEquipmentName;

            /**
            * 状态 1-下发中，2-是，3-否 ，4-未知
            */
    private Integer state;

            /**
            * 是否接入96333 1否 2是
            */
            @TableField("is_96333")
    private Integer is96333;

            /**
            * 维保单id
            */
    private Integer maintListId;

            /**
            * 维保单名称
            */
    private String maintListName;

            /**
            * 是否对接第三方维保 0-否 1-是
            */
    private Integer isExternalMaint;

            /**
            * 第三方维保方编码
            */
    private String externalMaintCode;

            /**
            * 第三方维保方名称
            */
    private String externalMaintName;

            /**
            * 对讲类型 1-可视对讲 2- 语音对讲'
            */
    private String talkType;

            /**
            * 对讲类型名称
            */
    private String talkTypeName;

            /**
            * 产品代数，3为三代，4为四代
            */
    private String generation;

            /**
            * 是否接入云梯标识 1：是 2：否
            */
    private Integer ytFlag;

            /**
            * 下次检验日期
            */
    private LocalDate nextCheckTime;

            /**
            * 云梯状态 10-安装调试 20-正常 30-维护 40-演示 50-测试
            */
    private String ytStatus;

            /**
            * 上线时间
            */
    private LocalDateTime onlineDate;

            /**
            * 屏幕数量 默认0
            */
    private Integer screenNum;


}
