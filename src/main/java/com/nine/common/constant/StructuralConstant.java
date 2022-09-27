package com.nine.common.constant;

public class StructuralConstant {
    /**
     * 路面层位结构
     */
    public enum HorizonStructuralEnum{
        SURFACE(0, "面层"),
        BASE(1, "基层"),
        SUBBASE(2, "底基层"),
        SUBGRADE(3, "土基");

        private int code;
        private String msg;

        HorizonStructuralEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }
        public int getCode(){return code;}
        public String getMsg(){return msg;}
    }
}
