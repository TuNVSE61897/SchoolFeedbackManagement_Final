package com.sample.sfms.repository;

import com.sample.sfms.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MyPC on 23/02/2018.
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
