package com.unit.dao;

import com.unit.domain.BsRechargeInfo;

public interface BsRechargeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BsRechargeInfo record);

    int insertSelective(BsRechargeInfo record);

    BsRechargeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BsRechargeInfo record);

    int updateByPrimaryKeyWithBLOBs(BsRechargeInfo record);

    int updateByPrimaryKey(BsRechargeInfo record);
}