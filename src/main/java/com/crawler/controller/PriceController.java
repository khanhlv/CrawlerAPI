package com.crawler.controller;

import com.crawler.dto.GRequest;
import com.crawler.dto.GResponse;
import com.crawler.dto.enums.Web;
import com.crawler.dto.request.PriceRequest;
import com.crawler.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/price")
@Api(value = "/price", description = "API Lay gia")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/")
    @ApiOperation(value = "Lay gia cua san pham")
    public GResponse translate(@RequestBody GRequest<PriceRequest> data) {
        return GResponse.build().data(priceService.priceFetch(data.getData().getCode(), data.getData().getWeb()));
    }

    @GetMapping("/web")
    @ApiOperation(value = "Danh sach web lay gia")
    public GResponse webList() {
        return GResponse.build().data(Web.values());
    }

}
