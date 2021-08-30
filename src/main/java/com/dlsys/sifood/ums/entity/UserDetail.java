package com.dlsys.sifood.ums.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user_detail")
public class UserDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	@GeneratedValue
	private UUID id;
	
	@Column
	@NotEmpty
	@Size(min = 13, max = 13)
	private String rfc;
	
	@Column(name = "phone_number")
	@NotEmpty
	@Size(min = 10, max = 10)
	private Long phoneNumber;
	
	@Column
	@NotEmpty
	@Size(max = 30)
	private String street;
	
	@Column(name = "number_street")	
	private Integer numberStreet;
	
	@Column(name = "internal_number")	
	private Integer internalNumber;
	
	@Column(name = "emergency_number")	
	private Integer emergencyNumber;
	
	@Column(name = "name_emergency")	
	private String nameEmergency;
	
	@Column(name = "id_country")	
	private Integer idCountry;
	
	@Column(name = "id_state")	
	private Integer idState;
	
	@Column(name = "id_conty")	
	private Integer idConty;
	
	@Column
	private Integer flag;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberStreet() {
		return numberStreet;
	}
	public void setNumberStreet(Integer numberStreet) {
		this.numberStreet = numberStreet;
	}
	public Integer getInternalNumber() {
		return internalNumber;
	}
	public void setInternalNumber(Integer internalNumber) {
		this.internalNumber = internalNumber;
	}
	public Integer getEmergencyNumber() {
		return emergencyNumber;
	}
	public void setEmergencyNumber(Integer emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getNameEmergency() {
		return nameEmergency;
	}
	public void setNameEmergency(String nameEmergency) {
		this.nameEmergency = nameEmergency;
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
}
