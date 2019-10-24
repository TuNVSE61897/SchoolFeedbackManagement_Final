package com.sample.sfms.repository;

import com.sample.sfms.entity.Course;
import com.sample.sfms.entity.MajorCourse;
import com.sample.sfms.entity.MajorCoursePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 21/02/2018.
 */
@Repository
public interface MajorCourseRepository extends JpaRepository<MajorCourse, MajorCoursePK>{
    List<MajorCourse> findByMajorByMajorId_NameContains(String majorname);
    List<MajorCourse> findByCourseByCourseId(Course course);
}
