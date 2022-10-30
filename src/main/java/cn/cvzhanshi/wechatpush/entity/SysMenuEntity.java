package cn.cvzhanshi.wechatpush.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 菜单权限表
 * 
 * @author 青蛙军曹
 * @email 1466981275@qq.com
 * @date 2022-09-12 10:39:22
 */
@Data
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID
	 */
	@TableId
	private Long menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 父菜单ID
	 */
	private Long parentId;
	/**
	 * 显示顺序
	 */
	private Integer orderNum;
	/**
	 * 路由地址
	 */
	private String path;
	/**
	 * 组件路径
	 */
	private String component;
	/**
	 * 路由参数
	 */
	private String query;
	/**
	 * 是否为外链（0是 1否）
	 */
	private Integer isFrame;
	/**
	 * 是否缓存（0缓存 1不缓存）
	 */
	private Integer isCache;
	/**
	 * 菜单类型（M目录 C菜单 F按钮）
	 */
	private String menuType;
	/**
	 * 菜单状态（0显示 1隐藏）
	 */
	private String visible;
	/**
	 * 菜单状态（0正常 1停用）
	 */
	private String status;
	/**
	 * 权限标识
	 */
	private String perms;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 创建者
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新者
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;

}
