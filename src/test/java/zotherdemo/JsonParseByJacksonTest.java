package zotherdemo;

import com.zotherdemo.JsonParseByJackson;
import org.junit.Test;

import java.util.Map;

/**
 * Created by zzy on 2017/9/8.
 */
public class JsonParseByJacksonTest {

    @Test
    public void parseJsonTest() throws Exception{
        String json = "{\"name\":\"张三\",\"age\":10,\"sex\":\"男\"}";

        Map map = JsonParseByJackson.parseStringToMap(json);
        System.out.println("姓名： "+map.get("name"));
        System.out.println("年龄： "+map.get("age"));
        System.out.println("性别： "+map.get("sex"));
    }
}
