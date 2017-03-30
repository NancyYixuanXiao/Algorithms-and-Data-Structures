package leetCodeJava;

public class CopyBooks {

	public static int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int max = 0, total = 0;
        for (int page : pages) {
            if (page > max) {
                max = page;
            }
            total += page;
        }
        int start = max, end = total, mid;
        while (start < end - 1) {
        	mid = start + (end - start) / 2;
        	if (countCopier(pages, mid) <= k) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        if (countCopier(pages, start) <= k) {
        	return start;
        }
        return end;
	}
	private static int countCopier(int[] pages, int limit) {
		if (pages == null || pages.length == 0) {
			return 0;
		}
		int count = 1;
		int tmp = 0;
		for (int page : pages) {
			if (tmp + page > limit) {
				count++;
				tmp = 0;
			}
			tmp += page;
		}
		return count;
	}
}
