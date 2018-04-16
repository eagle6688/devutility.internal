package devutility.internal.data;

public class PaginationUtils {
	/**
	 * Calculate pages count for given total count and page size.
	 * @param totalCount: Total records count.
	 * @param pageSize: Page size
	 * @return int
	 */
	public static int calculatePagesCount(int totalCount, int pageSize) {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		}

		return totalCount / pageSize + 1;
	}
}