package com.mike.company.dao;

import com.mike.company.entity.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:48.
 */
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("from Company")
    List<Company> findAllCompany();

    @Modifying
    @Query("update Company u set u.companyName=?1, u.turnover=?2, u.ceo=?3, u.brief=?4, u.stockCode=?5 where u.id=?6")
    void updateCompanyById(String companyName, Double turnover, String ceo, String brief, String stockCode, long id);

    @Query(value = "SELECT WEEK(company.date) dates, ROUND(sum(company.currentPrice),2) currentPrice,company.companyname from( SELECT sp.currentPrice,sp.date , c.companyname  " +
            " FROM stock_price sp , company c where c.id=sp.companycode and sp.companycode=?1  and sp.date>?2 and  sp.date<?3  ) company " +
            "GROUP BY WEEK(company.date) " +
            "ORDER BY WEEK(company.date) asc ", nativeQuery = true)
    List<Object[]> getWeekCompanyStockPrice(int companyId, String startTime, String endTime);

    @Query(value = "SELECT MONTH(company.date) dates, ROUND(sum(company.currentPrice),2) currentPrice,company.companyname from( SELECT sp.currentPrice,sp.date  , c.companyname " +
            " FROM stock_price sp , company c where c.id=sp.companycode and sp.companycode=?1  and sp.date>?2 and  sp.date<?3  ) company " +
            "GROUP BY MONTH(company.date) " +
            "ORDER BY MONTH(company.date) asc ", nativeQuery = true)
    List<Object[]> getMonthCompanyStockPrice(int companyId, String startTime, String endTime);

    @Query(value = "SELECT QUARTER(company.date) dates, ROUND(sum(company.currentPrice),2) currentPrice,company.companyname from( SELECT sp.currentPrice,sp.date , c.companyname  " +
            " FROM stock_price sp, company c where c.id=sp.companycode and sp.companycode=?1  and sp.date>?2 and  sp.date<?3  ) company " +
            "GROUP BY QUARTER(company.date) " +
            "ORDER BY QUARTER(company.date) asc ", nativeQuery = true)
    List<Object[]> getQuaterCompanyStockPrice(int companyId, String startTime, String endTime);


    @Query(value = "SELECT YEAR(company.date) dates, ROUND(sum(company.currentPrice),2) currentPrice,company.companyname from( SELECT sp.currentPrice,sp.date , c.companyname  " +
            " FROM stock_price , company c where c.id=sp.companycode and sp.companycode=?1  and sp.date>?2 and  sp.date<?3  ) company " +
            "GROUP BY YEAR(company.date) " +
            "ORDER BY YEAR(company.date) asc ", nativeQuery = true)
    List<Object[]> getYearCompanyStockPrice(int companyId, String startTime, String endTime);

}
