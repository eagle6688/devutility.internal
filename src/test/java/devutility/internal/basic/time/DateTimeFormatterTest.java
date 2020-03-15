package devutility.internal.basic.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(String.format("BASIC_ISO_DATE: %s", DateTimeFormatter.BASIC_ISO_DATE.format(now)));
		System.out.println(String.format("ISO_LOCAL_DATE: %s", DateTimeFormatter.ISO_LOCAL_DATE.format(now)));
		System.out.println(String.format("ISO_LOCAL_TIME: %s", DateTimeFormatter.ISO_LOCAL_TIME.format(now)));
		System.out.println(String.format("ISO_LOCAL_DATE_TIME: %s", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now)));
		System.out.println(String.format("ISO_OFFSET_DATE: %s", DateTimeFormatter.ISO_OFFSET_DATE.format(now)));
		System.out.println(String.format("ISO_OFFSET_TIME: %s", DateTimeFormatter.ISO_OFFSET_TIME.format(now)));
		System.out.println(String.format("ISO_OFFSET_DATE_TIME: %s", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now)));
		System.out.println(String.format("ISO_ZONED_DATE_TIME: %s", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(now)));
		System.out.println(String.format("ISO_INSTANT: %s", DateTimeFormatter.ISO_INSTANT.format(now)));
		System.out.println(String.format("ISO_DATE: %s", DateTimeFormatter.ISO_DATE.format(now)));
		System.out.println(String.format("ISO_TIME: %s", DateTimeFormatter.ISO_TIME.format(now)));
		System.out.println(String.format("ISO_DATE_TIME: %s", DateTimeFormatter.ISO_DATE_TIME.format(now)));
		System.out.println(String.format("ISO_ORDINAL_DATE: %s", DateTimeFormatter.ISO_ORDINAL_DATE.format(now)));
		System.out.println(String.format("ISO_WEEK_DATE: %s", DateTimeFormatter.ISO_WEEK_DATE.format(now)));
		System.out.println(String.format("RFC_1123_DATE_TIME: %s", DateTimeFormatter.RFC_1123_DATE_TIME.format(now)));

		ZonedDateTime beijingOlympics = ZonedDateTime.of(2008, 8, 8, 20, 8, 8, 8, ZoneId.of("Asia/Shanghai"));

		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("G, GGGG, GGGGG");
		System.out.println(beijingOlympics.format(f1));

		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yy, yyyy");
		System.out.println(beijingOlympics.format(f2));

		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("M, MM, MMM, MMMM, MMMMM");
		System.out.println(beijingOlympics.format(f3));

		DateTimeFormatter f4 = DateTimeFormatter.ofPattern("d, dd");
		System.out.println(beijingOlympics.format(f4));

		DateTimeFormatter f5 = DateTimeFormatter.ofPattern("e, E, EEEE, EEEEE");
		System.out.println(beijingOlympics.format(f5));

		DateTimeFormatter f6 = DateTimeFormatter.ofPattern("H, HH");
		System.out.println(beijingOlympics.format(f6));

		DateTimeFormatter f7 = DateTimeFormatter.ofPattern("K, KK");
		System.out.println(beijingOlympics.format(f7));

		DateTimeFormatter f8 = DateTimeFormatter.ofPattern("a");
		System.out.println(beijingOlympics.format(f8));

		DateTimeFormatter f9 = DateTimeFormatter.ofPattern("mm");
		System.out.println(beijingOlympics.format(f9));

		DateTimeFormatter f10 = DateTimeFormatter.ofPattern("ss");
		System.out.println(beijingOlympics.format(f10));

		DateTimeFormatter f11 = DateTimeFormatter.ofPattern("nnnnnn");
		System.out.println(beijingOlympics.format(f11));

		DateTimeFormatter f12 = DateTimeFormatter.ofPattern("VV");
		System.out.println(beijingOlympics.format(f12));

		DateTimeFormatter f13 = DateTimeFormatter.ofPattern("z, zzzz");
		System.out.println(beijingOlympics.format(f13));

		DateTimeFormatter f14 = DateTimeFormatter.ofPattern("x, xx, xxx, XXX");
		System.out.println(beijingOlympics.format(f14));

		DateTimeFormatter f15 = DateTimeFormatter.ofPattern("O, OOOO");
		System.out.println(beijingOlympics.format(f15));
	}
}