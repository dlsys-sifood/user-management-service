package com.dlsys.sifood.ums.model;


import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserFilter {
	@NotEmpty(message = "es requerido para la consulta")
	private String field;
	@NotEmpty(message = "es requerido para la consulta")
	private String value;
}
