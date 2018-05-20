package com.mywuwu.quartz.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.mywuwu.quartz.dto.AlipayOrderDto;
import com.mywuwu.quartz.service.IAlipayService;
import com.mywuwu.quartz.utils.DateUtils;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@CrossOrigin
@RequestMapping("/alipay")
public class AlipayController {

    /**
     * 支付宝支付处理类
     */
    @Autowired
    private IAlipayService alipayService;
/*
    public void notifyUrl() {
        Map<String, Object> requestParams = ActionContext.getContext().getParameters();
        Map<String, String> params = null;
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            log.warn("支付宝异步支付获取输出流失败：" + e.getMessage());
            return;
        }
        try {
            params = tradeService.splitParam(requestParams);// 分割参数
        } catch (UnsupportedEncodingException e) {
            log.warn("alipay sign convert failed: " + e.getMessage());
            return ;
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        if (AlipayNotify.verify(params)){   //验证成功
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                Order verifiedAlipay = tradeService.verifiedAlipay(seller_id, out_trade_no, total_fee);
                if (verifiedAlipay == null) {
                    log.warn("参数验证失败");
                    return; // 跳转支付失败页
                }
                writer.print("success");    //请不要修改或删除
                return;
            } else {
                log.warn("没有完成订单");
                return;
            }
        } else {
            log.warn("支付宝异步支付验证失败");
            writer.print("fail");   //请不要修改或删除
        }
    }

    public String returnUrl() {
        Map<String, Object> requestParams = ActionContext.getContext().getParameters();
        Map<String, String> params = null;
        try {
            params = tradeService.splitParam(requestParams);
            if (params == null) {
                log.warn("签名验证失败-参数列表为空");
                return TRADEERROR;  // 跳转支付失败页
            }
        } catch (UnsupportedEncodingException e) {
            log.warn("alipay sign convert failed: " + e.getMessage());
        }
        if (AlipayNotify.verify(params)) {// 验证成功
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                Order verifiedAlipay = tradeService.verifiedAlipay(seller_id, out_trade_no, total_fee);
                if (verifiedAlipay == null) {
                    log.warn("参数验证失败");
                    return TRADEERROR;  // 跳转支付失败页
                }
                putSession(S_TRADE_FINISHED, verifiedAlipay);// 将支付详情放入session域中，到页面显示
            } else {
                log.warn("没有完成订单");
                return TRADEERROR;  // 跳转支付失败页
            }
        } else {// 验证失败
            log.warn("签名验证失败");
            return TRADEERROR;  // 跳转支付失败页
        }
        return TRADESUCCESS;
    }
*/

