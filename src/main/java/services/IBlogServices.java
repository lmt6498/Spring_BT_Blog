package services;

import models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogServices {
    List<Blog> findAll();
    List<Blog> findAllByName(String name);
    Page<Blog> findAll(Pageable pageable);

    Blog findByID(Integer id);

    void save(Blog blog);

    void remove(Blog blog);
}
