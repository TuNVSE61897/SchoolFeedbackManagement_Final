package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Feedback;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.FeedbackDetailsModel;
import com.sample.sfms.model.ModifyFeedbackModel;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 */
public interface ModifyFeedbackViewConductService {

    public FeedbackDetailsModel addConductors(FeedbackDetailsModel model, int[] conductorIds);

    public FeedbackDetailsModel addViewers(FeedbackDetailsModel model, int[] viewerIds);

    public FeedbackDetailsModel removeConductors(FeedbackDetailsModel model, int[] conductorIds);

    public FeedbackDetailsModel removeViewers(FeedbackDetailsModel model, int[] viewerIds);
}