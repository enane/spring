package com.logate.academy.zima23.Controllers;

import com.logate.academy.zima23.DTO.UserDTO;
import com.logate.academy.zima23.Filters.UserFilter;
import com.logate.academy.zima23.Services.ProductService;
import com.logate.academy.zima23.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    //lista svih usera
    @RequestMapping(path="/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> userDTOList = userService.getAll();
        //return ResponseEntity.ok().body(userDTOList);
        return new ResponseEntity<> (userDTOList, HttpStatus.OK);
    }

    //list korisnika sa id = 1
    @RequestMapping(path="/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getById (@PathVariable(value="id") Integer id) {
        LOGGER.info("PathVariable is: {}",id);
        UserDTO userDTO = userService.getById(id);
        if(userDTO != null) {
            //return ResponseEntity.ok().body(userDTO);
            return new ResponseEntity<> (userDTO, HttpStatus.OK);
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //list korinsika sa age=31
    @RequestMapping(path="/api/users/users-by-age", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getByAge(@RequestParam(value="age") Integer age) {
        List<UserDTO> userDTOList = userService.getByAge(age);
        //return ResponseEntity.ok().body(userDTOList);
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    //list korinsika sa fromAge=31 toAge=
//    @RequestMapping(path="/api/users-by-age", method = RequestMethod.GET)
//    public ResponseEntity<List<UserDTO>> getByAge(@RequestParam(value="fromAge") Integer fromAge,
//                                                  @RequestParam(value="toAge") Integer ageTO) {
//        List<UserDTO> userDTOList = userService.getByAge(fromAge, ageTO);
//        //return ResponseEntity.ok().body(userDTOList);
//        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
//    }

    //list korisnika sa fromAge=31 toAge=35 name=Stefan
    @RequestMapping(path="/api/users/users-by-params", method = RequestMethod.GET)
    public ResponseEntity<Void> getByParams(@RequestParam Map<String, Objects> queryParams) {
        //List<UserDTO> userDTOList = userService.getByParams(queryParams);
        LOGGER.info("List of query params by map: {}", queryParams);
        //return ResponseEntity.ok();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //list korisnika sa fromAge=31 toAge=35 name=Stefan address = Address1 putem class
    @RequestMapping(path="/api/users/users-by-params-class", method = RequestMethod.GET)
    public ResponseEntity<Void> getgetByParamsClass(UserFilter userFilter){
        LOGGER.info("List of query params by class: {}", userFilter);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
