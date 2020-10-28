## pom
```aidl
        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.13</version>
        </dependency>

```

## 代码
```aidl
public class HttpClientUtil {
    public static String get(String url) {
        CloseableHttpClient client  = HttpClients.createDefault();
        HttpGet             httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "UTF-8");//转化json格式 并防止乱码

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class HttpClientTest {
    public static void main(String[] args) {
        String result = HttpClientUtil.get("http://www.baidu.com");
        System.out.println(result);
    }
}
s
```