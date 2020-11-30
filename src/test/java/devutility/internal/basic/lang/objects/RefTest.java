package devutility.internal.basic.lang.objects;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class RefTest extends BaseTest {
	@Override
	public void run() {
		Box box = new Box();
		BoxItem item = null;
		box.setBoxItem(item);

		item = new BoxItem();
		println(box.getBoxItem() != null ? "Yes" : "No");
	}

	public static void main(String[] args) {
		TestExecutor.run(RefTest.class);
	}

	public static class Box {
		private BoxItem boxItem;

		public BoxItem getBoxItem() {
			return boxItem;
		}

		public void setBoxItem(BoxItem boxItem) {
			this.boxItem = boxItem;
		}
	}

	public static class BoxItem {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}