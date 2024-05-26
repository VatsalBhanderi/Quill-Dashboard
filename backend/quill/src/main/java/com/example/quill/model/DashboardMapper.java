package com.example.quill.model;

import java.util.List;

/**
 * Mapper object that returns a list of charts for a given dashboard
 * @author vatsalbhanderi
 */
public class DashboardMapper {
	private String name;
	private String initialDateRange;
	private List<ChartsMapper> charts;
	
	public DashboardMapper(String name, String initialDateRange, List<ChartsMapper> charts) {
		super();
		this.name = name;
		this.initialDateRange = initialDateRange;
		this.charts = charts;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInitialDateRange() {
		return initialDateRange;
	}
	public void setInitialDateRange(String initialDateRange) {
		this.initialDateRange = initialDateRange;
	}
	public List<ChartsMapper> getCharts() {
		return charts;
	}
	public void setCharts(List<ChartsMapper> charts) {
		this.charts = charts;
	}
	
	
}
