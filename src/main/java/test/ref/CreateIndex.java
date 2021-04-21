package test.ref;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:21
 */
public class CreateIndex {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(e ->{
            // 创建索引 - 请求对象
            CreateIndexRequest request = new CreateIndexRequest("user3");
            // 发送请求，获取响应
            CreateIndexResponse response = e.indices().create(request,
                    RequestOptions.DEFAULT);
            boolean acknowledged = response.isAcknowledged();
            // 响应状态
            System.out.println("操作状态 = " + acknowledged);
        } );
    }

}
    