package com.mike.company.dao;

import com.mike.company.entity.Company;
import com.mike.company.entity.IPO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:48.
 */
public interface IPORepository extends CrudRepository<IPO, Long> {

    @Query("from IPO order by openDate desc")
    List<IPO> findAllIPO();

    @Modifying
    @Query("update IPO u set u.companyName=?1, u.stockExchange=?2, u.pricePerShare=?3, u.totalShares=?4, u.openDate=?5, u.remarks=?6 where u.id=?7")
    void updateIPOById(String companyName, String stockExchange, Double pricePerShare, int totalShares, Date openDate, String remarks, long id);

}
