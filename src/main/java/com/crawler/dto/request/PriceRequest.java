package com.crawler.dto.request;

import com.crawler.dto.enums.Web;
import lombok.Getter;
import lombok.Setter;

public class PriceRequest {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private Web web;
}
