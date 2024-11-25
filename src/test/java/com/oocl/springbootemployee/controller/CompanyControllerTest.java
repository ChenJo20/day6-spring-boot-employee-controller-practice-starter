package com.oocl.springbootemployee.controller;


import com.oocl.springbootemployee.entity.Company;
import com.oocl.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class CompanyControllerTest {

    @Autowired
    private MockMvc client;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JacksonTester<Company> json;
    @Autowired
    private JacksonTester<List<Company>> jsonList;

    @BeforeEach
    void setup() {
        companyRepository.setCompanies(new ArrayList<>());
        companyRepository.getCompanies().add(new Company(1, "company1"));
        companyRepository.getCompanies().add(new Company(2, "company2"));
    }

    @Test
    void should_return_companies_when_get_all_given_companies() throws Exception {
        //Given
        List<Company> expectedCompanies = companyRepository.getCompanies();

        //When
        //Then
        String resultJson = client.perform(MockMvcRequestBuilders.get("/companies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(jsonList.parseObject(resultJson))
                .usingRecursiveComparison()
                .isEqualTo(expectedCompanies);
    }
}
