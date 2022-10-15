package view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_list")
public class TransactionList {
	
	@Id
	private int id;
	@Column
	private String acc_no, time, amount, total_amount, details;
	
	public TransactionList(){
		
	}
	
	public TransactionList(String acc_no, String time, String amount, String total_amount, String details) {
		super();
		this.acc_no = acc_no;
		this.time = time;
		this.amount = amount;
		this.total_amount = total_amount;
		this.details = details;
	}
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	
}
