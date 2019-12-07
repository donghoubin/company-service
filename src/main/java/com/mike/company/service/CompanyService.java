package com.mike.company.service;

import com.mike.company.entity.Company;
import com.mike.company.model.CompanyStockPriceRequest;
import com.mike.company.model.CompanyStockPriceResponse;

import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
public interface CompanyService {
    void createCompany(Company company);
    List<Company> retrieveAllCompanies();

    void editCompany(Company company);

    List<Object[]> getCompanyStockPrice(CompanyStockPriceRequest companyStockPriceRequest);
    Company getCompanyById(int companyCode);
}
