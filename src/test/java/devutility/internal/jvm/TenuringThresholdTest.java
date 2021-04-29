package devutility.internal.jvm;

/**
 * 
 * TenuringThresholdTest
 * <p>
 * -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -Xloggc:gc.log
 * </p>
 * 
 * @author: Aldwin
 * @creation: 2021-04-23 22:06:39
 */
public class TenuringThresholdTest {
	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3;
		System.out.println("1st allocation");
		allocation1 = new byte[_1MB / 4];

		System.out.println("2st allocation");
		allocation2 = new byte[4 * _1MB];

		System.out.println("3st allocation");
		allocation3 = new byte[4 * _1MB];

		System.out.println("4st allocation");
		allocation3 = null;

		System.out.println("5st allocation");
		allocation3 = new byte[4 * _1MB];
		System.out.println("Finished!");
	}
}