package com.mywuwu.quartz.utils.alipayutil;


import com.mywuwu.quartz.pay.alipay.AlipayConfig;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Package: com.mywuwu.quartz.pay.alipay.util
 * Description： TODO
 * Author: 梁乐乐
 * Date: Created in 2018/5/20 10:37
 * Company: clinbrain
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
public class logFile {

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     * Description： TODO
     * Author: 梁乐乐
     * Date: Created in
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
