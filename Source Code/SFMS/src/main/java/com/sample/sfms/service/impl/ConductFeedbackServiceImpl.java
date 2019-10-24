package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Answer;
import com.sample.sfms.entity.Feedback;
import com.sample.sfms.entity.Optionn;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.answer.ConductAnswer;
import com.sample.sfms.model.answer.ConductAnswerWrapper;
import com.sample.sfms.repository.AnswerRepository;
import com.sample.sfms.repository.FeedbackRepository;
import com.sample.sfms.repository.OptionnRepository;
import com.sample.sfms.service.interf.ConductFeedbackService;
import com.sample.sfms.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ConductFeedbackServiceImpl implements ConductFeedbackService {

    Logger logger = Logger.getLogger(ConductFeedbackServiceImpl.class.getName());

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private OptionnRepository optionnRepository;

    @Override
    public ResponseEntity<Feedback> findFeedbackByid(int id) {
        Feedback feedback = feedbackRepository.findById(id);
        if (null == feedback) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity saveAnswer(ConductAnswerWrapper conductAnswerWrapper) {
        //test
        User user = userService.getCurrentAuthenticatedUser();
        if (user == null) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        try {
            Timestamp currDate = new Timestamp(System.currentTimeMillis());
            if (conductAnswerWrapper.getAnswers() != null) {
                Optionn optionn;
                Answer answer;
                for (ConductAnswer conductAnswer : conductAnswerWrapper.getAnswers()) {
                    optionn = optionnRepository.findOne(conductAnswer.getOptionnByOptionnId());
                    answer = new Answer();
                    answer.setCreateDate(currDate);
                    answer.setOptionnByOptionnId(optionn);
                    answer.setUserByUserId(user);
                    answer.setAnswerContent(conductAnswer.getAnswerContent());
                    answerRepository.save(answer);
                }
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (RollbackException e) {
            logger.log(Level.FINE, e.toString());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
