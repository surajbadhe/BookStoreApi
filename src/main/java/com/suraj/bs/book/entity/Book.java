package com.suraj.bs.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue 
	private Long id;

	@Column(name = "BOOK_NAME")
	private String bname;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "QUNATITY")
	private Long quantity;
	
	@Column(name = "PRICE")
	private Long bprice;
	

	@Column(name = "DESCRIPTION")
	private String description;
	
	public Book() {
		
	}
	public Book(Long inventoryID, String bname, String author, Long quantity, Long bprice, String description) {
		super();
		this.id = inventoryID;
		this.bname = bname;
		this.author = author;
		this.quantity = quantity;
		this.bprice = bprice;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return author;
	}

	public void setBauthor(String author) {
		this.author = author;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getBprice() {
		return bprice;
	}

	public void setBprice(Long bprice) {
		this.bprice = bprice;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((bprice == null) ? 0 : bprice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id == null) ? 0 :quantity.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (bprice == null) {
			if (other.bprice != null)
				return false;
		} else if (!bprice.equals(other.bprice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
