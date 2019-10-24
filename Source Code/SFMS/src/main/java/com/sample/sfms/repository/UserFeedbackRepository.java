package com.sample.sfms.repository;

import com.sample.sfms.entity.UserFeedback;
import com.sample.sfms.entity.UserFeedbackPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 05/03/2018.
 */
@Repository
public interface UserFeedbackRepository extends JpaRepository<UserFeedback, UserFeedbackPK> {

    List<UserFeedback> findByFeedbackByFeedbackId_Id(int id);
    List<UserFeedback> findByUserByUserId_Id(int id);
}
