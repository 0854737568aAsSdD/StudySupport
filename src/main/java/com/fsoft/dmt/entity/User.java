package com.fsoft.dmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	private String lastName;

	private String logincol;

	private String password;

	private byte role;

	private String surName;

	private String userName;

	// bi-directional many-to-one association to Minimap
	@OneToMany(mappedBy = "user")
	private List<Minimap> minimaps;

	// bi-directional many-to-one association to Planning
	@OneToMany(mappedBy = "user")
	private List<Planning> plannings;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogincol() {
		return this.logincol;
	}

	public void setLogincol(String logincol) {
		this.logincol = logincol;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getRole() {
		return this.role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Minimap> getMinimaps() {
		return this.minimaps;
	}

	public void setMinimaps(List<Minimap> minimaps) {
		this.minimaps = minimaps;
	}

	public Minimap addMinimap(Minimap minimap) {
		getMinimaps().add(minimap);
		minimap.setUser(this);

		return minimap;
	}

	public Minimap removeMinimap(Minimap minimap) {
		getMinimaps().remove(minimap);
		minimap.setUser(null);

		return minimap;
	}

	public List<Planning> getPlannings() {
		return this.plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}

	public Planning addPlanning(Planning planning) {
		getPlannings().add(planning);
		planning.setUser(this);

		return planning;
	}

	public Planning removePlanning(Planning planning) {
		getPlannings().remove(planning);
		planning.setUser(null);

		return planning;
	}

}