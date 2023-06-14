package com.leet.code.anso08leetcode.question;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;

/**
 * @Package: com.leet.code.anso08leetcode.question
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2023/2/21 11:28
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class BaiduOS {
    public static void main(String[] args) {
        String appid = "20230221001569655";
        String q = "苹果";
        String salt = "1435660288";
        String ye = "pyMsiyBn9SQNBZyvX2pD";
        byte[] sign = DigestUtil.md5(appid + q + salt + ye);
        for (byte s:sign) {
            System.out.print(s);
        }

    }
}
