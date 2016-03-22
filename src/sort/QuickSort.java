package sort;
/**
 * Quicksort is a fast sorting algorithm, which is used not only for educational purposes, but widely applied in practice. 
 * On the average, it has O(n log n) complexity, making quicksort suitable for sorting big data volumes. 
 * 
 * Algorithm
 * The divide-and-conquer strategy is used in quicksort. Below the recursion step is described:
 * 1. Choose a pivot value. We take the value of the middle element as pivot value, 
 * but it can be any value, which is in range of sorted values, even if it doesn't present in the array.
 * 2. Partition. Rearrange elements in such a way, that all elements which are lesser than the pivot go to the left 
 * part of the array and all elements greater than the pivot, go to the right part of the array. 
 * Values equal to the pivot can stay in any part of the array. Notice, that array may be divided in non-equal parts.
 * 3. Sort both parts. Apply quicksort algorithm recursively to the left and the right parts.
 * @author miao
 *
 */
public class QuickSort {

	/**
	 * Function: quicksort
	 * @param nums
	 * @return
	 */
	public int[] quickSort(int[] nums) {
		if(nums == null) {
			return nums;
		}
		quickSorter(nums, 0, nums.length - 1);
		return nums;
	}
	
	/**
	 * Helper function, use recursion. 
	 * @param nums
	 * @param left
	 * @param right
	 */
	public void quickSorter(int[] nums, int left, int right) {
		int index = partition(nums, left, right);
		if(left < index - 1) {
			quickSorter(nums, left, index - 1);
		}
		//Notice: for right part, it starts from index to sort;
		if(right > index) {
			quickSorter(nums, index, right);
		}
	}

	/**
	 * Left part of pivot are numbers less than pivot; Right part are numbers larger than pivot. 
	 * @param nums
	 * @param left
	 * @param right
	 */
	public int partition(int[] nums, int left, int right) {
		int i = left, j = right;
		int pivot = nums[(left + right) / 2];
		while(i < j) {
			//To determine: here should be i <= j or just i < j
			while(nums[i] < pivot) {
					i++;
			}
			while(nums[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}
		return i;		
	}
	
	/**
	 * Helper function
	 * @param nums
	 * @param left
	 * @param right
	 */
	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] nums1 = {6,5,4,3};
		int[] nums2 = {6,3,4,5};
		int[] result = sort.quickSort(nums2);
		for(int i : result) {
			System.out.print(i + ",");
		}
	}

}
