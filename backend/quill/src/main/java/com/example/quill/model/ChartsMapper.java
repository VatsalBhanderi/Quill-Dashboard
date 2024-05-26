package com.example.quill.model;

import java.util.List;
import java.util.Map;

/**
 * Chart object containing data after executing the SQL query for the provided date range 
 * @author vatsalbhanderi
 *
 */
public class ChartsMapper {

	private String chartName;
	private String xName;
	private String yName;
	private List<Map<String, Object>> data;
	private String chartType;
	private String dateField;
	
	public ChartsMapper(String chartName, String xName, String yName, List<Map<String, Object>> data, String chartType, String dateField) {
		this.chartName = chartName;
		this.xName = xName;
		this.yName = yName;
		this.data = data;
		this.chartType=chartType;
		this.dateField = dateField;
	}
	
	
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	public String getxName() {
		return xName;
	}
	public void setxName(String xName) {
		this.xName = xName;
	}
	public String getyName() {
		return yName;
	}
	public void setyName(String yName) {
		this.yName = yName;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}


	public String getChartType() {
		return chartType;
	}


	public void setChartType(String chartType) {
		this.chartType = chartType;
	}


	public String getDateField() {
		return dateField;
	}


	public void setDateField(String dateField) {
		this.dateField = dateField;
	}
	
	
	
}
