package com.example.quill.model;

import jakarta.persistence.*;

@Entity
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dashboardName;
    private String chartType;
    private String sqlQuery;
    private String xAxisField;
    private String yAxisField;

    @Embedded
    private DateField dateField;

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

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public String getxAxisField() {
		return xAxisField;
	}

	public void setxAxisField(String xAxisField) {
		this.xAxisField = xAxisField;
	}

	public String getyAxisField() {
		return yAxisField;
	}

	public void setyAxisField(String yAxisField) {
		this.yAxisField = yAxisField;
	}

	public DateField getDateField() {
		return dateField;
	}

	public void setDateField(DateField dateField) {
		this.dateField = dateField;
	}

    // Getters and setters
    
}