package com.example.quill.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quill.model.Dashboard;
import com.example.quill.repository.DashboardRepository;

@Service
public class DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;
	
	public Optional<Dashboard> findByName(String name){
		return dashboardRepository.findByName(name); 
	}
}
