package com.cdu.springboot.controller;

import com.cdu.springboot.bean.Article;
import com.cdu.springboot.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @RequestMapping("/sort")
    public Iterable<Article> sortArticle(){
        //指定排序的参数对象：根据id，进行降序查询
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Iterable<Article> articles = articleService.findAllSort(sort);
        return articles;
    }
    @RequestMapping("/pager")
    public List<Article> sortPagerArticle(int pageIndex){
        //指定排序的参数对象：根据id，进行降序查询
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable page = PageRequest.of(pageIndex-1,2,sort);
        Page<Article> articlePage = articleService.findAll(page);
        List<Article> articles = articlePage.getContent();
        return articles;
    }
}
