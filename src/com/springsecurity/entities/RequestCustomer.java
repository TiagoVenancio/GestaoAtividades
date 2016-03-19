package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_request_customer", schema = "gestao_atividades")
public class RequestCustomer implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	@OneToMany(mappedBy = "requestCustomer", targetEntity = RequestTask.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RequestTask> requestTasks;

	@Id
	@GeneratedValue
	@Column(name = "CLIENT_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE", nullable = false)
	private Date lastUpdate;

	@Column(name = "USERNAME", length = 20, nullable = false)
	private String userId;

	@Column(name = "NAME", length = 255, nullable = false)
	private String userName;

	@Column(name = "EMAIL", length = 100, nullable = false)
	private String email;

	@Column(name = "LAST_USER_CHANGE", length = 20, nullable = false)
	private String lastUserChange;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATUS_ROW_ITEM", length = 1, nullable = false)
	private StatusObjectEnum statusObjectEnum;

	public Long getId() {
		return id;
	}

	public List<RequestTask> getRequestTasks() {
		return requestTasks;
	}

	public void setRequestTasks(List<RequestTask> requestTasks) {
		this.requestTasks = requestTasks;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastUserChange() {
		return lastUserChange;
	}

	public void setLastUserChange(String lastUserChange) {
		this.lastUserChange = lastUserChange;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
