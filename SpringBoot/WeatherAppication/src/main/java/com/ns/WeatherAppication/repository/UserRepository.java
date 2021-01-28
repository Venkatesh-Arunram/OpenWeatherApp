package com.ns.WeatherAppication.repository;

import com.ns.WeatherAppication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);


 //   @Query(value = "select * from user ;",nativeQuery = true)
 //   String findByUsername(@Param("username") String username);

}
