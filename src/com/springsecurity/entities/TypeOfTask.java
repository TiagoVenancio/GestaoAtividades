package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sg_act_type_task", schema = "gestao_atividades")
public class TypeOfTask implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	@OneToMany(mappedBy = "typeOfTask", targetEntity = RequestTask.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RequestTask> requestTasks;

	@Id
	@GeneratedValue
	@Column(name = "TYPE_TASK_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = true)
	private Calendar createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE", nullable = true)
	private Calendar lastUpdate;

	@Enumerated
	@Column(name = "STATUS_OBJECT_TYPE_TASK", length = 10, nullable = true)
	private StatusObjectEnum statusObjectEnum;

	@Column(name = "DESCRIPTION", length = 45, nullable = false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
