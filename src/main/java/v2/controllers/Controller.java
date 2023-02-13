package v2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
@RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
    ModelAndView mav = new ModelAndView("index");
    String s ="";
    mav.addObject("message",s);
    return "index";
}
}
