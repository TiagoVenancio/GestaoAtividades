package com.springsecurity.enums;

public enum StatusTaskEnum {

	Planejada(0), Cancelada(1), Finalizada(2);

	public int valorStatusEnum;

	StatusTaskEnum(int valor) {
		valorStatusEnum = valor;
	}

}
