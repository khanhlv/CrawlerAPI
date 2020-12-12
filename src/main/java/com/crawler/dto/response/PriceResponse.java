package com.crawler.dto.response;

import com.crawler.dto.enums.Web;
import lombok.Getter;
import lombok.Setter;

public class PriceResponse {

    @Getter
    @Setter
    private String price;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private Web web;

    @Getter
    @Setter
    private long time;
}
