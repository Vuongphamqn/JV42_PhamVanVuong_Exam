/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.service;

import com.ivt.jv42_phamvanvuong_exam.entities.NewsEntity;
import com.ivt.jv42_phamvanvuong_exam.repository.NewsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class NewsService {
    
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsEntity> getnewss() {
        return (List<NewsEntity>) newsRepository.findAll();
    }

    public void save(NewsEntity news) {
        newsRepository.save(news);
    }

    public NewsEntity findNewsById(int id) {
        Optional<NewsEntity> optional = newsRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return new NewsEntity();
        }
    }

    public boolean deleteNews(int id) {
        newsRepository.deleteById(id);
        return newsRepository.existsById(id);
    }

    public List<NewsEntity> searchNews(String strSearch) {
//        return newsRepository.findByNameContainingOrAuthorContaining(strSearch, strSearch);
//        return newsRepository.findBookByCategory(strSearch, 120000);
        return newsRepository.findNewsByCategory(strSearch, strSearch, strSearch);
    }
    
}
