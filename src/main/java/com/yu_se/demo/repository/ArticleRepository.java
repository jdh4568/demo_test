package com.yu_se.demo.repository;

import com.yu_se.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
