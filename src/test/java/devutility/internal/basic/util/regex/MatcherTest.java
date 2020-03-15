package devutility.internal.basic.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devutility.internal.data.uri.UriUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MatcherTest extends BaseTest {
	@Override
	public void run() {
		String value = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD";
		Pattern pattern = Pattern.compile(UriUtils.REGEXP_DATAURISCHEME_HEADER);
		Matcher matcher = pattern.matcher(value);

		if (!matcher.find()) {
			println("Not found!");
			return;
		}

		int groupCount = matcher.groupCount();
		println(groupCount);

		for (int i = 0; i < groupCount; i++) {
			println(matcher.group(i));
		}

		println(matcher.group(groupCount));
	}

	public static void main(String[] args) {
		TestExecutor.run(MatcherTest.class);
	}
}