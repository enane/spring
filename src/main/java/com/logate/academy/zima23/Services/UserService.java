package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.DTO.UserDTO;
import com.logate.academy.zima23.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // | //@Service | //@Repository
//@Controller
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
       return userRepository.getAll();
    }

    public UserDTO getById(Integer id) {
       return userRepository.getById(id);
    }

    public List<UserDTO> getByAge(Integer age) {
        return userRepository.getByAge(age);
    }
}
