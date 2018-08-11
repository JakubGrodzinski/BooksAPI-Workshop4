package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class FormController
{
    @RequestMapping(value = "add", produces = "text/html")
    public String addForm ()
    {
        return "addbook";
    }

}
