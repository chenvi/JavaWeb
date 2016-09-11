package com.tairanchina.funds.common.redis;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tairanchina.funds.account.model.BizAccount;
import com.tairanchina.funds.account.service.BizAccountService;
import com.tairanchina.utils.DateUtils;

@Component
public class BizAccountRedisUtil {

	@Autowired
	private BizAccountService bizAccountService;

	private static BizAccountRedisUtil bizAccountRedisUtil = null;

	@PostConstruct
	public void init() {
		bizAccountRedisUtil = this;
		bizAccountRedisUtil.bizAccountService = bizAccountService;
	}

	/**
	 * 查询账户表(获取基本不修改信息 例：userId)
	 * 
	 * @param accountId
	 * @return
	 */
	public static BizAccount getAccountById(String accountId) {
		return getAccountById(accountId, false);
	}

	/**
	 * 查询账户表(获取基本不修改信息 例：userId)
	 * 
	 * @param accountId
	 * @return
	 */
	public static BizAccount getAccountById(String accountId, boolean refresh) {
		String key = RedisConstant.ACCOUNT_BY_ACCOUNTID_PREFIX + accountId;
		BizAccount account = RedisUtil.get(key, BizAccount.class);
		if (!refresh && null != account) {
			return account;
		}
		account = bizAccountRedisUtil.bizAccountService.selectByPrimaryKey(accountId);
		// 存入redis缓存
		RedisUtil.set(key, account);
		return account;
	}
	
    /**
     * 根据泰易付id获取账户信息
     * @param accountId
     * @return
     */
    public static BizAccount getAccountByTyfId(String tyfId) {
        String key = RedisConstant.ACCOUNT_BY_ACCOUNTTYFID_PREFIX+tyfId;
        BizAccount account = RedisUtil.get(key, BizAccount.class);
        if ( null != account ) {
            return account;
        }
        account = bizAccountRedisUtil.bizAccountService.getBizAccountByTyfId(tyfId);
        //存入redis缓存
        RedisUtil.set(key,account);
        return account;
    }
    
	/**
	 * 根据用户id获取账户信息
	 * 
	 * @param accountId
	 * @return
	 */
	public static BizAccount getAccountByUserId(String userId) {
		String key = RedisConstant.ACCOUNT_BY_USERID_PREFIX + userId;
		BizAccount account = RedisUtil.get(key, BizAccount.class);
		if (null != account) {
			return account;
		}
		account = bizAccountRedisUtil.bizAccountService.getBizAccountByUserId(userId, null,"101");
		// 存入redis缓存
		RedisUtil.set(key, account);
		return account;
	}
    
	public static BizAccount removeAccountById(String accountId) {
		String key = RedisConstant.ACCOUNT_BY_ACCOUNTID_PREFIX + accountId;
		BizAccount account = BizAccountRedisUtil.getAccountById(accountId, true);
		if (null != account) {
			key = RedisConstant.ACCOUNT_BY_ACCOUNTTYFID_PREFIX + account.getAccounttyfId();
			RedisUtil.set(key, account);
			key = RedisConstant.ACCOUNT_BY_USERID_PREFIX + account.getUserId();
			RedisUtil.set(key, account);
		}

		// if(account != null){
		// //AccountVo
		// key = RedisConstant.ACCOUNTVO_BY_USERID+account.getUserId();
		// RedisUtil.remove(key);
		// //我的理财
		// key = RedisConstant.getInvestVoKey(account.getUserId());
		// RedisUtil.remove(key);
		// }
		return account;
	}

//	public static void removeAccountById(String accountId) {
//		String key = RedisConstant.ACCOUNT_BY_ACCOUNTID_PREFIX + accountId;
//		RedisUtil.remove(key);
//		BizAccount account = BizAccountRedisUtil.getAccountById(accountId);
//		// if(account != null){
//		// //AccountVo
//		// key = RedisConstant.ACCOUNTVO_BY_USERID+account.getUserId();
//		// RedisUtil.remove(key);
//		// //我的理财
//		// key = RedisConstant.getInvestVoKey(account.getUserId());
//		// RedisUtil.remove(key);
//		// }
//	}

	/**
	 * 查询商户账户可用资金
	 * 
	 * @param refresh
	 * @return
	 */
	public static BigDecimal getPlatformNoBalance(boolean refresh) {
		// String key = RedisConstant.PLATFORMNO_BALANCE;
		BigDecimal balance = BigDecimal.ZERO;
		try {
			Date now = new Date();
			Date start = null;
			Date end = null;
			// TODO ???字典缓存，保存、获取
			// String startTime = DictUtils.getDictValue("start_time",
			// "withdraw_control", "");
			// String endTime = DictUtils.getDictValue("end_time",
			// "withdraw_control", "");
			String startTime = "";
			String endTime = "";
			if (StringUtils.isNotBlank(startTime) || StringUtils.isNotBlank(endTime)) {
				if (StringUtils.isBlank(startTime)) {
					startTime = "2000-01-01 00:00:01";
				}
				if (StringUtils.isBlank(endTime)) {
					endTime = "2099-12-31 23:59:59";
				}
				start = DateUtils.parse(startTime, DateUtils.TIME_PATTON_DEFAULT);
				end = DateUtils.parse(endTime, DateUtils.TIME_PATTON_DEFAULT);

				if (now.before(start) && now.after(end)) {
					balance = BigDecimal.ONE;
				}
			} else {
				balance = BigDecimal.ONE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return balance;
		}
		return balance;
	}

}
