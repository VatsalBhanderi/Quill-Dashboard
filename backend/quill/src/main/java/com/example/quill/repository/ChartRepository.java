package com.example.quill.repository;

import com.example.quill.model.Chart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends JpaRepository<Chart, Long> {
	
	List<Chart> findByDashboardName(String name);
	Optional<Chart> findByName(String name);
}
