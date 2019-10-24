package com.sample.sfms.entity;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.TargetView;
import com.sample.sfms.view.UserView;

>>>>>>> Stashed changes
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Major {
    private int id;
<<<<<<< Updated upstream
    private String code;
=======
    @JsonView({TargetView.basicClazzView.class, TargetView.basicMajorView.class, UserView.listUserView.class})
    private String code;
    @JsonView({TargetView.basicClazzView.class, TargetView.basicMajorView.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private String name;
    private Collection<Feedback> feedbacksById;
    private Major majorByReferenceId;
    private Collection<Major> majorsById;
    private Collection<MajorCourse> majorCoursesById;
    private Collection<User> usersById;

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
    @Column(name = "code", nullable = true, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Major major = (Major) o;

        if (id != major.id) return false;
        if (code != null ? !code.equals(major.code) : major.code != null) return false;
        if (name != null ? !name.equals(major.name) : major.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "majorByMajorId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @ManyToOne
    @JoinColumn(name = "reference_id", referencedColumnName = "id")
    public Major getMajorByReferenceId() {
        return majorByReferenceId;
    }

    public void setMajorByReferenceId(Major majorByReferenceId) {
        this.majorByReferenceId = majorByReferenceId;
    }

    @OneToMany(mappedBy = "majorByReferenceId")
    public Collection<Major> getMajorsById() {
        return majorsById;
    }

    public void setMajorsById(Collection<Major> majorsById) {
        this.majorsById = majorsById;
    }

    @OneToMany(mappedBy = "majorByMajorId")
    public Collection<MajorCourse> getMajorCoursesById() {
        return majorCoursesById;
    }

    public void setMajorCoursesById(Collection<MajorCourse> majorCoursesById) {
        this.majorCoursesById = majorCoursesById;
    }

    @OneToMany(mappedBy = "majorByMajorId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
