package com.springsecurity.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_request_task", schema = "gestao_atividades")
public class RequestTask implements Serializable {
	private static final long serialVersionUID = -7590317347612436291L;

	private Long id;
	private Calendar createDate;
	private Calendar closeDate;
	private Calendar startDate;
	private Calendar conclusionDate;
	private Double amountHours;
	private StatusObjectEnum statusObjectEnum;
	private String description;
	private String resume;
	private TypeOfActivity typeOfActivity;
	private TypeOfTask typeOfTask;
	private TypeOfAction typeOfAction;
	private TypeOfGroup typeOfGroup;
	private StatusOfTask statusOfTask;
	private RequestCustomer requestCustomer;
	private User user;
	private TypeOfPriority typeOfPriority;

	@Id
	@GeneratedValue
	@Column(name = "TASK_ID", length = 20)
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

	@Column(name = "CLOSE_DATE")
	public Calendar getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Calendar closeDate) {
		this.closeDate = closeDate;
	}

	@Column(name = "START_DATE", nullable = false)
	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	@Column(name = "CONCLUSION_DATE")
	public Calendar getConclusionDate() {
		return conclusionDate;
	}

	public void setConclusionDate(Calendar conclusionDate) {
		this.conclusionDate = conclusionDate;
	}

	@Column(name = "AMOUNT_HOURS", nullable = false)
	public Double getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(Double amountHours) {
		this.amountHours = amountHours;
	}

	@Column(name = "STATUS_OBJECT_TASK", length = 10, nullable = false)
	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	@Column(name = "DESCRIPTION", length = 1000, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "RESUME", length = 45, nullable = false)
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column(name = "TYPE_ACTVITY_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "TYPE_ACTIVITY_ID")
	public TypeOfActivity getTypeOfActivity() {
		return typeOfActivity;
	}

	public void setTypeOfActivity(TypeOfActivity typeOfActivity) {
		this.typeOfActivity = typeOfActivity;
	}

	@Column(name = "TYPE_TASK_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "TYPE_TASK_ID")
	public TypeOfTask getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(TypeOfTask typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	@Column(name = "TYPE_ACTION_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "TYPE_ACTION_ID")
	public TypeOfAction getTypeOfAction() {
		return typeOfAction;
	}

	public void setTypeOfAction(TypeOfAction typeOfAction) {
		this.typeOfAction = typeOfAction;
	}

	@Column(name = "TYPE_GROUP_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "TYPE_GROUP_ID")
	public TypeOfGroup getTypeOfGroup() {
		return typeOfGroup;
	}

	public void setTypeOfGroup(TypeOfGroup typeOfGroup) {
		this.typeOfGroup = typeOfGroup;
	}

	@Column(name = "STATUS_TASK_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "STATUS_TASK_ID")
	public StatusOfTask getStatusOfTask() {
		return statusOfTask;
	}

	public void setStatusOfTask(StatusOfTask statusOfTask) {
		this.statusOfTask = statusOfTask;
	}

	@Column(name = "CLIENT_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public RequestCustomer getRequestCustomer() {
		return requestCustomer;
	}

	public void setRequestCustomer(RequestCustomer requestCustomer) {
		this.requestCustomer = requestCustomer;
	}

	@Column(name = "USER_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "PRIORITY_ID", length = 20, nullable = false)
	@ManyToOne
	@JoinColumn(name = "PRIORITY_ID")
	public TypeOfPriority getTypeOfPriority() {
		return typeOfPriority;
	}

	public void setTypeOfPriority(TypeOfPriority typeOfPriority) {
		this.typeOfPriority = typeOfPriority;
	}

}
