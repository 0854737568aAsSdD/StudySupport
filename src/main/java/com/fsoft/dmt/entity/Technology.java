package com.fsoft.dmt.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the technology database table.
 * 
 */
@Entity
@Table
public class Technology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTechnology;

	private String technologyName;

	//bi-directional many-to-one association to Knowledgetoday
	@OneToMany(mappedBy="technology")
	private List<Knowledgetoday> knowledgetodays;

	//bi-directional many-to-one association to Planning
	@OneToMany(mappedBy="technology")
	private List<Planning> plannings;

	public Technology() {
	}

	public int getIdTechnology() {
		return this.idTechnology;
	}

	public void setIdTechnology(int idTechnology) {
		this.idTechnology = idTechnology;
	}

	public String getTechnologyName() {
		return this.technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public List<Knowledgetoday> getKnowledgetodays() {
		return this.knowledgetodays;
	}

	public void setKnowledgetodays(List<Knowledgetoday> knowledgetodays) {
		this.knowledgetodays = knowledgetodays;
	}

	public Knowledgetoday addKnowledgetoday(Knowledgetoday knowledgetoday) {
		getKnowledgetodays().add(knowledgetoday);
		knowledgetoday.setTechnology(this);

		return knowledgetoday;
	}

	public Knowledgetoday removeKnowledgetoday(Knowledgetoday knowledgetoday) {
		getKnowledgetodays().remove(knowledgetoday);
		knowledgetoday.setTechnology(null);

		return knowledgetoday;
	}

	public List<Planning> getPlannings() {
		return this.plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}

	public Planning addPlanning(Planning planning) {
		getPlannings().add(planning);
		planning.setTechnology(this);

		return planning;
	}

	public Planning removePlanning(Planning planning) {
		getPlannings().remove(planning);
		planning.setTechnology(null);

		return planning;
	}

}