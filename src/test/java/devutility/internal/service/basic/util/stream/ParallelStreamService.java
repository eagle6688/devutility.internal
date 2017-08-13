package devutility.internal.service.basic.util.stream;

import java.util.ArrayList;

import devutility.internal.test.BaseService;

public class ParallelStreamService extends BaseService {

	@Override
	public void run() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);
		
		println("Normally print:");
		
		numbers.stream().forEach(i->{
			System.out.print(i);
		});
		
		println("\nParallelStream:");
		
		numbers.parallelStream().forEach(i->{
			System.out.print(i);
		});
	}
}