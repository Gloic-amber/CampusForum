package com.ustc.blog.content;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.ustc.blog.content.pojo.BlogDTO;
import com.ustc.blog.content.service.BlogContentService;
import com.ustc.blog.content.service.impl.BlogContentServiceImpl;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: com.ustc.blog.content.DataImport
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Gloic
 * @Create 2023/12/13
 * @Version 1.0
 */

@SpringBootTest
public class DataImport {
    private RestHighLevelClient client;

    @Autowired
    private BlogContentService blogContentService;

    @BeforeEach
    void setUp() {
        this.client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.111.128:9200")
        ));
    }

    @Test
    void testConnect() {
        System.out.println(client);
    }

    @Test
    public void testBlogList(){
        System.out.println(blogContentService.getBlogList());
    }

    @Test
    public void testLoadBlogDoc() throws IOException {
        // 1.创建Request
        BulkRequest request = new BulkRequest("blog");
        // 2.准备参数，添加多个新增的Request
        List<BlogDTO> blogDTOList = blogContentService.getBlogList();
        for (BlogDTO blogDTO : blogDTOList) {
            // 2.1.创建新增文档的Request对象
            request.add(new IndexRequest()
                    .id(String.valueOf(blogDTO.getId()))
                    .source(JSONUtil.toJsonStr(blogDTO), XContentType.JSON));
        }
        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }

}
