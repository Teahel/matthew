package com.matthew.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.Utils
 * @CreateDate: 2019/9/19 17:32
 * @Version: 1.0
 */
public class ReturnResultUtils extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public ReturnResultUtils() {
        put("code", 000);
        put("msg", "success");
    }

    public static ReturnResultUtils error(int code, String msg) {
        ReturnResultUtils r = new ReturnResultUtils();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ReturnResultUtils ok(String msg) {
        ReturnResultUtils r = new ReturnResultUtils();
        r.put("msg", msg);
        return r;
    }

    public static ReturnResultUtils ok(Map<String, Object> map) {
        ReturnResultUtils r = new ReturnResultUtils();
        r.putAll(map);
        return r;
    }

    public static ReturnResultUtils ok() {
        return new ReturnResultUtils();
    }

    @Override
    public ReturnResultUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 添加单个对象数据
     *
     * @param value 传入的值
     * @return 封装结果
     */
    public ReturnResultUtils putObject(Object value) {
        super.put("data", value);
        return this;
    }

    /**
     * 添加List对象
     *
     * @param value 传入的值
     * @return 封装结果
     */
    public ReturnResultUtils putList(Object value) {
        super.put("list", value);
        return this;
    }

    /**
     * 添加分页数据
     *
     * @param value 传入的值
     * @return 封装结果
     */
    public ReturnResultUtils putPage(Object value) {
        super.put("page", value);
        return this;
    }

    /**
     * 添加Map数据
     *
     * @param map 传入的值
     * @return 封装结果
     */
    public ReturnResultUtils putMap(Map<String, Object> map) {
        super.putAll(map);
        return this;
    }

}
