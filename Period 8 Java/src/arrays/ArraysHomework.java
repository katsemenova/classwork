package arrays;

import java.lang.reflect.Array;

public class ArraysHomework {

    public static void main(String[] args) {
        double[] test={13.0,11.4,9.3,7.3,5.3,3.5,1.0,0.2,0.5};
        getStats(test);
        
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
//
//        	int[] arr1={1,2,4,5,2,0,9,6,3,4,3,8,9,97,98}; 
//        	int[]arr2={1,2,9,6,3,4,3,6,7,97,98};
//        	System.out.println(longestSharedSequence(arr1,arr2));

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
            double[] stats = new double[6];
            
            double mean=getMean(array); 
            double max=getMax(array);   
            double min=getMin(array,max);
        	double[] temp= sortArray(array,max);
            double median=getMedian(temp);
            double numMore=getNumberGreaterMean(array, mean);
            double numLess=getNumberLessMean(array, mean);
            
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
    	   double median;
    	   if(array.length%2==1)
    		   median=array[(int) (array.length/2)];
    	   else
    		   median=(array[array.length/2]+array[array.length/2-1])/2;
    	   return median;
		
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

       private static double[] sortArray(double[] arr,double max){
    	   double[] tempArray=new double[arr.length];
    	   double[] copyArr = new double[arr.length];
    	   for(int i=0;i<arr.length;i++){
    		   copyArr[i]=arr[i];
    	   }
    	   tempArray[tempArray.length-1]=max;
    	   int count=0;
    	   while(!allTheSame(copyArr)&&count<tempArray.length-1){
    		   double min= getMin(copyArr,max);
    		   tempArray[count]=min;
    		   int minPos = searchUnsortedDoubles(copyArr,min);
    		   copyArr[minPos]=max;
    		   count++;
    	   }
    	   for(int i=0;i<tempArray.length;i++){
           	System.out.println(tempArray[i]);
           }
    	   return tempArray;
		
       }
       public static int searchUnsortedDoubles(double[] arrayToSearch, double key){
    	   for(int i=0;i<arrayToSearch.length;i++){
    		   if(arrayToSearch[i]==key)
    			   return i;
    	   }
        return -1;
       }
       
       private static boolean allTheSame(double[] arr){
    	   double currentNum=arr[0];
    	   for(int i=1;i<arr.length;i++){
    		   if(arr[i]!=currentNum)
    			   return false;
    		   currentNum=arr[i];
    	   }
    	   return true;
       }


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
            * longestSequence({0, 9,6,3,4,3 ,8,9,a,b}, {1,2, 9,6,3,4,3 ,6,7,a,b}) returns '5', 
            *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter that the sequence begins at different indices 
            * longestSequence({3,9,6,1,4,3,6,7,9}, {4,9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in both arrays and is 3 integers long
            * */
//i=1;
//i=1+5=6;
    	   int max = 0;
           int count = 0;
           
           for(int seqStart=0; seqStart<array1.length; seqStart++){
               //insert a loop here
           	int seqEnd = seqStart;
               int[] seq = getSequence(seqStart, seqEnd, array1);
               if(checkSequence(seq, array2)){
               	count++;
               	if(count>max){
               		max=count;
               	}
               }
               //reset the count to 0 after every seq has been checked
               count = 0;
           }
           
           return max;
       }
       
       //returns true if seq is found inside array2;
       private static boolean checkSequence(int[] seq, int[] arr){
       	// i checks every value in arr
       	A: for(int i=0; i<arr.length; i++){
       		//j checks every element in seq
       		B: for(int j=0; j<seq.length; j++){
           		if(j+i<arr.length && seq[j]!=arr[j+i]){
           			//break out of inner-most 'for loop' unless particular 'for loop' is specified
           			//(labels "A:")
           			break B;
           		}
           		else if(j == seq.length-1){
           			return true;
           		}
           	}
       	}
       	return false;
       }

     //returns a sub-array containing the elements in array1 from seqStart to seqEnd
       private static int[] getSequence(int seqStarts, int seqEnd, int[] arr){
    	   int[] seq = new Array[seqEnd-seqStarts+1];
    	   for(int j=0;j<seq.length;j++){
    	   		for(int i=seqStarts;i<seqEnd+1;i++){
    	   			seq[j]=arr[i];
    	   		}
    	   }
           return seq;
       }
//    	   int tempSequenceLength=0;
//    	   int longestSequence=0;
//           for(int i=0;i<array1.length-1;i++){
//        	   for(int j=0;j<array2.length;j++){
//        		   if(array1[i]==array2[j]){
//        			   tempSequenceLength = countSequence(array1, array2,i,j);
//        			   if(tempSequenceLength>longestSequence)
//        				   longestSequence=tempSequenceLength;
//        			   
//        			   if(array1.length<=i+tempSequenceLength)
//        			      i=array1.length;
//        			   else if(tempSequenceLength>1)
//        				   i=i+tempSequenceLength;
//        			   System.out.println("temp seq length"+tempSequenceLength);
//        			   System.out.println("i is "+i);
//        		   }
//        		 
//        	   }
//           }
//           return longestSequence;
//
//       }
//
//       private static int countSequence(int[] arr1,int[] arr2,int start1, int start2) {
//    	   int sequenceLength=0;
//			int arr1Start = start1;
//			int arr2Start = start2;
//			while (arr1Start<arr1.length-1&&arr2Start<arr2.length-1&&arr1[arr1Start]==arr2[arr2Start]){
//				sequenceLength++;
//				arr1Start++;
//				arr2Start++;
//			}
//		return sequenceLength;
//	}

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
    	   while(n>0){
    		   cycleOnce(array);
    		   n--;
    	   }
       }

		private static void cycleOnce(int[] arr) {
			if(arr.length>1){
				for(int i=1;i<arr.length;i++){
					int index1=i;
					int index2=i-1;
					swap(arr,index1,index2);	
				}
			}
		}
	
		private static void swap(int[] arr,int a,int b) {
	    	int placeholder=arr[b];
	    	arr[b]=arr[a];
			arr[a]=placeholder;
		}
		
}
