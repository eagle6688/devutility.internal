package devutility.internal.service.basic.lang.Objects;

import java.util.Objects;

import devutility.internal.test.BaseService;

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
}