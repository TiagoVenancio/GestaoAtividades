package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_request_task", schema = "gestao_atividades")
public class RequestTask implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	@Id
	@GeneratedValue
	@Column(name = "TASK_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSE_DATE")
	private Date closeDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONCLUSION_DATE")
	private Date conclusionDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "AMOUNT_HOURS", nullable = false)
	private Date amountHours;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATUS_ROW_ITEM", length = 1, nullable = false)
	private StatusObjectEnum statusObjectEnum;

	@Column(name = "DESCRIPTION", length = 1000, nullable = false)
	private String description;

	@Column(name = "RESUME", length = 45, nullable = false)
	private String resume;

	@ManyToOne
	@JoinColumn(name = "TYPE_ACTIVITY_ID")
	private TypeOfActivity typeOfActivity;

	@ManyToOne
	@JoinColumn(name = "TYPE_TASK_ID")
	private TypeOfTask typeOfTask;

	@ManyToOne
	@JoinColumn(name = "TYPE_ACTION_ID")
	private TypeOfAction typeOfAction;

	@ManyToOne
	@JoinColumn(name = "TYPE_GROUP_ID")
	private TypeOfGroup typeOfGroup;

	@ManyToOne
	@JoinColumn(name = "STATUS_TASK_ID")
	private StatusOfTask statusOfTask;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private RequestCustomer requestCustomer;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "PRIORITY_ID")
	private TypeOfPriority typeOfPriority;

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

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getConclusionDate() {
		return conclusionDate;
	}

	public void setConclusionDate(Date conclusionDate) {
		this.conclusionDate = conclusionDate;
	}

	public Date getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(Date amountHours) {
		this.amountHours = amountHours;
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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public TypeOfActivity getTypeOfActivity() {
		return typeOfActivity;
	}

	public void setTypeOfActivity(TypeOfActivity typeOfActivity) {
		this.typeOfActivity = typeOfActivity;
	}

	public TypeOfTask getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(TypeOfTask typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	public TypeOfAction getTypeOfAction() {
		return typeOfAction;
	}

	public void setTypeOfAction(TypeOfAction typeOfAction) {
		this.typeOfAction = typeOfAction;
	}

	public TypeOfGroup getTypeOfGroup() {
		return typeOfGroup;
	}

	public void setTypeOfGroup(TypeOfGroup typeOfGroup) {
		this.typeOfGroup = typeOfGroup;
	}

	public StatusOfTask getStatusOfTask() {
		return statusOfTask;
	}

	public void setStatusOfTask(StatusOfTask statusOfTask) {
		this.statusOfTask = statusOfTask;
	}

	public RequestCustomer getRequestCustomer() {
		return requestCustomer;
	}

	public void setRequestCustomer(RequestCustomer requestCustomer) {
		this.requestCustomer = requestCustomer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TypeOfPriority getTypeOfPriority() {
		return typeOfPriority;
	}

	public void setTypeOfPriority(TypeOfPriority typeOfPriority) {
		this.typeOfPriority = typeOfPriority;
	}

}
