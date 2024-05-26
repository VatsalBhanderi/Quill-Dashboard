package com.example.quill.controller;

import com.example.quill.model.Chart;
import com.example.quill.repository.ChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartRepository chartRepository;

    @GetMapping("/{id}")
    public Optional<Chart> getChartById(@PathVariable Long id) {
        return chartRepository.findById(id);
    }
}
