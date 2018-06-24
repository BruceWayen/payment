package com.unit.dao;

import com.unit.domain.SysSequence;
import org.apache.ibatis.annotations.Param;

public interface SysSequenceMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(SysSequence record);

    int insertSelective(SysSequence record);

    SysSequence selectByPrimaryKey(Integer id);

    SysSequence selectBySeqName(@Param("seqName") String seqName);

    int updateByPrimaryKeySelective(SysSequence record);

    int updateByPrimaryKey(SysSequence record);

    int updateBySeqName(SysSequence record);

    String queryTime();
}