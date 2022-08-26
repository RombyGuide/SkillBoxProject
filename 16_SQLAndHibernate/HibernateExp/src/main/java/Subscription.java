import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private KeySubscription id;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
