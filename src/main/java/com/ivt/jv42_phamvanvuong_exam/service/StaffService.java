/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.service;

import com.ivt.jv42_phamvanvuong_exam.entities.StaffEntity;
import com.ivt.jv42_phamvanvuong_exam.repository.StaffRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
//
    public List<StaffEntity> getStaffs() {
        return (List<StaffEntity>) staffRepository.findAll();
    }
//
    public void save(StaffEntity staff) {
        staffRepository.save(staff);
    }
//
//    public BookEntity findBookById(int id) {
//        Optional<BookEntity> optional = bookRepository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            return new BookEntity();
//        }
//    }
//
//    public boolean deleteBook(int id) {
//        bookRepository.deleteById(id);
//        return bookRepository.existsById(id);
//    }
//
//    public List<BookEntity> searchBook(String strSearch) {
//        //return bookRepository.findByNameContainingOrAuthorContaining(strSearch, strSearch);
////        return bookRepository.findBookByCategory(strSearch, 120000);
//        return bookRepository.findBookByCategoryNative("%"+strSearch+"%", 120000);
//    }
    
}
