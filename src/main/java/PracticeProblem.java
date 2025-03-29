public class PracticeProblem {

	public static void main(String args[]) {
		double[] numbers = {155.2, 155.1, 1, 5, 3, 2, 7, 8};
		int[] swaps = selectionSort(numbers);
		System.out.println(swaps[0]);

		double [] numbs = {155.2, 155.1, 1, 5, 3, 2, 7};
		int[] swas = insertionSort(numbs);
		System.out.println(swas[0]);
	}

	public static int[] bubbleSort(double[] nums){
		boolean swapped = true;
		int swaps = 0;
		int steps = 0;
		for(int i = 0; i < nums.length; i++){
			swapped = false;
			for(int j = 0; j < nums.length - i - 1; j++){
				if(nums[j] > nums[j+1]){
					double temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					swapped = true;
					swaps += 3;
				}
				steps++;
			}
			if(!swapped){
				i = nums.length;
			}
		}

		return new int[]{swaps, steps};
	}

	public static int[] selectionSort(double[] nums){
		int swaps = 0;
		int steps = 0;
		for(int i = 0; i < nums.length - 1; i++){
			int smallest = i;
			// swaps++;
			for(int j = i+1; j < nums.length ; j++){
				if(nums[j] < nums[smallest]){
					smallest = j;
					swaps++;
				}
				steps++;
			}
			double temp = nums[smallest];
			nums[smallest] = nums[i];
			nums[i] = temp;
			swaps += 3;
		}
		return new int[]{swaps, steps};
	}

	public static int[] insertionSort(double[] nums){
		int swaps = 0;
		int steps = 0;
		for(int i = 1; i < nums.length; i++){
			double key = nums[i];
			int index = i - 1;
			swaps++;
			while(index >= 0 && key < nums[index]){
				nums[index + 1] = nums[index];
				swaps++;
				steps++;
				index--;
			}
			nums[index + 1] = key;
			swaps++;
		}
		return new int[]{swaps, steps};
	}

	public static String leastSwaps(double[] nums){
		double[] nums2 = new double[nums.length];
		double[] nums3 = new double[nums.length];

		for(int i = 0; i < nums.length; i++){
			nums2[i] = nums[i];
			nums3[i] = nums[i];
		}

		int[] bubble = bubbleSort(nums);
		int[] selection = selectionSort(nums2);
		int[] insertion = insertionSort(nums3);

		if(bubble[0] <= selection[0] && bubble[0] <= insertion[0]){
			return "Bubble";
		}
		else if(insertion[0] <= selection[0] && insertion[0] < bubble[0]){
			return "Insertion";
		}
		else{
			return "Selection";
		}
	}

	public static String leastIterations(double[] nums){
		double[] nums2 = new double[nums.length];
		double[] nums3 = new double[nums.length];

		for(int i = 0; i < nums.length; i++){
			nums2[i] = nums[i];
			nums3[i] = nums[i];
		}

		int[] bubble = bubbleSort(nums);
		int[] selection = selectionSort(nums2);
		int[] insertion = insertionSort(nums3);

		if(bubble[1] <= selection[1] && bubble[1] <= insertion[1]){
			return "Bubble";
		}
		else if(insertion[1] <= selection[1] && insertion[1] < bubble[1]){
			return "Insertion";
		}
		else{
			return "Selection";
		}
	}
	
}
