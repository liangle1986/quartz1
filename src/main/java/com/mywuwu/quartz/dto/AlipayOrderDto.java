package com.mywuwu.quartz.dto;

/**
 * Package: com.mywuwu.quartz.dto
 * Description： TODO
 * Author: 梁乐乐
 * Date: Created in 2018/5/20 10:58
 * Company: clinbrain
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
public class AlipayOrderDto {

    // 商户订单号，商户网站订单系统中唯一订单号，必填
    private String outTradNo;

    // 订单名称，必填
    private String subject;

    // 付款金额，必填
    private String totalAmount;

    // 商品描述，可空
    private String body;
    // 超时时间 可空
    private String timeoutExpress;
    // 销售产品码 必填 QUICK_WAP_WAY
    private String productCode;

    /**
     * 获取订单号
     * @return 订单号
     */
    public String getOutTradNo() {
        return outTradNo;
    }

    /**
     * 设置订单号
     * @param outTradNo 订单号
     */
    public void setOutTradNo(String outTradNo) {
        this.outTradNo = outTradNo;
    }

    /**
     * 订单名称
     * @return 订单名称
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置订单名
     * @param subject 订单名
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 付款金额
     * @return 订单金额
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置订单金额
     * @param totalAmount 金额
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBody() {
        return body;
    }

    /**
     * 描述
     * @param body 商品描述
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 超时时间
     * @return 超时时间
     */
    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    /**
     * 超时时间
     * @param timeoutExpress 超时时间
     */
    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    /**
     * 销售产品码
     * @return 销售产品码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 销售产品码
     * @param productCode 销售产品码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
