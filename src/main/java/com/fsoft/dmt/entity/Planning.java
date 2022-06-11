package com.fsoft.dmt.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planning database table.
 * 
 */
@Entity
@Table
public class Planning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlanning;

	private String content;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdUser")
	private User user;

	//bi-directional many-to-one association to Technology
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdTechnology")
	private Technology technology;

	public Planning() {
	}

	public int getIdPlanning() {
		return this.idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}