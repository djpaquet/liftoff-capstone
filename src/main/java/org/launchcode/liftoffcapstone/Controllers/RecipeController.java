package org.launchcode.liftoffcapstone.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller


public class RecipeController {

    @RequestMapping(value= "")
    @ResponseBody
    public String index(){
        return "its working";
    }



}
