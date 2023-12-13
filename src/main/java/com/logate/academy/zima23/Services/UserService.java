package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.Repositories.UserRepository;

public class UserService {

    UserRepository userRepository;

    void listAllUser() {
        userRepository.listAllUser();
    }

    void listUserWithId(int id) {
        userRepository.listUserWithId(int id);
    }
}
