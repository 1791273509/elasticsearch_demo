package test;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:17
 */
public class DeleteIndex {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        // 删除索引 - 请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("user2");
        // 发送请求，获取响应
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        // 操作结果
        System.out.println("操作结果 ： " + response.isAcknowledged());
        client.close();
    }
}