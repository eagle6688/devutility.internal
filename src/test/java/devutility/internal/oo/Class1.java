package devutility.internal.oo;

public abstract class Class1 implements Face1 {
	@Override
	public void test() {
		display();
		this.display();
	}

	@Override
	public void display() {
		System.err.println("This is Class1");
	}
}