import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MyController {


    @GetMapping("/a")
    public String hel(){
        return "my good";
    }
    @GetMapping("/prin")
    public  ResponseEntity getPrin(Principal principal){
        return ResponseEntity.ok(principal);
    }
}
