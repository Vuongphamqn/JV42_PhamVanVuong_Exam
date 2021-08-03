/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "staff")
public class StaffEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "staff_name")
    private String staffName;
    
    @Column(name = "staff_address")
    private String staffAddress;
    private String phone;
    private String email;
    
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<NewsEntity> newss;

    public StaffEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NewsEntity> getNewss() {
        return newss;
    }

    public void setNewss(List<NewsEntity> newss) {
        this.newss = newss;
    }
    
}
