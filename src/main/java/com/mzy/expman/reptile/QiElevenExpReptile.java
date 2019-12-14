package com.mzy.expman.reptile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.qielevenexp.QiElevenExpDownEntity;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName QiElevenExpReptile
 * @Description 711exp爬虫
 * @Author 程方园
 * @Date 2019/12/12 10:52
 * @Version 1.0
 */
@Async("QiElevenExpTheadPool")
@Slf4j
@Component
public class QiElevenExpReptile extends MyBaseReptile<QiElevenExpDownEntity> {

    private final static String JS711 = "function getUrl(int_time, exp_id) {!function (a) {\"use strict\";function b(a, b) {var c = (65535 & a) + (65535 & b), d = (a >> 16) + (b >> 16) + (c >> 16);return d << 16 | 65535 & c}function c(a, b) {return a << b | a >>> 32 - b}function d(a, d, e, f, g, h) {return b(c(b(b(d, a), b(f, h)), g), e)}function e(a, b, c, e, f, g, h) {return d(b & c | ~b & e, a, b, f, g, h)}function f(a, b, c, e, f, g, h) {return d(b & e | c & ~e, a, b, f, g, h)}function g(a, b, c, e, f, g, h) {return d(b ^ c ^ e, a, b, f, g, h)}function h(a, b, c, e, f, g, h) {return d(c ^ (b | ~e), a, b, f, g, h)}function i(a, c) {a[c >> 5] |= 128 << c % 32, a[(c + 64 >>> 9 << 4) + 14] = c;var d, i, j, k, l, m = 1732584193, n = -271733879, o = -1732584194, p = 271733878;for (d = 0; d < a.length; d += 16) i = m, j = n, k = o, l = p, m = e(m, n, o, p, a[d], 7, -680876936), p = e(p, m, n, o, a[d + 1], 12, -389564586), o = e(o, p, m, n, a[d + 2], 17, 606105819), n = e(n, o, p, m, a[d + 3], 22, -1044525330), m = e(m, n, o, p, a[d + 4], 7, -176418897), p = e(p, m, n, o, a[d + 5], 12, 1200080426), o = e(o, p, m, n, a[d + 6], 17, -1473231341), n = e(n, o, p, m, a[d + 7], 22, -45705983), m = e(m, n, o, p, a[d + 8], 7, 1770035416), p = e(p, m, n, o, a[d + 9], 12, -1958414417), o = e(o, p, m, n, a[d + 10], 17, -42063), n = e(n, o, p, m, a[d + 11], 22, -1990404162), m = e(m, n, o, p, a[d + 12], 7, 1804603682), p = e(p, m, n, o, a[d + 13], 12, -40341101), o = e(o, p, m, n, a[d + 14], 17, -1502002290), n = e(n, o, p, m, a[d + 15], 22, 1236535329), m = f(m, n, o, p, a[d + 1], 5, -165796510), p = f(p, m, n, o, a[d + 6], 9, -1069501632), o = f(o, p, m, n, a[d + 11], 14, 643717713), n = f(n, o, p, m, a[d], 20, -373897302), m = f(m, n, o, p, a[d + 5], 5, -701558691), p = f(p, m, n, o, a[d + 10], 9, 38016083), o = f(o, p, m, n, a[d + 15], 14, -660478335), n = f(n, o, p, m, a[d + 4], 20, -405537848), m = f(m, n, o, p, a[d + 9], 5, 568446438), p = f(p, m, n, o, a[d + 14], 9, -1019803690), o = f(o, p, m, n, a[d + 3], 14, -187363961), n = f(n, o, p, m, a[d + 8], 20, 1163531501), m = f(m, n, o, p, a[d + 13], 5, -1444681467), p = f(p, m, n, o, a[d + 2], 9, -51403784), o = f(o, p, m, n, a[d + 7], 14, 1735328473), n = f(n, o, p, m, a[d + 12], 20, -1926607734), m = g(m, n, o, p, a[d + 5], 4, -378558), p = g(p, m, n, o, a[d + 8], 11, -2022574463), o = g(o, p, m, n, a[d + 11], 16, 1839030562), n = g(n, o, p, m, a[d + 14], 23, -35309556), m = g(m, n, o, p, a[d + 1], 4, -1530992060), p = g(p, m, n, o, a[d + 4], 11, 1272893353), o = g(o, p, m, n, a[d + 7], 16, -155497632), n = g(n, o, p, m, a[d + 10], 23, -1094730640), m = g(m, n, o, p, a[d + 13], 4, 681279174), p = g(p, m, n, o, a[d], 11, -358537222), o = g(o, p, m, n, a[d + 3], 16, -722521979), n = g(n, o, p, m, a[d + 6], 23, 76029189), m = g(m, n, o, p, a[d + 9], 4, -640364487), p = g(p, m, n, o, a[d + 12], 11, -421815835), o = g(o, p, m, n, a[d + 15], 16, 530742520), n = g(n, o, p, m, a[d + 2], 23, -995338651), m = h(m, n, o, p, a[d], 6, -198630844), p = h(p, m, n, o, a[d + 7], 10, 1126891415), o = h(o, p, m, n, a[d + 14], 15, -1416354905), n = h(n, o, p, m, a[d + 5], 21, -57434055), m = h(m, n, o, p, a[d + 12], 6, 1700485571), p = h(p, m, n, o, a[d + 3], 10, -1894986606), o = h(o, p, m, n, a[d + 10], 15, -1051523), n = h(n, o, p, m, a[d + 1], 21, -2054922799), m = h(m, n, o, p, a[d + 8], 6, 1873313359), p = h(p, m, n, o, a[d + 15], 10, -30611744), o = h(o, p, m, n, a[d + 6], 15, -1560198380), n = h(n, o, p, m, a[d + 13], 21, 1309151649), m = h(m, n, o, p, a[d + 4], 6, -145523070), p = h(p, m, n, o, a[d + 11], 10, -1120210379), o = h(o, p, m, n, a[d + 2], 15, 718787259), n = h(n, o, p, m, a[d + 9], 21, -343485551), m = b(m, i), n = b(n, j), o = b(o, k), p = b(p, l);return [m, n, o, p]}function j(a) {var b, c = \"\";for (b = 0; b < 32 * a.length; b += 8) c += String.fromCharCode(a[b >> 5] >>> b % 32 & 255);return c}function k(a) {var b, c = [];for (c[(a.length >> 2) - 1] = void 0, b = 0; b < c.length; b += 1) c[b] = 0;for (b = 0; b < 8 * a.length; b += 8) c[b >> 5] |= (255 & a.charCodeAt(b / 8)) << b % 32;return c}function l(a) {return j(i(k(a), 8 * a.length))}function m(a, b) {var c, d, e = k(a), f = [], g = [];for (f[15] = g[15] = void 0, e.length > 16 && (e = i(e, 8 * a.length)), c = 0; 16 > c; c += 1) f[c] = 909522486 ^ e[c], g[c] = 1549556828 ^ e[c];return d = i(f.concat(k(b)), 512 + 8 * b.length), j(i(g.concat(d), 640))}function n(a) {var b, c, d = \"0123456789abcdef\", e = \"\";for (c = 0; c < a.length; c += 1) b = a.charCodeAt(c), e += d.charAt(b >>> 4 & 15) + d.charAt(15 & b);return e}function o(a) {return unescape(encodeURIComponent(a))}function p(a) {return l(o(a))}function q(a) {return n(p(a))}function r(a, b) {return m(o(a), o(b))}function s(a, b) {return n(r(a, b))}function t(a, b, c) {return b ? c ? r(b, a) : s(b, a) : c ? p(a) : q(a)}\"function\" == typeof define && define.amd ? define(function () {return t}) : a.TM = t}(this);var TME = function (a, b, d, c, s, t) {return c = c || 'trackingmore', s = s || Math.floor(d / 888), s = s.toString(), t = t || s.length, TM(TM(c) + \"::\" + a + \":\" + TM(Math.floor(d / 1000)) + \":\" + TM(b))};return 'https://www.trackingmore.com/gettracedetail.php?lang=cn&callback=jQuery1_'+ (int_time - parseInt((Math.random() * 9 + 1))).toString()+'&tracknumber='+exp_id+'&express=qi-eleven&express_amazon=&track_number_orderId_ge=&pt=0&tracm=&destination=&track_account=&againtrack=&exception=0&validate='+TME(TM(exp_id), TM(\"qi-eleven\"), int_time)+'&_='+int_time;}\n";
    @Override
    public CompletableFuture<QiElevenExpDownEntity> getDownEntity(ExpRequestEntity expRequestEntity) throws ScriptException, NoSuchMethodException {

        log.info("{} 开始时间：{}", expRequestEntity.getExpId(), new Date());

        QiElevenExpDownEntity qiElevenExpDownEntity = new QiElevenExpDownEntity();
        qiElevenExpDownEntity.setExpId(expRequestEntity.getExpId());
        List<String> stausDataList = List.of("查询中", "查询不到", "运输途中", "到达待取", "成功签收", "运输过久", "投递失败", "可能异常");

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        engine.eval(JS711);
        Invocable invocable = (Invocable) engine;
        long intTime = new Date().getTime();
        String url = (String) invocable.invokeFunction("getUrl",intTime,expRequestEntity.getExpId());

        Connection connection = Jsoup.connect(url);
        try {
            String result = connection.get().text();
            result = result.substring(22, result.length() - 1).toLowerCase();
            ObjectMapper objectMapper = new ObjectMapper();
            Map JsonMap = objectMapper.readValue(result, Map.class);
            Integer stausdatanum = Integer.parseInt(JsonMap.get("stausdatanum").toString()) ;
            if (!stausdatanum.equals(1) && !stausdatanum.equals(0)){
                Map origincountrydata = (Map) JsonMap.get("origincountrydata");
                qiElevenExpDownEntity.setState(stausDataList.get((Integer) origincountrydata.get("stausdatanum")));
                qiElevenExpDownEntity.setStartTime((String) origincountrydata.get("firstupdatetime"));
                qiElevenExpDownEntity.setLastTime((String) origincountrydata.get("lastupdatetime"));
                qiElevenExpDownEntity.setLastEvent((String) origincountrydata.get("statusinfo"));
            }else {
                qiElevenExpDownEntity.setRemark("查询失败或无此订单");
            }
        } catch (IOException e) {
            qiElevenExpDownEntity.setRemark("生成失败");
            log.info("{} 生成失败：{}",expRequestEntity.getExpId(),e.getMessage());
//            throw e;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            log.info("线程休眠异常：{}",e.getMessage());
        }
        log.info("{} 结束时间：{}",expRequestEntity.getExpId(),new Date());
        return CompletableFuture.completedFuture(qiElevenExpDownEntity);
    }

    @Override
    public CompletableFuture<List<QiElevenExpDownEntity>> getDownEntityList(ExpRequestEntity expRequestEntity) {
        return null;
    }
}
