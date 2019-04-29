package edu.uiowa.projectteam10.forms;

import java.util.Date;

public class BillingForm {
    private Date startDate;
    private Date endDate;
    private float dayPrice;
    private float totalPrice;

    public BillingForm(Date startDate, Date endDate, float dayPrice, float totalPrice){
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayPrice = dayPrice;
        this.totalPrice = totalPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(float dayPrice) {
        this.dayPrice = dayPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
