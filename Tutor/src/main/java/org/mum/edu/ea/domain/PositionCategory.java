package org.mum.edu.ea.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class PositionCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pcategoryId;	

	@Column(name="TYPE", length=15, nullable=false)
	@Enumerated(EnumType.STRING)
	private Category type ;

	public Long getPcategoryId() {
		return pcategoryId;
	}

	public void setPcategoryId(Long pcategoryId) {
		this.pcategoryId = pcategoryId;
	}

	public Category getType() {
		return type;
	}

	public void setType(Category type) {
		this.type = type;
	}

}
