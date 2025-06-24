package tech.learns.lionel.spiritual_health_tracker.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HealthController {

    @GetMapping({ "/" })
    public String getOk() {
        return "all ok";
    }

    @GetMapping("/health")
    public String getHealth() {
        return "all good and healthy";
    }

    @GetMapping("/testcicd")
    public String getTestcicd() {
        return "ci/cd pipeline is working";
    }
}
