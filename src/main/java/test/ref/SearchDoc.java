package test.ref;

import com.tdunning.math.stats.Sort;
import javax.management.Query;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/22 上午12:10
 * 全量查询
 */
public class SearchDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            SearchRequest request = new SearchRequest();
            request.indices("user");

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //全量查询
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            //查询age为301的
            // sourceBuilder.query(QueryBuilders.termQuery("age","301"));

            //排序
            // sourceBuilder.sort("age", SortOrder.DESC);


            //过滤字段
            /*String exclude[] = {"name"};
            String include[] = {"age"};
            sourceBuilder.fetchSource(include,exclude);*/

            //组合查询
           /* BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            boolQueryBuilder.must(QueryBuilders.matchQuery("age","20"));
            boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));

            sourceBuilder.query(boolQueryBuilder);*/


    //        范围查询
    /*        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("age");
            queryBuilder.gt(30);
            queryBuilder.lte(40);

            sourceBuilder.query(queryBuilder);*/

            // 模糊查询
        /*    FuzzyQueryBuilder fuzziness = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE);
            sourceBuilder.query(fuzziness);
*/



            //聚合查询

            AggregationBuilder aggreation =  AggregationBuilders.max("Age_Max").field("age");

            sourceBuilder.aggregation(aggreation);


            request.source(sourceBuilder);
            SearchResponse search = client.search(request, RequestOptions.DEFAULT);

            SearchHits hits = search.getHits();
            System.out.println(search.getAggregations());
            hits.forEach(e -> System.out.println(e.getSourceAsString()));


        });
    }

}
    