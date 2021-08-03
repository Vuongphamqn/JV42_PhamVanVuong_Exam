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
@Table(name = "category")
public class CategoryEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100, nullable = false, name = "cate_name")
    private String cateName;
    
    @Column(length = 1000, name = "cate_desc")
    private String cateDesc;
    
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<NewsEntity> newss;

    public CategoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }

    public List<NewsEntity> getNewss() {
        return newss;
    }

    public void setNewss(List<NewsEntity> newss) {
        this.newss = newss;
    }
    
    
    
}
