package com.tairanchina.funds.common.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public final class RedisUtil {

	@Autowired
	private JedisPool jedisPool;

	private static RedisUtil redisUtil;

	private static boolean redisEnable = true;

	@PostConstruct
	public void init() {
		redisUtil = this;
		redisUtil.jedisPool = jedisPool;
	}

	/**
	 * 向缓存中设置字符串内容 默认10分钟
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static boolean set(String key, String value) {
		if (!redisEnable) {
			return false;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			jedis.set(key, value);
			jedis.expire(key, 600);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 向缓存中设置字符串内容
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 * @throws Exception
	 */
	public static boolean set(String key, String value, int seconds) {
		if (!redisEnable) {
			return false;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			jedis.setex(key, seconds, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 向缓存中设置对象 默认10分钟
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(String key, Object value) {
		if (!redisEnable) {
			return false;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			String str = serialize(value);
			if (str != null && str.trim().length() > 0) {
				jedis.setex(key, 600, str);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 向缓存中设置对象
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public static boolean set(String key, Object value, int seconds) {
		if (!redisEnable) {
			return false;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			String str = serialize(value);
			if (str != null && str.trim().length() > 0) {
				jedis.setex(key, seconds, str);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除缓存中得对象，根据key
	 * 
	 * @param key
	 * @return
	 */
	public static boolean remove(String key) {
		if (!redisEnable) {
			return true;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			jedis.del(key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据key 获取内容
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return get(key, 0);
	}

	public static String get(String key, int expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			if (expireSeconds > 0 && jedis.exists(key)) {
				jedis.expire(key, expireSeconds);
			}
			return jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据key 获取对象
	 * 
	 * @param key
	 * @return
	 */
	public static <T> T get(String key, Class<T> clazz) {
		return get(key, clazz, 0);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(String key, Class<T> clazz, int expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			if (expireSeconds > 0 && jedis.exists(key)) {
				jedis.expire(key, expireSeconds);
			}
			String str = jedis.get(key);
			if (str != null && str.trim().length() > 0) {
				return (T) unserialize(str);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		try {
			return redisUtil.jedisPool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(Jedis jedis) {
		if (jedis != null) {
			// redisUtil.jedisPool.returnResource(jedis);
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// serialize
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			return baos.toString("ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object unserialize(String value) {
		ByteArrayInputStream bais = null;
		try {
			// deserialize
			bais = new ByteArrayInputStream(value.getBytes("ISO-8859-1"));
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isRedisEnable() {
		return redisEnable;
	}

	/**
	 * 向缓存中设置字符串内容 ,永久有效
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static boolean persist(String key, String value) {
		if (!redisEnable) {
			return false;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			jedis.set(key, value);
			jedis.persist(key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 往队列中增加一个值，默认使用lpush
	 * 
	 * @param key
	 * @param value
	 * @param expireSeconds
	 * @return
	 */
	public static Long push(String key, String value, int expireSeconds) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			Long result = jedis.lpush(key, value);
			if (expireSeconds > 0) {
				jedis.expire(key, expireSeconds);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从队列中获取一个值，默认使用rpop
	 * 
	 * @param key
	 * @return
	 */
	public static String pop(String key) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.rpop(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从队列中获取一个值，使用阻塞模式，默认使用brpop
	 * 
	 * @param seconds
	 *            超时时间，超过这个时间之后仍然没有取到值则停止阻塞返回空值
	 * @param key
	 * @return list[0]是队列的名称，list[1]是返回的具体数据，如果为空则代表没有取到数据
	 */
	public static List<String> bpop(int seconds, String key) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.brpop(seconds, key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从队列1中获取一个值并返回，同时将这个值放在队列2的末尾
	 * 
	 * @param key1
	 *            队列1
	 * @param key2
	 *            队列2，可以是队列1的名称，这样就是从队列1的头部拿出来，同时又放回队列1的尾部
	 * @return
	 */
	public static String rpoplpush(String key1, String key2) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.rpoplpush(key1, key2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 从key对应list中删除与value相同的所有元素
	public static Long remAll(String key, String value) {
		return rem(key, 0L, value);
	}

	// 从key对应list中删除count个和value相同的元素,
	// count>0时，按从头到尾的顺序删除,count<0时，按从尾到头的顺序删除,count=0时，删除全部
	public static Long rem(String key, Long count, String value) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.lrem(key, count, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将队列中的所有value对应的缓存删除掉
	 * 
	 * @param key
	 */
	public static void removeCacheList(String key) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			String value = jedis.rpop(key);
			while (value != null && value.trim().length() > 0) {
				jedis.del(value);
				value = jedis.rpop(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将redis中的key值增加
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long incrBy(String key, long value) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.incrBy(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将redis中的key值减去
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long decrBy(String key, long value) {
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			return jedis.decrBy(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新缓存中key的过期时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 * @throws Exception
	 */
	public static void expire(String key, int seconds) {
		if (!redisEnable) {
			return;
		}
		Jedis jedis = null;
		try {
			jedis = redisUtil.jedisPool.getResource();
			jedis.expire(key, seconds);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断能否执行操作.
	 * 
	 * @param userId
	 *            用户名
	 * @param actionName
	 *            操作名称
	 * @param expiredSeconds
	 *            有效时间
	 * @param maxCount
	 *            最大执行次数
	 * @param query
	 *            其他参数条件
	 * @param invokeTimes
	 *            触发多少次执行次数
	 * @return
	 */
	public static boolean baseActionAssert(String userId, String actionName, int expiredSeconds, int maxCount,
			String query, int invokeTimes) {
		if (!RedisUtil.isRedisEnable()) {
			return true;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(RedisConstant.ACTION_PREFIX);
		sb.append(actionName);
		sb.append(RedisConstant.USERID_PREFIX);
		sb.append(userId);
		if (StringUtils.isNotBlank(query)) {
			sb.append(RedisConstant.QUERY_PREFIX);
			sb.append(query);
		}
		String key = sb.toString();
		Integer count = RedisUtil.get(key, Integer.class);
		if (null == count) {
			count = 0;
		}
		count += invokeTimes;
		if (count <= maxCount) {
			RedisUtil.set(key, count, expiredSeconds);
			return true;
		}
		return false;
	}

}