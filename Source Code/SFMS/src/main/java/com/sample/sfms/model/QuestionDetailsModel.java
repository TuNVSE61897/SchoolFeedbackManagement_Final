package com.sample.sfms.model;

import com.sample.sfms.entity.Criteria;
import com.sample.sfms.entity.Question;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

/**
 * Created by Binh Nguyen on 27-Feb-18.
 */
public class QuestionDetailsModel {

    private Question question;
    private Criteria criteria;
    private Map<Integer, Integer> optionsPercentages;
    private int numberOfAnswers;

    public QuestionDetailsModel() {

    }

    public QuestionDetailsModel(Question question, Criteria criteria, Map<Integer, Integer> optionsPercentages, int numberOfAnswers) {
        this.question = question;
        this.criteria = criteria;
        this.optionsPercentages = optionsPercentages;
        this.numberOfAnswers = numberOfAnswers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Map<Integer, Integer> getOptionsPercentages() {
        return optionsPercentages;
    }

    public void setOptionsPercentages(Map<Integer, Integer> optionsPercentages) {
        this.optionsPercentages = optionsPercentages;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }
}
