package test.ref;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:37
 */
public class SearchIndex {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(e -> {
            GetIndexRequest indexRequest = new GetIndexRequest("user2");
            GetIndexResponse getIndexResponse = e.indices().get(indexRequest, RequestOptions.DEFAULT);
            System.out.println(getIndexResponse);
        });
    }

}
    