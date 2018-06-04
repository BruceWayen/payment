package com.unit.dao;

import com.unit.domain.SysFeeInfo;

public interface SysFeeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFeeInfo record);

    int insertSelective(SysFeeInfo record);

    SysFeeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFeeInfo record);

    int updateByPrimaryKeyWithBLOBs(SysFeeInfo record);

    int updateByPrimaryKey(SysFeeInfo record);
}