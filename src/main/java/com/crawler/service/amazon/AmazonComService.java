package com.crawler.service.amazon;

import java.net.InetSocketAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.dto.enums.Web;
import com.crawler.model.Data;
import com.crawler.parser.AmazonComParser;
import com.crawler.parser.AmazonUkParser;
import com.crawler.proxy.ProxyProvider;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AmazonComService {

    @Autowired
    private AmazonComParser amazonComParser;

    @Autowired
    private ProxyProvider proxyProvider;

    public String priceFetch(String code) {

        String price = "0";

        String urlDetail = Web.AMAZON_COM.getDesc() + "/dp/%s/";

        List<InetSocketAddress> inetSocketAddresses = proxyProvider.proxyList();

        if (inetSocketAddresses != null && inetSocketAddresses.size() > 0) {
            for (InetSocketAddress socketAddress : inetSocketAddresses) {
                Data content = null;

                try {
                    content = amazonComParser.readDetail(String.format(urlDetail, code), code, 0, socketAddress);
                } catch (Exception ex) {

                }

                if (content != null) {
                    if (content.getPrice() > 0) {
                        price = String.valueOf(content.getPrice());
                    } else {
                        price = "0";
                    }
                    break;
                }
            }
        }

        return price;
    }
}
