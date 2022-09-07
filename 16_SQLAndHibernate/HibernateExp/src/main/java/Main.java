import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


////        Задание 2
//        Course course = session.get(Course.class, 2);
//        System.out.println(course.getName().concat(": ") + course.getStudentsCount() + " студентов");
//
//        Teachers teachers = session.get(Teachers.class, 3);
//        System.out.println("Преподаватель: " + teachers.getName() + "\nВозраст: " + teachers.getAge() +
//                " лет\n" + "З/п - " + teachers.getSalary() + " руб.");

////        Задание 3
//        Transaction transaction = session.beginTransaction();
//
//        Course course = session.get(Course.class, 1);
//        Student student = session.get(Student.class, 2);
////        List<Student> students = course.getStudents();
////        students.forEach(student -> System.out.println(student.getName()));
//
//
//        Subscription subscription = session.get(Subscription.class,
//                new KeySubscription(student.getId(), course.getId()));
//        System.out.println(subscription.getStudent().getName());
//
//        transaction.commit();

////        hibernate queryBuilder
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> query = builder.createQuery(Course.class);
//        Root<Course> root = query.from(Course.class);
//        query.select(root).where(builder.greaterThan(root.get("price"), 100000))
//                .orderBy(builder.desc(root.get("price")));
//        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();
//        courseList.forEach(course -> System.out.println(course.getName().concat(" - ") + course.getPrice()));

////        HQL start study
//        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000" + " Order By price";
//        List<Course> courseList = session.createQuery(hql).getResultList();
//        courseList.forEach(course -> System.out.println(course.getName().concat(" - ") + course.getPrice()));

//        Добавление таблицы с данными, на основе данных из другой таблицы
        String query = "INSERT INTO " + LinkedPurchaseList.class.getSimpleName() + "(student_id, course_id, student_name, " +
                "course_name, subscription_date, price) " +
                "SELECT students.id as student_id, courses.id as course_id, student_name, course_name, subscription_date, " +
                "purchaselist.price FROM purchaselist " +
                "JOIN courses on courses.name = course_name " +
                "JOIN students on students.name = student_name";

        session.createSQLQuery(query).executeUpdate();
        session.get(LinkedPurchaseList.class, new KeyLinkedPurchaseList(1,10));

        transaction.commit();
        sessionFactory.close();
    }
}
