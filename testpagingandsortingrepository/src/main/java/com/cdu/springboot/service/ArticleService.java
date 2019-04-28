package com.cdu.springboot.service;

import com.cdu.springboot.bean.Article;
import com.cdu.springboot.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleService {
    @Resource
    private ArticleRepository articleRepository;
    public Iterable<Article> findAllSort(Sort sort){
        return articleRepository.findAll(sort);
    }
    public Page<Article> findAll(Pageable page){
        return articleRepository.findAll(page);
    }
}
