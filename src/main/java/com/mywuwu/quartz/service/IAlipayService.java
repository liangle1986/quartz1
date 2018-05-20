package com.mywuwu.quartz.service;

import com.alipay.api.domain.AlipayTradeFastpayEteDidiPayModel;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.mywuwu.quartz.dto.AjaxResult;
import com.mywuwu.quartz.dto.AlipayOrderDto;

/**
 * Package: com.mywuwu.quartz.service
 * Description： 支付宝支付实现接口
 * Author: 梁乐乐
 * Date: Created in 2018/5/20 10:52
 * Company: clinbrain
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
public interface IAlipayService {

    /**
     * Description： 支付宝网站支付
     * @param orderDto 网站支付参数
     * Author: 梁乐乐
     * Date: Created in 2018/5/20 11:27
     */
    String alipayTradeWapPay(AlipayOrderDto orderDto);

    /**
     * Description： 支付宝退款
     * @param fasModel 退款对象
     * Author: 梁乐乐
     * Date: Created in 2018/5/20 20:18
     * @return com.mywuwu.quartz.dto.AjaxResult
     */
    AjaxResult alipayTradeFastpayRefundQuery(AlipayTradeFastpayEteDidiPayModel fasModel);

    /**
     * @param queryModel 退款订单查询对象
     * @return com.mywuwu.quartz.dto.AjaxResult
     * @Description： 退款订单查询
     * @Author: 梁乐乐
     * @Date: Created in 2018/5/20 20:49
     */
    AjaxResult alipayFundTransOrderQuery(AlipayTradeFastpayRefundQueryModel queryModel);
}
