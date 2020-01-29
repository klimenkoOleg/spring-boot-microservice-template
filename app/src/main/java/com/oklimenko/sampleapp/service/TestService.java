package com.oklimenko.sampleapp.service;

import com.oklimenko.sampleapp.dto.TestDto;
import com.oklimenko.sampleapp.logging.LogMethodStartExit;
import com.oklimenko.sampleapp.mapper.TestMapper;
import com.oklimenko.sampleapp.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Test service.
 *
 * @author oklimenko@gmail.com
 */
@Slf4j
@RequiredArgsConstructor
@LogMethodStartExit
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class TestService {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    public List<TestDto> getResults() {
        return testMapper.createDtoToEntity(testRepository.findAll());
    }

}
