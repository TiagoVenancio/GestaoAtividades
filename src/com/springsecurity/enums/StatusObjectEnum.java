package com.springsecurity.enums;

public enum StatusObjectEnum {

	Ativo(1), Inativo(0);

	public int valorStatusEnum;

	StatusObjectEnum(int valor) {
		valorStatusEnum = valor;
	}

}
