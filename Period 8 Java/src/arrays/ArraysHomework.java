package arrays;

import java.lang.reflect.Array;

public class ArraysHomework {

    public static void main(String[] args) {
//        double[] test={13.0,11.4,9.3,7.3,5.3,3.5,1.0,0.2};
//        System.out.println("test 1 is"+ getStats(test));
//        
//        for(int i=0;i<6;i++){
//        	System.out.println(getStats(test)[i]);
//        }
//        int[] test2={1,6,3};
//        
//        reverseOrder(test2);
//        
//        for(int i=0;i<3;i++){
//        	System.out.println(test2[i]);
//        }
    	int[] array = generateDistinctItemsList(5);
    	for(int i=0;i<array.length;i++){
        	System.out.println(array[i]);
        }
        /**
         * IMPORTANT NOTE: 
         * This homework assignment will be weighted 4x.
         * DO NOT ASSUME my tests are perfect! If you have code that you think should work, 
         * but you keep failing the tests PLEASE bring it to my attention so that I can fix the tests
         * DO NOT spend hours and hours trying to fix perfect code just because my test
         * says that it isn't perfect!
         * */
       }
       
       public static int searchUnsorted(int[] arrayToSearch, int key){
    	   for(int i=0;i<arrayToSearch.length;i++){
    		   if(arrayToSearch[i]==key)
    			   return i;
    	   }
        return -1;
       }
       
       public static int searchSorted(int[] sortedArrayToSearch, int key){
	    	int length=sortedArrayToSearch.length;
	    	if(key<=sortedArrayToSearch[length/2]){
	    		for(int i=sortedArrayToSearch[length/2]-1;i<sortedArrayToSearch.length;i++){
	     		   if(sortedArrayToSearch[i]==key)
	     			   return i;
	     	   	}	
	    	}else if (key>sortedArrayToSearch[length/2]){
	    		for(int i=0;i<sortedArrayToSearch.length/2;i++){
	      		   if(sortedArrayToSearch[i]==key)
	      			   return i;
	      	   	}	
	    	}
	        return -1;
	    }
       
       public static boolean isSorted(int[] array){
    	   boolean inLoop = true;
    	   while(inLoop){
    		   for(int i=1;i< array.length;i++){
    			   if(i+1==array.length)
    				   inLoop=false;
    			   else if((array[i]<=array[i-1]))
    				   inLoop=true;
    			   else 
    				   return false;
    		   }
    	   }
           return true;
       }
       
       
       public static double[] getStats(double[] array){
           /** 
            * This method return a double[] contain a WHOLE BUNCH of stats
            * The double array must keep the following stats about the array parameter:
            * index 0 = the mean
            * index 1 = the max
            * index 2 = the min
            * index 3 = the median
            * index 4 = the number of values greater than or equal to the mean
            * index 5 = the number of values below the mean
            * */
            double[] stats = new double[6];
            
            double mean=getMean(array); 
            double max=getMax(array);   
            double min=getMin(array,max);
            double median=getMedian(array);
            double numMore=getNumberGreaterMean(array, mean);
            double numLess=getNumberLessMean(array, mean);
            double temp= orderArray(array);
            	if(array.length%2==1)
            		median=array[(int) Math.floor(array.length/2)];
            	else
            		median=(array[array.length/2]+array[array.length/2-1])/2;
            
            
            stats[0]=mean;
            stats[1]=max;
            stats[2]=min;
            stats[3]=median;
            stats[4]=numMore;
            stats[5]=numLess;
            return stats;
       }
       
       
       private static double getNumberLessMean(double[] array, double mean) {
    	   double numLess=0.0;
           for(double n:array){
           		if(n<mean)
           			numLess++;
           }
           return numLess;
	}

	private static double getNumberGreaterMean(double[] array, double mean) {
		double numMore=0.0;
        for(double n:array){
        	if(n>=mean)
        		numMore++;
        }
        return numMore;
	}

	private static double getMax(double[] array) {
    	   double max=0.0;
           for(double n:array){
        	   if(n>max)
        		   max=n;
           }
           return max;
		
       }

       private static double getMedian(double[] array) {
		return 0;
		// TODO Auto-generated method stub
		
       }

       private static double getMin(double[] array, double maxVal) {
		
    	   double min=maxVal;
    	   for(double n:array){
    		   if(n<min)
    			   min=n;
    	   }
    	   return min;
       }

       private static double getMean(double[] array) {
    	   double sum=0.0;
           for(double v:array){
           		sum=sum+v;
           }
           double mean=sum/array.length; 
		return mean;
    	   
		
       }

	private static double orderArray(double[] arr) {
    	   
		return 0;
	}

	private static void swap(double[] arr,int a,int b) {
    	double placeholder=arr[b];
    	arr[b]=arr[a];
		arr[a]=placeholder;
       }

