package com.ustc.blog.constants;

/**
 * @author css
 */
public class RedisConstants {

	public static final Long RANK_HOT_WEEK_TTL = 60 * 60 * 24 * 7L;

	public static final Long RANK_HOT_DAY_TTL = 60 * 60 * 24 * 40L;

	public static final String RANK_HOT_DAY_KEY = "rank:hot:day:";

	public static final String RANK_HOT_WEEK_KEY = "rank:hot:week:";

	public static final String RANK_AUTHOR_WEEK_KEY = "rank:author:week:";

	public static final String RANK_AUTHOR_TOTAL_KEY = "rank:author:total";

}
