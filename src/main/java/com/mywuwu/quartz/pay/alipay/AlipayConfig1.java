package com.mywuwu.quartz.pay.alipay;

/**
 * Package: com.mywuwu.quartz.pay.alipay
 * Description： 阿里支付的公共参数
 * Author: 梁乐乐
 * Date: Created in 2018/5/20 10:22
 * Company: clinbrain
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
public class AlipayConfig1 {

    // 商户appid 沙箱：2016091500515364   应用：2018051760144755
    public static String APPID = "2016091500515364";
    // 私钥 pkcs8格式的 沙箱：MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPI/Mmj/o3UyR9iI3vRpPFLTMdT+XQfzzYG6T6eRWl/ZSvhePB0zSxvkfrAGwKQdq54DYIj61Crrgi9EJ4lJzxY6MIExxIYmNLEIYjpuOsdckqxgjZZmUcytFzSe2ZZJedntX9VU5faW3QRyJA5n9DyuPMPtmCXAU6fjHZ7SISbuNaNy4mKLUbCKm0hc9iHSDZ0WbXx2lkRhlL/NKeVp8K9qsYRDHGcPdl3t72UFo2/tkGJ9o8omBX0kQxDQsUCTvYDw0mpQP+R+HWrb3j4u9oJdsFIeuGZzvbm8n18Alo/sEmFkwS2Ft7hO0tr8HTtjxYXEZdoRAfYtLMuTooA3yhAgMBAAECggEAX7A1pMrNB10SYMT/tTwmHsMHj4nQ5N+aKhHY6QQ2/58UXX4Q8oqhiEzewO+oSfcaI/YJyRFbTt+EAwHsybT3cbscypIT7yOuowip032GZ8zZrTlzwvlbkLLY78w1BL0lSd5byR3U5Z2SJpDXCjHMU+J3BBvjxeyEJkUkSD3o8A6hXNfcqsB/2UMQrnjytxiqh0ijXtCQHvyq7ko5W8E9a0ad6DsEiRcVf2w9eMqLrAr5jHiBRj6GzkK6yTStXvJ8FtW1p7ik3ctcu7lD3s/lCFSuwTE0OaCwQaEeFejl1jbDi6hhLXkf/euB60nMIg30ZzxeMxo49cwDqr/9/2fgkQKBgQDsK9hqgET/T2a7w7U7IvsWvusLoKbqkthKW+vJK725Nfjf64+LgLTotULpkgO475JyluR0ad3woy+1KA8MYjWOvSxNVTyiwpZKE+UA+0DoAQ59sVfbTjbWL8wo2OZyHl2bSVVTw/9mPcgG1m6NBN9l/bBhKPqf2oBNR/fNFPMbdQKBgQCbKIsJKvOkKWxtv2T61Lx8RXqVuLI9J2cB2zp/PhMIdM4PDpKCMgKJHYeN77JRYt8TsO+DWdMCWw3qxOjNxWKaRq6rzV/GazFCdE2TW1CFmsVahfRBWE3iDiI+SqxwWer3rK/5Cg2CfZQjUpBwT5tqELzeFfbw6iaI3j9WrMKy/QKBgDLclnUJPtLFJNjXIxajR/P0FeahKJFoIpCRD0x50RgsGXcP4hAnHc7oCosG2Spg3eczu+ueSR/j5QhcojEGjYY6E2psKuzaf0dg1XbKpYXRhG9pXARs6b5i+NLrM2XsSDiDKI8rrLs2HvfqAlD4dawfYHbsPl1izzLVhvZxxpFpAoGBAJYPqCi9udZTmeKq8WcGySUHrX+QmhI7QYyyEulth8rt7Tzyww/YfktOnAPSh4vfLBFHVt6ayVHF7rfYqbAZ7zt2kQjoIHEuyv2SrlSORFpzTdw3IfzxAqJXORc18YDX9kCEa81Yw6go/FUNTVTSKWVzurawV5y5WXuWN3wEqmmhAoGAeHzxHtlmihqmqkViLQbpBoGJPzU5x7UfyzS9PdsjvE2WZghBPCI0EQS2REgQiRvrVmWIYIm26J3WEsYbfEDWndAMYOKN1nJTJCJT4qh34mm3lCaxFeNa6m6tnX7CIRqLxH1kdBr267UaM8Vfr653P7Qg3ALnvC1H84SOzQwFes4=
    //   应用：MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAt85Vrmf4OWQxP+CECQvNS78khAgq+gfLNZZ1Kqe0vvAirKe7IhLh/+NDrRnCexztMkRkRa01EYZQPq50YVtjeRNsDFLKTNVKmxfu7vhlwI42MDGP5+fzqq58ByUdO23Ju00My4qiXGTyFE7QF1XHqzeUHy7g71OEoCDcrZg7mPRVOCx2Vge0k7NUW938zWqyb6gLZXInqZ7cjOjG793oCc0SrxldeIpqVDL5Kk3Iws5kC7ywm1/2YR9C+sde5tylcZ/F3PYLDRtVUU+PdtWXWcbmrWrd+7Qictn6uWhtZjCSnABTZzPR0/01lf5WW5c5GxP3Ww0q1lRhiERMnlb1AgMBAAECggEAb5vxA4Y4jJlm8PVMPfCCFT7KvGTnmCw4udD7ZxjXVfgBzG8c+TwwV1pDuxjLL0EE8f8WIkPwTgWmCspvBmaskXIYjyWYW+WHRCt68yiupbvzE7VyJC+XhkbHCLBBVDmFltgblS6gROwMc4N8Wx8AuCMUDBGF2nBqYKNgGzlCuNlKBFEEesJK0MEpe20nF/wqNFuA3lXdLDhdpdSP65VE9Jo/glTg1aVAAjjsN34SCh8xNUSrdU3B94QHPCr8uEpLBH3wX8V53OaxpLNSoo8vFIcB5kgyM71hlbjdMLBFAX58ASgwY6U2l/yA503Vu2RLE9iDW7rm2dVtWUMmjMy7OQKBgQDBYkbuuKIkv8DMzAS9PWfIOp5QePhvPuuoPfbV80+xHqkQ7kr5sm8CA02yrOXMZk4vhlTIvboSM6XE51hP4AY9Qcp05+82PYdhWX5jXnNpkA+Xpq3VIAV34PZU5ipGMM6OO+xuhyET5RV16S0yyUD45DfLKHy/FABn2rZ0d/tABwKBgQCqZVQBON2IUggvMfxsHF/G/ffmMP0jDBu0Hbc/1KyrWaGEG0oPx/xhPQ/TEg/cwPSZ31riyO7pffoTsSNeR62HvlxobJxx60VP1MCbvfdL1AOCLk1pKToxCI84bPMCsaJN3zHh84g4f6Dx3oCmGasStB/88762p839ZjE4GmU6IwKBgDhObyzO4ZclpfN7a93V5UPtnW786gkqHt+LuzUsdQWzUbK2T2pIw/2oDJV7tiU/nIBF8qXIaEcodpnQamxHZEmtwE8twP7gB20W66/vLleMNJ4JUBAAFNeEzvSFV8W8LEhJtluwSLdMOmVskVZ6NsrBWGV00m2oWz3h9sIOtT89AoGBAIAiBlOM8XnLRgBHdGvPwm4fGMVu3Uv3lPWSyvQi910632w6IS1Q04ZDppywHmGAb+8tuGiFdLL8WotoTxJckC9dhJu54MMBinOHpvb2mPnainDgZLHJoMqyhxCFTRAfh89LIXWp7iuePebjzJYbAzvjW5KZsDYmZY5BxI1NvAVFAoGAYxL0OVSPCoo/lz0o68uXO8iNyJZNRYR50n65QrZ7Uw1orWGyjmSwetLyw58inUwOnBsp42eqb7qwO7FJeoSPN3ULscQEclyrAw1ZWonnkQ9i0WSRAohVm5umtJ/tItNWXlQFYaPd2aevtvZTVMH2RZ0BKeX/Jdzh8CC/T35eAqc=
    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPI/Mmj/o3UyR9iI3vRpPFLTMdT+XQfzzYG6T6eRWl/ZSvhePB0zSxvkfrAGwKQdq54DYIj61Crrgi9EJ4lJzxY6MIExxIYmNLEIYjpuOsdckqxgjZZmUcytFzSe2ZZJedntX9VU5faW3QRyJA5n9DyuPMPtmCXAU6fjHZ7SISbuNaNy4mKLUbCKm0hc9iHSDZ0WbXx2lkRhlL/NKeVp8K9qsYRDHGcPdl3t72UFo2/tkGJ9o8omBX0kQxDQsUCTvYDw0mpQP+R+HWrb3j4u9oJdsFIeuGZzvbm8n18Alo/sEmFkwS2Ft7hO0tr8HTtjxYXEZdoRAfYtLMuTooA3yhAgMBAAECggEAX7A1pMrNB10SYMT/tTwmHsMHj4nQ5N+aKhHY6QQ2/58UXX4Q8oqhiEzewO+oSfcaI/YJyRFbTt+EAwHsybT3cbscypIT7yOuowip032GZ8zZrTlzwvlbkLLY78w1BL0lSd5byR3U5Z2SJpDXCjHMU+J3BBvjxeyEJkUkSD3o8A6hXNfcqsB/2UMQrnjytxiqh0ijXtCQHvyq7ko5W8E9a0ad6DsEiRcVf2w9eMqLrAr5jHiBRj6GzkK6yTStXvJ8FtW1p7ik3ctcu7lD3s/lCFSuwTE0OaCwQaEeFejl1jbDi6hhLXkf/euB60nMIg30ZzxeMxo49cwDqr/9/2fgkQKBgQDsK9hqgET/T2a7w7U7IvsWvusLoKbqkthKW+vJK725Nfjf64+LgLTotULpkgO475JyluR0ad3woy+1KA8MYjWOvSxNVTyiwpZKE+UA+0DoAQ59sVfbTjbWL8wo2OZyHl2bSVVTw/9mPcgG1m6NBN9l/bBhKPqf2oBNR/fNFPMbdQKBgQCbKIsJKvOkKWxtv2T61Lx8RXqVuLI9J2cB2zp/PhMIdM4PDpKCMgKJHYeN77JRYt8TsO+DWdMCWw3qxOjNxWKaRq6rzV/GazFCdE2TW1CFmsVahfRBWE3iDiI+SqxwWer3rK/5Cg2CfZQjUpBwT5tqELzeFfbw6iaI3j9WrMKy/QKBgDLclnUJPtLFJNjXIxajR/P0FeahKJFoIpCRD0x50RgsGXcP4hAnHc7oCosG2Spg3eczu+ueSR/j5QhcojEGjYY6E2psKuzaf0dg1XbKpYXRhG9pXARs6b5i+NLrM2XsSDiDKI8rrLs2HvfqAlD4dawfYHbsPl1izzLVhvZxxpFpAoGBAJYPqCi9udZTmeKq8WcGySUHrX+QmhI7QYyyEulth8rt7Tzyww/YfktOnAPSh4vfLBFHVt6ayVHF7rfYqbAZ7zt2kQjoIHEuyv2SrlSORFpzTdw3IfzxAqJXORc18YDX9kCEa81Yw6go/FUNTVTSKWVzurawV5y5WXuWN3wEqmmhAoGAeHzxHtlmihqmqkViLQbpBoGJPzU5x7UfyzS9PdsjvE2WZghBPCI0EQS2REgQiRvrVmWIYIm26J3WEsYbfEDWndAMYOKN1nJTJCJT4qh34mm3lCaxFeNa6m6tnX7CIRqLxH1kdBr267UaM8Vfr653P7Qg3ALnvC1H84SOzQwFes4=";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.ywuwu.com";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.ywuwu.com";
    // 请求网关地址 沙箱：https://openapi.alipaydev.com/gateway.do 网站支付:https://openapi.alipay.com/gateway.do
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥 沙箱：MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvbmibHAKUsRNJXKq9LmndvbWaBZXTEfKHTu8hE1/jZs5pQ25g4svLppho+sXikLXKhqzNFg5uXNrytzS1j5SOvCQrIODgi+iVBwAQTBye2qrboB/3FyvK2c6SLXT2XqgveVuNSJkEGIKOt4Omw3zKvoLBCQvvAajVkv54jhGZRHcPtCtbO5O+Ef8Jnazj8vpnby10RorBXSKiEw0CiLJcWBiaa5SBa+syt2rH+EPs7zDcltkio81C5tGzBUjkUGPfCnhxsbDRVg3XRxQQIVAi4uvbvejH9DpyjhQehPBq7s9NIwupaspclHLSoG4vUIyQxk0doBKe12AKBq89YWDkwIDAQAB
    //应用：MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApY1VVzeUKnF2LK7UjORLf6R32vdbamarfFFAosLVRZYHrvGVxuQIsQHbxTfegEKqV6C/mzVrW5Gc0SnU4Ke1bUtbtHlwenv2WKW/sPmSag5UNz3VjW8xGF0m014VdvW4xaliDz16ys1wvh3EPgTaKMszGF8np/RPqa9p11WYPsGgM9LDv8+wD5VwQVXXurUD193aOvepXF9QvpiRFLj7ZeIXSJDMLb6ShJ26zmrCpFJyC/ppmBlczgOI4l464cbCQYwrLSIvXwzqKKf31CnPRbfwzBS59ZRzpAKnrbgde5NNLTYB6hXl5PV450x6PomPQiUWPM13x7R2W8CiUj2v0wIDAQAB
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvbmibHAKUsRNJXKq9LmndvbWaBZXTEfKHTu8hE1/jZs5pQ25g4svLppho+sXikLXKhqzNFg5uXNrytzS1j5SOvCQrIODgi+iVBwAQTBye2qrboB/3FyvK2c6SLXT2XqgveVuNSJkEGIKOt4Omw3zKvoLBCQvvAajVkv54jhGZRHcPtCtbO5O+Ef8Jnazj8vpnby10RorBXSKiEw0CiLJcWBiaa5SBa+syt2rH+EPs7zDcltkio81C5tGzBUjkUGPfCnhxsbDRVg3XRxQQIVAi4uvbvejH9DpyjhQehPBq7s9NIwupaspclHLSoG4vUIyQxk0doBKe12AKBq89YWDkwIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
