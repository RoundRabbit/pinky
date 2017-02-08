package pinky;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class PinkyAPI {

    @RequestMapping(method = RequestMethod.POST, value = "sayHello")
    public void sayHello(@RequestParam(value = "greeting") final String greeting) {

        System.out.println(greeting);

    }

    @RequestMapping(method = RequestMethod.POST, value = "do")
    public void sayHello(@RequestBody final Stuff stuff) {

        System.out.println(stuff.type + " - " + stuff.decription);

    }
}
