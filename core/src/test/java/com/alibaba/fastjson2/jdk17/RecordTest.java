package com.alibaba.fastjson2.jdk17;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    @Test
    public void test() {
        Bean bean = new Bean(123);
        assertEquals("{\"id\":123}", JSON.toJSONString(bean));

        JSONObject object = JSONObject.of("value", bean);
        assertEquals("{\"value\":{\"id\":123}}", JSON.toJSONString(object));
    }

    @Test
    public void test1() {
        var jo = new JSONObject();
        jo.put("type", 2);
        jo.put("id", "cxcc");
        jo.put("uid", "uid");
        jo.put("data", List.of(
                new LogoutEntity("aa", "111"),
                new LogoutEntity("bbb", "222"))
        );
        assertEquals(
                "{\"type\":2,\"id\":\"cxcc\",\"uid\":\"uid\",\"data\":[{\"serviceTicket\":\"aa\",\"url\":\"111\"},{\"serviceTicket\":\"bbb\",\"url\":\"222\"}]}",
                jo.toJSONString()
        );
    }

    public record LogoutEntity(String serviceTicket, String url) {
    }

    public record Bean(int id) {
    }
}
