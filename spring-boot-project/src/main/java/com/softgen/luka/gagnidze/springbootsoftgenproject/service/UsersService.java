package com.softgen.luka.gagnidze.springbootsoftgenproject.service;

import com.softgen.luka.gagnidze.springbootsoftgenproject.entity.Users;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface UsersService {

    Users createUser(Users user);

    List<Users> getUsers();

    Users getUserById(Long id);

    Users getUserByPersonalNumber(Long personalNumber);

    void deleteUser(Long id);

    Users updateUser(Long id, Users user);

    Users setUserProfileImage(Long id, MultipartFile file);

    String saveUploadedFile(MultipartFile file) throws IOException;
}
