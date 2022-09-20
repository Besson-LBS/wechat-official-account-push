package cn.cvzhanshi.wechatpush.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;


    public <T> T getData(TypeReference<T> reference) {

        Object data = get("data");
        String s = JSON.toJSONString(data);
        return JSON.parseObject(s, reference);
    }

    public <T> T getData(Class<T> clazz) {

        Object data = get("data");
        String s = JSON.toJSONString(data);
        return JSON.parseObject(s, clazz);
    }

    public <T> T getDataByName(String name, Class<T> clazz) {

        Object data = get(name);
        String s = JSON.toJSONString(data);
        return JSON.parseObject(s, clazz);
    }

    public R setData(Object objects) {
        put("data", objects);
        return this;
    }

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getCode() {
        String code = this.get("code").toString();
        return Integer.parseInt(code);
    }

}
