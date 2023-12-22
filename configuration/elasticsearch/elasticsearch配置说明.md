# elasticsearch配置说明

### 1.正常启动elasticsearch和kibana以及在elasticsearch中安装了ik分词器后，在kibana中打开Dev tools，输入如下的语句即可在elasticsearch中创建索引。

```
PUT /blog
{
  "mappings": {
    "properties": {
      "id": {
        "type": "integer"
      },
      "authorId": {
        "type": "integer"
      },
      "title": {
        "type": "text",
        "analyzer": "ik_max_word",
        "copy_to": "descriptiveContent"
      },
      "description": {
        "type": "text",
        "analyzer": "ik_max_word",
        "copy_to": "descriptiveContent"
      },
      "schoolCode": {
        "type": "integer"
      },
      "coverImage": {
        "type": "keyword",
        "index": false
      },
      "createTime": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"
      },
      "releaseTime": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"
      },
      "modifiedTime": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"
      },
      "status": {
        "type": "integer"
      },
      "writeType":{
          "type":"integer"
       },
       "descriptiveContent":{
          "type":"text",
          "analyzer":"ik_max_word"
       }
    }
  }
}
```

### 2.然后由于elasticsearch中一开始是没有数据的，需要运行一个脚本将数据库中的博客数据导入。

运行``blog-service/blog-content-server/src/test``中的``DataImport``类中的``testLoadBlogDoc``单元测试，进行博客数据的导入。

注意需要修改``setUp``方法中的连接elasticsearch的路径。