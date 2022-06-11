package com.fsoft.dmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the knowledgetoday database table.
 * 
 */
@Entity
@Table
public class Knowledgetoday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int knowledgeTodayId;

	private String content;

	@Column(name = "`Date create`")
	private String date_create;

	private int evaluate;

	private int idUser;

	private String image;

	private String title;

	// bi-directional many-to-one association to Technology
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTechnology")
	private Technology technology;

	// bi-directional many-to-one association to Minimap
	@OneToMany(mappedBy = "knowledgetoday")
	private List<Minimap> minimaps;

	public Knowledgetoday() {
	}

	public int getKnowledgeTodayId() {
		return this.knowledgeTodayId;
	}

	public void setKnowledgeTodayId(int knowledgeTodayId) {
		this.knowledgeTodayId = knowledgeTodayId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate_create() {
		return this.date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public int getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public List<Minimap> getMinimaps() {
		return this.minimaps;
	}

	public void setMinimaps(List<Minimap> minimaps) {
		this.minimaps = minimaps;
	}

	public Minimap addMinimap(Minimap minimap) {
		getMinimaps().add(minimap);
		minimap.setKnowledgetoday(this);

		return minimap;
	}

	public Minimap removeMinimap(Minimap minimap) {
		getMinimaps().remove(minimap);
		minimap.setKnowledgetoday(null);

		return minimap;
	}

}