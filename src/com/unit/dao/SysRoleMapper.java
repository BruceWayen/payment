package com.unit.dao;

import com.unit.domain.SysRole;

import java.util.List;

public interface SysRoleMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    /**
     *@DESCRIPTION 获取所有角色
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-14:39
     *@CLASS_NAME SysRoleMapper
     **/
    List<SysRole> selectAll();

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}