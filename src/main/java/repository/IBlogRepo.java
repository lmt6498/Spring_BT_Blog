package repository;

import models.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepo extends PagingAndSortingRepository<Blog,Integer> {
    @Query(value = "select c from Blog c where c.author like concat('%',:author,'%')")
    List<Blog> findAllByName(@Param("author") String author);
}
