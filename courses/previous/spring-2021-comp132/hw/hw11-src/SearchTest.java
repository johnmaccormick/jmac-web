import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	private boolean contains(int[] arr, int target) {
		for (int i : arr) {
			if (i==target) {
				return true;
			}
		}
		return false;
	}
	
	private String a2str(int[] arr) {
		StringBuilder s = new StringBuilder();
		s.append('{');
		for (int i : arr) {
			s.append(Integer.toString(i));
			s.append(',');
		}
		if (s.length()>1) {
			s.deleteCharAt(s.length()-1); // remove trailing comma
		}
		s.append('}');
		return s.toString();
	}
	
	@Test
	void testBinarySearch() {
		int[] arr1 = {};
		int[] arr2 = {1};
		int[] arr3 = {1,5};
		int[] arr4 = {1,5,6};
		int[] arr5 = {5,5,5};
		int[] arr6 = {1,2,3,4,5};
		int[] arr7 = {1,2,3,4,4,4,4,4,4,4,5};
		int[] arr8 = {5,6,7,8,9};
		int[][] arrays = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
		
		for (int[] arr : arrays) {
			String arrStr = a2str(arr);
			for (int target = 0; target < 10; target++) {
				int index = Search.binarySearch(arr, target);
				String msg = arrStr + " target " + target + ", index " + index;
				if (index==-1) {
					assertFalse(contains(arr, target), msg);
				} else {
					assertTrue(arr[index]==target, msg);
				}
			}
		}
	}

}
