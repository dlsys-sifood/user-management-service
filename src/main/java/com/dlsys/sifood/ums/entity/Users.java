package com.dlsys.sifood.ums.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;



@Entity
@Table(name = "user")
@Data
public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	@GeneratedValue
	private UUID id;
	
	@Column
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String name;
	
	@Column
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 1, max = 1, message = "debe contener maximo 1 caracter")
	private String gender;
	
	@Column(name = "father_name")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String fatherName;
	
	@Column(name = "mother_name")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String motherName;
	
	@Column
	@NotEmpty(message = "no puede ser vacio")
	@Email
	@Size(max = 40,  message = "debe contener minimo 40 caracteres")
	private String email;
	
	@Column(name = "username")
	@Email
	@NotEmpty(message = "no puede ser vacio")
	private String username; 
	
	@Column
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 8, max = 8)
	private String password;

	@Column
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 13, max = 13, message = "el campo debe ser de 13 caracteres")
	private String rfc;
	
	@Column(name = "id_country")
	private Integer idCountry;
	
	@Column(name = "id_state")	
	private Integer idState;
	
	@Column(name = "id_county")	
	private Integer idConty;
	
	@Column(name = "id_father")	
	private UUID idFather;
	
	@Column(name = "id_role")	
	private Integer idRole;

	@Column(name = "id_profile_job")	
	private Integer idProfileJob;
	
	@Column
	private Date dateRegister;
	
	@Column
	private Integer flag;
	
	@PrePersist
	private void beforeSave() {
		this.flag = 1;
		this.dateRegister = new Date();
	}

	public List<String> toList() {
		
		List<String> response = new ArrayList<String>();
		response.add("Users [id=" + id + ", name=" + name + ", gender=" + gender + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", email=" + email + ", username=" + username + ", password="
				+ password + ", rfc=" + rfc + ", idCountry=" + idCountry + ", idState=" + idState + ", idConty="
				+ idConty + ", idFather=" + idFather + ", idRole=" + idRole + ", idPorfileJob=" + idProfileJob
				+ ", dateRegister=" + dateRegister + ", flag=" + flag + "]");
		
		return response;
	}
	
}
