package com.sample.sfms.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Answer {
    private int id;
    private String answerContent;
    private Timestamp createDate;
    private Optionn optionnByOptionnId;
    private User userByUserId;

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
    @Column(name = "answer_content", nullable = true)
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (answerContent != null ? !answerContent.equals(answer.answerContent) : answer.answerContent != null)
            return false;
        if (createDate != null ? !createDate.equals(answer.createDate) : answer.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (answerContent != null ? answerContent.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id", nullable = false)
    public Optionn getOptionnByOptionnId() {
        return optionnByOptionnId;
    }

    public void setOptionnByOptionnId(Optionn optionnByOptionnId) {
        this.optionnByOptionnId = optionnByOptionnId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
