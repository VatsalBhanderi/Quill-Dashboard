package com.example.quill.model;

import jakarta.persistence.*;

@Embeddable
public class DateFilter {
    private String filterName;
    private String initialDateRange;
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getInitialDateRange() {
		return initialDateRange;
	}
	public void setInitialDateRange(String initialDateRange) {
		this.initialDateRange = initialDateRange;
	}
	@Override
	public String toString() {
		return "DateFilter [filterName=" + filterName + ", initialDateRange=" + initialDateRange + "]";
	}

   
    
}