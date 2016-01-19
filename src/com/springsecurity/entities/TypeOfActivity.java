package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_type_activity", schema = "gestao_atividades")
public class TypeOfActivity implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	private Long id;
	private Calendar createDate;
	private Calendar lastUpdate;
	private StatusObjectEnum statusObjectEnum;
	private String description;
	
	@Id
	@GeneratedValue
	@Column(name = "TYPE_ACTIVITY_ID", length = 20)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column (name = "CREATE_DATE", nullable = false )
	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	@Column (name = "LAST_UPDATE", nullable = false)
	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column (name = "STATUS_OBJECT_ACTIVITY", length = 10, nullable = false)
	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public String getDescription() {
		return description;
	}

	@Column(name = "DESCRIPTION", length = 45, nullable = false)
	public void setDescription(String description) {
		this.description = description;
	}

	
}
