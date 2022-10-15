package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import view.Customers;

public class CustomerDAO {
	
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	private void getConnect()
	{
		  cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml"); 
		  
		 
		  factory= cfg.buildSessionFactory();
		   session = factory.openSession();
		 
		 tx = session.beginTransaction();
	}
	
	public String saveCustomer(Customers c)
	{
		getConnect();
		 
		 session.save(c);
		 tx.commit();
		 System.out.println("Stored successfully.....!!");
		 
		 endConnect();
		return "data inserted";
		
	}
	
	public boolean checkCustomerDetails(String id, String pass){
		getConnect(); 
	      
	 
		Query q=session.createQuery("from Customers c where c.id=:i and c.password=:p");
		
		q.setParameter("i", id);
		q.setParameter("p", pass);
  
		List<Customers> ls = q.list();

		for(Customers u2:ls)
		{
			if(id.equals(u2.getId()) && pass.equals(u2.getPassword()))
			{
				return true;
			}
		}
		tx.commit();
	
		endConnect();
		return false;
	}
	
	/* Function - Display Customer Data  */
	public List<Customers> displayDetails()
	{
		getConnect();

		Query<Customers> query = session.createQuery("from Customers c");
		
		List<Customers> list1 = query.list();

		endConnect();
		
		return list1;
	}
	
	/* Function - Update Money to Customer Account  */
	public int updateMoney(String balance, String id)
	{
		getConnect();
		
		String q = "UPDATE Customers set balance = :a "  + "WHERE id = :i";
		
		Query query = session.createQuery(q);
		
		query.setParameter("a", balance);
		query.setParameter("i", id);
		
		int res = query.executeUpdate();

		endConnect();
		return res;
	}
	
	/* Function - End Connection  */
	private void endConnect()
	{
		
		 session.close();
		 factory.close();
	}
 
}
