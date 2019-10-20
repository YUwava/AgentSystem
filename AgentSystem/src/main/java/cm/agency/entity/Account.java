package cm.agency.entity;


import java.math.BigDecimal;
import java.util.List;

public class Account {


	private Integer id;
	private Integer userId;
	private double money;
	private BigDecimal moneyBak;
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public BigDecimal getMoneyBak() {
		return moneyBak;
	}

	public void setMoneyBak(BigDecimal moneyBak) {
		this.moneyBak = moneyBak;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
