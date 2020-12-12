package com.crawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.dto.enums.Web;
import com.crawler.dto.response.PriceResponse;
import com.crawler.service.amazon.AmazonComService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceService {

    @Autowired
    private AmazonComService amazonComService;

    public PriceResponse priceFetch(String code, Web web) {

        PriceResponse priceResponse = new PriceResponse();

        if (Web.AMAZON_COM.equals(web)) {
            long start = System.currentTimeMillis();
            String price = amazonComService.priceFetch(code);
            long end = System.currentTimeMillis() - start;

            priceResponse.setPrice(price);
            priceResponse.setCode(code);
            priceResponse.setWeb(web);
            priceResponse.setTime(end);

            log.debug(" CODE [{}] WEB[{}] TIME[{}]", code,  Web.AMAZON_COM.name(), end);
        }

        return priceResponse;
    }
}
