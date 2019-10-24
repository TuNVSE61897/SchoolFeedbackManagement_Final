package com.sample.sfms.entity;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.TargetView;
import com.sample.sfms.view.UserView;

>>>>>>> Stashed changes
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Clazz {
<<<<<<< Updated upstream
=======
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private int id;
    private Date endDate;
    private Date startDate;
<<<<<<< Updated upstream
    private String className;
    private Semester semesterBySemesterId;
    private User userByLecturerId;
=======
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
    private String className;
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
    private Semester semesterBySemesterId;
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
    private User userByLecturerId;
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private Course courseByCourseId;
    private Collection<Feedback> feedbacksById;
    private Collection<StudentClazz> studentClazzesById;

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
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "class_name", nullable = false, length = 45)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (id != clazz.id) return false;
        if (endDate != null ? !endDate.equals(clazz.endDate) : clazz.endDate != null) return false;
        if (startDate != null ? !startDate.equals(clazz.startDate) : clazz.startDate != null) return false;
        if (className != null ? !className.equals(clazz.className) : clazz.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "id", nullable = false)
    public Semester getSemesterBySemesterId() {
        return semesterBySemesterId;
    }

    public void setSemesterBySemesterId(Semester semesterBySemesterId) {
        this.semesterBySemesterId = semesterBySemesterId;
    }

    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id", nullable = false)
    public User getUserByLecturerId() {
        return userByLecturerId;
    }

    public void setUserByLecturerId(User userByLecturerId) {
        this.userByLecturerId = userByLecturerId;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @OneToMany(mappedBy = "clazzByClazzId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "clazzByClazzId")
    public Collection<StudentClazz> getStudentClazzesById() {
        return studentClazzesById;
    }

    public void setStudentClazzesById(Collection<StudentClazz> studentClazzesById) {
        this.studentClazzesById = studentClazzesById;
    }
}
