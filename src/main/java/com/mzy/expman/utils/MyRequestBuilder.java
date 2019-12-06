package com.mzy.expman.utils;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpUpEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpUpEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeTwoClassCode;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeUpEntity;
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
    private static final List<Request> HEIMAO_ZIP_CODE_REQUEST_LIST = new ArrayList<>();

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

        Request request1 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "1126")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575450257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=8454064.382390498.1575450257.1575450257.1575453196.2; ASP.NET_SessionId=ezc1ikss02yvnizl255m0ost; citrix_ns_id=wJUAsd4wPqfReK/sJR+FUaC6nwo0000; __utmc=8454064; __utmt=1; __utmb=8454064.31.10.1575453196")
                .addHeader("cache-control", "no-cache")
                .build();
        Request request2 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "719")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575450257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ASP.NET_SessionId=3mnzvoxut3vvuc3kt10sw3lj; citrix_ns_id=ZpAy0Nv+o693hYeZdCMNLqUHQkI0002; __utma=8454064.382390498.1575450257.1575453196.1575510274.3; __utmc=8454064; __utmt=1; __utmb=8454064.1.10.1575510274")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "65053a00-cce7-4a47-9743-d5b990558d38")
                .build();

        Request request3 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "717")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575450257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ASP.NET_SessionId=jiil0kaub1byrgbuwpbifi2v; citrix_ns_id=mLwVJ71LrVbksT9+a34GJZvBgNE0002; __utma=8454064.382390498.1575450257.1575510274.1575515486.4; __utmc=8454064; __utmt=1; __utmb=8454064.2.10.1575515486")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "5f9a6e26-d1c8-465f-9e97-c56e95e81a57")
                .build();
        Request request4 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "719")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575450257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=8454064.382390498.1575450257.1575510274.1575515486.4; ASP.NET_SessionId=oaghusjzrewljbwuxeb2nru4; citrix_ns_id=S7TA5gXqrPZdpIbQMUuBJs4RVZM0002; __utmc=8454064; __utmt=1; __utmb=8454064.4.10.1575515486")
                .addHeader("cache-control", "no-cache")
                .build();
        Request request5 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Language", "zh-Hans-CN,zh-Hans;q=0.5")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18363")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Cookie", "ASP.NET_SessionId=cefxhhhjo3smlwkhj2fxzcmi; citrix_ns_id=ceMy7/6/KAq5y9wWIkP5j5Z09Yc0002; __utma=8454064.1128487829.1575518075.1575518075.1575518075.1; __utmb=8454064.2.10.1575518075; __utmc=8454064; __utmz=8454064.1575518075.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "acc60ab8-49e0-4b70-ae12-25c84d943a0e")
                .build();

        Request request6 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "725")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575450257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=8454064.382390498.1575450257.1575510274.1575515486.4; __utmt=1; ASP.NET_SessionId=y4or3u1fo2l0v5tbky1gs3no; citrix_ns_id=Dx6/eAHPu2C0k1uzJNSZtp8cess0000; __utmc=8454064; __utmb=8454064.7.10.1575515486")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "d4308d21-231b-4cdb-b0a4-57ec52c5e94a")
                .build();

        Request request7 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "721")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=yugdhlqnpc3rtbfc1taneqfy; citrix_ns_id=AqDVYvSrIgcU9i0sLJACLO/UEZg0002; __utma=8454064.915710372.1575518346.1575518346.1575518346.1; __utmc=8454064; __utmz=8454064.1575518346.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575518346")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "18c79ac2-cdd1-483b-b640-78f9e9aa0ac7")
                .build();

        Request request8 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "717")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=kwqquhiuwmmfgqyq2vv5ngpn; citrix_ns_id=PAXRDbwDFgf+LbdGqb8lw/fNM/k0002; __utma=8454064.1835477032.1575518403.1575518403.1575518403.1; __utmc=8454064; __utmz=8454064.1575518403.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575518403")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "5b6b1aa9-9e6c-486a-b3ff-58587409d197")
                .build();


        Request request9 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "723")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/trace.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=1nj5gcfzwwfab5wsq5t1nlex; citrix_ns_id=U4L9ppOLiHQj/OleU0MkXXAkmP00000; __utma=8454064.1077422594.1575518454.1575518454.1575518454.1; __utmc=8454064; __utmz=8454064.1575518454.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575518454")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "90ae5965-4791-4709-b80c-fb4ea47c1bc1")
                .build();
        HEIMAO_EXP_REQUEST_LIST.add(request);
        HEIMAO_EXP_REQUEST_LIST.add(request1);
        HEIMAO_EXP_REQUEST_LIST.add(request2);
        HEIMAO_EXP_REQUEST_LIST.add(request3);
        HEIMAO_EXP_REQUEST_LIST.add(request4);
        HEIMAO_EXP_REQUEST_LIST.add(request5);
        HEIMAO_EXP_REQUEST_LIST.add(request6);
        HEIMAO_EXP_REQUEST_LIST.add(request7);
        HEIMAO_EXP_REQUEST_LIST.add(request8);
        HEIMAO_EXP_REQUEST_LIST.add(request9);
    }

    static {
        Request request = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("host", "www.t-cat.com.tw")
                .addHeader("connection", "keep-alive")
                .addHeader("content-length", "11557")
                .addHeader("origin", "https://www.t-cat.com.tw")
                .addHeader("x-requested-with", "XMLHttpRequest")
                .addHeader("cache-control", "no-cache")
                .addHeader("x-microsoftajax", "Delta=true")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("accept", "*/*")
                .addHeader("referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("accept-encoding", "gzip, deflate, br")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("cookie", "__utmz=8454064.1572921542.8.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; ASP.NET_SessionId=vlla5gzawmfgzzrdfu5xirvo; __utmc=8454064; citrix_ns_id=iP4x3FCOSTMxaKCzLj8IH0SdapU0002; __utma=8454064.1157522952.1572517015.1572934865.1572938238.10; __utmt=1; __utmb=8454064.8.10.1572938238")
                .addHeader("postman-token", "bd0ef5b1-7e2d-fe0a-5c5f-27356d373db3")
                .build();

        Request request1 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "12102")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__utmz=8454064.1575518454.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ASP.NET_SessionId=wnzf0f3fai2i5bu3tdwiquhb; citrix_ns_id=rKQvXO6C4u4Z571kJLfARmhyUtg0000; __utma=8454064.1077422594.1575518454.1575532334.1575613328.4; __utmc=8454064; __utmt=1; __utmb=8454064.1.10.1575613328")
                .addHeader("cache-control", "no-cache")
                .build();

        Request request2 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "12096")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=pneln4o5gup1rpzr0kmomybq; citrix_ns_id=tojgpIbZPayixlo3OryozhZMPj40000; __utma=8454064.684167330.1575613511.1575613511.1575613511.1; __utmc=8454064; __utmz=8454064.1575613511.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575613511")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "2f9bb1ac-bd5e-4873-93be-ab3ef82e0a08")
                .build();

        Request request3 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "11373")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=onp4f5rfbiiy03kegqbeg5g2; citrix_ns_id=Ba35x2wlvtbRUJSmGmOqCOWGMB00001; __utma=8454064.1529135151.1575613617.1575613617.1575613617.1; __utmc=8454064; __utmz=8454064.1575613617.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.2.10.1575613617")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "8239ed9b-4cf6-42c4-a6a7-92d568cb896a")
                .build();

        Request request4 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "11001")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=ios2tzuowih3s1cjbj1ygp4m; citrix_ns_id=ZnY7DrESN4pl0s+91ar0vv0GO1Y0001; __utma=8454064.392014429.1575613707.1575613707.1575613707.1; __utmc=8454064; __utmz=8454064.1575613707.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.2.10.1575613707")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "99055916-4414-400e-85e7-86b36ffa4320")
                .build();

        Request request5 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "10707")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=sl2agyrm42hhpe5qq3y15bo1; citrix_ns_id=ptSdLoBw0st+NXxlNTlQVpnUxvk0001; __utma=8454064.1677783125.1575613782.1575613782.1575613782.1; __utmc=8454064; __utmz=8454064.1575613782.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575613782")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "d0f87dd8-5fcf-450a-842b-3698a0b67ef8")
                .build();


        Request request6 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "11170")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=5hxnvz0hjbt3tabrlutkpvbf; citrix_ns_id=jQ2euuWo4kN9Ml6GCP3YXMCj+kg0001; __utma=8454064.449525414.1575613887.1575613887.1575613887.1; __utmc=8454064; __utmz=8454064.1575613887.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575613887")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "e9ba52be-b0b4-4fb9-806d-6b986c06ce0c")
                .build();

        Request request7 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "10872")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=2azqqgfxuutoalgypwylxlv3; citrix_ns_id=xfBxctIY+c5rWDXyu8Y4KRI/jHE0001; __utma=8454064.2137191523.1575614334.1575614334.1575614334.1; __utmc=8454064; __utmz=8454064.1575614334.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575614334")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "34addcc8-9405-4d5d-bd11-5189b0100d8f")
                .build();

        Request request8 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "10954")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=5zngtfnf2jr4bwqmhsackcum; citrix_ns_id=b86pyh61M5YwwzlxTwrjklBJSkE0002; __utma=8454064.1432171877.1575614483.1575614483.1575614483.1; __utmc=8454064; __utmz=8454064.1575614483.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575614483")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "bace80c7-57cf-4623-bef9-bf2cd5550fe5")
                .build();

        Request request9 = new Request.Builder()
                .url("https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Host", "www.t-cat.com.tw")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Length", "11363")
                .addHeader("Origin", "https://www.t-cat.com.tw")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("X-MicrosoftAjax", "Delta=true")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.t-cat.com.tw/Inquire/Office.aspx")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "ASP.NET_SessionId=fdf3uaaay1p3tf2dzknhead1; citrix_ns_id=2i3m8wISBVriq3GbmXiMbjhHvI40002; __utma=8454064.1728106273.1575614552.1575614552.1575614552.1; __utmc=8454064; __utmz=8454064.1575614552.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=8454064.1.10.1575614552")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "99a030d3-8e56-4d1a-bd47-5bcf479ad11c")
                .build();




        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request1);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request2);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request3);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request4);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request5);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request6);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request7);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request8);
        HEIMAO_ZIP_CODE_REQUEST_LIST.add(request9);
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


    public static List<ExpRequestEntity> getHeiMaoZipCodeRequest(List<HeiMaoZipCodeUpEntity> heiMaoZipCodeUpEntityList) {

        String requestBodyHead = "ctl00%24ContentPlaceHolder1%24ToolkitScriptManager1=ctl00%24ContentPlaceHolder1%24ToolkitScriptManager1%7Cctl00%24ContentPlaceHolder1%24btnQuery" +
                "&ContentPlaceHolder1_ToolkitScriptManager1_HiddenField=" +
                "&q=%E7%AB%99%E5%85%A7%E6%90%9C%E5%B0%8B" +
                "&ctl00%24ContentPlaceHolder1%24PostCode%24ddlCounty=";
        String requestBodyEnd = "&__EVENTTARGET=ctl00%24ContentPlaceHolder1%24btnQuery" +
                "&__EVENTARGUMENT=" +
                "&__LASTFOCUS=" +
                "&__VIEWSTATE=CUotEfzz0e2EYh8lFgKvH8wJ%2BhPwauvE5NYyuY1fcolbl8az%2BSlQE%2BZcOn354HlpIneDkQNi5S5u0D2ErhPLFOV77DWy6IHe2FUQbXOAhNdoS9sRAckarcc5%2FogD3z%2Fwx9g7wgdSooRbKF66HYloVRkWJpkq%2BEWcpKILGyEZzWDBO8EjwFr0faunLly9QO%2FGbJO%2FWj6V14eF55OhJC9U4LgO%2FFCZngBJBQ2SXx9MRFCIVnCH5LbsWY2DGYqqyDFgiGtHDBMmNdQyq56pVcbpX%2B%2BPxORIXGnaMPFa6LwSeIBqGsVqrCc1T%2BXYsvJ5NqBLDorp%2BRskjxwMtMsPBRafbI2Vd9CSJdqfViRWOcpPMjuT11iwOnwTmNhslTX8XKjOlVo3sz4HOt6u5Gw5ycPUHdtmyTKyo%2FQuL3fdaxk5ZzNTxiQfHVJ5gqxGRqkgnmuYoTK480dk2qhyvw3HskjP%2FRjG81VqotLMc6CIpp5c1fZNntnfS0%2FewVWULBzaNGmxO%2BE7cYKUxz293v%2BIYihjkKx9iBeTjqLIdU%2BtlTGLe4JTTKLr6IXJzNZmWgQrf9GHimpyIWOVo6T94rSQ1wbtcYAhlrZA3L%2B%2FpmvP0iG8RJcaQ%2FGJz7%2BsR%2BYbjJ%2BbGyJ8NWNXGy2iMRwUTS0z7xR1%2B5yr7EiWm9CjMk7zbdUMgTXoRsKo%2BFAuVGYK3JmhEHg54s137t8%2F3qAaJWvUqKeO6huxfmebC24RXdBCan15OJtek8TClC1oEjkIHdcYbN3IuJ0iPIFOVWrn6CorHxs524XbNHClNLz0VrP0VCZT0GgAZ0CYwFAOXTaAbYr%2Bawujgjjm7Q%2FWhhavsfknFW7bnRXoc2LbfK4%2FfkY5IwwJdlyBNVFxaTpcz8Jy8b0yr6TaqLmOAEw6IIIhcqgJQSlveG2JpUD93uhhjclrN0uaSaIhn4%2FaGkFc%2FsFfqNxpJwC0G5QdUg42X31l3UGRXuiiKt1sgAu2AJiM6oPLOZ082eM%2BYS3NCx5WbMiR%2B%2FyFOSPT2x83JvhqGMBLcsVUYONB6VeK82jwCukMm9VBQeF47vyZWS2B42hvnRx7ZOOLvMFqHDX6AMqTDRckEWYYMHLOZPMzU%2BlYwdRIGlSoJfK%2BubzqTBFaCFG5t%2FalJp1NaL9q2UdZFc%2BvNp8yeqWlqPGeCuvFB5AGIrAaONzTcArkr4y%2FWEcEUKOBuYTxtovMJktenoQmpV8ilUt1jKllmy1P0jsC%2FA8meeUL9guD2chpGBRuhvozIJmmOaAd3OFKPkMyiIioXDuvMx52ygSZkN5XvK0y%2F6vuezMz5s%2BBeRtOhSYtmF%2Fd7k0dI7YvfDE2odDl5yMFgtQuRj6CdjbZXg8eJh3nLdBKpsCurtHyi79Af1c0ARzqY17IpHFQbZDdytbvODcxP2yd3eL1KvC%2FG4NVnpX4OYSsB7rtM9k9xgFIErYDT79tQ9TyWejvjZSAVDRNKwf7L%2B0lBOPD9O%2BDihLSoU7rknHFpjzMc3DXPppSstUj5F0AbQK3aEEHfESiA4vaoi%2FqJvy0urAPay91nfZtZGV7XqTqiSR66vMbL28pzUVgvpjjfQlAFehXL%2Ba7OABk1VBcqw%3D%3D" +
                "&__VIEWSTATEGENERATOR=6EB3E046" +
                "&__EVENTVALIDATION=QlvdIQgClAgVwCnC2bX3gBL3Ve2UYx74sfjt%2BS8pktubNiCwrKK35aw0pagwnfk1PebwzbTeO1u8M8g5UjPOY7xQl9P5Dp4q%2FvpWM3APdJmzbxgq6dm%2BHq%2FW0R5nTgn9kI7d2lHPdi50mcHBS6jqZOpkBhC4TgIpBR8TDPaX%2B45InDpjHc1TsjH2%2Fs%2Ba7GZCGihs2xka28h27EvAqZZB03dvUIsuSKgMbO2e8jDFeTA4uj20IxiKCj%2BLHbJmm7Bk4kk5EgNA5TJgLYwoeSr0ySGdlrXOseNJJEN1YKGoUJLWU5AkKtAGtBtVUn90J87iPW6HkcG2SZbQTN4xm6YBzdZhS%2BAJgmbyiQEEs47g4CX%2BxkfjpFzFwvC98SsN9zMcnS5JhiAODtI%2BY80rJnTFi1u2NOkt2NH%2F4KDMEP6ya4%2BfgOw5bY%2FTEkWR1UztP3YFShpwBy18Gib0HLJbEuQJ1d1lb7HU2Mp6SoxrvGfeJ5FRyGqdYL25LAvqm68XrUpkO%2FRxtdfl3qDGwHfgoHEf0s1bUOT%2B6OSylEgMV0ip2jx1MecyXqyKKVxOVfrC7LgFS60AXTFFEzgnJwVMygP2Sexj7k7xJrOOE6Mw5bNBd00n2vruAXi6wPUS0iebkSeUH9%2FWXpqL4TD1nhwiA0EWeKbY17ojJUXlPuvWQ%2FLOowZgZACQsQFa0W%2BDAKKHRhZAkO3MztCxPQgPADi5Ezn0JlG%2Btum443CPq7iDdeObIz6sz7rKhEuNpoaDnw%2FHHvAT5MgkX3wLBw8GiBBcUkbOyUX5zS7I2CWHYs0PVvXoyVeip7GBv2y5dRnWqLA%2FnK1pcxtgIc2fw0ZChjawtG4mWwMRvmbwwApy4%2F10V%2F2S5DQisvxqbC%2F%2FHntojMBx%2F%2FhGVnoqg0F2Ufkp7z99TCQT5%2Fb4uWdnJ8TT2xi2Er%2Bn8BD7JP5GwOnQ3ttj7qsrPUzt38qKckTV4%2FfQ36Tsayz9mnzzZLCWj3gMm2meNkj0F9sPNnjNpQND46bgpl%2BBDLcKw%2FHrkIxsaJBVLtMLvQUYSRcx%2BDUl1qkVtwtm6iXFgvuNXIza2Fg3VHYjjgwVivu5vvzQG7u7QDmojgT98Udw7PWdvrFAVpN0Stj8aqa1wZZ0CGdpQnPRrZeVJjebUmkEn4d%2FTIyu9EK6nuTCwaU9iQ611KlgXH84x6T9pBbqjtBbWFF38mBvPthn%2F2ZI995VO0hE1NQjv24mRB5ZJX8pkroky0HLeNq3T5W38rG7WMYWLR9SKGg9JI2RoJt1x%2BAxCypHERPvYXqpDmOQnxmP0P6U61TYo9VvUZQfDYXQ6zoYFLYECX1G2zSrAO5bj7LPHMqdVM6q8TcE7IV0KXpTV4DC6T%2FIaaCBjOLIBLnVGAybmbtTs2L2%2BZuajd92dpMvzMe%2FTerFhte%2FKYowJZaU1qVrr%2BC%2BurkW7NBIJMvFqQDMNWng19%2B6fBGUCbGvBsrUhW8v%2FA9L7UWZl%2BVbG1lwuapastvu%2BesWhyzpz1gLqDhbpy30%2FFCcGawnXpxAR7iLtYXmDbSDFkxRWdkjFPA56SNPoudekVbB897z5l5HE0vqub%2BqdiuxgoFJBNzyZltcrHBfOgpfQXQ9rIe1V%2FbzSAJPJjXZIvKeaEeG0SCNXaWzeXf2laPPvGS8t5KHwEeAXeh8ltwolvbyaHFG%2BCa0xBliSonLrzQLMICdr5VqUHDy6ZaXgbK7JS1t%2F5n%2F0g5Z%2Ft6fjPB%2BTC%2BoHd69I6T4h6neCcR2Zbx4%2F0KYANpxaJBfHIAbzorpUlgEr5RRnyqdkY8Q7wniIpAqGW11QZ%2F%2FI8Aofl1UnI1r6h49vmcEddSZKU5zuXaKlNDQtyrSPkpx18eGDOVAisebYzoJxU6NiaDojCTmtkNxO2aApTWZcF2T7%2Bn2cyGUMnck6F%2B5aU8APNA0ewlThuKnW9EcIl%2B5tPA9IcSiBfZlOZf8%2BARS%2F3NPU9HEMwWek1erbKEInXsgOshl0gIS7i2bRKpk9d09ckaPzUpPrqorgZjU7n59KAimSudcmuAqZ4MCiTdbP04dwD13EKq4XeqPfKBx%2FLnJ6UKAgjO87hmlDKsPfZCDkKOchbt09A%2FhIN7sl3RjcxuT9hm0ag9H8Xh5SV3k4WiBumQQQhvVvNlNSEMrPDHKH5JejK1MK0Xl8C9g1tz4fKWh%2FRAffqs2MuXJR%2FcIoYKG95TQdDrcz7OpotwpgKc%2FEmafJ5ua6n7SyacHAjIDwneimCrfxriZ1np9%2BIq3byEasuXYw0IhBTa%2F3kqllLAnoGQmb5uL2YALwjygec95wHdmM%2BGBew9NwKSUhtQgpirUpwULRwcTrpXFl8fDDZIjF%2Fzo1jnituWG5JY7beo7Uu%2FoVVulbr%2F3L%2FP1O4Uwig3sdydW94rVdoKHTNgaSaDteELG7C7HOmqkxKlRNzKyRZUldQHRC%2FJH6iwHU%2F2dfmH32zMi%2F6lCi47RqUB5MwdFE96aJVKSzSdTwndVH1q8FQ%2BBcRlHTppMy3jqbDuAChs4HMI1Oa0%2FM0Ad20PCL5daqKeQGRLxNbCrH0ddi1MzTPK8mcE0%2F2rB6%2FMs6WcKT83D%2B8T8%2BfgiqpxPIVziQN9Cbm7F2xME%2BLcrPSlMGbK7LICjdFk3v28nMaTTLixD6yQdqlzNLljYikqpos7mjCsp3UB8TnosWv%2FLjKkfwCfOk%2Fb%2FxPyrM4%2BrI6sfCv5ckOlCaBOHK54Y1WNbZ3m5nf5xH%2Bh6MmTvs3vESH%2FRBNwfbT8LV3dieofmGkaBWxZf0JvgFm4T35iXTMSNnJuPbkoam3FvREAgsuisEKuvhRzsYubzi5W2Ha54%2BVvicm8NJawvtJDLUReJa65B9MMie0OfxWk95GEr60tvsOg3JSbFZWPdJ9a5wE0OpyYQr4RpW7O7cMUSJKYYxFAAy1sV1p3I54101%2BFDEEZXUdKU10xfYb1ID0wIgnbVLUb%2FiJ9wOQ%2FfP%2BjCRpRmViPmH3qJc8tONsk%2BJMtUUHEJZHFNR3MsA%2FpHBaH69i2SgfK1uyCAsvwCVapBS8u8PzosgAAlQXLUzYkocDaiC0Qie1hHjs5%2FB0XXvdS40aLupCkDrj3exy4KRN9FdC9EP81EDdC7dxd%2BEWhBsLkiAXe7tqP45%2Ftp6%2Fy%2BD2cXjaH6denxPm1ZWpxI%2FuYSlHPgDc%2BJFMgdoTOOPYb9w9RzxtEw2ljmb79Ej%2FnYdeEkdMwZv0NPTDtFm3iru9cND7JVrUApAQJ2KsSEuSmHBRqkx2I1vXxYGpDqaEKlXBQwyBjWVllVCTYpkVcUFiCn4wMHE3b1hh8BKXa0vFq7iuRr5izWKcM0%2Bt%2FbtuxNUc%2FsXnmK3vYejW%2BJ633HYxLCwDjbxz03KyLZx7BwnWgUSd187PgoAx3O4%2FSCJp7YsVu4KX2s3i2AoLwM6retUe2tUrA0dh2fx2tni4eHduNUQUbhmfa8Wi6BVm2i9b53z3m3I1KaO3O9poUTQrNMt4VLnZzSxBJf4yiMUOQ1mPsEvkQIzLRlGboYzM8BHh68tZgIkiYYvWr5TcnEJtmLesNT59JG7wR9qipLyVJWMaeg5kB1KzL8vzxpAPoJFnsQPX1coBrfiXkTR9RNyPCojzFR%2BgDuaA%2BKCzXBF4HDptTjAZPTYNjoDatsTYXaWdARJmAUVu2tKGNO4kXkD3JAE%2BQ40Ptm38wH%2BZWKvyCi128TUqU2rDtb4C2UB4rkXKp634mA6RaAgsSkfnXm%2BqTAyBVUvybWkpYKn6ILYpAcgnEU0cNWqnfXM9qVzGToRlZR5nU6SUWxUQQnttH6pAAhqYDMS%2FR84huRqCMSsXckALMLA0Q4cjLSQlTFjPOcBq2YRyTX%2B6A9Xi1ugXweAknQ8YPRIC6%2FrHofdwptcY0uLcRagrP1KGeqjZ6v58%2BYpCKugctWAhqbJWfnpvf44KRrs3iaEf85SGERYlfdFuPqfStQubjKORY176817ULUV7qJyx2JifqEa2kS4BG5rcWNJZbRlAyVsscCpDz7U4VJG%2Fl7U06ilutq7jwgz%2F9wpd4InQlmDCmRIOEGdCuUF3WVrVJiQxV3Hs6G0mFEVG21eQde%2BlatMEiPfmWogsQp2CmyV4Talf9pqc43I25IOezzX7u7VaBQW1QQWfM%2FY%2FXqI%2BUbidfTok8EE9%2FHIdW7hn6KVfjkOpiZAPciRg3PPIr%2Brc84E%2BFihB8cD46phbHCdUXLWhRwFTqwwxL6i%2FMGvLvrupz6lt7DgbBQdrEbRip8g1zAPzSLx6c7kZAwVtWb4tjvtImmh1x9oMFw4zvf%2FNK5d6ygSYKfrOfkybrlNnDtOLyy%2BBeGRQfMKS6eb9JHiniH41atXbu86xISatg2J38kEmPrk3N6a%2Brb%2BfJWpwxsdy4lYaLnbMMRmPV3yvgmkdH1g%2FpiYYdLUfUvxwirvn3gGqEdrDGz%2FJQuVZl1gWh247C999KcNM%2FwEEAvAoURzkQBEsqQ2hzgJRZoibOg6mf0GlEpb2PEtpMEVgJV8Qxz1J6t9RWuUSy9RmUUu7%2BNmjV%2BW41UZOdhzbwBkmd1ifEze6bKIQuvs96a3zAIR3TI9yiSYdnlrTuDR65ZDyQs4TzXIbvYaqL8GudVdYHJJRFpsXXcGcrrAfyIYiRwAX8ifnSa234ztF0ephNIhDIoN86JP%2FIiqaU4paTrYiSUmd9%2Bvc%2B0LFQYnQFexHmRkVuGPsB6UgKxLKE1n7cR7wv15FP%2FM7hMOtm7UbhIYTLkA6ZCAjDQV48%2FIzKhbqbhioRpoYy42yQA79A%2BeJwGWEWD8PglF6%2B74eRR7IXMop2MZYC9HCsrtYSqoNR3G1vi99GnF0WU5hcnKasi1htfXZJxcdNJghl3EUQU2ifYFNcNJaHMRz2muj%2FW4YmbnICFqaNsQqtdYKL%2FWd6fPF4Y34RIKipweFhbHyvoz1MGmnkkk6%2FL7Vu8KHL%2FaMMYNqpllQmZ8bmsnZBZxC4NUORvVWIwQJK%2BqVYL8D22jwaC2%2FhYF8sXcqK7WqpeMyRBARXO%2BXeR%2B9%2FANcHnNoyt6TlQXSCTJVgJB4jKZQaiFAOLlwYhdYjmzSZlc1qJDRr3g8ILWvS8KHo9PjCdJM8Yc8AoDqBoy6Oxbf2fO7H9o00GQI0zqlfNwuyC82zbLRj9nwzWgbqKcLCYiAAbH5Vaz95IZS846dBnT9mknGShGLljAQfDnCUtL9nYQtxY%2Bul2N3eOBSNMw4APhKvXEzljLoZ38uIu7iKeVEPjji%2FVTfiQYdOZG0zkwEjZQlYzKrIh%2BVfOxPak%2FQXoxNHYpCF6jn%2F1xrChk5d3XGTGgU3RGsz%2FdlKAREm5XeWu0U86Qm54w8j4q5cmIKHrpG0Hjhu7%2BYbrRAuJvOSeO4%2BmC3LQYPHagX2CWmODiaPJcNZeY5x2qrwnEKC0Y4IRTpiBomv20Aa7Z5YdzwSx7Du%2B5R%2B6mkLu5M88XIV0Df3nGJCiJ51AMkIZsIL3OMcUWXR6Ynk7SDfc4R8shCM%2B49jA6ULidbFkY%2FQABatiad3yKq2Ht2nQX07LEHjDzPGLvaMikRfR%2BMJ6rYiXn6ok2Ecla7Mq%2B6IdaFpI5ZNZdhns1BiskxrGCCmheHcs2Oqwi%2FN3gOOedbBD1rKyZEmRsAaKtP6Hrxm5Bq1wTOvi%2BFnD6sb5s%2Bzl6a2qd2KU%2B4fhhE15ue%2FSoZB%2B%2BvSKtEVGTXpV7tZImgfal31beKjpQAEgV7kFOPhTU6yOmd5%2FyPjeVx4krzAHTVajQh2ou%2FK1DnaifzbmevLDu1AkBOTmvxpk6WODQZfqQqr1Vg9yRKfGy1ttmESGas2fwtg91udcw7hPuT0oU63ns5X0%2B%2BvHOGhWBU9IZ5AzVjww4joMhLUJA7hrBU4%2FahuxNOtdCA%2BC%2FkQXZTp3Hw3zCFtDEeWv9jdV1CrKmKddZ6Ptb91Aj%2FEh5oWkszC3GtdL1gRtyogWezm2KuFR3g9UTklweGxN3YGBzQNlzH4baGtNcxcfGzcRSs22nLvZLUCQihAbkxHjvfdOgILVT0QKln4rvmklvxnT%2F88gb2aJ%2BDFl6pnGrk%2BKyvPCqV%2FcPNc9jJ7sL9rVPr46FBeVQW29cOWdp0U%2Bt4AKr4qQqvTcTgnK0np3whpL7ltTo5lssTKRB3DQtfBf5Y4KVDNeEIK0jvECTbzTBNS6OCJwfQdpJEz7mVBWGkQPPM7qbheBuvQR6xx3gcVbHPinqub8NVj5Lf4O5hCWUK2M8cYaGdzAmT5IJczcQIUAMYp80GkNXgncaqPnG0CdyU4E4J3o9R6az1gzFSsjwyv%2B96Tk7vT5PeWwFGlOqFrjxs7Z70OKmHVj6OcHb%2FE32slCbCsYlTMPovYwA5pDFqD2QhRbsbO5GmdH45w3mhsqanVJkKD952K2T8At7kGew%2FSnNPN5PDSage9PfzhaoMW4%2FrrS1wGT5usN9nNls3cpg1MSpjASEAyVFrbHC6jSnzsxW%2BxHnOBmZn3Xr4MSMCbEULtQvS2i0KlljShFGzrsu4audfsqzuRZx2tJbpw1z%2FcAZcuTpq5rc%2FF3rd%2FPvIuq%2Fw1CwxbAyy5m5QH0ejD%2Fp9aSLvm12NZidTaTvFOl0ngeU6xjVrn%2F2ew0x1Vl2uMOlQpsKV1QFXCpAOCthldSIvHZMEj%2F8zDSG83sN0JSreyIFgzt%2FRLk4aN%2FfH%2BZjKYxnTHws50FxqRPXR4uXOe99q%2FCKJM9FamUkMerluA3lnPgQqtnq5%2BRX37STpdUSf%2BMd1YGHAHQFPA2%2F2xLr2oS1SG83xDjCdEs4cS5gxa8p2lF5Zsp9XbpkH49Ajb46aXaMgtZhHnTQC5h9rXe5UkKznGqRcqfN%2Bm%2FouzAWdWNJpT7lhgFMoBBO0iRsvDJxdrY%2FNmii12KRNY%2F7Fv%2BikCRy8B21rSU12wibB%2Fi9hasD5o1hIlmxh2EqRrcI81M6q6T4eLQ%2FJG2Kw6bOItlIVwI3n6NRw9FcMRbA2lhAXgkX5GmW4c1EzvReHy6LwaO08kXAJR0skZcoiNchVkRSG9Na%2Fdxs1%2BcuEkbPwNqt2pLiBb11qip2ZIA5OaJ76CVZsCUBN%2F6ycWDYP8bWq2cZRHflSOPRDOuEjQiua5vyjYG5K7K4f3vk%2Fz9ldwHwt6LoJeM7XHRudBzo0p5yChECXMRSKq5k2xTqkjmNmq3nvv06axOo9TOTy6GmfWZeRnYvv7IaQVelGFfbFMpKtFNQirHEDRpjQMK3801UOu4HdzJP%2FZn1yHhtmdtVCjQ5LywrllvUtNFAIT5e2VsxAOYLF6z8XP4OO094Y2O9jkL9Gsbia0qzdaOkOIB50Ydn8qeLYKbzpWK3wxs9IC6uldq9jYC9YsR5lREvaukHG6CJqIBn2mbNKacu67L9%2BKlg%2B0RfwcshpBCBbGMoPTKWYwxCZhE1RhjifP8HH724aKIk2FqSJTNhVTYyQE40CkPDcCNE%2Fuv2Uz0fyGfOS4lTW9RlWBxAHHsu6N4BgndrHE0iV7MmU5SJ7YgkLDzDxbEAj3YMD0g6sxYn7e%2FuKgDKfkmHasNasFSQgVAiCxAywrl68E1nF5fdFmZg9WXDLU%2BoZfmEiMUoUlWOUaRzxUeNYgWujlt68FtxvZz0PQJtw7VXekqSTeZJCjlIiM9SuKkmGJf4NbRcimviJpIGrxsI1xQi1u1%2FTr4dFlGjF5UhcwhGvbwzgNsqsdfU69shGEJtjx30dw1Gd%2BzRmhtxWk9QA%2FfL%2FWBSrM4N4hvTP636WFeZFsa0p37%2Fzf%2F2%2FHROYEpR2dS8DyifQoOPbxaN111BNUw9okR%2BG3pA6sX50qYQzf4uI3sL%2BPbmxdRpxouF64zTBI%2FKPTAqcqhZsUFG3XNiU72qq7T3s91vWf0aqIzMtVV1NPLhjIPYCePqnmF5NMgbnQyubULj8Tl84r6PCREYVY3woCWmsTY4YhjSgkB2neRwAEqPP94aDQkEnHNy5DoMVrFowYs5nb6QzGRMP0hTpmbBOEQq70rb41VW%2B%2FDxoLC7kjdtagqCFe2RvKoBt4GMRxBe3rRe%2BtKERG6GkP0tE8bHTx30xrbNca9iDawCt%2FCys37Qm%2FoCLKSRkPs8APTBH8z40fwg210WSFzXyKwXkPhoukivI%2Bf3bmgyEOZPCkMCezrjuly2ma1aX3MJBOx3C7J3fyswZtMAJMe7UHJj9SM8asHygPA%2BHCQGnncEWLEY6MSiZ4olxPpA7ZwZALWkKPmfFT%2F0z5w1r0JjX5euGmB2%2Fwl47Bjfeq5WvBdXisEcw1kULMfhzfp0TTCc3rE1SIziRQob2iURF0juEDZNetyPWGIu0E%3D" +
                "&__ASYNCPOST=true" +
                "&";

        List<ExpRequestEntity> expRequestEntityList = new ArrayList<>();

        int index = 0;
        for (HeiMaoZipCodeUpEntity heiMaoZipCodeUpEntity : heiMaoZipCodeUpEntityList) {
            //拼接请求
            String content = requestBodyHead +
                    heiMaoZipCodeUpEntity.getOneClassAddress() +
                    "&ctl00$ContentPlaceHolder1$PostCode$ddlCity=" +
                    HeiMaoZipCodeTwoClassCode.getCode(heiMaoZipCodeUpEntity.getOneClassAddress(), heiMaoZipCodeUpEntity.getTwoClassAddress()) +
                    "&ctl00$ContentPlaceHolder1$txtAddr=" +
                    heiMaoZipCodeUpEntity.getIntactAddress() +
                    requestBodyEnd;

            Request tempRequest = HEIMAO_ZIP_CODE_REQUEST_LIST.get(index++%HEIMAO_ZIP_CODE_REQUEST_LIST.size());
                    Request request = new Request.Builder()
                            .url(tempRequest.url())
                            .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), content))
                            .addHeader("user-agent", Objects.requireNonNull(tempRequest.header("user-agent")))
                            .addHeader("cookie", Objects.requireNonNull(tempRequest.header("cookie")))
                            .build();
            expRequestEntityList.add(new ExpRequestEntity(request,heiMaoZipCodeUpEntity.getIntactAddress()));

        }
        return expRequestEntityList;
    }


    public static List<ExpRequestEntity> getFamiportExpRequest(List<FamiportExpUpEntity> famiportExpUpEntityList) {
        List<ExpRequestEntity>  expRequestEntityList= new ArrayList<>();

        for (FamiportExpUpEntity famiportExpUpEntity : famiportExpUpEntityList) {
            RequestBody requestBody =RequestBody.create(MediaType.parse("application/json"),"{\"EC_ORDER_NO\":\""+famiportExpUpEntity.getExpId()+"\",\"RCV_USER_NAME\":null,\"ORDER_NO\":\"\"}");
            Request request = new Request.Builder()
                    .url("https://ecfme.famiport.com.tw/fmedcfpwebv2/index.aspx/GetOrderDetail")
                    .post(requestBody)
                    .addHeader("content-type","application/json")
                    .build();
            expRequestEntityList.add(new ExpRequestEntity(request,famiportExpUpEntity.getExpId()));
        }

        return expRequestEntityList;
    }
}
