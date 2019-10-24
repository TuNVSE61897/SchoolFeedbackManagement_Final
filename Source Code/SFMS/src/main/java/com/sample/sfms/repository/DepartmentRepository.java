package com.sample.sfms.repository;

import com.sample.sfms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 *
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("select d from Department d where " +
            "EXISTS (SELECT f FROM Feedback f WHERE f.departmentByDepartmentId.id = d.id)")
    List<Department> filtering ();
}
