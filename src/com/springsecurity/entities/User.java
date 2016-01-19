package com.springsecurity.entities;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	private Long id;
	private Calendar dateCreate;
	private Calendar lastUpdate;
	private String registration;
	private String email;
	private String username;
	private String password;
	private List<Role> roles;
	private Long lastUserChange;
	private StatusObjectEnum statusObjectEnum;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "REGISTRATION", unique = true)
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	@Column(name = "EMAIL", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	public Calendar getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Calendar dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE")
	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "LAST_USER_CHANGE")
	public Long getLastUserChange() {
		return lastUserChange;
	}

	public void setLastUserChange(Long lastUserChange) {
		this.lastUserChange = lastUserChange;
	}

	@Enumerated
	@Column(name = "STATUS_OBJECT_USER")
	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	@ManyToMany
	@JoinTable(name = "sg_act_access_user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	@LazyCollection(LazyCollectionOption.FALSE)
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

}
