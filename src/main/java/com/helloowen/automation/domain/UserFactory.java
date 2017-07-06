package com.helloowen.automation.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.lang.String.format;

@Component
public class UserFactory {

    public User create(String name) throws IOException {
        final String path = format("users/user-%s.json", name);
        return new ObjectMapper().readValue(getClass().getClassLoader().getResource(path), User.class);
    }
}
