package test.ref;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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
            GetIndexRequest indexRequest = new GetIndexRequest("user");
            GetRequest request = new GetRequest("user");
            request.id("1006");
            GetResponse documentFields = e.get(request, RequestOptions.DEFAULT);
            System.out.println("id\t" + documentFields.getSourceAsString());
            GetIndexResponse getIndexResponse = e.indices().get(indexRequest, RequestOptions.DEFAULT);
            System.out.println(getIndexResponse);
        });
    }

}
    