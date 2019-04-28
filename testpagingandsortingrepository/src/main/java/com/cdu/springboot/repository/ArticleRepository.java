package com.cdu.springboot.repository;

import com.cdu.springboot.bean.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article,Integer> {
}
