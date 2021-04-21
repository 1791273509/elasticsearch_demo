package test.ref;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:46
 */
public class DeleteIndex {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(e -> {
            DeleteIndexRequest request = new DeleteIndexRequest("user2");
            AcknowledgedResponse delete = e.indices().delete(request, RequestOptions.DEFAULT);
            System.out.println(delete);

        });
    }
}
    