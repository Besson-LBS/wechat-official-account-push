package cn.cvzhanshi.wechatpush.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.cvzhanshi.wechatpush.entity.SysMenuEntity;
import cn.cvzhanshi.wechatpush.service.SysMenuService;
import cn.cvzhanshi.wechatpush.utils.PageUtils;
import cn.cvzhanshi.wechatpush.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 菜单权限表
 *
 * @author 青蛙军曹
 * @email 1466981275@qq.com
 * @date 2022-09-12 10:39:22
 */
@RestController
@RequestMapping("/sysmenu")
@CrossOrigin
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        if (null != params.get("id")){
            wrapper.eq("menu_id",params.get("id"));
        }
        List<SysMenuEntity> list = sysMenuService.list(wrapper);
        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    public R info(@PathVariable("menuId") Long menuId){
		SysMenuEntity sysMenu = sysMenuService.getById(menuId);

        return R.ok().put("sysMenu", sysMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysMenuEntity sysMenu){
		sysMenuService.save(sysMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysMenuEntity sysMenu){
		sysMenuService.updateById(sysMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] menuIds){
		sysMenuService.removeByIds(Arrays.asList(menuIds));

        return R.ok();
    }

}
