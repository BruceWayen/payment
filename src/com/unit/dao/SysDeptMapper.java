package com.unit.dao;

import com.unit.domain.SysDept;

import java.util.List;

public interface SysDeptMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    /**
     *@DESCRIPTION 查询所有部门信息
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-13:13
     *@CLASS_NAME SysDeptMapper
     **/
    List<SysDept> selectAll();

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}