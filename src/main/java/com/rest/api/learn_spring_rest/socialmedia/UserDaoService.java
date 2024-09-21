package com.rest.api.learn_spring_rest.socialmedia;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    private static int userCount = 0;
    static {
        users.add(new User(++userCount, "vv4",LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "vy6",LocalDate.now().minusYears(10)));
        users.add(new User(++userCount, "hb2",LocalDate.now().minusYears(40)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUserById(int id) {
        return findAll().stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
