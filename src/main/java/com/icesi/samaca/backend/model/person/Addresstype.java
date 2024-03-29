package com.icesi.samaca.backend.model.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the addresstype database table.
 *
 */
@Entity
@NamedQuery(name = "Addresstype.findAll", query = "SELECT a FROM Addresstype a")
public class Addresstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ADDRESSTYPE_ADDRESSTYPEID_GENERATOR", allocationSize = 1, sequenceName = "ADDRESSTYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESSTYPE_ADDRESSTYPEID_GENERATOR")
	private Integer addresstypeid;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	// bi-directional many-to-one association to Businessentityaddress
	@OneToMany(mappedBy = "addresstype")
	private List<Businessentityaddress> businessentityaddresses;

	public Addresstype() {
	}

	public Businessentityaddress addBusinessentityaddress(Businessentityaddress businessentityaddress) {
		getBusinessentityaddresses().add(businessentityaddress);
		businessentityaddress.setAddresstype(this);

		return businessentityaddress;
	}

	public Integer getAddresstypeid() {
		return this.addresstypeid;
	}

	public List<Businessentityaddress> getBusinessentityaddresses() {
		return this.businessentityaddresses;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Businessentityaddress removeBusinessentityaddress(Businessentityaddress businessentityaddress) {
		getBusinessentityaddresses().remove(businessentityaddress);
		businessentityaddress.setAddresstype(null);

		return businessentityaddress;
	}

	public void setAddresstypeid(Integer addresstypeid) {
		this.addresstypeid = addresstypeid;
	}

	public void setBusinessentityaddresses(List<Businessentityaddress> businessentityaddresses) {
		this.businessentityaddresses = businessentityaddresses;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}