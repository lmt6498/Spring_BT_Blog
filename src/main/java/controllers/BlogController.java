package controllers;

import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.IBlogServices;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogServices blogServices;

    @RequestMapping("blog")
    public ModelAndView home() {
        List<Blog> list = blogServices.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogList", list);
        return modelAndView;
    }

    @GetMapping("/read/{id}")
    public ModelAndView view(@PathVariable Integer id){
        Blog blog = blogServices.findByID(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute Blog blog){
        Timestamp dateTime = new Timestamp(System.currentTimeMillis());
        blog.setDate(dateTime);
        blogServices.save(blog);
        return new ModelAndView("redirect:/blog");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        Blog blog = blogServices.findByID(id);
        if(blog != null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }
    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog){
        blogServices.save(blog);
        return new ModelAndView("redirect:/blog");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        blogServices.remove(id);
        return new ModelAndView("redirect:/blog");
    }

}
