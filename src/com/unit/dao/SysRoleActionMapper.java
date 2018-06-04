package com.unit.dao;

import com.unit.domain.SysRoleAction;

public interface SysRoleActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAction record);

    int insertSelective(SysRoleAction record);

    SysRoleAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleAction record);

    int updateByPrimaryKey(SysRoleAction record);
}