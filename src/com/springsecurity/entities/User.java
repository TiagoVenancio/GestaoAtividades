package com.springsecurity.entities;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecurity.enums.StatusObjectEnum;

@Entity
@Table(name = "sg_act_access_user", schema = "gestao_atividades")
public class User implements UserDetails {
	private static final long serialVersionUID = -7590317347612436291L;

	@OneToMany(mappedBy = "user", targetEntity = RequestTask.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<RequestTask> requestTasks;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", length = 20)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Calendar dateCreate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE")
	private Calendar lastUpdate;

	@Column(name = "NAME", unique = true, length = 255)
	private String name;

	@Column(name = "EMAIL", unique = true, length = 255)
	private String email;

	@Column(name = "USERNAME", unique = true, length = 20)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany
	@JoinTable(name = "sg_act_access_user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles;

	@Column(name = "LAST_USER_CHANGE")
	private Long lastUserChange;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Calendar getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Calendar dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Long getLastUserChange() {
		return lastUserChange;
	}

	public void setLastUserChange(Long lastUserChange) {
		this.lastUserChange = lastUserChange;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {

		return false;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {

		return false;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {

		return false;
	}

	@Override
	@Transient
	public boolean isEnabled() {

		return false;
	}

	@Override
	public String toString() {
		return "User [requestTasks=" + requestTasks + ", id=" + id
				+ ", dateCreate=" + dateCreate + ", lastUpdate=" + lastUpdate
				+ ", name=" + name + ", email=" + email + ", username="
				+ username + ", password=" + password + ", roles=" + roles
				+ ", lastUserChange=" + lastUserChange + ", statusObjectEnum="
				+ statusObjectEnum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateCreate == null) ? 0 : dateCreate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result
				+ ((lastUserChange == null) ? 0 : lastUserChange.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((requestTasks == null) ? 0 : requestTasks.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		User other = (User) obj;
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
		if (lastUserChange == null) {
			if (other.lastUserChange != null)
				return false;
		} else if (!lastUserChange.equals(other.lastUserChange))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (requestTasks == null) {
			if (other.requestTasks != null)
				return false;
		} else if (!requestTasks.equals(other.requestTasks))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
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

}
