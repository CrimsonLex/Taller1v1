package com.icesi.samaca.backend.model.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the person database table.
 *
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PERSON_BUSINESSENTITYID_GENERATOR", allocationSize = 1, sequenceName = "PERSON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private String additionalcontactinfo;

	private String demographics;

	private Integer emailpromotion;

	private String firstname;

	private String lastname;

	private String middlename;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modifieddate;

	private String namestyle;

	private String persontype;

	private Integer rowguid;

	private String suffix;

	private String title;

	// bi-directional many-to-one association to Businessentitycontact
	@OneToMany(mappedBy = "person")
	private List<Businessentitycontact> businessentitycontacts;

	// bi-directional many-to-one association to Emailaddress
	@OneToMany(mappedBy = "person")
	private List<Emailaddress> emailaddresses;

	// bi-directional one-to-one association to Password
	@OneToOne(mappedBy = "person")
	private Password password;

	// bi-directional one-to-one association to Businessentity
	@OneToOne
	@JoinColumn(name = "businessentityid")
	private Businessentity businessentity;

	// bi-directional many-to-one association to Personphone
	@OneToMany(mappedBy = "person")
	private List<Personphone> personphones;

	public Person() {
	}

	public Businessentitycontact addBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().add(businessentitycontact);
		businessentitycontact.setPerson(this);

		return businessentitycontact;
	}

	public Emailaddress addEmailaddress(Emailaddress emailaddress) {
		getEmailaddresses().add(emailaddress);
		emailaddress.setPerson(this);

		return emailaddress;
	}

	public Personphone addPersonphone(Personphone personphone) {
		getPersonphones().add(personphone);
		personphone.setPerson(this);

		return personphone;
	}

	public String getAdditionalcontactinfo() {
		return this.additionalcontactinfo;
	}

	public Businessentity getBusinessentity() {
		return this.businessentity;
	}

	public List<Businessentitycontact> getBusinessentitycontacts() {
		return this.businessentitycontacts;
	}

	public Integer getBusinessentityid() {
		return this.businessentityid;
	}

	public String getDemographics() {
		return this.demographics;
	}

	public List<Emailaddress> getEmailaddresses() {
		return this.emailaddresses;
	}

	public Integer getEmailpromotion() {
		return this.emailpromotion;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public String getNamestyle() {
		return this.namestyle;
	}

	public Password getPassword() {
		return this.password;
	}

	public List<Personphone> getPersonphones() {
		return this.personphones;
	}

	public String getPersontype() {
		return this.persontype;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTitle() {
		return this.title;
	}

	public Businessentitycontact removeBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().remove(businessentitycontact);
		businessentitycontact.setPerson(null);

		return businessentitycontact;
	}

	public Emailaddress removeEmailaddress(Emailaddress emailaddress) {
		getEmailaddresses().remove(emailaddress);
		emailaddress.setPerson(null);

		return emailaddress;
	}

	public Personphone removePersonphone(Personphone personphone) {
		getPersonphones().remove(personphone);
		personphone.setPerson(null);

		return personphone;
	}

	public void setAdditionalcontactinfo(String additionalcontactinfo) {
		this.additionalcontactinfo = additionalcontactinfo;
	}

	public void setBusinessentity(Businessentity businessentity) {
		this.businessentity = businessentity;
	}

	public void setBusinessentitycontacts(List<Businessentitycontact> businessentitycontacts) {
		this.businessentitycontacts = businessentitycontacts;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
	}

	public void setEmailaddresses(List<Emailaddress> emailaddresses) {
		this.emailaddresses = emailaddresses;
	}

	public void setEmailpromotion(Integer emailpromotion) {
		this.emailpromotion = emailpromotion;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setNamestyle(String namestyle) {
		this.namestyle = namestyle;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public void setPersonphones(List<Personphone> personphones) {
		this.personphones = personphones;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}