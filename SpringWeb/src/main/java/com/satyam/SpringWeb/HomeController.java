package com.satyam.SpringWeb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("In home");
        return "index";    //the path and type are set in properties file
    }


    //Accepting and sending request the servlet way
//    @RequestMapping("/add")
//    public String hello(HttpServletRequest req, HttpSession session){
//        System.out.println("In Method cal");
//        int num = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int res =num+num2;
//        System.out.println("Sum is: "+res);
//
//        session.setAttribute("result",res);
//
//
//        return "result.jsp";
//    }


    //Accepting request and sending the spring way
//    @RequestMapping("/add")
//    public String hello(int num1, int num2, Model model){   //Add @RequestParam("") in attribute for different attribute name
//        int res = num1+num2;
//        System.out.println(res);
//
//        model.addAttribute("result",res);
//        return "result";
//    }

    //Use Model if i just want to work with data
    //use ModelandView if i want to return view aswell
    @RequestMapping("/add")
    public ModelAndView hello(int num1, int num2, ModelAndView mv){   //Add @RequestParam("") in attribute for different attribute name
        int res = num1+num2;
        System.out.println(res);

        mv.addObject("result",res);
        mv.setViewName("result");

        return mv;
    }




    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @RequestMapping("/emp")
//    public ModelAndView Emp(String name, int id, ModelAndView mv){   //Add @RequestParam("") in attribute for different attribute name
//
//        Employee emp = new Employee();
//        emp.setId(id);
//        emp.setName(name);
//
//        mv.addObject("result",emp);
//        mv.setViewName("result");
//
//        return mv;
//    }


//    Can be simply using ModelAttribute() (applyed by default )

    @RequestMapping("/emp")
    public String Emp( @ModelAttribute("result") Employee emp){
        return "result";
    }

    //basically whatever this method returns, course has that value
    @ModelAttribute("course")
    public String getCourse(){
        return "java";
    }

}
