package com.zxc.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private int id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private int createBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
    private int userId;
}
