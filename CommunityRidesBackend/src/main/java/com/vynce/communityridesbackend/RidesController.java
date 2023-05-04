package com.vynce.communityridesbackend;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RidesController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/ride")
    public Ride getRides(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Ride(counter.incrementAndGet(), String.format(template, name));
    }
}
