//
// Enter your name: Tom Kely
// Enter your student ID: 201876245
//
class COMP108W05 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// data[] is an array, n is size of array, key is the number we want to find
	static void seqSearch(int[] data, int n, int key) {
		int i, count;
		boolean found;

		// start sequential search on the array called data[]
		found = false;	// to indicate if the number is found
		i = 0;		// an index variable to iterate through the array
		count = 0;	// to count how many comparisons are made
		while (i<n && found==false) {
			if (data[i] == key) {
				found = true;
			} else {
				i = i+1;
			}
			count = count+1;
		}
		System.out.print("The number " + key + " is ");
		if (found == false)
			System.out.print("not ");
		System.out.println("found by sequential search and the number of comparisons used is " + count);
	}

	// data[] is an array in ascending order, n is size of array, key is the number we want to find
	// You can assume that data[] is already sorted
	static void binarySearch(int[] data, int n, int key) {
		int count = 0;
		boolean found = false;
		
		int lower = 0;
		int upper = n - 1;
		
		while (lower <= upper && found == false) {
			count ++;

			int mid = lower + (int) Math.floor((upper - lower) / 2);

			if (data[mid] == key) {
				found = true;
			} else if (data[mid] < key) {
				lower = mid + 1;
			} else if (data[mid] > key) {
				upper = mid - 1;
			}
		}

		System.out.print("The number " + key + " is ");
		if (found == false)
			System.out.print("not ");
		System.out.println("found by binary search and the number of comparisons used is " + count);
		
	}

	// print the smallest number in the array of size n
	static void findMin(int[] data, int n) {
		int i, min;

		min = data[0];
		i = 1;
		while (i < n) {
			if (data[i] < min)
				min = data[i];
			i++;
		}
		System.out.println("The smallest number is " + min + ".");
	}

	// print the largest number in the array of size n
	static void findMax(int[] data, int n) {
		int i = 0, max = data[0];
		
		while (i < n) {
			if (data[i] > max)
				max = data[i];
			i++;
		}
		System.out.println("The largest number is " + max + ".");

	}

	// print the second largest number in the array of size n
	static void findSecondMax(int[] data, int n) {
		int max = 0;
		int second_max = 0;
		
        if (data[0] > data[1]) {
            max = data[0];
            second_max = data[1];
        } else {
            max = data[1];
            second_max = data[0];
        }

        int i = 2; // Set i to 2 because first two elements have been compared and stored as max and second max

        while (i < n) {
            if (data[i] > max) {
                second_max = max;
                max = data[i];
            } else if (data[i] > second_max && data[i] != max) {
                second_max = data[i];
            }
            i++;
        }

		System.out.println("The second largest number is " + second_max + ".");

	}

	
}
