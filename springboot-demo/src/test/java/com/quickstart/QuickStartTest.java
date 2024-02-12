package com.quickstart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quickstart.entity.User;
import com.quickstart.service.UserService;

@SpringBootTest(classes = Application.class)
public class QuickStartTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsertService() {
        User user = new User();
        user.setName("miaokela");
        user.setAge(30);
        user.setEmail("2222@qq.com");
        userService.save(user);
    }

    @Test
    public void testSelectService() {
        List<User> list = userService.list();
        list.forEach(item -> {
            System.out.println(item.getName());
        });
    }
}
