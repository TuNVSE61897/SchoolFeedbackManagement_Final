package com.sample.sfms.repository;

import com.sample.sfms.entity.Criteria;
import com.sample.sfms.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by MyPC on 20/02/2018.
 */
@org.springframework.stereotype.Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {
    Criteria findById(int id);
}
