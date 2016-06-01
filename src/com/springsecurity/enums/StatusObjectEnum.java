package com.springsecurity.enums;

import java.io.Serializable;

public enum StatusObjectEnum implements Serializable {

	Ativo(0), Inativo(1);

	public int valorStatusEnum;

	StatusObjectEnum(int valor) {
		valorStatusEnum = valor;
	}

}
