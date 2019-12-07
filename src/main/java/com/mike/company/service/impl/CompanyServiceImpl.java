package com.mike.company.service.impl;

import com.mike.company.dao.CompanyRepository;
import com.mike.company.entity.Company;
import com.mike.company.model.CompanyStockPriceRequest;
import com.mike.company.model.CompanyStockPriceResponse;
import com.mike.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> retrieveAllCompanies() {
        return companyRepository.findAllCompany();
    }

    @Override
    @Transactional
    public void editCompany(Company company) {
        companyRepository.updateCompanyById(
                company.getCompanyName(), company.getTurnover(), company.getCeo(), company.getBrief(), company.getStockCode(), company.getId());
    }

    @Override
    public List<Object[]> getCompanyStockPrice(CompanyStockPriceRequest companyStockPriceRequest) {
        List<Object[]> result = new ArrayList<>();
        int companyId =Integer.parseInt(companyStockPriceRequest.getCompanyId());
        String startTime =companyStockPriceRequest.getStartTime();
        String endTime = companyStockPriceRequest.getEndTime();
        switch (companyStockPriceRequest.getPeriodicity()) {
            case "1":
                result = companyRepository.getWeekCompanyStockPrice(companyId, startTime,endTime);
                break;
            case "2":
                result = companyRepository.getMonthCompanyStockPrice(companyId, startTime,endTime);
                break;
            case "3":
                result = companyRepository.getQuaterCompanyStockPrice(companyId, startTime,endTime);
                break;
            case "4":
                result = companyRepository.getYearCompanyStockPrice(companyId, startTime,endTime);
                break;
        }
        return result;
    }

    @Override
    public Company getCompanyById(int companyCode) {
        return companyRepository.findById(Long.valueOf(companyCode)).get();
    }
}
