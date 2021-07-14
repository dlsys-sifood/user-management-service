package com.dlsys.sifood.ums.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
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
	private Integer flag;
	
	@Column(name = "id_father")	
	private UUID idFather;
	
	@Column(name = "id_role")	
	private Integer idRole;

	@Column(name = "id_profile_job")	
	private Integer idPorfileJob;
	
	@Column
	private Date dateRegister;
	
	@JoinColumn(name = "id_user_detail")
	@OneToOne(fetch = FetchType.LAZY)
	private UserDetail userDetail;

	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getIdFather() {
		return idFather;
	}
	public void setIdFather(UUID idFather) {
		this.idFather = idFather;
	}
	public Date getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRol) {
		this.idRole = idRol;
	}
	public Integer getIdPorfileJob() {
		return idPorfileJob;
	}
	public void setIdPorfileJob(Integer idPorfileJob) {
		this.idPorfileJob = idPorfileJob;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
}
