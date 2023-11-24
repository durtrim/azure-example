/*
 * Copyright © Robert Bosch GmbH 2022. All rights reserved,
 * also regarding any disposal, exploitation, reproduction, editing,
 * distribution, as well as in the event of applications for industrial property rights.
 */

package example.uppercase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private final ObjectMapper objectMapper;

    public SomeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toUpperCase(String input) {
        return input.toUpperCase();
    }
}
