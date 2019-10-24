package com.sample.sfms.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.FeedbackView;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
@Table(name = "optionn", schema = "capstone", catalog = "")
public class Optionn {
    @JsonView(FeedbackView.conductFeedbackView.class)
    private int id;
    @JsonView(FeedbackView.conductFeedbackView.class)
    private String optionnContent;
    @JsonView(FeedbackView.conductFeedbackView.class)
    private Double point;
    private Collection<Answer> answersById;
    private Question questionByQuestionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "option_content", nullable = true)
    public String getOptionnContent() {
        return optionnContent;
    }

    public void setOptionnContent(String optionnContent) {
        this.optionnContent = optionnContent;
    }

    @Basic
    @Column(name = "point", nullable = true, precision = 0)
    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Optionn optionn = (Optionn) o;

        if (id != optionn.id) return false;
        if (optionnContent != null ? !optionnContent.equals(optionn.optionnContent) : optionn.optionnContent != null)
            return false;
        if (point != null ? !point.equals(optionn.point) : optionn.point != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (optionnContent != null ? optionnContent.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "optionnByOptionnId")
    public Collection<Answer> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<Answer> answersById) {
        this.answersById = answersById;
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    public Question getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(Question questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
