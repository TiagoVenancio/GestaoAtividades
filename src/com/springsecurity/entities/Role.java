package com.springsecurity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "sg_act_access_role", schema = "gestao_atividades")
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = -3968396919486158590L;

	private Long id;
	private String descriptionRole;

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION_ROLE", unique = true)
	public String getDescription() {
		return descriptionRole;
	}

	public void setDescription(String description) {
		this.descriptionRole = description;
	}

	@Override
	@Transient
	public String getAuthority() {
		return descriptionRole;
	}
}
