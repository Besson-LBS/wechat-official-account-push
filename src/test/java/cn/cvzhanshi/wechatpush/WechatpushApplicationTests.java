package cn.cvzhanshi.wechatpush;

import cn.cvzhanshi.wechatpush.dao.SysMenuDao;
import cn.cvzhanshi.wechatpush.entity.SysMenuEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class WechatpushApplicationTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SysMenuDao sysMenuDao;

    @Test
    public void contextLoads() {
//        System.out.println(sqlSessionFactory);
//        SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(sqlSessionFactory);
//        HashMap<Object, Object> map = new HashMap<>();
//
//        Object queryNotButtonList = sqlSessionManager.selectOne("queryNotButtonList", map);
//        SysMenuEntity sysMenuEntity = JSONObject.toJavaObject(JSON.parseObject(JSONObject.toJSONString(queryNotButtonList)), SysMenuEntity.class);
//        System.out.println(sysMenuEntity);

        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        sysMenuEntity.setMenuId(2L);

        List<SysMenuEntity> sysMenuEntities = sysMenuDao.queryNotButtonList(sysMenuEntity);
        System.out.println(sysMenuEntities.size());
    }

}
