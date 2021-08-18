package services;

import models.Blog;

import java.util.List;

public interface IBlogServices {
    List<Blog> findAll();

    Blog findByID(Integer id);

    void save(Blog blog);

    void remove(Integer id);
}
