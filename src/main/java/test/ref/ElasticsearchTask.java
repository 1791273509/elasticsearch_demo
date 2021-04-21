package test.ref;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/4/21 下午7:21
 */

import org.elasticsearch.client.RestHighLevelClient;

public interface ElasticsearchTask {

    void doSomething(RestHighLevelClient client) throws Exception;

}
    