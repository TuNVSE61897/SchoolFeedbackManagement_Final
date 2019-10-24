package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Feedback;
import com.sample.sfms.model.feedback.FeedbackCreateModel;

import java.util.List;

public interface FeedbackService {

    List<Feedback> getListTemplate(boolean isTemplate);

    Feedback findFeedbackById (int id);

    int save(FeedbackCreateModel model) throws Exception;
<<<<<<< Updated upstream
=======

    List<Feedback> loadListFeedback (String type);

    ResponseEntity getNotConductedFeedbacksByUserId();

    List<UserFeedback> getFeedbacksByUserId();

    Feedback findFeedbackToConduct(int id);

    Feedback findFeedbackToPreview(int feedbackId);

    List<Feedback> findAllFeedback();
>>>>>>> Stashed changes
}

