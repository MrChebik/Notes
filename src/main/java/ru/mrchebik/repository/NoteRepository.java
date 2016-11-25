package ru.mrchebik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mrchebik.model.Note;

import java.util.List;

/**
 * Created by mrchebik on 07.08.16.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("select N from ru.mrchebik.model.Note N where N.USER_ID = :USER_ID")
    List<Note> findById(@Param("USER_ID") long id);
}
