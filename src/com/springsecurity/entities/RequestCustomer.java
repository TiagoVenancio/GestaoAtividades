package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_request_customer", schema = "gestao_atividades")
public class RequestCustomer implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result
				+ ((lastUserChange == null) ? 0 : lastUserChange.hashCode());
		result = prime
				* result
				+ ((statusObjectEnum == null) ? 0 : statusObjectEnum.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestCustomer other = (RequestCustomer) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (lastUserChange == null) {
			if (other.lastUserChange != null)
				return false;
		} else if (!lastUserChange.equals(other.lastUserChange))
			return false;
		if (statusObjectEnum != other.statusObjectEnum)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestCustomer [id=" + id + ", createDate=" + createDate
				+ ", lastUpdate=" + lastUpdate + ", userId=" + userId
				+ ", userName=" + userName + ", email=" + email
				+ ", lastUserChange=" + lastUserChange + ", statusObjectEnum="
				+ statusObjectEnum + "]";
	}

}
