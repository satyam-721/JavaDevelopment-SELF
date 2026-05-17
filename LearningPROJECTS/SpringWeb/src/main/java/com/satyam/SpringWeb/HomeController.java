package com.satyam.SpringWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<Todos> obj = new ArrayList<>();


    @RequestMapping("/")
    public String home(Model model){

        model.addAttribute("items",obj);

        return "home";
    }

    @RequestMapping("/todos")
    public String add(Todos todo){

        if (todo.getId()!=0){
            obj.removeIf(t -> t.getId() == todo.getId());
            obj.add(todo);
            return "forward:/";
        }

        todo.setId(System.currentTimeMillis());
        System.out.println(todo.getId());
        obj.add(todo);
        return "forward:/";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        System.out.println(id);
        obj.removeIf(todo -> todo.getId() == id);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public ModelAndView update(long id, ModelAndView mv){
        System.out.println(id);
        Todos td=null;
        for(Todos todos:obj){
            if(todos.getId()==id){
                td=todos;
                break;
            }
        }
        mv.setViewName("update");

        mv.addObject("item",td);
        return mv;
    }



}
