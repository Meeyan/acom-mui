package com.acom.util;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * http提交工具类
 *
 * @author zhaojy
 * @createTime 2017-06-30
 */
public class HttpUtil {
    private static Logger logger = LogFactory.getLogger(HttpUtil.class);

    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 2;
    public static final int METHOD_JSON = 3;

    /**
     * @param address    服务地址
     * @param contentMap 参数map，不管是get还是post，都以map传入
     * @param method     提交方法
     * @return String
     */
    public static String httpReq(String address, Map<String, Object> contentMap, int method) {
        String retString = "";
        URL url = null;
        HttpURLConnection urlConn = null;
        String content = "";
        try {
            /*得到url地址的URL类*/
            url = new URL(address);
            /*获得打开需要发送的url连接*/
            urlConn = (HttpURLConnection) url.openConnection();
            /*设置连接超时时间*/
            urlConn.setConnectTimeout(30000);
            /*设置读取响应超时时间*/
            urlConn.setReadTimeout(30000);

            if (method == HttpUtil.METHOD_POST) {
                /*设置post发送方式*/
                urlConn.setRequestMethod("POST");
                content = HttpUtil.getUrlStringByMay(contentMap);
            } else if (method == HttpUtil.METHOD_GET) {
                /*设置get发送方式*/
                urlConn.setRequestMethod("GET");
                content = HttpUtil.getUrlStringByMay(contentMap);
            } else if (method == HttpUtil.METHOD_JSON) {
                // json提交
                urlConn.setRequestMethod("POST");
                urlConn.setRequestProperty("Content-Type", "application/json");
                content = getJsonFromMap(contentMap);
            }

            /*发送commString*/
            urlConn.setDoOutput(true);
            OutputStream out = urlConn.getOutputStream();
            out.write(content.getBytes());
            out.flush();
            out.close();
            /*发送完毕 获取返回流，解析流数据*/
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            retString = sb.toString().trim();
            /*解析完毕关闭输入流*/
            rd.close();
        } catch (Exception e) {
            logger.error("----http request error happens:", e);
            /*异常处理*/
            retString = "-107";
        } finally {
            /*关闭URL连接*/
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
        /*返回响应内容*/
        return retString;
    }

    /**
     * 组装get请求的字符串
     *
     * @param map 参数map
     * @return String
     * @author zhaojy
     * @createTime 2017-06-27
     */
    public static String getUrlStringByMay(Map<String, Object> map) {
        if (null == map || map.size() <= 0) {
            return "";
        }
        Iterator iterator = map.keySet().iterator();
        String retString = "";
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Object obj = map.get(key);
            retString += key + "=";
            if (obj instanceof String) {
                retString += obj + "&";
            } else {
                retString += String.valueOf(obj) + "&";
            }
        }
        retString = retString.substring(0, retString.length() - 1);
        return retString;
    }

    /**
     * map转成json字符串
     *
     * @param map 参数map
     * @return String
     * @author zhaojy
     * @createTime 2017-06-27
     */
    public static String getJsonFromMap(Map<String, Object> map) {
        if (null == map || map.size() <= 0) {
            return "";
        }
        JSONObject jsonObj = new JSONObject();
        Iterator iterator = map.keySet().iterator();
        for (; iterator.hasNext(); ) {
            String key = (String) iterator.next();
            Object obj = map.get(key);
            jsonObj.put(key, obj);
        }
        return jsonObj.toString();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new TreeMap<String, Object>();    // 升序
        String url = "http://www.birdfenqi.com/out/riskCheck";
        String appId = "098f6bcd4621d373cade4e832627b4f6";
        String appKey = "e8f653d2c467f8d962cf33271a6754016bba7639";
        String timeStr = TimeUtil.getStandardTimestampStr();

        map.put("appID", appId);
        map.put("name", "安美琪");
        map.put("phone", "18249771880");
        map.put("id_num", "230107199401092027");
        map.put("req_time", timeStr);
        map.put("req_code", "80080001");

        Iterator iterator = map.keySet().iterator();
        String headStr = "";
        for (; iterator.hasNext(); ) {
            String key = (String) iterator.next();
            Object obj = map.get(key);
            String value = String.valueOf(obj);
            headStr += key + "|" + value;
        }
        String tailStr = appId.toUpperCase() + appKey.toUpperCase() + timeStr;
        tailStr = CryptUtil.sha1(tailStr);
        String sign = CryptUtil.base64Encode(headStr + tailStr);
        map.put("sign", sign);
        String ret = httpReq(url, map, HttpUtil.METHOD_JSON);
        System.out.println(ret);
    }


}
