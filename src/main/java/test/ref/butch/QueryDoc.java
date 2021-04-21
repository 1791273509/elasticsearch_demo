package test.ref.butch;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import test.ref.ConnectElasticsearch;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午8:24
 */
public class QueryDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {



            // 创建搜索请求对象
            SearchRequest request = new SearchRequest();
            request.indices("user");

            // 构建查询的请求体
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            // 查询所有数据
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            request.source(sourceBuilder);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            // 查询匹配
            SearchHits hits = response.getHits();
            System.out.println("took:" + response.getTook());
            System.out.println("timeout:" + response.isTimedOut());
            System.out.println("total:" + hits.getTotalHits());
            System.out.println("MaxScore:" + hits.getMaxScore());
            System.out.println("hits========>>");
            for (SearchHit hit : hits) {
                //输出每条查询的结果信息
                System.out.println(hit);
                System.out.println(hit.getSourceAsString());
            }
            System.out.println("<<========");
        });
    }
}
    