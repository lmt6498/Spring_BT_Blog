package services;

import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import repository.IBlogRepo;

import java.util.List;


@Transactional
public class BlogServices implements IBlogServices{
    @Autowired
    private IBlogRepo BlogRepo;

    @Override
    public List<Blog> findAll() {
      return (List<Blog>) BlogRepo.findAll();
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return BlogRepo.findAllByName(name);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return BlogRepo.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        BlogRepo.save(blog);
    }

    @Override
    public Blog findByID(Integer id) {
       return BlogRepo.findById(id).get();
    }

    @Override
    public void remove(Blog blog) {
        BlogRepo.delete(blog);
    }
}
