package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Feedback;
import com.sample.sfms.entity.Type;
import com.sample.sfms.model.feedback.FeedbackCreateModel;
import com.sample.sfms.repository.FeedbackRepository;
import com.sample.sfms.repository.TypeRepository;
import com.sample.sfms.service.interf.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Binh Nguyen on 21-Feb-18.
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    static Logger logger = Logger.getLogger(FeedbackServiceImpl.class.getName());
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Feedback> getListTemplate(boolean isTemplate) {
        return feedbackRepository.findByIsTemplate(isTemplate);
    }

    @Override
    public Feedback findFeedbackById(int id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public int save(FeedbackCreateModel model) throws Exception {
        Feedback feedback = new Feedback();
        Type type = typeRepository.getOne(1); //Hard code. Please fix when release
        feedback.setTypeByTypeId(type);
        feedback.setIsTemplate(false); //Hard code

        feedbackRepository.save(feedback);
        return feedback.getId();
    }
<<<<<<< Updated upstream
=======

    @Override
    public List<Feedback> loadListFeedback(String type) {
        List<Feedback> list = new ArrayList<>();
        switch (type) {
            case "Major":
                list.addAll(feedbackRepository.getListMajorFeedback());
                break;
            case "Course":
                list.addAll(feedbackRepository.getListCourseFeedback());
                break;
            case "Dep":
                list.addAll(feedbackRepository.getListDepFeedback());
                break;
            case "Class":
                list.addAll(feedbackRepository.getListClassFeedback());
                break;
            default: break;
        }
        return list;
    }

    @Override
    public ResponseEntity getNotConductedFeedbacksByUserId() {
        User user = getAuthorizedUser();
        if (user != null) {
            try {
                List<UserFeedback> listUserFeedback = userFeedbackRepository.findNotConductedFeedbacksByUserId(user.getId());
                if (null == listUserFeedback || listUserFeedback.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity(listUserFeedback, HttpStatus.OK);
                }
            } catch (Exception e) {
                logger.log(Level.FINE, e.toString());
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public List<UserFeedback> getFeedbacksByUserId() {
        User user = getAuthorizedUser();
        if (user != null) {
            List<UserFeedback> userFeedbacks = userFeedbackRepository.findFeedbacksByUserId(user.getId());
            return userFeedbacks;
        } else {
            return null;
        }
    }

    @Override
    public Feedback findFeedbackToConduct(int feedbackId) {
        //if user is logged in
        User user = getAuthorizedUser();
        if (user == null) {
            return null;
        }
        UserFeedback userFeedback = userFeedbackRepository.findUserFeedbackByUserAndFeedback(user.getId(), feedbackId);
        //if user doesn't have the right to to do this feedback or this feedback is conducted
        if (userFeedback == null || !userFeedback.isConductor() || userFeedback.isConducted()) {
            return null;
        }
        Feedback feedback = userFeedback.getFeedbackByFeedbackId();
        //if feedback is overdue or not started yet
        long currDate = System.currentTimeMillis();
        if (currDate < feedback.getStartDate().getTime() || currDate > feedback.getEndDate().getTime()) {
            return null;
        } else return feedback;
    }

    @Override
    public Feedback findFeedbackToPreview(int feedbackId) {
        //if user is logged in
        User user = getAuthorizedUser();
        if (user == null) {
            return null;
        }
        Feedback feedback = feedbackRepository.findById(feedbackId);
        //if feedback is overdue or not started yet
        return feedback;
    }

    @Override
    public List<Feedback> findAllFeedback() {
        return feedbackRepository.findAll();
    }

    private User getAuthorizedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }
>>>>>>> Stashed changes
}
