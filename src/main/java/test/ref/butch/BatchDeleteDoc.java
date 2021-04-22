package test.ref.butch;

import java.sql.ResultSet;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import test.ref.ConnectElasticsearch;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午8:14
 */
public class BatchDeleteDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            //创建批量删除请求对象
            BulkRequest request = new BulkRequest();
            request.add(new DeleteRequest().index("user").id("1001"));
            request.add(new DeleteRequest().index("user").id("1002"));
            request.add(new DeleteRequest().index("user").id("1003"));
            //客户端发送请求，获取响应对象
            BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
            //打印结果信息
            System.out.println("took:" + responses.getTook());
            System.out.println("items:" + responses.getItems());


            BulkRequest bulkRequest = new BulkRequest();
            DeleteRequest request1 = new DeleteRequest("user").id("6-dR9HgBrQvXZVqYEXMq");
            DeleteRequest request2 = new DeleteRequest("user").id("6OdN9HgBrQvXZVqYI3P9");
            bulkRequest.add(request1);
            bulkRequest.add(request2);
            client.bulk(bulkRequest,RequestOptions.DEFAULT);
        });
    }
}