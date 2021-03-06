package com.unit.dao;

import com.unit.domain.SysUnicodeDict;

public interface SysUnicodeDictMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(SysUnicodeDict record);

    int insertSelective(SysUnicodeDict record);

    SysUnicodeDict selectByPrimaryKey(Integer id);

    SysUnicodeDict selectByCodeClassAndCodeName(SysUnicodeDict sysUnicodeDict);

    int updateByPrimaryKeySelective(SysUnicodeDict record);

    int updateByPrimaryKey(SysUnicodeDict record);
}