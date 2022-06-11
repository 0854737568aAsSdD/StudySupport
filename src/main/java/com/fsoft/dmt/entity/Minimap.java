package com.fsoft.dmt.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the minimap database table.
 * 
 */
@Entity
@Table
public class Minimap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int minimapID;

	private String content;

	@Column(name="`Date create`")
	private String date_create;

	private String minimapcol;

	private String title;

	//bi-directional many-to-one association to Knowledgetoday
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="KnowledgeToayId")
	private Knowledgetoday knowledgetoday;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdUser")
	private User user;

	public Minimap() {
	}

	public int getMinimapID() {
		return this.minimapID;
	}

	public void setMinimapID(int minimapID) {
		this.minimapID = minimapID;
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

	public String getMinimapcol() {
		return this.minimapcol;
	}

	public void setMinimapcol(String minimapcol) {
		this.minimapcol = minimapcol;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Knowledgetoday getKnowledgetoday() {
		return this.knowledgetoday;
	}

	public void setKnowledgetoday(Knowledgetoday knowledgetoday) {
		this.knowledgetoday = knowledgetoday;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}