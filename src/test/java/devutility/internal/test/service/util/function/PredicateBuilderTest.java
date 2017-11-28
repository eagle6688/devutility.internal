package devutility.internal.test.service.util.function;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.util.ListHelper;
import devutility.internal.util.function.PredicateBuilder;

public class PredicateBuilderTest extends BaseService {
	@Override
	public void run() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(1);

		PredicateBuilder<Integer> predicateBuilder = new PredicateBuilder<>();
		predicateBuilder.or(i -> i == 1);
		predicateBuilder.or(i -> i == 2);
		List<Integer> result = ListHelper.list(list, predicateBuilder.getPredicate());
		System.out.println(result);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(PredicateBuilderTest.class);
	}
}