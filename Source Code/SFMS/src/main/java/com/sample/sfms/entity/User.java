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
public class User {
<<<<<<< Updated upstream
    private int id;
    private String username;
    private String password;
=======
    @JsonView({TargetView.basicClazzView.class, UserView.listUserView.class})
    private int id;
    private String username;
    private String password;
    @JsonView({UserView.authenticatedUser.class, TargetView.basicClazzView.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private String fullname;
    @JsonView({UserView.listUserView.class})
    private String code;
    @JsonView({UserView.listUserView.class})
    private String mail;
    private Date birth;
    @JsonView({UserView.listUserView.class})
    private Byte status;
    private boolean male;
    private Collection<Answer> answersById;
    private Collection<Clazz> clazzesById;//clazzes whose be taught by a lecturer
    private Collection<Feedback> feedbacksById;
    @JsonView({UserView.listUserView.class})
    private Collection<StudentClazz> studentClazzesById;
    private Collection<UserFeedback> userFeedbacksById;
    @JsonView({UserView.listUserView.class})
    private Department departmentByDepartmentId;
<<<<<<< Updated upstream
=======
    @JsonView({UserView.authenticatedUser.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private Role roleByRoleId;
    @JsonView({UserView.listUserView.class})
    private Major majorByMajorId;

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
    @Column(name = "username", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fullname", nullable = true, length = 255)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "birth", nullable = true)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "male", nullable = true)
    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (fullname != null ? !fullname.equals(user.fullname) : user.fullname != null) return false;
        if (code != null ? !code.equals(user.code) : user.code != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (birth != null ? !birth.equals(user.birth) : user.birth != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Answer> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<Answer> answersById) {
        this.answersById = answersById;
    }

    @OneToMany(mappedBy = "userByLecturerId")
    public Collection<Clazz> getClazzesById() {
        return clazzesById;
    }

    public void setClazzesById(Collection<Clazz> clazzesById) {
        this.clazzesById = clazzesById;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserFeedback> getUserFeedbacksById() {
        return userFeedbacksById;
    }

    public void setUserFeedbacksById(Collection<UserFeedback> userFeedbacksById) {
        this.userFeedbacksById = userFeedbacksById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<StudentClazz> getStudentClazzesById() {
        return studentClazzesById;
    }

    public void setStudentClazzesById(Collection<StudentClazz> studentClazzesById) {
        this.studentClazzesById = studentClazzesById;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    public Major getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(Major majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }
}
