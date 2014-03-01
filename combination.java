//package avltree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class combination {
	static void combination(int arr[], int size, int index, int data[], int price[],int sum[], int i, HashMap<String, Integer> hm, int limit)
	{
	    if (index == size){
	    	String path="";
	        for (int j=0; j<size; j++){
	            path+=data[j];
	        }
	        if(sum[index-1]<=limit){
	        	hm.put(path,sum[index-1]);
	        }
	        return;
	    }
	 
	    if (i >= arr.length){
	        return;
	    }
	    data[index] = arr[i];
	    if(index-1>=0){
	    	sum[index]=sum[index-1]+price[i];
	    }
	    else{
	    	sum[index]=price[i];
	    }
	    combination(arr, size, index+1, data, price, sum,i+1,hm, limit);
	 
	    combination(arr, size, index, data, price,sum,i+1, hm, limit);
	}
	public static HashMap initialize(){
		int arr[]={1,2,3,4,5,6};
		int price[]={10,20,15,25,30,35};
		/*Random r=new Random();
		for(int i=0;i<1000;i++){
			arr[i]=r.nextInt(1000);
			price[i]=r.nextInt(300);
		}*/
		int size=3;
		int data[]=new int[size];
		int sum[]=new int[size];
		int limit=150;
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		combination(arr,size,0,data,price,sum,0,hm,limit);
		return hm;
	}
	public static void main(String args[]){
		//System.out.println();
		HashMap<String, Integer> hm=initialize();
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.print(key);
		    System.out.println("   :" +value);
		}
		System.out.println();
	}
}

