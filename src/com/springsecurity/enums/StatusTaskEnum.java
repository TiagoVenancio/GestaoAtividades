package com.springsecurity.enums;

public enum StatusTaskEnum {

	A_FAZER(0), FAZENDO(1), CONCLUIDA(2), CANCELADA(3);

	public int valorStatusEnum;

	StatusTaskEnum(int valor) {
		valorStatusEnum = valor;
	}

}
