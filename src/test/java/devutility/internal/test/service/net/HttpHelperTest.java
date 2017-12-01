package devutility.internal.test.service.net;

import devutility.internal.net.HttpHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class HttpHelperTest extends BaseService {
	@Override
	public void run() {
		println(HttpHelper.get("http://www.baidu.com"));
		println(HttpHelper.postJson("http://localhost:9080/products/search?pageIndex=1&pageSize=10", "{}", 1000 * 30));
	}

	public static void main(String[] args) {
		ServiceExecutor.run(HttpHelperTest.class);
	}
}