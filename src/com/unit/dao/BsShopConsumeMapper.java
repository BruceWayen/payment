package com.unit.dao;

import com.unit.domain.BsShopConsume;

public interface BsShopConsumeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BsShopConsume record);

    int insertSelective(BsShopConsume record);

    BsShopConsume selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BsShopConsume record);

    int updateByPrimaryKeyWithBLOBs(BsShopConsume record);

    int updateByPrimaryKey(BsShopConsume record);
}