package com.springsecurity.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class RedirectorBean {
	public String userPage() {
		return "userPage";
	}

	public String adminPage() {
		return "adminPage";
	}

	public String index() {
		return "index";
	}

	public String successfulPage() {
		return "successfulPage";

	}

	public String usuarios() {
		return "usuariosPage";

	}

	public String prioridades() {
		return "prioridadesPage";

	}

	public String statusTask() {
		return "statusTarefaPage";

	}

	public String tipoAtividades() {
		return "tipoAtividadesPage";

	}

	public String tipoAcoes() {
		return "tipoAcoesPage";

	}

	public String solicitante() {
		return "solicitantePage";

	}

	public String tipoTarefasPage() {
		return "tipoTarefasPage";

	}

}
