package com.rodrigo.integration.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rodrigo.integration.domain.enums.Tag;

@Document(collection = "note")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private String description;
	private String tag;
//	private Date date;
//	
//	private UserDTO user;
	
	public Note() {
	}
	
	public Note(String id, String title, String description, Tag tag) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tag = (tag==null) ? null : tag.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tag getTag() {
		return Tag.toEnum(tag);
	}

	public void setTag(Tag tag) {
		this.tag = tag.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
