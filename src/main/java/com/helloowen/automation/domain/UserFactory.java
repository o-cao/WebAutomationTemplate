package com.helloowen.automation.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class UserFactory {

    private static final Map<String, User> users = new HashMap<>();

    public static synchronized User getUser(String name) {
        User user = users.get(name);

        if (user == null) {
            final String path = format("users/user-%s.json", name);
            try {
                user = new ObjectMapper().readValue(UserFactory.class.getClassLoader().getResource(path), User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            users.put(name, user);
        }

        return user;
    }

}
