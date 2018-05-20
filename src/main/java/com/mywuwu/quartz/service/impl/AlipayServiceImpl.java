package com.mywuwu.quartz.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.mywuwu.quartz.dto.AlipayOrderDto;
import com.mywuwu.quartz.pay.alipay.AlipayConfig;
import com.mywuwu.quartz.service.IAlipayService;
import org.springframework.stereotype.Service;


/**
 * Package: com.mywuwu.quartz.service.impl
 * Description： 支付宝支付实现类
 * Author: 梁乐乐
 * Date: Created in 2018/5/20 10:52
 * Company: clinbrain
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
@Service
public class AlipayServiceImpl implements IAlipayService {


    /**
     * 支付宝网站支付
     *
     * @param orderDto 订单信息
     * @return 支付表单
     */
    public String alipayTradeWapPay(AlipayOrderDto orderDto) {
        String form = "";
        try {
            // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
            //调用RSA签名方式
//            AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

            AlipayClient client = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091500515364",
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPI/Mmj/o3UyR9iI3vRpPFLTMdT+XQfzzYG6T6eRWl/ZSvhePB0zSxvkfrAGwKQdq54DYIj61Crrgi9EJ4lJzxY6MIExxIYmNLEIYjpuOsdckqxgjZZmUcytFzSe2ZZJedntX9VU5faW3QRyJA5n9DyuPMPtmCXAU6fjHZ7SISbuNaNy4mKLUbCKm0hc9iHSDZ0WbXx2lkRhlL/NKeVp8K9qsYRDHGcPdl3t72UFo2/tkGJ9o8omBX0kQxDQsUCTvYDw0mpQP+R+HWrb3j4u9oJdsFIeuGZzvbm8n18Alo/sEmFkwS2Ft7hO0tr8HTtjxYXEZdoRAfYtLMuTooA3yhAgMBAAECggEAX7A1pMrNB10SYMT/tTwmHsMHj4nQ5N+aKhHY6QQ2/58UXX4Q8oqhiEzewO+oSfcaI/YJyRFbTt+EAwHsybT3cbscypIT7yOuowip032GZ8zZrTlzwvlbkLLY78w1BL0lSd5byR3U5Z2SJpDXCjHMU+J3BBvjxeyEJkUkSD3o8A6hXNfcqsB/2UMQrnjytxiqh0ijXtCQHvyq7ko5W8E9a0ad6DsEiRcVf2w9eMqLrAr5jHiBRj6GzkK6yTStXvJ8FtW1p7ik3ctcu7lD3s/lCFSuwTE0OaCwQaEeFejl1jbDi6hhLXkf/euB60nMIg30ZzxeMxo49cwDqr/9/2fgkQKBgQDsK9hqgET/T2a7w7U7IvsWvusLoKbqkthKW+vJK725Nfjf64+LgLTotULpkgO475JyluR0ad3woy+1KA8MYjWOvSxNVTyiwpZKE+UA+0DoAQ59sVfbTjbWL8wo2OZyHl2bSVVTw/9mPcgG1m6NBN9l/bBhKPqf2oBNR/fNFPMbdQKBgQCbKIsJKvOkKWxtv2T61Lx8RXqVuLI9J2cB2zp/PhMIdM4PDpKCMgKJHYeN77JRYt8TsO+DWdMCWw3qxOjNxWKaRq6rzV/GazFCdE2TW1CFmsVahfRBWE3iDiI+SqxwWer3rK/5Cg2CfZQjUpBwT5tqELzeFfbw6iaI3j9WrMKy/QKBgDLclnUJPtLFJNjXIxajR/P0FeahKJFoIpCRD0x50RgsGXcP4hAnHc7oCosG2Spg3eczu+ueSR/j5QhcojEGjYY6E2psKuzaf0dg1XbKpYXRhG9pXARs6b5i+NLrM2XsSDiDKI8rrLs2HvfqAlD4dawfYHbsPl1izzLVhvZxxpFpAoGBAJYPqCi9udZTmeKq8WcGySUHrX+QmhI7QYyyEulth8rt7Tzyww/YfktOnAPSh4vfLBFHVt6ayVHF7rfYqbAZ7zt2kQjoIHEuyv2SrlSORFpzTdw3IfzxAqJXORc18YDX9kCEa81Yw6go/FUNTVTSKWVzurawV5y5WXuWN3wEqmmhAoGAeHzxHtlmihqmqkViLQbpBoGJPzU5x7UfyzS9PdsjvE2WZghBPCI0EQS2REgQiRvrVmWIYIm26J3WEsYbfEDWndAMYOKN1nJTJCJT4qh34mm3lCaxFeNa6m6tnX7CIRqLxH1kdBr267UaM8Vfr653P7Qg3ALnvC1H84SOzQwFes4="
                    , "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvbmibHAKUsRNJXKq9LmndvbWaBZXTEfKHTu8hE1/jZs5pQ25g4svLppho+sXikLXKhqzNFg5uXNrytzS1j5SOvCQrIODgi+iVBwAQTBye2qrboB/3FyvK2c6SLXT2XqgveVuNSJkEGIKOt4Omw3zKvoLBCQvvAajVkv54jhGZRHcPtCtbO5O+Ef8Jnazj8vpnby10RorBXSKiEw0CiLJcWBiaa5SBa+syt2rH+EPs7zDcltkio81C5tGzBUjkUGPfCnhxsbDRVg3XRxQQIVAi4uvbvejH9DpyjhQehPBq7s9NIwupaspclHLSoG4vUIyQxk0doBKe12AKBq89YWDkwIDAQAB"
                    , "RSA2");
            //阿里支付请求类
            AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

            // 封装请求支付信息
            AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
            model.setOutTradeNo(orderDto.getOutTradNo());
            model.setSubject(orderDto.getSubject());
            model.setTotalAmount(orderDto.getTotalAmount());
            model.setBody(orderDto.getBody());
            model.setTimeoutExpress(orderDto.getTimeoutExpress());
            model.setProductCode(orderDto.getProductCode());
            alipay_request.setBizModel(model);
            // 设置异步通知地址
            alipay_request.setNotifyUrl(AlipayConfig.notify_url);
            // 设置同步地址
            alipay_request.setReturnUrl(AlipayConfig.return_url);

            // form表单生产   // 调用SDK生成表单
            form = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}
