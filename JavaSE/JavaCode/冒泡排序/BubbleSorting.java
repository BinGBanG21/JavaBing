/*冒泡排序




*/


 
 public class BubbleSorting {
 	public class void main (String[] args) {
 		int[] arr = { 24, 69, 80, 57, 13, -1, 30, 200, -110 };
 		for ( int i = 0; i < arr.length ; i++ ) {
 			for ( int j = i ; j < arr.length - 1 -i ; j++ ) {
 				if ( arr[j] < arr[j + 1]) {
 					int temp = arr[j+1]
 					arr[j + 1] = arr[j]
 					arr[j] = temp
 				}
 			}
 		}
 	}	
 }