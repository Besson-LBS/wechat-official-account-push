package cn.cvzhanshi.wechatpush.service.impl;

import cn.cvzhanshi.wechatpush.dao.SysMenuDao;
import cn.cvzhanshi.wechatpush.entity.SysMenuEntity;
import cn.cvzhanshi.wechatpush.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {


}