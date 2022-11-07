package zmeyka.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String hellopage(@RequestParam(value = "name",required=false)String name,
                            @RequestParam(value="surname",required = false)String surname,
                            Model model){
       model.addAttribute("message","hello" +" "+name+surname);


          return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodBye(){
        return "first/goodbye";
    }
    @GetMapping("/calc")
    public String calc(@RequestParam( "a")int a,
                       @RequestParam("b")int b,
                       @RequestParam("action") String action,
                       Model model){

        double result;

        switch (action){
            case"mult": result=a*b;break;
            case"del":result=a/b;break;
            case"sum":result=a+b;break;
            default:result=0;break;
        }
        model.addAttribute("result","result"+result);

        return "first/calc";

    }
}
