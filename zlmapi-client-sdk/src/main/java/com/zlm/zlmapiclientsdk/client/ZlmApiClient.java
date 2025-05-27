package com.zlm.zlmapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zlm.zlmapiclientsdk.model.User;
import com.zlm.zlmapiclientsdk.utils.SignUtils;

import java.util.HashMap;

public class ZlmApiClient {
    private String accessKey;
    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public ZlmApiClient() {}

    public ZlmApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private HashMap<String,String> getHeaderMap(String body){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);

        hashMap.put("nonce", RandomUtil.randomNumbers(4));

        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));

        hashMap.put("sign", SignUtils.genSign(hashMap,secretKey));
        return hashMap;
    }

    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result= HttpUtil.post(GATEWAY_HOST + "/api/name/post", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUserNameByPost(User user){
        //生成密钥
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
    public String setPost(String api,String param){
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + api)
                .addHeaders(getHeaderMap(param))
                .body(param)
                .execute();
        String result = httpResponse.body();
        return result;
    }
}
