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
public class Course {
<<<<<<< Updated upstream
    private int id;
    private String name;
=======
    @JsonView({TargetView.basicClazzView.class, TargetView.basicCourseView.class, UserView.listUserView.class})
    private int id;
    @JsonView({TargetView.basicClazzView.class, TargetView.basicCourseView.class, UserView.listUserView.class})
    private String name;
    @JsonView({TargetView.basicClazzView.class, TargetView.basicCourseView.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private String code;
    private Collection<Clazz> clazzesById;
    private Collection<Feedback> feedbacksById;
    private Collection<MajorCourse> majorCoursesById;

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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (code != null ? !code.equals(course.code) : course.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Clazz> getClazzesById() {
        return clazzesById;
    }

    public void setClazzesById(Collection<Clazz> clazzesById) {
        this.clazzesById = clazzesById;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<MajorCourse> getMajorCoursesById() {
        return majorCoursesById;
    }

    public void setMajorCoursesById(Collection<MajorCourse> majorCoursesById) {
        this.majorCoursesById = majorCoursesById;
    }
}
