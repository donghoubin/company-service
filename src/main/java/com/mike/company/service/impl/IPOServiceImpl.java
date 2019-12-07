package com.mike.company.service.impl;

import com.mike.company.dao.IPORepository;
import com.mike.company.entity.IPO;
import com.mike.company.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
@Service
public class IPOServiceImpl implements IPOService {

    @Autowired
    private IPORepository ipoRepository;

    @Override
    public void createIPO(IPO ipo) {
        ipoRepository.save(ipo);
    }

    @Override
    public List<IPO> retrieveAllIPO() {
        return ipoRepository.findAllIPO();
    }

    @Override
    @Transactional
    public void editIPO(IPO ipo) {
        ipoRepository.updateIPOById(ipo.getCompanyName(), ipo.getStockExchange(),
                ipo.getPricePerShare(), ipo.getTotalShares(), ipo.getOpenDate(), ipo.getRemarks(), ipo.getId());
    }
}
