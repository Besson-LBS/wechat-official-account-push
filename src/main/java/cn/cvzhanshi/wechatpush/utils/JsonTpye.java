package cn.cvzhanshi.wechatpush.utils;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

public class JsonTpye<T> extends TypeReference<T> {

    public JsonTpye() {
        super();
    }

    public JsonTpye(Type... actualTypeArguments) {
        super(actualTypeArguments);
    }
}
