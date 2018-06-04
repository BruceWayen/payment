package com.unit.domain;

public class SysSequence {
    private Integer id;

    private String seqName;

    private Double currentVal;

    private Integer incrementVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName == null ? null : seqName.trim();
    }

    public Double getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(Double currentVal) {
        this.currentVal = currentVal;
    }

    public Integer getIncrementVal() {
        return incrementVal;
    }

    public void setIncrementVal(Integer incrementVal) {
        this.incrementVal = incrementVal;
    }
}