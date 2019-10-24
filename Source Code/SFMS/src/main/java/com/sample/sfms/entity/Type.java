package com.sample.sfms.entity;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.CriteriaView;
import com.sample.sfms.view.FeedbackView;
import com.sample.sfms.view.TypeView;

>>>>>>> Stashed changes
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Type {
<<<<<<< Updated upstream
    private int id;
=======
    @JsonView({FeedbackView.overview.class, TypeView.basicTypeView.class, CriteriaView.basicCriteriaView.class})
    private int id;
    @JsonView({FeedbackView.overview.class, TypeView.basicTypeView.class, CriteriaView.basicCriteriaView.class})
>>>>>>> Stashed changes
    private String description;
    private Collection<Feedback> feedbacksById;
    private Collection<Criteria> criteriasById;

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
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (id != type.id) return false;
        if (description != null ? !description.equals(type.description) : type.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<Criteria> getCriteriasById() {
        return criteriasById;
    }

    public void setCriteriasById(Collection<Criteria> criteriasById) {
        this.criteriasById = criteriasById;
    }
}
