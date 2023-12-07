package com.ustc.blog.sdk;

/**
 * @author css
 */
public class BlogMqConstants {

    /**
     * 博客服务交互机
     */
    public static final String BLOG_TOPIC_EXCHANGE = "blog.topic";

    /**
     * 博客插入
     */
    public static final String BLOG_INSERT_KEY = "blog.insert";

    /**
     * 刷新ES数据，也可以用于批量导入博客数据到ES
     */
    public static final String BLOG_REFRESH_ES_KEY = "blog.refresh.es";

    /**
     * 博客更新
     */
    public static final String BLOG_UPDATE_KEY = "blog.update";

    /**
     * 博客删除
     */
    public static final String BLOG_DELETE_KEY = "blog.delete";

    /**
     * 用户浏览博客
     */
    public static final String BLOG_OPERATE_READ_KEY = "blog.read";

    /**
     * 用户点赞博客
     */
    public static final String BLOG_OPERATE_LIKE_KEY = "blog.like";

    /**
     * 用户取消点赞博客
     */
    public static final String BLOG_OPERATE_LIKE_CANCEL_KEY = "blog.like.cancel";

    /**
     * 用户收藏博客
     */
    public static final String BLOG_OPERATE_COLLECT_KEY = "blog.collect";

    /**
     * 用户收藏博客
     */
    public static final String BLOG_OPERATE_COLLECT_CANCEL_KEY = "blog.collect.cancel";

    /**
     * 用户转发博客
     */
    public static final String BLOG_OPERATE_RELAY_KEY = "blog.relay";

}