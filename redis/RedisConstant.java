package com.tairanchina.funds.common.redis;

public class RedisConstant {
	
	/** 用户key前缀. */
	public static final String USER_BY_USERID_PREFIX = "user_by_user_id_";

	/** 资金账户key前缀(account_id). */
	public static final String ACCOUNT_BY_ACCOUNTID_PREFIX = "account_by_account_id_";
	
	/** 资金账户key前缀(accounttyf_id). */
	public static final String ACCOUNT_BY_ACCOUNTTYFID_PREFIX = "account_by_accounttyf_id_";
	
	/** 资金账户key前缀(user_id). */
	public static final String ACCOUNT_BY_USERID_PREFIX = "account_by_user_id_";

	public static final String USERID_PREFIX = "_userid_";

	public static final String ACTION_PREFIX = "action_";

	public static final String QUERY_PREFIX = "_where_";

	public static final String ACTION_BINDCARD = "_bindcard_";

	public static final String ACTION_UNBINDCARD = "_unbindcard_";

	public static final int EXPIRED_SECONDS_10m = 600;

	public static final int ALLOW_TIMES_10 = 10;

	public static final int EXPIRED_SECONDS_1d = 86400;

}
