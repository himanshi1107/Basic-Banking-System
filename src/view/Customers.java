package view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customers {
	
	@Id
	private String id;
	@Column
	private String name, mob_no, password, balance, upi_pin, acc_no;
	
	public Customers(){
		
	}
	
	public Customers(String balance, String upi_pin, String acc_no) {
		super();
		this.balance = balance;
		this.upi_pin = upi_pin;
		this.acc_no = acc_no;
	}

	public Customers(String name, String mob_no, String password, String balance, String upi_pin, String acc_no) {
		super();
		this.name = name;
		this.mob_no = mob_no;
		this.password = password;
		this.balance = balance;
		this.upi_pin = upi_pin;
		this.acc_no = acc_no;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getUpi_pin() {
		return upi_pin;
	}
	public void setUpi_pin(String upi_pin) {
		this.upi_pin = upi_pin;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	
	
	

}
