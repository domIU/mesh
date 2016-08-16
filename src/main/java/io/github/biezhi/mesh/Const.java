package io.github.biezhi.mesh;

public interface Const {
	
	/**
	 * 默认重试次数
	 */
	int DEFAULT_RETRY_COUNT = 3;
	
	/**
	 * 默认连接超时时长，5秒
	 */
	int DEFAULT_CONNECT_TIME_OUT = 5 * 1000;
	
	/**
	 * 默认读取数据超时时长，5秒
	 */
	int DEFAULT_READ_TIME_OUT = 5 * 1000;
	
	/**
	 * 默认启动线程数
	 */
	int DEFAULT_WORKDER_THREADS = 1;
	
	/**
	 * 默认等待10秒没有任务则停止线程
	 */
	int DEFAULT_SHUTDOWN_WAIT = 10;
	
	/**
	 * 线程名前缀
	 */
	String THREAD_NAME_PREFIX = "mesh-thread-";
}
