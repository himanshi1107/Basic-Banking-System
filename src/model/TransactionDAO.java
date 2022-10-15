package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import view.TransactionList;

public class TransactionDAO {
	
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	/* Function - Get Connection */
	private void getConnect()
	{
		  cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml"); 
		  
		 
		  factory= cfg.buildSessionFactory();
		   session = factory.openSession();
		 
		 tx = session.beginTransaction();
	}

	/* Function - Add Money to Account  */
	public String addMoney(String acc_no, String time, String amount, String total_amount, String details)
	{
		getConnect();
		
		TransactionList all = new TransactionList(acc_no, time, amount, total_amount, details);
		
		session.save(all);
		
		tx.commit();
		 
		 endConnect();
		return "Money added";
		
	}
	
	/* Function - Show Transaction List  */
	public List<TransactionList> showList(String acc_no)
	{
		getConnect();
		Query q2=session.createQuery("from TransactionList where acc_no = '"+acc_no+"'");
		
		List<TransactionList> all = q2.list();
		
		for(TransactionList li :  all)
		{
			System.out.println(li.getAcc_no());
		}
		endConnect();
		
		
		return all;
	}
	
	/* Function - Withdraw Money from Account  */
	public String withdrawMoney(String acc_no, String time, String amount, String total_amount, String details)
	{
		getConnect();
		
		TransactionList all = new TransactionList(acc_no, time, amount, total_amount, details);
		 
		session.save(all);
		
		tx.commit();
		 
		 endConnect();
		return "Money withdraw";
		
	}
	
	/* Function - End Connection  */
	private void endConnect()
	{
		
		 session.close();
		 factory.close();
	}

}



