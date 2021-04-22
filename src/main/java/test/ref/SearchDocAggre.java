package test.ref;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/22 下午8:19
 */
public class SearchDocAggre {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(e -> {
            SearchRequest request = new SearchRequest("user");

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            AggregationBuilder aggregation = AggregationBuilders.terms("age_group").field("age");
            AggregationBuilder aggregation2 = AggregationBuilders.terms("name_group").field("price");

            aggregation.subAggregation(aggregation2);

            sourceBuilder.aggregation(aggregation);

            request.source(sourceBuilder);
            SearchResponse searchResponse = e.search(request, RequestOptions.DEFAULT);

            System.out.println(searchResponse.getAggregations().get("age_group"));
            System.out.println(searchResponse.getAggregations().getAsMap());
        });
    }

}
    