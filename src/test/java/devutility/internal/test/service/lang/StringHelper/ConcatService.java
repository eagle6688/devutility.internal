package devutility.internal.test.service.lang.StringHelper;

import devutility.internal.lang.StringHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ConcatService extends BaseService {
	@Override
	public void run() {
		println(StringHelper.concat(""));
		println(StringHelper.concat("1", "2", "3", "4"));
		println("Concat completely!");
	}

	public static void main(String[] args) {
		ServiceExecutor.run(ConcatService.class);
	}
}