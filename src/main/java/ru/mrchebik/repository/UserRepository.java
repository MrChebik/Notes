package ru.mrchebik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mrchebik.model.User;

/**
 * Created by mrchebik on 08.08.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from ru.mrchebik.model.User where username = :username")
    User findByName(@Param("username") String username);
}
