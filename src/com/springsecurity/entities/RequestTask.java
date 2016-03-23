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
import com.springsecurity.enums.StatusTaskEnum;

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

	@Column(name = "AMOUNT_HOURS", length = 10, nullable = false)
	private String amountHours;

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

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "STATUS_TASK_ID", length = 1, nullable = false)
	private StatusTaskEnum statusTaskEnum;

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

	public StatusTaskEnum getStatusTaskEnum() {
		return statusTaskEnum;
	}

	public String getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(String amountHours) {
		this.amountHours = amountHours;
	}

	public void setStatusTaskEnum(StatusTaskEnum statusTaskEnum) {
		this.statusTaskEnum = statusTaskEnum;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((amountHours == null) ? 0 : amountHours.hashCode());
		result = prime * result
				+ ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result
				+ ((conclusionDate == null) ? 0 : conclusionDate.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((requestCustomer == null) ? 0 : requestCustomer.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime
				* result
				+ ((statusObjectEnum == null) ? 0 : statusObjectEnum.hashCode());
		result = prime * result
				+ ((statusTaskEnum == null) ? 0 : statusTaskEnum.hashCode());
		result = prime * result
				+ ((typeOfAction == null) ? 0 : typeOfAction.hashCode());
		result = prime * result
				+ ((typeOfActivity == null) ? 0 : typeOfActivity.hashCode());
		result = prime * result
				+ ((typeOfGroup == null) ? 0 : typeOfGroup.hashCode());
		result = prime * result
				+ ((typeOfPriority == null) ? 0 : typeOfPriority.hashCode());
		result = prime * result
				+ ((typeOfTask == null) ? 0 : typeOfTask.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		RequestTask other = (RequestTask) obj;
		if (amountHours == null) {
			if (other.amountHours != null)
				return false;
		} else if (!amountHours.equals(other.amountHours))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (conclusionDate == null) {
			if (other.conclusionDate != null)
				return false;
		} else if (!conclusionDate.equals(other.conclusionDate))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (requestCustomer == null) {
			if (other.requestCustomer != null)
				return false;
		} else if (!requestCustomer.equals(other.requestCustomer))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (statusObjectEnum != other.statusObjectEnum)
			return false;
		if (statusTaskEnum != other.statusTaskEnum)
			return false;
		if (typeOfAction == null) {
			if (other.typeOfAction != null)
				return false;
		} else if (!typeOfAction.equals(other.typeOfAction))
			return false;
		if (typeOfActivity == null) {
			if (other.typeOfActivity != null)
				return false;
		} else if (!typeOfActivity.equals(other.typeOfActivity))
			return false;
		if (typeOfGroup == null) {
			if (other.typeOfGroup != null)
				return false;
		} else if (!typeOfGroup.equals(other.typeOfGroup))
			return false;
		if (typeOfPriority == null) {
			if (other.typeOfPriority != null)
				return false;
		} else if (!typeOfPriority.equals(other.typeOfPriority))
			return false;
		if (typeOfTask == null) {
			if (other.typeOfTask != null)
				return false;
		} else if (!typeOfTask.equals(other.typeOfTask))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestTask [id=" + id + ", createDate=" + createDate
				+ ", closeDate=" + closeDate + ", startDate=" + startDate
				+ ", conclusionDate=" + conclusionDate + ", amountHours="
				+ amountHours + ", statusObjectEnum=" + statusObjectEnum
				+ ", description=" + description + ", resume=" + resume
				+ ", typeOfActivity=" + typeOfActivity + ", typeOfTask="
				+ typeOfTask + ", typeOfAction=" + typeOfAction
				+ ", typeOfGroup=" + typeOfGroup + ", statusTaskEnum="
				+ statusTaskEnum + ", requestCustomer=" + requestCustomer
				+ ", user=" + user + ", typeOfPriority=" + typeOfPriority + "]";
	}

}
