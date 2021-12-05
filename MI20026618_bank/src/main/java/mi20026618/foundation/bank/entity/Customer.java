package mi20026618.foundation.bank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	

	private int  acctID;
	private String custName;
	private int phone;
	private String country;
	private String password;
	
	
	public Customer(int acctID, String custName, int phone, String country, String password) {
		
		super();
		//this.cid=cid;
		this.acctID = acctID;
		this.custName = custName;
		this.country = country;
		this.phone = phone;
		this.password = password;
	}
	
//	public int getCid() {
//		return cid;
//	}
//
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
	
	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public int getPhoneNo() {
		return phone;
	}

	public void setPhoneNo(int phone) {
		this.phone = phone;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
