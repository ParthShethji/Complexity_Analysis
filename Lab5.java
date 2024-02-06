import java.util.Random;

public class Lab5{

        public int majorityElement(int[] nums) {
        int count = 0, maxEl = nums[0];   
    
            for (int i = 0; i < nums.length; i++) 
            {
                if (count == 0) 
                {
                    maxEl = nums[i];
                    count++;
                } 
                else if (maxEl == nums[i]) 
                {
                    count++;
                } 
                else 
                {
                    count--;
                }
            }   
            return maxEl;
        }


    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (true) {
            int pivot_index = left + rand.nextInt(right - left + 1);
            int new_pivot_index = partition(nums, left, right, pivot_index);
            if (new_pivot_index == nums.length - k) {
                return nums[new_pivot_index];
            } else if (new_pivot_index > nums.length - k) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Lab5 lab = new Lab5();

        // Example for majorityElement
        int[] nums1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int majorityElementResult = lab.majorityElement(nums1);
        System.out.println("Majority Element: " + majorityElementResult);

        // Example for findKthLargest
        int[] nums2 = {3, 1, 4, 4, 2, 2, 3, 5, 3, 5, 5, 1};
        int k = 3; // Replace with the desired value of k
        int kthLargestResult = lab.findKthLargest(nums2, k);
        System.out.println("K-th Largest Element: " + kthLargestResult);
    }
}