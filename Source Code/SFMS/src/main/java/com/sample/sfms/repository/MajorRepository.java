package com.sample.sfms.repository;

import com.sample.sfms.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 20/02/2018.
 */
@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query("select m from Major m where " +
            "EXISTS (SELECT f FROM Feedback f WHERE f.majorByMajorId.id = m.id)")
    List<Major> filtering ();
}
