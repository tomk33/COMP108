//
// Enter your name: Tom Kelly
// Enter your student ID:201876245
//

/*
	The time complexity for notExists() is O(ij) or O(size1 x size2) because there are two nested for loops which means that
	the time complexity is the product of the number of iterations of each. The time complexity for count() is the same but
	the order of the iteration through the lists is the other way around so technically O(ji) or O(size2 x size1)
*/ 

class COMP108W06 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// Input: array1[] with size1 entries and array2[] with size2 entries
	// print all entries of array1[] that does not exist in array2[]
	static void notExists(int array1[], int size1, int array2[], int size2) {
		for (int i : array1) {
			boolean exists = false;
			for (int j : array2) {
				if (j == i) {
					exists = true;
					break;
				} else continue;
			}
			if (exists == false) {
				System.out.print(i + " ");
			}
		}
	}
		
	// Input: array1[] with size1 entries and array2[] with size2 entries
	// for each entry in array2[], count how many times it appears in array1[]
	static void count(int array1[], int size1, int array2[], int size2) {
		for (int i : array2) {
			int count = 0;
			for (int j : array1) {
				if (j == i) {
					count ++;
				}
			}
			System.out.print(count + " ");
		}
	}

}
