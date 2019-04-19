package devutility.internal.test.basic.util.stream;

import java.util.ArrayList;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ParallelStreamService extends BaseTest {
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
			println(i);
		});
		
		println("\nParallelStream:");
		
		numbers.parallelStream().forEach(i->{
			println(i);
		});
	}
	
	public static void main(String[] args) {
		TestExecutor.run(ParallelStreamService.class);
	}
}