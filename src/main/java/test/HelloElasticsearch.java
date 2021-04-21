package test;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午6:06
 */

public class HelloElasticsearch {

    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
//		...
        System.out.println(client);

        // 关闭客户端连接
        client.close();
    }
}