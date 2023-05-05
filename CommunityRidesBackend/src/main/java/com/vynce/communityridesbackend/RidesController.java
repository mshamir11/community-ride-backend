package com.vynce.communityridesbackend;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RidesController {

    @GetMapping("/rides")
    public RideList getAllRides() {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = "[{\"id\":\"Alice\",\"content\":\"25\"},{\"id\":\"Bob\",\"content\":\"30\"}]";
        try {
            RideList rideList = objectMapper.readValue(json, RideList.class);
            for (Ride ride : rideList.getRideList()) {
                System.out.println(ride.content()); // prints each person's name
            }
            return rideList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
