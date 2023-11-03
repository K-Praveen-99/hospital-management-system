package com.jsp.hospitalmanagementsystem.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	@NotBlank(message = "reason cannot be null or blank")
	private String reason;
	private double cost;

	@ManyToOne
	private Person person;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> list;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Branch> getList() {
		return list;
	}

	public void setList(List<Branch> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Encounter [eid=" + eid + ", reason=" + reason + ", cost=" + cost + ", person=" + person + ", list="
				+ list + "]";
	}

}
