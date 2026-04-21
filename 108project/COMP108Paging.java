//
// Coded by Prudence Wong 2021-12-29
// Updated 2023-02-26
// Updated 2024-03-03
// Updated 2025-03-04
// Updated 2026-03-07
//
// NOTE: You are allowed to add additional methods if you need.
//
// Name: Tom Kelly
// Student ID: 201876245
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// evictFIFO():
//
// The algoritm searches through the cache for each entry in the requests array which means that for each of the n requests
// it spends at most O(p) time searching through the cache. The eviction is a simple index swap meaning it does not affect
// the time complexity, therefore the total time complexity is O(np).
//
// evictLFD():
//
// For each of the n requests, the algorithm first searches the cache which takes O(p) time. On a cache miss, the algorithm
// looks ahead through the remaining requests to find the next use, the next instance of a call, for each of the pages currently
// in the cache. This can take up to O(n) time for each slot in the cache, resulting in a time complxity of O(p * n) per miss.
// This means that the total time complexity is O(n^2p), since we take the longest time from O(np + n^2p).
//

class COMP108Paging {


	// evictFIFO
	// Aim: 
	// if a request is not in cache, evict the page present in cache for longest time
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108PagingOutput
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108PagingOutput evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		String hitPattern = "";
		int hitCount = 0;
		int missCount = 0;
		int nextEvict = 0;

		for (int i = 0; i < rSize; i++) {
			boolean found = false;

			for (int j = 0; j < cSize; j++) {
				if (cArray[j] == rArray[i]) {
					found = true;
					break;
				}
			}

			if (found == true) {
                hitCount++;
                hitPattern += "h";
            } else {
                missCount++;
                hitPattern += "m";
                cArray[nextEvict] = rArray[i];
                nextEvict = nextEvict + 1;
            }

		}

		COMP108PagingOutput output = new COMP108PagingOutput();
		output.hitCount = hitCount;
        output.missCount = missCount;
        output.hitPattern = hitPattern;
		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// evictLFD
	// Aim:
	// if a request is not in cache, evict the number whose next request is the latest
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108PagingOutput
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108PagingOutput evictLFD(int[] cArray, int cSize, int[] rArray, int rSize) {
		String hitPattern = "";
		int hitCount = 0;
		int missCount = 0;
		int nextEvict = 0;

		for (int i = 0; i < rSize; i++) {
			int currentRequest = rArray[i];
			int indexEvict = 0;
			int latestNextUse = -1;
			boolean found = false;

			for (int j = 0; j < cSize; j++) {
				if (cArray[j] == rArray[i]) {
					found = true;
					break;
				}
			}

			if (found == true) {
                hitCount++;
                hitPattern += "h";
            } else {
                missCount++;
                hitPattern += "m";

				for (int j = 0; j < cSize; j++) {
					int nextUse = Integer.MAX_VALUE;

					for (int l = i + 1; l < rSize; l++) {
						if (rArray[l] == cArray[j]) {
							nextUse = l;
							break;
						}
					}

					if (nextUse > latestNextUse) {
                        latestNextUse = nextUse;
                        indexEvict = j;
                    }
				}

                cArray[indexEvict] = currentRequest;
            }
		}

		COMP108PagingOutput output = new COMP108PagingOutput();
		output.hitCount = hitCount;
        output.missCount = missCount;
        output.hitPattern = hitPattern;
		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// DO NOT change this method
	// this will turn the cache into a String
	// Only to be used for output, do not use it to manipulate the cache
	static String arrayToString(int[] array, int size) {
		String outString="";
		
		for (int i=0; i<size; i++) {
			outString += array[i];
			outString += ",";
		}
		return outString;
	}

}

