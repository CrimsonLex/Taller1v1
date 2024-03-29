package com.icesi.samaca.backend.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.icesi.samaca.backend.model.person.Stateprovince;
import com.icesi.samaca.backend.validation.SalesTaxRateValidation;

/**
 * The persistent class for the salestaxrate database table.
 *
 */
@Entity
@NamedQuery(name = "Salestaxrate.findAll", query = "SELECT s FROM Salestaxrate s")
public class Salestaxrate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESTAXRATE_SALESTAXRATEID_GENERATOR", allocationSize = 1, sequenceName = "SALESTAXRATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESTAXRATE_SALESTAXRATEID_GENERATOR")
	private Integer salestaxrateid;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modifieddate;

	@Size(min = 5, groups = {SalesTaxRateValidation.class},message = "El nombre de la tasa debe ser de almenos 5 caracteres")
	private String name;

	private Integer rowguid;

	@ManyToOne
	@JoinColumn(name = "stateprovinceid")
	@NotNull(groups = {SalesTaxRateValidation.class},message = "El nombre de la tasa debe ser de almenos 5 caracteres")
	private Stateprovince stateprovince;

	@NotNull(groups= {SalesTaxRateValidation.class},message = "La tasa no puede ser nula ni negativa " )
	@Min(value = 0, groups= {SalesTaxRateValidation.class},message = "La tasa no puede ser negativa")
	private BigDecimal taxrate;

	private Integer taxtype;

	public Salestaxrate() {
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSalestaxrateid() {
		return this.salestaxrateid;
	}

	public BigDecimal getTaxrate() {
		return this.taxrate;
	}

	public Integer getTaxtype() {
		return this.taxtype;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalestaxrateid(Integer salestaxrateid) {
		this.salestaxrateid = salestaxrateid;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
	}

	public void setTaxtype(Integer taxtype) {
		this.taxtype = taxtype;
	}

	public Stateprovince getStateprovince() {
		return stateprovince;
	}

	public void setStateprovince(Stateprovince stateprovince) {
		this.stateprovince = stateprovince;
	}

}