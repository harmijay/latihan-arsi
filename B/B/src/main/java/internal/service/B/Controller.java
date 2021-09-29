package internal.service.B;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b/")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping
    @ResponseBody
    public String hello(){
        return "HELLO from B";
    }

    @GetMapping("/theOther")
    @ResponseBody
    public String other(){
        return "ANOTHER API from B";
    }

    @GetMapping("/internal")
    @ResponseBody
    public String internal(){
        return "internal call to B";
    }
}