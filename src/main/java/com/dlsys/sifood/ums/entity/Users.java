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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
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
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String name;
	
	@Column
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 1, max = 1, message = "debe contener maximo 1 caracter")
	private String gender;
	
	@Column(name = "father_name")
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String fatherName;
	
	@Column(name = "mother_name")
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 3, max = 20, message = "debe contener entre 3 y 20 caracteres")
	private String motherName;
	
	@Column
	@NotEmpty(message = "el campo no puede ser vacio")
	@Email
	@Size(max = 40,  message = "debe contener minimo 40 caracteres")
	private String email;
	
	@Column(name = "username")
	@Email
	@NotEmpty(message = "el campo no puede ser vacio")
	private String username; 
	
	@Column
	@NotEmpty(message = "el campo no puede ser vacio")
	@Size(min = 8, max = 8)
	private String password;

	@Column
	@NotEmpty
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

	@Column(name = "id_porfile_job")	
	private Integer idPorfileJob;
	
	@Column
	private Date dateRegister;
	
	@Column
	private Integer flag;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public Integer getIdConty() {
		return idConty;
	}

	public void setIdConty(Integer idConty) {
		this.idConty = idConty;
	}

	public UUID getIdFather() {
		return idFather;
	}

	public void setIdFather(UUID idFather) {
		this.idFather = idFather;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getIdPorfileJob() {
		return idPorfileJob;
	}

	public void setIdPorfileJob(Integer idPorfileJob) {
		this.idPorfileJob = idPorfileJob;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public List<String> toList() {
		
		List<String> response = new ArrayList<String>();
		response.add("Users [id=" + id + ", name=" + name + ", gender=" + gender + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", email=" + email + ", username=" + username + ", password="
				+ password + ", rfc=" + rfc + ", idCountry=" + idCountry + ", idState=" + idState + ", idConty="
				+ idConty + ", idFather=" + idFather + ", idRole=" + idRole + ", idPorfileJob=" + idPorfileJob
				+ ", dateRegister=" + dateRegister + ", flag=" + flag + "]");
		
		return response;
	}
	
}
