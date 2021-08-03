/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.repository;

import com.ivt.jv42_phamvanvuong_exam.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
