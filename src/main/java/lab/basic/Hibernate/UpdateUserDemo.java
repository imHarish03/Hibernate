package lab.basic.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUserDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// Hibernate will load default file
				.configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		try {
			int userId = 1;
			Session session = factory.getCurrentSession();
			// Start transaction
			session.beginTransaction();

			// Query User
			System.out.println("**Get Student with Id**");
			User user = (User) session.get(User.class, userId);
			System.out.println("Updating student...");
			user.setName("Vinodh");

			session.getTransaction().commit();

			/// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update country for all the users");
			session.createQuery("Update User Set country='India'").executeUpdate();

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			factory.close();
		}
	}

}
