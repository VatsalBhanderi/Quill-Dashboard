package com.example.quill.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class DateField {
    private String tableName;
    private String field;
	public String getTable() {
		return tableName;
	}
	public void setTable(String table) {
		this.tableName = table;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

    
    // Getters and setters
}