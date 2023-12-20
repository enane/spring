package com.logate.academy.zima23.Repositories;

import com.logate.academy.zima23.DTO.UserDTO;
import com.logate.academy.zima23.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {

    public List<UserDTO> getAll() {
        UserDTO stefan = new UserDTO();
        stefan.setId(1);
        stefan.setFullName("Stefan Stefan");
        stefan.setAddress("Address 1");
        stefan.setAge(31);

        UserDTO marko = new UserDTO();
        marko.setId(2);
        marko.setFullName("Marko Marko");
        marko.setAddress("Address 2");
        marko.setAge(24);

        return List.of(stefan, marko);
    }

    public UserDTO getById(Integer id) {
        List<UserDTO> userDTOList = getAll();
        for (UserDTO user: userDTOList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<UserDTO> getByAge(Integer age) {
        List<UserDTO> userDTOList = getAll();
        List<UserDTO> findList = new ArrayList<>();
        for (UserDTO user: userDTOList) {
            if(user.getAge().equals(age)) {
                findList.add(user);
            }
        }
        return findList;
    }

//    public List<UserDTO> getByParams(Map<String, Objects> queryParams) {
//        List<UserDTO> userDTOList = getAll();
//        List<UserDTO> findList = new ArrayList<>();
//        for (UserDTO user: userDTOList) {
//            if(user.getAge(queryParams.get("fromAge"))) {
//                findList.add(user);
//            }
//        }
//        return findList;
//    }
}
