package test.ref;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午8:06
 */
public class DeleteDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(e -> {
            DeleteRequest deleteRequest = new DeleteRequest("user").id("1001");
            System.out.println(e.delete(deleteRequest, RequestOptions.DEFAULT));
        });
    }
}
    