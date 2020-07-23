package devutility.internal.lang.objectutils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import devutility.internal.lang.ObjectUtils;
import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HashCodeTest extends BaseTest {
	@Override
	public void run() {
		testObject();
		testMap();
		testCollection();
		testArray();

		char ch = 'a';
		println(ObjectUtils.hashCode(ch));

		long lValue = 1000L;
		println(ObjectUtils.hashCode(lValue));
	}

	private void testObject() {
		println("===========Test object==============");
		Member member = Member.get();
		println(ObjectUtils.hashCode(member));
		println(member.hashCode());
		println(Member.get().hashCode());

		Member member1 = new Member();
		member1.setId(1);
		member1.setName("Aldwin");
		member1.setValue("Test");
		member1.setAge(30);
		println(member1.hashCode());

		Member member2 = new Member();
		member2.setId(1);
		member2.setName("Aldwin");
		member2.setValue("Test");
		member2.setAge(30);
		println(member2.hashCode());
	}

	/**
	 * Result shows that map has overwrite hashcode method.
	 */
	private void testMap() {
		println("===========Test Map==============");
		Member member = Member.get();

		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put("asd", member);
		map1.put("qwe", 456);
		System.out.printf("map1 hashcode: %d\n", map1.hashCode());

		Map<String, Object> map2 = new LinkedHashMap<>();
		map2.put("asd", member);
		map2.put("qwe", 456);
		System.out.printf("map2 hashcode: %d\n", map2.hashCode());

		Map<String, Object> map3 = new LinkedHashMap<>();
		map3.put("asd", member);
		map3.put("qwe", "123");
		System.out.printf("map3 hashcode: %d\n", map3.hashCode());
	}

	/**
	 * Result shows that Collection has overwrite hashcode method.
	 */
	private void testCollection() {
		println("===========Test Collection==============");
		Member member = Member.get();

		List<Member> list1 = new LinkedList<>();
		list1.add(member);
		println(list1.hashCode());

		List<Member> list2 = new LinkedList<>();
		list2.add(member);
		println(list2.hashCode());

		List<Member> list3 = new LinkedList<>();
		list3.add(Member.get());
		println(list3.hashCode());
	}

	private void testArray() {
		println("===========Test Array==============");
		String[] array1 = { "123", "asd", "qwe" };
		println(array1.hashCode());
		println(Arrays.hashCode(array1));

		String[] array2 = { "123", "asd", "qwe" };
		println(array2.hashCode());
		println(Arrays.hashCode(array2));

		String[] array3 = { "456", "asd", "qwe" };
		println(array3.hashCode());
		println(Arrays.hashCode(array3));
	}

	public static void main(String[] args) {
		TestExecutor.run(HashCodeTest.class);
	}
}