package com.ordermanager.restservice.orders;

import java.util.Date;

public class NewOrderMapping {

    private Date orderDate = new Date();
    private String orderReference = "";
    private Boolean checked;
    private String status="NOT_APPROVED";
    private Long id;

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public Boolean getChecked() {
        return checked;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }


}
