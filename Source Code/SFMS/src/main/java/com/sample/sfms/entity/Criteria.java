package com.sample.sfms.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.CriteriaView;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Criteria {

    @JsonView({CriteriaView.basicCriteriaView.class})
    private int id;
    @JsonView({CriteriaView.basicCriteriaView.class})
    private String criteria;
    @JsonView({CriteriaView.basicCriteriaView.class})
    private boolean status;
    private Collection<Question> questionsById;
    @JsonView({CriteriaView.basicCriteriaView.class})
    private Type typeByTypeId;

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
    @Column(name = "criteria", nullable = false, length = 45)
    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Criteria criteria1 = (Criteria) o;

        if (id != criteria1.id) return false;
        if (criteria != null ? !criteria.equals(criteria1.criteria) : criteria1.criteria != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (criteria != null ? criteria.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "criteriaByCriteriaId")
    public Collection<Question> getQuestionsById() {
        return questionsById;
    }

    public void setQuestionsById(Collection<Question> questionsById) {
        this.questionsById = questionsById;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
