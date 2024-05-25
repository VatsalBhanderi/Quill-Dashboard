package com.example.quill.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    	
    @Embedded
    private DateFilter dateFilter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateFilter getDateFilter() {
		return dateFilter;
	}

	public void setDateFilter(DateFilter dateFilter) {
		this.dateFilter = dateFilter;
	}

	@Override
	public String toString() {
		return "Dashboard [id=" + id + ", name=" + name + ", dateFilter=" + dateFilter + "]";
	}
    
	
}




