package com.org.opera.domain;

import java.sql.Timestamp;

/**
 * ÐÂÎÅ
 * @author huangshx
 *
 */
public class News {

	private Long id;
	private String title;
	private String text;
	private Timestamp time;
	private String type;

	// Constructors

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
