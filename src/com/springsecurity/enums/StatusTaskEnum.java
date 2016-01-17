package com.springsecurity.enums;

public enum StatusTaskEnum {

	CONCLUIDA(1), CANCELADA(2), AGENDADA(3), EXECUCAO(4);

	public int valorEnumStatusTask;

	StatusTaskEnum(int valor) {
		valorEnumStatusTask = valor;
	}

}
