package com.oklimenko.sampleapp.controller;

import com.oklimenko.sampleapp.dto.TestDto;
import com.oklimenko.sampleapp.logging.LogMethodStartExit;
import com.oklimenko.sampleapp.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Test implementation for Controller, for REST API.
 *
 * @author oklimenko@gmail.com
 */
@RequiredArgsConstructor
@LogMethodStartExit
@RestController
@RequestMapping("/")
public class GetDataController {

    private final TestService testService;

    @GetMapping("/list")
    public List<TestDto> getResultList() {
        return testService.getResults();
    }
}
