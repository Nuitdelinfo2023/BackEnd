package nuitinfo23.backend.io;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloApplication {
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }
    
}
