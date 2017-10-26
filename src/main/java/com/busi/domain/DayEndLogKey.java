package com.busi.domain;

import java.io.Serializable;

public class DayEndLogKey implements Serializable {
    private Integer stepNo;

    private String dayendDate;

    private static final long serialVersionUID = 1L;

    public Integer getStepNo() {
        return stepNo;
    }

    public void setStepNo(Integer stepNo) {
        this.stepNo = stepNo;
    }

    public String getDayendDate() {
        return dayendDate;
    }

    public void setDayendDate(String dayendDate) {
        this.dayendDate = dayendDate;
    }
}