package com.mywuwu.quartz.service;

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
}
