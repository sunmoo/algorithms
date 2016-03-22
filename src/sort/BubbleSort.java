package sort;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted, 
 * compares each pair of adjacent items and swaps them if they are in the wrong order.  (From Wiki)
 * Algorithm
 * 1. Compare each pair of adjacent elements from the beginning of an array and, if they are in reversed order, swap them.
 * 2. If at least one swap has been done, repeat step 1.
 * @author Miao
 *
 */
public class BubbleSort {
	/**
	 * Basic bubble sort idea;
	 * @param nums
	 * @return
	 */
	public int[] bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = 1; j < nums.length; j++) {
				if(nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}
			}
		}
		return nums;
	}
	
	public int[] optBubbleSort(int[] nums) {
		boolean swap = false;     //indicates if it has swap 
		int lastIndex = nums.length;    // the index that need to compare.
		
		for(int i = 0; i < nums.length; i++, lastIndex--) {
			if(i > 0 && swap == false) {
				return nums;
			}
			swap = false;
			for(int j = 1; j < lastIndex; j++) {
				if(nums[j] < nums[j - 1]) {
					swap(nums, j, j -1);
					swap = true;
				}
			}
		}
		return nums;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] nums1 = {6,5,4,3};
		int[] nums2 = {6,3,4,5};
		int[] result = sort.optBubbleSort(nums2);
		for(int i : result) {
			System.out.print(i + ",");
		}
	}
}