    //    @PostMapping("alipayClient")
    @GetMapping("alipayClient")
    public String alipayClient() {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091500515364",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPI/Mmj/o3UyR9iI3vRpPFLTMdT+XQfzzYG6T6eRWl/ZSvhePB0zSxvkfrAGwKQdq54DYIj61Crrgi9EJ4lJzxY6MIExxIYmNLEIYjpuOsdckqxgjZZmUcytFzSe2ZZJedntX9VU5faW3QRyJA5n9DyuPMPtmCXAU6fjHZ7SISbuNaNy4mKLUbCKm0hc9iHSDZ0WbXx2lkRhlL/NKeVp8K9qsYRDHGcPdl3t72UFo2/tkGJ9o8omBX0kQxDQsUCTvYDw0mpQP+R+HWrb3j4u9oJdsFIeuGZzvbm8n18Alo/sEmFkwS2Ft7hO0tr8HTtjxYXEZdoRAfYtLMuTooA3yhAgMBAAECggEAX7A1pMrNB10SYMT/tTwmHsMHj4nQ5N+aKhHY6QQ2/58UXX4Q8oqhiEzewO+oSfcaI/YJyRFbTt+EAwHsybT3cbscypIT7yOuowip032GZ8zZrTlzwvlbkLLY78w1BL0lSd5byR3U5Z2SJpDXCjHMU+J3BBvjxeyEJkUkSD3o8A6hXNfcqsB/2UMQrnjytxiqh0ijXtCQHvyq7ko5W8E9a0ad6DsEiRcVf2w9eMqLrAr5jHiBRj6GzkK6yTStXvJ8FtW1p7ik3ctcu7lD3s/lCFSuwTE0OaCwQaEeFejl1jbDi6hhLXkf/euB60nMIg30ZzxeMxo49cwDqr/9/2fgkQKBgQDsK9hqgET/T2a7w7U7IvsWvusLoKbqkthKW+vJK725Nfjf64+LgLTotULpkgO475JyluR0ad3woy+1KA8MYjWOvSxNVTyiwpZKE+UA+0DoAQ59sVfbTjbWL8wo2OZyHl2bSVVTw/9mPcgG1m6NBN9l/bBhKPqf2oBNR/fNFPMbdQKBgQCbKIsJKvOkKWxtv2T61Lx8RXqVuLI9J2cB2zp/PhMIdM4PDpKCMgKJHYeN77JRYt8TsO+DWdMCWw3qxOjNxWKaRq6rzV/GazFCdE2TW1CFmsVahfRBWE3iDiI+SqxwWer3rK/5Cg2CfZQjUpBwT5tqELzeFfbw6iaI3j9WrMKy/QKBgDLclnUJPtLFJNjXIxajR/P0FeahKJFoIpCRD0x50RgsGXcP4hAnHc7oCosG2Spg3eczu+ueSR/j5QhcojEGjYY6E2psKuzaf0dg1XbKpYXRhG9pXARs6b5i+NLrM2XsSDiDKI8rrLs2HvfqAlD4dawfYHbsPl1izzLVhvZxxpFpAoGBAJYPqCi9udZTmeKq8WcGySUHrX+QmhI7QYyyEulth8rt7Tzyww/YfktOnAPSh4vfLBFHVt6ayVHF7rfYqbAZ7zt2kQjoIHEuyv2SrlSORFpzTdw3IfzxAqJXORc18YDX9kCEa81Yw6go/FUNTVTSKWVzurawV5y5WXuWN3wEqmmhAoGAeHzxHtlmihqmqkViLQbpBoGJPzU5x7UfyzS9PdsjvE2WZghBPCI0EQS2REgQiRvrVmWIYIm26J3WEsYbfEDWndAMYOKN1nJTJCJT4qh34mm3lCaxFeNa6m6tnX7CIRqLxH1kdBr267UaM8Vfr653P7Qg3ALnvC1H84SOzQwFes4="
                , "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvbmibHAKUsRNJXKq9LmndvbWaBZXTEfKHTu8hE1/jZs5pQ25g4svLppho+sXikLXKhqzNFg5uXNrytzS1j5SOvCQrIODgi+iVBwAQTBye2qrboB/3FyvK2c6SLXT2XqgveVuNSJkEGIKOt4Omw3zKvoLBCQvvAajVkv54jhGZRHcPtCtbO5O+Ef8Jnazj8vpnby10RorBXSKiEw0CiLJcWBiaa5SBa+syt2rH+EPs7zDcltkio81C5tGzBUjkUGPfCnhxsbDRVg3XRxQQIVAi4uvbvejH9DpyjhQehPBq7s9NIwupaspclHLSoG4vUIyQxk0doBKe12AKBq89YWDkwIDAQAB"
                , "RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);
        model.setOutTradeNo(System.currentTimeMillis() + "");
        model.setTotalAmount("88.88");
        model.setSubject("Iphone6 16G");
        AlipayTradePrecreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.print(response.getBody());
        System.out.print(response.getQrCode());
        return response.getBody();
    }




    /**
     * Description： 支付宝网站支付
     * Author: 梁乐乐
     * Date: Created in 2018/5/20 11:07
     */
    @GetMapping("alipayTradeWapPay")
    public String alipayTradeWapPay(){
        AlipayOrderDto orderDto = new AlipayOrderDto();
        orderDto.setBody("苹果64G，标准版8p");
        orderDto.setOutTradNo("TEST" + DateUtils.date2string(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS));
        orderDto.setProductCode("MYWUWU_IPHONE_8P" + DateUtils.date2string(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS));
        orderDto.setSubject("苹果手机");
        orderDto.setTimeoutExpress("90m");
        orderDto.setTotalAmount("0.01");
        return alipayService.alipayTradeWapPay(orderDto);
    }
}

