package com.unit.dao;

import com.unit.domain.SysOperate;

public interface SysOperateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperate record);

    int insertSelective(SysOperate record);

    SysOperate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperate record);

    int updateByPrimaryKeyWithBLOBs(SysOperate record);

    int updateByPrimaryKey(SysOperate record);
}