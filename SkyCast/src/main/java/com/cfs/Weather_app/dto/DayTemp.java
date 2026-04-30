package com.cfs.Weather_app.dto;

import java.time.LocalDate;

public class DayTemp {

    private String date;

    private Double minTemp;
    private Double avrTemp;
    private Double maxTemp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getAvrTemp() {
        return avrTemp;
    }

    public void setAvrTemp(Double avrTemp) {
        this.avrTemp = avrTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }
}
