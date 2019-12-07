package com.mike.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mike.company.entity.Company;
import com.mike.company.model.CompanyStockPriceRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/7 17:30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {
    @Autowired
    private WebApplicationContext wac;

    public MockMvc mvc;
    public MockHttpSession session;
    public Cookie[] cookies = new Cookie[1];

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        cookies[0] = new Cookie("mykey", "myvalue");
    }

    @Test
    public void createCompany() throws Exception {
        Company company = new Company();
        company.setId(33333);
        company.setCompanyName("Test");
        company.setBrief("TestB");
        company.setCompanyCode("501111");
        company.setDirector("rrr");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(company);
        mvc.perform(MockMvcRequestBuilders.post( "/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void editCompany() throws Exception{
        Company company = new Company();
        company.setId(33333);
        company.setCompanyName("Test");
        company.setBrief("TestB");
        company.setCompanyCode("501111");
        company.setDirector("rrr");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(company);
        mvc.perform(MockMvcRequestBuilders.put( "/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void getCompanyDetails() throws Exception{
        CompanyStockPriceRequest companyStockPriceRequest =new CompanyStockPriceRequest();
        companyStockPriceRequest.setCompanyId(String.valueOf(500112));
        companyStockPriceRequest.setStartTime("2019-01-01");
        companyStockPriceRequest.setEndTime("2019-12-12");
        companyStockPriceRequest.setPeriodicity("1");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(companyStockPriceRequest);
        mvc.perform(
                MockMvcRequestBuilders.post("/companiesStockPrice")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getCompanyStockPrice() throws Exception{
        CompanyStockPriceRequest companyStockPriceRequest =new CompanyStockPriceRequest();
        companyStockPriceRequest.setCompanyId(String.valueOf(500112));
        companyStockPriceRequest.setStartTime("2019-01-01");
        companyStockPriceRequest.setEndTime("2019-12-12");
        companyStockPriceRequest.setPeriodicity("1");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(companyStockPriceRequest);
        mvc.perform(
                MockMvcRequestBuilders.post("/companiesStockPrice")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCompanyByCompanyCode() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("/company/500112")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }
}