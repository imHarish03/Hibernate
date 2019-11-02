package lab.basic.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// Hibernate will load default file
				.configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			// Create a User Object
			User user = new User("Christopher", "Krishnagiri");

			// Start transaction
			Transaction tx = session.beginTransaction();

			// Save the transaction
			session.save(user);

			User getUser = (User) session.get(User.class, 1);
			System.out.println("**Get Data***");
			System.out.println("Username is :" + getUser.getName());
			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			factory.close();
		}
	}
}
