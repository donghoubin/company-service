package com.mike.company.service;

import com.mike.company.entity.Company;
import com.mike.company.entity.IPO;

import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
public interface IPOService {
    void createIPO(IPO ipo);
    List<IPO> retrieveAllIPO();

    void editIPO(IPO ipo);
}
