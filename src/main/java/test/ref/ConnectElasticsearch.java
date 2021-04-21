package test.ref;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:21
 */
public class ConnectElasticsearch{

    public static void connect(ElasticsearchTask task){
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        try {
            task.doSomething(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}