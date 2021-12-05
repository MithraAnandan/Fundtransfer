package mi20026618.foundation.bank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	private int  acctID;
	private int balance;
	private String acctType;
	
	public Account(int acctID, int balance, String acctType) {
		super();
		this.acctID = acctID;
		this.balance = balance;
		this.acctType = acctType;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}


}
