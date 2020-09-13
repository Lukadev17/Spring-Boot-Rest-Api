package com.softgen.luka.gagnidze.springbootsoftgenproject.service.impl;

import com.softgen.luka.gagnidze.springbootsoftgenproject.entity.Users;
import com.softgen.luka.gagnidze.springbootsoftgenproject.repository.UsersRepository;
import com.softgen.luka.gagnidze.springbootsoftgenproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users getUserByPersonalNumber(Long personalNumber) {
        return usersRepository.findByPersonalNumber(personalNumber);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users updateUser(Long id, Users user) {
        Users existingUser = getUserById(id);
        existingUser.setPersonalNumber(user.getPersonalNumber());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        existingUser.setAddress(user.getAddress());
        existingUser.setZipCode(user.getZipCode());
        existingUser.setProfession(user.getProfession());
        return usersRepository.save(existingUser);
    }

    @Override
    public Users setUserProfileImage(Long id, MultipartFile file) {
        Users existingUser = null;
        try {
            existingUser = getUserById(id);
            existingUser.setProfilePicture(saveUploadedFile(file));
            usersRepository.save(existingUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return existingUser;
    }

    @Override
    public String saveUploadedFile(MultipartFile file) throws IOException {
        String pathReference = null;
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:\\uploaded\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            pathReference = path.toAbsolutePath().toString();
        }
        return pathReference;
    }
}
