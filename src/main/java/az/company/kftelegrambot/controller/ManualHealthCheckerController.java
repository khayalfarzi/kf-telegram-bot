package az.company.kftelegrambot.controller;

import az.company.kftelegrambot.service.impl.ManualHealthCheckerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manual/check")
public class ManualHealthCheckerController {

    private final ManualHealthCheckerServiceImpl service;

    public ManualHealthCheckerController(ManualHealthCheckerServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String check() {
        service.check();
        return "ok. done";
    }
}