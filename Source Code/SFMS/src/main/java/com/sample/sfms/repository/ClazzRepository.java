package com.sample.sfms.repository;

import com.sample.sfms.entity.Clazz;
import com.sample.sfms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 20/02/2018.
 */
@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    @Query("select c from Clazz c where " +
            "CONCAT(c.courseByCourseId.name,' - ',c.courseByCourseId.code) LIKE :coursename " +
            "AND c.semesterBySemesterId.title LIKE :semestertitle " +
            "AND CONCAT(c.userByLecturerId.fullname,' - ',c.userByLecturerId.code) LIKE :lecturerfullname")
    List<Clazz> filtering(@Param("coursename") String coursename,
                          @Param("semestertitle") String semestertitle,
                          @Param("lecturerfullname") String lecturerfullname);

    List<Clazz> findByCourseByCourseId(Course courseByCourseId);
}
