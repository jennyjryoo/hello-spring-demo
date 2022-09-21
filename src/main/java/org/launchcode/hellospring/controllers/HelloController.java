package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (language.equals("English")){
            return "Hello " + name;
        } else if (language.equals("Korean")){
            return "안녕하십니까 " + name;
        } else if (language.equals("Spanish")){
            return "Hola " + name;
        } else if (language.equals("French")){
            return "Bonjour " + name;
        } else{
            return "Hallo " + name;
        }
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option value='English'>English</option>" +
                "<option value='Korean'>Korean</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
