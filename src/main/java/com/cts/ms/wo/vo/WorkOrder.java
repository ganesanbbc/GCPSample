package com.cts.ms.wo.vo;

public class WorkOrder {


    private long id;
    private String name;
    private String customerid;
    private String details;
    private String start_date;
    private String status;

    public WorkOrder(String name, String customerid, String details, String start_date, String status){

        this.name = name;
        this.customerid = customerid;
        this.details = details;
        this.start_date = start_date;
        this.status = status;
    }

    public WorkOrder(String name) {
        this.name = name;
    }

    public WorkOrder() {

    }

    public WorkOrder(long id, String name, String customerid, String details, String start_date, String status) {
        this.id = id;
        this.name = name;
        this.customerid = customerid;
        this.details = details;
        this.start_date = start_date;
        this.status = status;
    }

    public WorkOrder(String name, String customerid, String details, String start_date) {

        this.name = name;
        this.customerid = customerid;
        this.details = details;
        this.start_date = start_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
