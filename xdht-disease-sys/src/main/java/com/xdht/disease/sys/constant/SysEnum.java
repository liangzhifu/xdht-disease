package com.xdht.disease.sys.constant;

/**
 * Created by L on 2018/6/10.
 */
public class SysEnum {

    public enum MenuTypeEnum{
        MENU_TYPE_MENU("1", "菜单"),
        MENU_TYPE_AUTHORITY("2", "权限");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }

        MenuTypeEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }

    public enum IsShowEnum{
        IS_SHOW_NO("0", "不显示"),
        IS_SHOW_YES("1", "显示");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }

        IsShowEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }

    public enum ResultEnum{
        RESULT_FAIL("0", "失败"),
        RESULT_SUCCESS("1", "成功");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }

        ResultEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }

    public enum StatusEnum {

        STATUS_NORMAL("0", "正常"),
        STATUS_DELETE("1", "删除"),
        STATUS_DISCONTINNATION("2", "停用");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }

        StatusEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static SysEnum.StatusEnum getInsuranceTypeByCode(String status) {
            status = status.trim();
            for (SysEnum.StatusEnum statusEnum : SysEnum.StatusEnum.values()) {
                if (status.equals(statusEnum.getCode())) {
                    return statusEnum;
                }
            }
            return null;
        }
    }
}
