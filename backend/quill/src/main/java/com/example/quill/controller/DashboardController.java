package com.example.quill.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quill.model.ChartsMapper;
import com.example.quill.model.Dashboard;
import com.example.quill.model.DashboardMapper;
import com.example.quill.service.ChartService;
import com.example.quill.service.DashboardService;
import com.example.quill.util.Util;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;
    
    @Autowired
    private ChartService chartService;

    /**
     * For the given dashboard - name, returns a DashboardMapper object (a list of charts filtered for the given dates)
     * @param name
     * @param updateStartDate
     * @param updateEndDate
     * @return
     */
    @GetMapping("/{name}")
    public DashboardMapper getDashboardByName(@PathVariable String name, @RequestParam(required=false) Optional<String> updateStartDate, 
    							@RequestParam(required=false) Optional<String> updateEndDate) {
    	
    	Optional<Dashboard> dashboards = dashboardService.findByName(name);
    	System.out.println("getDashboardByName() dashboard: " + dashboards.get());
    	
    	//For the initial call, we will fetch from the dates from database
    	String startDate = Util.getStartDate(dashboards.get().getDateFilter().getInitialDateRange());
    	String endDate = Util.getCurrentDate();
   
    	//In case the user selects the date
    	if(updateStartDate.isPresent() && updateStartDate.get() != "") {
    		startDate = updateStartDate.get();
    		endDate = updateEndDate.get();
    	}
		
		List<ChartsMapper> chartsList = chartService.executeQueriesForDashboard(name, startDate, endDate);
    	
        return new DashboardMapper(name, dashboards.get().getDateFilter().getInitialDateRange(), chartsList);
    }
}

