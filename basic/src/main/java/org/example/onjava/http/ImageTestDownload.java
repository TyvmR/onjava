
package org.example.onjava.http;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.apache.tools.ant.taskdefs.condition.Http;

import java.io.*;
import java.net.HttpCookie;

public class ImageTestDownload {


    public static void main(String[] args) throws IOException {
//        main2(args);
//        md5();
        main1(args);
    }

    public static void main1(String[] args) throws IOException {


        for (int i = 1; i <= 107; i++) {
            HttpCookie[] cookies = new HttpCookie[]{
                    new HttpCookie("Hm_lvt_7fafaf8b8dc670c2109d0bbddc8be7e0","1661942154"),
                    new HttpCookie("Qs_lvt_323391","1661942152"),
                    new HttpCookie("Qs_pv_323391","3072482936268305000"),
                    new HttpCookie("sajssdk_2015_cross_new_user","1"),
                    new HttpCookie("sensorsdata2015jssdkcross","%7B%22distinct_id%22%3A%22182f378ba8a7df-0a17514282c6328-26021d51-3686400-182f378ba8be0f%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22182f378ba8a7df-0a17514282c6328-26021d51-3686400-182f378ba8be0f%22%7D"),
                    new HttpCookie("SL_G_WPT_TO","zh"),
                    new HttpCookie("SL_GWPT_Show_Hide_tmp","1"),
                    new HttpCookie("SL_wptGlobTipTmp","1"),
            };
            HttpRequest get = HttpUtil.createGet("https://book.yunzhan365.com/qoez/mdvy/files/mobile/"+i+".jpg?x-oss-process=image/resize,h_1185,w_666/format,webp&1635254303");
//            HttpRequest get = HttpUtil.createGet("https://book.yunzhan365.com/aweew/ygsn/files/thumb/"+i+".jpg?x-oss-process=image/format,webp&1661906692");

            HttpResponse execute = get.
                    header("Accept-Encoding", "gzip, deflate, br").
                    header("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8").
                    header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                    .header("Connection", "keep-alive")
                    .header("Origin", "https://book.yunzhan365.com")
                    .header("Referer", "https://book.yunzhan365.com/")
                    .header("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"")
                    .header("sec-ch-ua-mobile", "?0")
                    .header("sec-ch-ua-platform", "Windows")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "cross-site")
//                .header("Host", "p-wc-rdr.cn-beijing.log.aliyuncs.com")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
                    .cookie(cookies)
                    .execute();

            byte[] bytes = execute.bodyBytes();
//        System.out.println(new String(bytes));
            File targetFile = new File(i + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

            fileOutputStream.write(bytes);
        }

    }



    public static void main2(String[] args) throws IOException {


//        for (int i = 1; i <= 3; i++) {
            HttpCookie[] cookies = new HttpCookie[]{
                    new HttpCookie("Hm_lvt_7fafaf8b8dc670c2109d0bbddc8be7e0","1661942154"),
                    new HttpCookie("Qs_lvt_323391","1661942152"),
                    new HttpCookie("Qs_pv_323391","3072482936268305000"),
                    new HttpCookie("sajssdk_2015_cross_new_user","1"),
                    new HttpCookie("sensorsdata2015jssdkcross","%7B%22distinct_id%22%3A%22182f378ba8a7df-0a17514282c6328-26021d51-3686400-182f378ba8be0f%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%22182f378ba8a7df-0a17514282c6328-26021d51-3686400-182f378ba8be0f%22%7D"),
                    new HttpCookie("SL_G_WPT_TO","zh"),
                    new HttpCookie("SL_GWPT_Show_Hide_tmp","1"),
                    new HttpCookie("SL_wptGlobTipTmp","1"),
            };
            HttpRequest pre = HttpUtil.createGet("https://p-wc-rdr.cn-beijing.log.aliyuncs.com/logstores/yzw-logstore/track?APIVersion=0.6.0&client_id=F5842384B271C2BD3A694444&url=https%3A%2F%2Fbook.yunzhan365.com%2Faweew%2Fygsn%2Fmobile%2Findex.html&top_url=https%3A%2F%2Fbook.yunzhan365.com%2Faweew%2Fygsn%2Fmobile%2Findex.html&browser=Chrome&device=PC&system=Windows%2010&language=zh-cn&net_type=normal&embed=yunzhan&item_type=Book&team_id=0&user_id=aweew&item_id=ygsn&action_name=ClickButton&current_page=2&button_name=next&button_caption=%E4%B8%8B%E4%B8%80%E9%A1%B5");


            HttpResponse preExe = pre.
                    header("Accept-Encoding", "gzip, deflate, br").
                    header("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8").
                    header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                    .header("Connection", "keep-alive")
                    .header("Origin", "https://book.yunzhan365.com")
                    .header("Referer", "https://book.yunzhan365.com/")
                    .header("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"")
                    .header("sec-ch-ua-mobile", "?0")
                    .header("sec-ch-ua-platform", "Windows")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "cross-site")
//                .header("Host", "p-wc-rdr.cn-beijing.log.aliyuncs.com")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
//                    .cookie(cookies)
                    .execute();

        HttpRequest get = HttpUtil.createGet("https://book.yunzhan365.com/ppwj/qijb/files/large/"+ "64771a8f2e4276f55219ad0e3faa4140" +".jpg?x-oss-process=image/format,webp&1661906692");

        HttpResponse execute = get.
                header("Accept-Encoding", "gzip, deflate, br").
                header("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8").
                header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("Connection", "keep-alive")
                .header("Origin", "https://book.yunzhan365.com")
                .header("Referer", "https://book.yunzhan365.com/")
                .header("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
//                .header("Host", "p-wc-rdr.cn-beijing.log.aliyuncs.com")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
                .cookie(cookies)
                .execute();
        byte[] bytes = execute.bodyBytes();
        System.out.println(UUID.fastUUID().toString(true));
        System.out.println(new String(bytes));
            File targetFile = new File("test"+ ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

            fileOutputStream.write(bytes);
        }

//    }

    public static void md5(){
        String md5Str = SecureUtil.md5("15f");
        System.out.println(md5Str);
    }
}