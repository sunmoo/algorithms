package sort;
/**
 * Algorithm
 * The idea of algorithm is quite simple. Array is imaginary divided into two parts - sorted one and unsorted one.
 * At the beginning, sorted part is empty, while unsorted one contains whole array. 
 * At every step, algorithm finds minimal element in the unsorted part and adds it to the end of the sorted one. 
 * When unsorted part becomes empty, algorithm stops.
 * @author miao
 *
 */
public class SelectionSort {
	
	public int[] selectionSort(int[] nums) {
		int minIndex = 0;
		int minEle = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			minEle = nums[i];
			minIndex = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < minEle) {
					minEle = nums[j];
					minIndex = j;
				}
			}
			nums[minIndex] = nums[i];
			nums[i] = minEle;
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort sort = new SelectionSort();
		int[] nums1 = {3};
		int[] nums2 = {6,3,4,5};
		int[] result = sort.selectionSort(nums1);
		for(int i : result) {
			System.out.print(i + ",");
		}
	}

}
