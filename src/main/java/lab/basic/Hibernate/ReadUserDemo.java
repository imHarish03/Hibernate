package lab.basic.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUserDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// Hibernate will load default file
				.configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			// Start transaction
			session.beginTransaction();

			// Query User
			System.out.println("**List of users**");
			List<User> userList = session.createQuery("from User").list();
			displayUsers(userList);

			// Query user where user name like kar
			System.out.println("**List of users like Kri**");
			List<User> users = session.createQuery("from User u Where u.name LIKE 'Chri%' OR u.country='Karur'")
					.list();
			displayUsers(users);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			factory.close();
		}
	}

	static void displayUsers(List<User> userList) {
		// Display the users
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
