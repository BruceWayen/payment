package com.unit.dao;

import com.unit.domain.SysContractInfo;

public interface SysContractInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysContractInfo record);

    int insertSelective(SysContractInfo record);

    SysContractInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysContractInfo record);

    int updateByPrimaryKey(SysContractInfo record);
}