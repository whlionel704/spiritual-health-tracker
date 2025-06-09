package tech.learns.lionel.spiritual_health_tracker.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public String getHealth() {
        return "all good";
    }

    @GetMapping("/test2")
    public String getTestCiCd() {
        return "ci/cd pipeline is working test2";
    }
}
