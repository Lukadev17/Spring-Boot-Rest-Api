package com.softgen.luka.gagnidze.springbootsoftgenproject.controller;

import com.softgen.luka.gagnidze.springbootsoftgenproject.entity.Users;
import com.softgen.luka.gagnidze.springbootsoftgenproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("create-user")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @GetMapping("get-users")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("get-user-by-id/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @GetMapping("get-user-by-personal-number/{personalNumber}")
    public Users getUserByPersonalNumber(@PathVariable Long personalNumber) {
        return usersService.getUserByPersonalNumber(personalNumber);
    }

    @PutMapping("update-user/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return usersService.updateUser(id, user);
    }

    @DeleteMapping("delete-user/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }

    @PutMapping("set-user-profile-image/{id}")
    public Users setUserProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return usersService.setUserProfileImage(id, file);
    }
}
