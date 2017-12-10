package devutility.internal.test.service.basic.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ConcurrentHashMapTest extends BaseService {
	@Override
	public void run() {
		ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
		hashMap.put(null, null);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(ConcurrentHashMapTest.class);
	}
}