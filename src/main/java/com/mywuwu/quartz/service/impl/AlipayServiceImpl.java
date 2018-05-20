package com.mywuwu.quartz.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayEteDidiPayModel;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.mywuwu.quartz.dto.AjaxResult;
import com.mywuwu.quartz.dto.AlipayOrderDto;
import com.mywuwu.quartz.pay.alipay.AlipayConfig;
import com.mywuwu.quartz.service.IAlipayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @Package: com.mywuwu.quartz.service.impl
 * @Description： 支付宝支付实现类
 * @Author: 梁乐乐
 * @Date: Created in 2018/5/20 10:52
 * @Company: clinbrain
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
@Service
public class AlipayServiceImpl implements IAlipayService {

    /**
     * 日志记录
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(AlipayServiceImpl.class);


    /**
     * 支付宝网站支付
     *
     * @param orderDto 订单信息
     * @return 支付表单
     */
    @Override
    public String alipayTradeWapPay(AlipayOrderDto orderDto) {
        String form = "";
        try {
            // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
            //调用RSA签名方式
            AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);


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
            LOGGER.error("支付出错。", e);
        }
        return form;
    }

    /**
     * @param fasModel 退款对象
     * @return com.mywuwu.quartz.dto.AjaxResult
     * @Description： 支付宝退款
     * @Author: 梁乐乐
     * @Date: Created in 2018/5/20 20:42
     */
    @Override
    public AjaxResult alipayTradeFastpayRefundQuery(AlipayTradeFastpayEteDidiPayModel fasModel) {

        //返回对象
        AjaxResult result = new AjaxResult();

        try {
            //验证前面
            AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

            AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();

            request.setBizModel(fasModel);

            AlipayTradeFastpayRefundQueryResponse response = client.execute(request);

            if (response.isSuccess()) {
                result.setCode("0");
                result.setMessage("退款成功。本次退款：" + response.getRefundAmount());
            } else {
                result.setCode(response.getErrorCode());
                result.setMessage("退款失败。本次退款订单：" + response.getOutTradeNo() + ";退款金额：" + response.getRefundAmount());
            }
            result.setData(request);
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            result.setCode("1");
            result.setMessage("退款失败,系统出错。");
            LOGGER.error("退款出错。", e);
            return result;
        }

    }

    /**
     * @param queryModel 退款订单查询对象
     * @return com.mywuwu.quartz.dto.AjaxResult
     * @Description： 退款订单查询
     * @Author: 梁乐乐
     * @Date: Created in 2018/5/20 20:49
     */
    @Override
    public AjaxResult alipayFundTransOrderQuery(AlipayTradeFastpayRefundQueryModel queryModel) {
        //返回对象
        AjaxResult result = new AjaxResult();
        try {
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "app_id", "your private_key", "json", "GBK", "alipay_public_key", "RSA2");
            AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
            request.setBizModel(queryModel);
            AlipayFundTransOrderQueryResponse response = alipayClient.execute(request);
            /**
             * 转账单据状态。
             SUCCESS：成功（配合"单笔转账到银行账户接口"产品使用时, 同一笔单据多次查询有可能从成功变成退票状态）；
             FAIL：失败（具体失败原因请参见error_code以及fail_reason返回值）；
             INIT：等待处理；
             DEALING：处理中；
             REFUND：退票（仅配合"单笔转账到银行账户接口"产品使用时会涉及, 具体退票原因请参见fail_reason返回值）；
             UNKNOWN：状态未知。
             */
            if (response.isSuccess()) {
                if ("SUCCESS".equalsIgnoreCase(response.getStatus())) {
                    result.setCode("0");
                    result.setMessage("退款成功，预计到账时间：" + response.getArrivalTimeEnd() + ";具体到账时间已银行为准。");

                } else if ("FAIL".equalsIgnoreCase(response.getStatus())) {
                    result.setCode("-10000");
                    result.setMessage("退款失败，失败原因：" + response.getFailReason() + ";错误码：[" + response.getErrorCode() + "]");
                } else if ("INIT".equalsIgnoreCase(response.getStatus())) {
                    result.setCode("1");
                    result.setMessage("退款等待处理，请赖心等待。");
                } else if ("DEALING".equalsIgnoreCase(response.getStatus())) {
                    result.setCode("2");
                    result.setMessage("退款处理中，请赖心等待。");
                } else if ("REFUND".equalsIgnoreCase(response.getStatus())) {
                    result.setCode("3");
                    result.setMessage("订单被退票，原因：" + response.getFailReason());
                } else {
                    result.setCode("4");
                    result.setMessage("未知错误，请赖心等待系统处理。");
                }

                result.setData(response);
            } else {
                result.setCode("-10001");
                result.setMessage("系统调用错误，请联系管理员.");
            }
            return result;
        } catch (Exception e) {
            LOGGER.error("查询退款订单出错。", e);
            result.setCode("-10001");
            result.setMessage("系统调用错误，请联系管理员.");
            return result;
        }
    }
}
