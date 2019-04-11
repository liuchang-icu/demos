package com.example.zhujie;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.io.IOException;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/11
 */
public class TXMSTest {
    public static void  main(String args[]){
        // 短信应用SDK AppID
        int appid = 1400091760; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "2c2e6a0a365b1b3595de6cd772de637c";

        // 需要发送短信的手机号码
        String[] phoneNumbers = {"17624402301", "12345678902", "12345678903"};

        // 短信模板ID，需要在短信应用中申请
        int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

        // 签名
        String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result;

        {
            try {
                result = ssender.send(0, "86", phoneNumbers[0],
                        "mecook提醒您，你的验证码是走回去吃饭吧？嗯哼？，请勿告知他人。", "", "");
                System.out.print(result);
            } catch (com.github.qcloudsms.httpclient.HTTPException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
