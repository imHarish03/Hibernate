package lab.basic.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			User getUser = (User) session.get(User.class, 1);
			System.out.println("Username is :" + getUser.getName());
			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
