package sort;
/**
 * The insertion sort, although still O(n2), works in a slightly different way. 
 * It always maintains a sorted sublist in the lower positions of the list. 
 * Each new item is then “inserted” back into the previous sublist such that the sorted sublist is one item larger.
 * @author miao
 *
 */
public class InsertionSort {

	public int[] insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int tmp = nums[i];
			int j = i;
			while(j > 0 && (nums[j - 1] > tmp)) {
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = tmp;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] nums1 = {6,5,4,3};
		int[] nums2 = {6,3,4,5};
		int[] result = sort.insertionSort(nums2);
		for(int i : result) {
			System.out.print(i + ",");
		}
	}

}
