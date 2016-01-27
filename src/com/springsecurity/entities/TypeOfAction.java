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
@Table(name = "sg_act_type_action", schema = "gestao_atividades")
public class TypeOfAction implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	@OneToMany(mappedBy = "typeOfAction", targetEntity = RequestTask.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RequestTask> requestTasks;

	@Id
	@GeneratedValue
	@Column(name = "TYPE_ACTION_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE", nullable = false)
	private Date lastUpdate;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATUS_ROW_ITEM", length = 1, nullable = false)
	private StatusObjectEnum statusObjectEnum;

	@Column(name = "DESCRIPTION", length = 45, nullable = false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
