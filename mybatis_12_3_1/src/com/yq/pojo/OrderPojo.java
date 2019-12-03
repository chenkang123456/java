package com.yq.pojo;
import java.sql.Timestamp;
import java.util.List;

public class OrderPojo {
	private Integer id;
	private Integer user_id;
	private String number;
	private Timestamp createTime;
	private String note;
	private UserPojo user;//当前订单的下单人对象
	private List<OrderDetailPojo> Details;//订单对应的名细集合
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public UserPojo getUser() {
		return user;
	}

	public void setUser(UserPojo user) {
		this.user = user;
	}
	
	public List<OrderDetailPojo> getDetails() {
		return Details;
	}

	public void setDetails(List<OrderDetailPojo> details) {
		Details = details;
	}

	@Override
	public String toString() {
		return "OrderPojo [id=" + id + ", user_id=" + user_id + ", number=" + number + ", createTime=" + createTime
				+ ", note=" + note + "]";
	}
	

}
