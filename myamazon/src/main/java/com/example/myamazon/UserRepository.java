package com.example.myamazon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByNameAndPassword(String name, String password);
}
