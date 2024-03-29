package com.icesi.samaca.backend.model.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the businessentitycontact database table.
 * 
 */
@Embeddable
public class BusinessentitycontactPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Column(insertable=false, updatable=false)
	private Integer personid;

	@Column(insertable=false, updatable=false)
	private Integer contacttypeid;

	public BusinessentitycontactPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public Integer getPersonid() {
		return this.personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}
	public Integer getContacttypeid() {
		return this.contacttypeid;
	}
	public void setContacttypeid(Integer contacttypeid) {
		this.contacttypeid = contacttypeid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BusinessentitycontactPK)) {
			return false;
		}
		BusinessentitycontactPK castOther = (BusinessentitycontactPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.personid.equals(castOther.personid)
			&& this.contacttypeid.equals(castOther.contacttypeid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.personid.hashCode();
		hash = hash * prime + this.contacttypeid.hashCode();
		
		return hash;
	}
}