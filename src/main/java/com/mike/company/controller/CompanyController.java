package com.mike.company.controller;

import com.mike.company.entity.Company;
import com.mike.company.model.CompanyStockPriceRequest;
import com.mike.company.model.CompanyStockPriceResponse;
import com.mike.company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
@Controller
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<Void> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        log.info("Create company successfully!");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/company")
    public ResponseEntity<Void> editCompany(@RequestBody Company company) {
        companyService.editCompany(company);
        log.info("Edit company successfully!");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCompanyDetails() {
        List<Company> companyList = new ArrayList<>();
        companyList = companyService.retrieveAllCompanies();
        log.info("Get company list successfully!");
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PostMapping("/companiesStockPrice")
    public ResponseEntity<List<Object[]>> getCompanyStockPrice(@RequestBody CompanyStockPriceRequest companyStockPriceRequest) {
        List<Object[]> companyPirceList = new ArrayList<>();
        companyPirceList = companyService.getCompanyStockPrice(companyStockPriceRequest);
        log.info("Get company stock list successfully!");
        return new ResponseEntity<>(companyPirceList, HttpStatus.OK);
    }

    @GetMapping("/company/{companyCode}")
    public ResponseEntity<Company> getCompanyByCompanyCode(@PathVariable("companyCode") long companyCode) {
        Company company = new Company();
        log.info("Get company by company code successfully!");
        company = companyService.getCompanyById(Integer.parseInt(String.valueOf(companyCode)));
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
