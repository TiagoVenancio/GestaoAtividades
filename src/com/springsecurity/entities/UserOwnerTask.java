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
@Table(name = "sg_act_request_task_user", schema = "gestao_atividades")
public class UserOwnerTask implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	@Id
	@GeneratedValue
	@Column(name = "USER_OWNER_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date dateCreate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	@Column(name = "NAME", unique = true, length = 255, nullable = false)
	private String name;

	@Column(name = "EMAIL", unique = true, length = 255)
	private String email;

	@Column(name = "USERNAME", unique = true, length = 20)
	private String username;

	@Column(name = "BUSINESS_GROUP", length = 20)
	private String businessGroup;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATUS_ROW_ITEM", length = 1, nullable = false)
	private StatusObjectEnum statusObjectEnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public String getBusinessGroup() {
		return businessGroup;
	}

	public void setBusinessGroup(String businessGroup) {
		this.businessGroup = businessGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessGroup == null) ? 0 : businessGroup.hashCode());
		result = prime * result
				+ ((dateCreate == null) ? 0 : dateCreate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((statusObjectEnum == null) ? 0 : statusObjectEnum.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		UserOwnerTask other = (UserOwnerTask) obj;
		if (businessGroup == null) {
			if (other.businessGroup != null)
				return false;
		} else if (!businessGroup.equals(other.businessGroup))
			return false;
		if (dateCreate == null) {
			if (other.dateCreate != null)
				return false;
		} else if (!dateCreate.equals(other.dateCreate))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (statusObjectEnum != other.statusObjectEnum)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserOwnerTask [id=" + id + ", dateCreate=" + dateCreate
				+ ", lastUpdate=" + lastUpdate + ", name=" + name + ", email="
				+ email + ", username=" + username + ", businessGroup="
				+ businessGroup + ", statusObjectEnum=" + statusObjectEnum
				+ "]";
	}

}
