package com.softgen.luka.gagnidze.springbootsoftgenproject.repository;

import com.softgen.luka.gagnidze.springbootsoftgenproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByPersonalNumber(Long personalNumber);

}
