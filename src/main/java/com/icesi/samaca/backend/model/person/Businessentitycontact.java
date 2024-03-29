package com.icesi.samaca.backend.model.person;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the businessentitycontact database table.
 *
 */
@Entity
@NamedQuery(name = "Businessentitycontact.findAll", query = "SELECT b FROM Businessentitycontact b")
public class Businessentitycontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BusinessentitycontactPK id;

	private Timestamp modifieddate;

	private Integer rowguid;

	// bi-directional many-to-one association to Businessentity
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Businessentity businessentity;

	// bi-directional many-to-one association to Contacttype
	@ManyToOne
	@JoinColumn(name = "contacttypeid", insertable = false, updatable = false)
	private Contacttype contacttype;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "personid", insertable = false, updatable = false)
	private Person person;

	public Businessentitycontact() {
	}

	public Businessentity getBusinessentity() {
		return this.businessentity;
	}

	public Contacttype getContacttype() {
		return this.contacttype;
	}

	public BusinessentitycontactPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Person getPerson() {
		return this.person;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public void setBusinessentity(Businessentity businessentity) {
		this.businessentity = businessentity;
	}

	public void setContacttype(Contacttype contacttype) {
		this.contacttype = contacttype;
	}

	public void setId(BusinessentitycontactPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}