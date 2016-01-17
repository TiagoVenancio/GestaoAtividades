package com.springsecurity.enums;

public enum StatusObjectEnum {

	ATIVO(1), INATIVO(2);

	public int valorEnumStatus;

	StatusObjectEnum(int valor) {
		valorEnumStatus = valor;
	}

}
