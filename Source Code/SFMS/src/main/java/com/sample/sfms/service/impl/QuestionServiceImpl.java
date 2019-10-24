package com.sample.sfms.service.impl;

import com.sample.sfms.entity.*;
import com.sample.sfms.model.option.OptionCreateModel;
import com.sample.sfms.model.option.OptionUpdateModel;
import com.sample.sfms.model.question.AddQuestionModel;
import com.sample.sfms.model.question.RemoveQuestionModel;
import com.sample.sfms.model.StaticVariables;
import com.sample.sfms.model.question.UpdateQuestionModel;
import com.sample.sfms.repository.CriteriaRepository;
import com.sample.sfms.repository.FeedbackRepository;
import com.sample.sfms.repository.QuestionRepository;
import com.sample.sfms.service.interf.OptionnService;
import com.sample.sfms.service.interf.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by Binh Nguyen on 24-Feb-18.
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private OptionnService optionnService;

    @Override
    @Transactional
    public int addQuestion(AddQuestionModel model) throws Exception {

        if (model.getFeedbackId() == 0) {
            throw new Exception("Xin hãy xác định rằng câu hỏi này thuộc feedback nào");
        }

        if (model.getType() == null) {
            throw new Exception("Xin hãy chọn loại câu hỏi");
        }

        if (!isValidType(model)){
            throw new Exception("Xin kiểm tra lại loại câu hỏi và các option");
        }

        Question question = new Question();
        question.setIsRequied(model.isRequired());
        question.setQuestionContent(model.getQuestionContent());
        question.setSuggestion(model.getSuggestion());
        question.setType(model.getType());


        try {
            Feedback feedback = feedbackRepository.findById(model.getFeedbackId());
            question.setFeedbackByFeedbackId(feedback);

            Criteria criteria = criteriaRepository.findById(model.getCriteriaId());
            question.setCriteriaByCriteriaId(criteria);

            this.questionRepo.save(question);

            int id = question.getId();

            if (model.getOptionCreateModel() != null) {
                for (OptionCreateModel option : model.getOptionCreateModel()) {
                    option.setQuestion(question);
                    optionnService.add(option);
                }
                if (model.isRequireOther()) {
                    OptionCreateModel optionCreateModel = new OptionCreateModel();
                    optionCreateModel.setQuestion(question);
                    optionCreateModel.setOptionContent("Khác");
                    optionCreateModel.setPoint(0.0);
                    optionnService.add(optionCreateModel);
                }
            }
            return id;
        } catch (Exception ex) {
            throw ex;
        }


    }

    @Override
    @Transactional
    public void updateQuestion(UpdateQuestionModel model) throws Exception {
        if (model.getId() == 0) {
            throw new Exception("Xin chọn câu hỏi để update");
        }
        if (model.getFeedbackId() == 0) {
            throw new Exception("Xin hãy xác định rằng câu hỏi này thuộc feedback nào");
        }

        if (model.getType() == null) {
            throw new Exception("Xin kiểm tra lại loại câu hỏi và các option");
        }

        if (!isValidType(model)){
            throw new Exception("Xin kiểm tra lại các option. Nếu chọn option thì thêm đủ option.");
        }

        try {
            Question question = this.questionRepo.getOne(model.getId());

            question.setIsRequied(model.isRequired());
            question.setQuestionContent(model.getQuestionContent());
            question.setSuggestion(model.getSuggestion());
            question.setType(model.getType());
            Feedback feedback = feedbackRepository.findById(model.getFeedbackId());

            question.setFeedbackByFeedbackId(feedback);

            this.questionRepo.save(question);

            if (model.getOptionUpdateModels() != null) {
                for (OptionUpdateModel option : model.getOptionUpdateModels()) {
                    option.setQuestion(question);
                    optionnService.update(option);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void removeQuestion(RemoveQuestionModel model) throws Exception {
        if (model.getId() == 0) {
            throw new Exception("Xin chọn câu hỏi để xóa");
        }

        try {
            Question question = this.questionRepo.findOne(model.getId());

            for (Optionn option : question.getOptionsById()) {
                this.optionnService.remove(option.getId());
            }

            this.questionRepo.delete(model.getId());

        } catch (Exception ex) {
            throw ex;
        }
    }

    /*---------------Private methods------------------*/
    private boolean isValidType(AddQuestionModel model) {
        if (Arrays.asList(StaticVariables.OPTION_NEEDED_QUESTION_TYPE).contains(model.getType()))
            return model.getOptionCreateModel() != null;
        else return model.getOptionCreateModel() == null;
    }

}
