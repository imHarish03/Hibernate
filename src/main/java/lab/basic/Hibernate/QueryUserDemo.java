package lab.basic.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QueryUserDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// Hibernate will load default file
				.configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			// Create a User Object
			User user = new User("Yogi", "Dindigul");

			// Start transaction
			Transaction tx = session.beginTransaction();

			// Save the transaction
			session.save(user);

			// Commit Transaction
			session.getTransaction().commit();

			// Find out student Id
			System.out.println("Saved User. Generated Id:" + user.getId());

			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			User getUser = (User) session.get(User.class, user.getId());

			System.out.println("Saved User. Generated Id:" + getUser.getName());
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			factory.close();
		}
	}

}
