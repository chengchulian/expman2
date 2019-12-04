package com.mzy.expman.utils;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpUpEntity;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @ClassName MyRequestBuilder
 * @Description Request创建者
 * @Author 程方园
 * @Date 2019/12/3 16:00
 * @Version 1.0
 */
public class MyRequestBuilder {
    private static final List<Request> HEIMAO_EXP_REQUEST_LIST = new ArrayList<>();

    static {
        Request request = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("cache-control", "no-cache")
                .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("accept-language", "zh-Hans-CN,zh-Hans;q=0.5")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("upgrade-insecure-requests", "1")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362")
                .addHeader("accept-encoding", "gzip, deflate, br")
                .addHeader("host", "www.t-cat.com.tw")
                .addHeader("content-length", "1132")
                .addHeader("connection", "Keep-Alive")
                .addHeader("cookie", "ASP.NET_SessionId=l5vbr5kqhmbk2unfigvmjb2y; citrix_ns_id=+rRnct545hDCJb/guAkqwpSEaks0001; __utma=8454064.1604718305.1572580467.1572580467.1572580467.1; __utmb=8454064.1.10.1572580467; __utmc=8454064; __utmz=8454064.1572580467.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1")
                .build();




        HEIMAO_EXP_REQUEST_LIST.add(request);
        HEIMAO_EXP_REQUEST_LIST.add(request);
    }


    public static List<ExpRequestEntity> getHeiMaoExpRequest(List<HeiMaoExpUpEntity> heiMaoExpUpEntityList) {
        List<ExpRequestEntity> expRequestEntityList = new ArrayList<>();
        int countTime = heiMaoExpUpEntityList.size() % 10 == 0 ? heiMaoExpUpEntityList.size() / 10 : heiMaoExpUpEntityList.size() / 10 + 1;

        for (int i = 0; i < countTime; i++) {
            List<String> expIdList = new ArrayList<>();
            //拼接请求内容
            StringBuilder content = new StringBuilder("__EVENTTARGET=ctl00%24ContentPlaceHolder1%24btnSend&__EVENTARGUMENT=&__VIEWSTATE=XG%2F1u8GVjOWuTJJkxGXSLA9aNQRyn%2BJshBDTY23N%2FPebdlBsdskX2TxwteY7MZX1nXzy63%2FMcaKqeZ6LTnvASsKOs0cy4wjWdaMrRFKpcUD%2F1WtFq51zg26hj7YOCrRn8NEc%2BA%3D%3D&__VIEWSTATEGENERATOR=9A093EFF&__EVENTVALIDATION=gN4menV2wyz48VfmSQ1L%2B77thZnGAKeV0Jza1cbKHcv9A9TaWnZWjcqyVs4VLb5asInbYW8uZMNAG%2F1XEgTABGSz8%2Ft5tuhkrHHzXZ8VtryoAnd5PvXu2eDkf2Jn6U4GzU5i7HrqBAfJlRtZZjSrVmfzZOVnqHZtUghAEcAK2FyldefLorbku9eN0HtdJHBzUfXqDcuObEbRF4EZWsGPdx4%2Fn25vM6luzV4oGljZjrdI1l%2FZz9Gg9fjB5aycgxd2LWk80ivNXBcDOnY4TRWl1qAWe%2BcIdzeC4FW5HmlH%2Bqc3L%2FxPB70zSt693H1e2BSWVzKF%2F1W9g94yAc3sAQ2N%2FT3rMAHWh65d0yHlUJoRPeo95hW2&q=%E7%AB%99%E5%85%A7%E6%90%9C%E5%B0%8B");
            for (int j = 0; j < 10; j++) {

                String expId = heiMaoExpUpEntityList.size() >= i * 10 + j + 1 ? heiMaoExpUpEntityList.get(i * 10 + j).getExpId() : "";
                content.append("&")
                        .append("ctl00%24ContentPlaceHolder1%24txtQuery")
                        .append(j + 1)
                        .append("=")
                        .append(expId);
                expIdList.add(expId);
            }
            Request tempRequest = HEIMAO_EXP_REQUEST_LIST.get(i % HEIMAO_EXP_REQUEST_LIST.size());

            Request request = new Request.Builder()
                    .url(tempRequest.url())
                    .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), content.toString()))
                    .addHeader("cookie", Objects.requireNonNull(tempRequest.header("cookie")))
                    .build();


            expRequestEntityList.add(new ExpRequestEntity(request, expIdList));
        }
        return expRequestEntityList;

    }


}
