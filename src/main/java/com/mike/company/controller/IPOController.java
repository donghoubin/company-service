package com.mike.company.controller;

import com.mike.company.entity.IPO;
import com.mike.company.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/3 20:47.
 */
@Controller
public class IPOController {

    @Autowired
    private IPOService ipoService;

    @PostMapping("/ipo")
    public ResponseEntity<Void> createIPO(@RequestBody IPO ipo) {
        ipoService.createIPO(ipo);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/ipo")
    public ResponseEntity<Void> editIPO(@RequestBody IPO ipo) {
        ipoService.editIPO(ipo);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/ipos")
    public ResponseEntity<List<IPO>> retrieveAllIPO() {
        List<IPO> ipoList = new ArrayList<>();
        ipoList = ipoService.retrieveAllIPO();
        return new ResponseEntity<>(ipoList, HttpStatus.OK);
    }
}