	/////end of get stats
	
	////
	////
	public static void reverseOrder(int[] array){
    	   int tempArray[] =new int[array.length];
    	   for(int i=0;i<array.length;i++){
    		   tempArray[i]=array[array.length-i-1];
    	   }for(int i=0;i<array.length;i++){
              	array[i]=tempArray[i];
           }
    	   
       }
       
       public static int countDifferences(int[] array1, int[] array2){
      	   	int differenceCount=0;
    	   	for(int i=0;i<array1.length;i++){
    	   		if(!(array1[i]==array2[i]))
    	   			differenceCount++;
    	   	}
            return differenceCount;
       }
       

       public static int longestConsecutiveSequence(int[] array1){
           /**This method counts the longest consequtive sequence in an array.
            * It does not matter where the sequence begins
            * If there are no consecutive numbers, the method should return '1'
            * 
            * Examples:
            * longestSequence({1,2,3,4,5,8,9}) returns '5', since the sequence '1,2,3,4,5' is 5 integers long 
            * longestSequence({0,9,10,11,4,3,8,9}) returns '3', since '9,10,11' is 3 integers long
            * longestSequence({0,9,8,11,4,3,7,9}) returns '1', since there are no consecutive integers
            * */
           int sequence=1;
           int longestSequence = 1;
           for(int i=0;i<array1.length-1;i++){
        	   int currentNum =array1[i];
        	   int nextNum=array1[i+1];
        	   if((currentNum-nextNum)==-11)
        		   sequence++;
        	   else{
        		   if(sequence>=longestSequence)
        			   longestSequence=sequence;
        		   sequence=1;
        	   }
           }
        	   
           return longestSequence;
       }

       public static int longestSharedSequence(int[] array1, int[] array2){
           /**This method counts the longest unbroken, shared sequence in TWO arrays.
            * The sequence does NOT have to be a consecutive sequence
            * It does NOT matter where the sequence begins, the arrays might not be the same length
            * 
            * Examples:
            * longestSequence({9,6,3,4,3,8,9}, {9,6,3,4,3,6,7}) returns '5', since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long 
            * longestSequence({0,9,6,3,4,3,8,9}, {1,2,9,6,3,4,3,6,7}) returns '5', 
            *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter that the sequence begins at different indices 
            * longestSequence({9,6,1,4,3,6,7,9}, {9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in both arrays and is 3 integers long
            * */
    	   int currentSequence=0;
           int longestSequence=0;
         
           return 0;
       }
       private static int[] startIndexOfSequence(int[] array1, int[] array2, int startArray1,int startArray2){
    	  
    	   for(int i=startArray1;i<array1.length;i++){
        	   for(int j=startArray2;j<array2.length;j++){
        		   if(array1[i]==array2[j]){
        			   int[] tempArray={i,j};
        			   return tempArray;
        		   }
        	   }
           }
    	   int[] tempArray={0,0};
    	   return tempArray;
       }

       public static int[] generateDistinctItemsList(int n){
           
    	   int[] array= new int[n];
    	   for(int i=0;i<n;i++){
    		   int num=(int) (Math.random()*(2*n));
    		   
    		   while(repeats(array,num)){
    			   num=(int) (Math.random()*(2*n));
    		   }
    		   array[i]=num;
    	   }
           return array; 
       }
       private static boolean repeats(int[] array, int n){
    	   for(int num:array){
    		   if(n==num)
    			   return true;
    	   }
    	   return false;
       }
       
       
       public static void cycleThrough(int[] array, int n){
           /** This problem represents people moving through a line.
            * Once they get to the front of the line, they get what they've been waiting for, then they 
            * immediately go to the end of the line and "cycle through" again.
            * 
            * This method reorders the array so that it represents what the array would look like
            * after it had been cycled through an n number of times.
            * For example, cycleThrough({2,1,5,6}}, 1) after executing, array == {1,5,6,2} 
            * because '2' (the person at the front of the line) cycled through and is now at the end of the line
            * 
            * cycleThrough({3,7,4,2,8,6,2,9}}, 2) after executing, array == {4,2,8,6,2,9,3,7} 
            * because '3' and '7' (the TWO people at the front of the line) cycled through and are now at the end of the line
            * 
            * Likewise,
            * cycleThrough({3,7,4,2,8,6,2,9}}, 0) after executing, array == {3,7,4,2,8,6,2,9}  (no movement)
            * and the most interesting case, 
            * cycleThrough({3,7,4,2,8,6,2,9}}, 49) after executing, array == {7,4,2,8,6,2,9,3}  
            * Because after cycling through 49 times, everyone had a chance to go through 6 times, but '3'
            * was able to go through one more time than anyone else
            * 
            * CHALLENGE
            * For extra credit, make your method handle NEGATIVE n
            * */
       }
       
}
