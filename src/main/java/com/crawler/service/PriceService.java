package com.crawler.service;

import org.springframework.stereotype.Service;

import com.crawler.dto.enums.Web;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceService {

    public String priceFetch(String code, Web web) {

        if (Web.AMAZON_COM.equals(web)) {

        }

        return "0";
    }
}
