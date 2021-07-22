package one.shirokova.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @RequestMapping(method = RequestMethod.GET, value = "hello-world")
    public String helloWorld(){
        return "Hello world";
    }
}
