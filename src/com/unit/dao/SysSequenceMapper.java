package com.unit.dao;

import com.unit.domain.SysSequence;

public interface SysSequenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSequence record);

    int insertSelective(SysSequence record);

    SysSequence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSequence record);

    int updateByPrimaryKey(SysSequence record);
}