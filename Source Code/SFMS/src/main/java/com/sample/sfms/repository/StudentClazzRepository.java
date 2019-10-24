package com.sample.sfms.repository;

import com.sample.sfms.entity.Clazz;
import com.sample.sfms.entity.StudentClazz;
import com.sample.sfms.entity.StudentClazzPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by MyPC on 24/02/2018.
 */
public interface StudentClazzRepository extends JpaRepository<StudentClazz, StudentClazzPK> {
    List<StudentClazz> findByClazzByClazzId(Clazz clazzByClazzId);

}
