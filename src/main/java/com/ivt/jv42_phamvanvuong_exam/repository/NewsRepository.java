/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.repository;

import com.ivt.jv42_phamvanvuong_exam.entities.NewsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Integer> {
    
    @Query("Select n From NewsEntity n where n.category.cateName Like %?1% or n.title Like %?2% or n.summary Like %?3%")     
    List<NewsEntity> findNewsByCategory(String category, String summary, String title);
    
    
    
//    List<NewsEntity> findNewsNative(String strSearch);
    
}
