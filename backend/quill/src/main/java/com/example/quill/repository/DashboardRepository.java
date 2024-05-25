package com.example.quill.repository;

import com.example.quill.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Optional<Dashboard> findByName(String name);
}
