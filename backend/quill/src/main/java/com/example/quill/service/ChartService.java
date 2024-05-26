package com.example.quill.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.quill.model.Chart;
import com.example.quill.model.ChartsMapper;
import com.example.quill.repository.ChartRepository;

@Service
public class ChartService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ChartRepository chartRepository;

    public List<Chart> getChartsByDashboardName(String dashboardName) {
        return chartRepository.findByDashboardName(dashboardName);
    }
    
    /**
     * Will execute all the queries for all the charts for a given dashboard
     * @param dashboardName
     * @param startDate
     * @param endDate
     * @return - Return the result as a list of ChartsMapper object
     */

    public List<ChartsMapper> executeQueriesForDashboard(String dashboardName, String startDate, String endDate) {
        List<Chart> charts = getChartsByDashboardName(dashboardName);
        
        List<ChartsMapper> chartsList = new ArrayList<>();
        
        for (Chart chart : charts) {
            String sqlQuery = chart.getSqlQuery().replace(":startDate", "\'" + startDate + "\'").replace(":endDate", "\'" + endDate + "\'");
            System.out.println("query to execute executeQueriesForDashboard(): " + sqlQuery);
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlQuery);
            
    		ChartsMapper chartMapper = new ChartsMapper(chart.getName(), chart.getxAxisField(),
    										chart.getyAxisField(), result, chart.getChartType());
    		chartsList.add(chartMapper);
        }


        return chartsList;
    }
}
