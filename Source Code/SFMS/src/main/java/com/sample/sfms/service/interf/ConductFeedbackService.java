package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Feedback;
import com.sample.sfms.model.answer.ConductAnswerWrapper;
import org.springframework.http.ResponseEntity;

public interface ConductFeedbackService {

    ResponseEntity<Feedback> findFeedbackByid(int id);

    ResponseEntity saveAnswer(ConductAnswerWrapper answerWrapper);

}
