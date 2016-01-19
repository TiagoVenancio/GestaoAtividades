package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springsecurity.enums.StatusFinalAction;
import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_status_task", schema = "gestao_atividades")
public class StatusOfTask implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	private Long id;
	private Calendar createDate;
	private Calendar lastUpdate;
	private StatusObjectEnum statusObjectEnum;
	private String description;
	private StatusFinalAction statusFinalAction;

	
	@Id
	@GeneratedValue
	@Column(name = "STATUS_TASK_ID", length = 20)
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

	@Column (name = "STATUS_OBJECT_TASK", length = 10, nullable = false)
	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	@Column(name = "DESCRIPTION", length = 45, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column (name = "FINAL_ACTION", length = 10, nullable = false)
	public StatusFinalAction getStatusFinalAction() {
		return statusFinalAction;
	}

	public void setStatusFinalAction(StatusFinalAction statusFinalAction) {
		this.statusFinalAction = statusFinalAction;
	}

}
