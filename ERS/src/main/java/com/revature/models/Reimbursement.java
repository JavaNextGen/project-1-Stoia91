package com.revature.models;

public class Reimbursement {

	private int id;
	private int author;
	private int resolver;
	private int amount;
	private int status;
	private int reimb_type;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}

	public Reimbursement() {
		super();
	}
	
	public Reimbursement (int id, int author, int amount, int reimb_type, int status,int resolver) {
	super();
	this.id = id;
	this.author = author;
	this.resolver = resolver;
	this.amount = amount;
	this.status = status;
	this.reimb_type = reimb_type;
	}
	public Reimbursement (int id,int status,int resolver) {
		super();
		this.id = id;
		this.resolver = resolver;
		this.status = status;
		}
	public Reimbursement (int author, int amount, int reimb_type, int status) {
		super();
		this.author = author;
		this.amount = amount;
		this.reimb_type = reimb_type;
		this.status = status;
		}
	
	public String toString() {
		return "Reimbursement [id=" + id + ", author=" + author + ", amount=" + amount + ", type=" + reimb_type + ", status=" + status + ", resolver=" + resolver  + "]"; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + author;
		result = prime * result + id;
		result = prime * result + reimb_type;
		result = prime * result + resolver;
		result = prime * result + status;
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
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (author != other.author)
			return false;
		if (id != other.id)
			return false;
		if (reimb_type != other.reimb_type)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
}

