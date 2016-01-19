package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_request_customer", schema = "gestao_atividades")
public class RequestCustomer implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	private Long id;
	private Calendar createDate;
	private Calendar lastUpdate;
	private String userName;
	private String Name;
	private String email;
	private String lastUserChange;
	private StatusObjectEnum statusObjectEnum;

	@Id
	@GeneratedValue
	@Column(name = "CLIENT_ID", length = 20)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CREATE_DATE", nullable = false)
	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	@Column(name = "LAST_UPDATE", nullable = false)
	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "USERNAME", length = 20, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "NAME", length = 255, nullable = false)
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Column(name = "EMAIL", length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "LAST_USER_CHANGE", length = 20, nullable = false)
	public String getLastUserChange() {
		return lastUserChange;
	}

	public void setLastUserChange(String lastUserChange) {
		this.lastUserChange = lastUserChange;
	}

	@Enumerated
	@Column(name = "STATUS_OBJECT_CLIENT", length = 10, nullable = false)
	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

}
