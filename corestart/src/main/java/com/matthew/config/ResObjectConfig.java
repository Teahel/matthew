package com.matthew.config;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 18:00 2019/12/2
 */
public class ResObjectConfig {

    private int code;

    private Object data;

    private String desc;

    public ResObjectConfig(int code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    public ResObjectConfig(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ResObjectConfig(int code, Object data, String desc) {
        super();
        this.code = code;
        this.data = data;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
