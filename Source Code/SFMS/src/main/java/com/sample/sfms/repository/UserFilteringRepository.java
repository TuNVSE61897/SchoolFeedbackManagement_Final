package com.sample.sfms.repository;

import com.sample.sfms.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 */
@Repository
public interface UserFilteringRepository extends JpaRepository<User, Integer> {
    List<User> findByMajorByMajorId(Major major);
    List<User> findByClazzesByIdContains(List<Clazz> clazz);
    List<User> findByStudentClazzesById(List<StudentClazz> studentClazzes);

    List<User> findByRoleByRoleId_RoleNameAndMajorByMajorId(String roleName, Major major);
    List<User> findByRoleByRoleId_RoleNameAndAndDepartmentByDepartmentId(String roleName, Department department);
    List<User> findByRoleByRoleId_RoleNameAndClazzesByIdContains(String roleName, List<Clazz> clazzes);
    List<User> findByRoleByRoleIdAndMajorByMajorId_MajorCoursesByIdContains(Role role, List<MajorCourse> majorCourses);

}
