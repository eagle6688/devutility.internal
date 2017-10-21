package devutility.internal.test.service.basic.lang.Objects;

import java.util.Objects;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class RequireNonNullService extends BaseService {
	String value;

	public RequireNonNullService(String value) {
		this.value = value;
	}

	@Override
	public void run() {
		String str = Objects.requireNonNull(value, "value can not null in RequireNonNullService!");
		println(str);
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(new RequireNonNullService(null));
	}
}