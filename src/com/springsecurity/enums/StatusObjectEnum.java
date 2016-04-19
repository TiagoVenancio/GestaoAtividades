package com.springsecurity.enums;

public enum StatusObjectEnum {

	Ativo(0), Inativo(1);

	public int valorStatusEnum;

	StatusObjectEnum(int valor) {
		valorStatusEnum = valor;
	}

}
