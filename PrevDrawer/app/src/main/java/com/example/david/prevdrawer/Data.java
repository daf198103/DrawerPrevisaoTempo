package com.example.david.prevdrawer;

/**
 * Created by david on 13/06/2018.
 */
import java.util.Date;

/**
 * Created by david on 15/03/2018.
 */

public class Data {

    private Double temperature;
    private String windDirection;
    private int windVelocity;
    private int humidity;
    private String condition;
    private String pressure;
    private String icon;
    private String sensation;
    private String dia;



    public Data(Double t, String windD, int windV, int hum, String cond, String pres, String icon, String sen, String dia) {
        this.temperature = t;
        this.windDirection = windD;
        this.windVelocity = windV;
        this.humidity = hum;
        this.condition = cond;
        this.pressure = pres;
        this.icon = icon;
        this.sensation = sen;
        this.dia = dia;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getWindVelocity() {
        return windVelocity;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    public String getPressure() {
        return pressure;
    }

    public String getIcon() {
        return icon;
    }

    public String getSensation() {
        return sensation;
    }

    public String getDia(){return dia;}

    public void setTemperature(Double t){
        this.temperature = t;
    }
    public void setWindDirection(String wdd){
        this.windDirection = wdd;
    }
    public void setWindVelocity(int wdv){
        this.windVelocity = wdv;
    }
    public void setHumidity(int hmd){
        this.humidity = hmd;
    }
    public void setCondition(String cnd){
        this.condition = cnd;
    }
    public void setPressure(String psr){
        this.pressure = psr;
    }
    public void setIcon(String icn){
        this.icon = icn;
    }
    public void setSensation(String sst){
        this.sensation = sst;
    }
    public void setData(String dt) {this.dia = dt;}
}