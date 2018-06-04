package com.unit.dao;

import com.unit.domain.BsFoodInfo;

public interface BsFoodInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BsFoodInfo record);

    int insertSelective(BsFoodInfo record);

    BsFoodInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BsFoodInfo record);

    int updateByPrimaryKey(BsFoodInfo record);
}