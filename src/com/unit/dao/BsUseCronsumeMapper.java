package com.unit.dao;

import com.unit.domain.BsUseCronsume;

public interface BsUseCronsumeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BsUseCronsume record);

    int insertSelective(BsUseCronsume record);

    BsUseCronsume selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BsUseCronsume record);

    int updateByPrimaryKeyWithBLOBs(BsUseCronsume record);

    int updateByPrimaryKey(BsUseCronsume record);
}