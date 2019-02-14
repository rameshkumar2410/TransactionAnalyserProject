package com.hoolah.transactionanalyser;

import java.text.DecimalFormat;

class DiggingDetails {
	private int noOfDays;
	private int noOfHours;
	private int noOfMins;
	private int noOfSecs;
	private double totalMeter;
	private double bigMiceDigged;
	private double smallMiceDigged;

	public double getBigMiceDigged() {
		return bigMiceDigged;
	}

	public void setBigMiceDigged(double bigMiceDigged) {
		this.bigMiceDigged = bigMiceDigged;
	}

	public double getSmallMiceDigged() {
		return smallMiceDigged;
	}

	public void setSmallMiceDigged(double smallMiceDigged) {
		this.smallMiceDigged = smallMiceDigged;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public int getNoOfMins() {
		return noOfMins;
	}

	public void setNoOfMins(int noOfMins) {
		this.noOfMins = noOfMins;
	}

	public int getNoOfSecs() {
		return noOfSecs;
	}

	public void setNoOfSecs(int noOfSecs) {
		this.noOfSecs = noOfSecs;
	}

	public double getTotalMeter() {
		return totalMeter;
	}

	public void setTotalMeter(double totalMeter) {
		this.totalMeter = totalMeter;
	}

}

public class Solution {
	private static final String errorString = "Invalid Input meter cannot be less than 0";
	public  int SmallValue=0;
	public  int fixedValue;
	     
	public  int solution(int[] array) {
        // write your code in Java SE 8
/*	    for(int i=A.length-1;i>=0;i--){
        	for(int j=0; j<=A.length-1;j++){
                System.out.println("Find valuses === "+A[i]+"======"+A[j]);
            	if(A[i]<A[j]){
                			SmallValue=A[i];
                			fixedValue=SmallValue;
                    }else {
                    	if(SmallValue>A[j]) {
                        	SmallValue=A[j];
                        	  System.out.println("Final SmallValue === "+SmallValue);
                    	}
                    }
            }
        	break;
        }
	   // System.out.println("Final SmallValue === "+fixedValue);
        boolean flag=false;
        for(int j=0; j<=A.length-1;j++){
            if(SmallValue == A[j] && SmallValue+1 !=0){
                flag=true;
                SmallValue++;
                break;
            }      
        }
        return SmallValue;*/
		
	    int min = array[0];
	    int max = array[0];

	    for (int i = 1; i <= array.length - 1; i++) {
	        if (max < array[i]) {
	            max = array[i];
	        }
	        if (min > array[i]) {
	            min = array[i];
	        }
	    }
	     System.out.println("min: " + min + "\nmax: " + max);
	     
	    int positiveValue=0;
	    if(min==2) {
	    	min--;
	    }
	    for (int i = 0; i <= array.length - 1; i++) {
	     if(min == array[i]) {
	    	 min++;
	    	 i=0;
	     }
	     positiveValue=min;
	    }
	    System.out.println("positiveValue" + positiveValue);
		  
	    return min;
    }
	
	public int squareRoot(int a,int b) {
		double d=Math.floor(Math.sqrt(b));
		if(d/Math.sqrt(d)==0) {
			System.out.println("Value "+d);
		}else {
			System.out.println("Not Value "+d);
			squareRoot(a,b-10);
			
		}
		System.out.println("Value of Square"+d*d);
		int count=1;
		if((d*d) > a) {
			while(d >= 4) {
				d=Math.floor(Math.sqrt(d));
				System.out.println("Value of Square2222 === "+d);
				count++;
			}
		}
		
		return count;
	}
	
	public int smallestNumber(int N) {

		String str=String.valueOf(N);
		StringBuffer sb=new StringBuffer();
		int size=str.length();
		if(size == 1) {
			return 0;
		}else {
			if(size > 1) {
				sb.append("1");
				for(int i=0; i<str.length()-1;i++) {
					sb.append("0");
				}
			}
		}
//		sb.append("1");
		System.out.println("Value === "+sb);
		return Integer.valueOf(sb.toString());
	}
	
	public DiggingDetails totalDays(double meter) throws Exception {
		DiggingDetails digDetails = new DiggingDetails();
		double bx = 1;
		double sx = 1;
		double mice = 2;
		double bigM = 1;
		double smallM = 1;
		double totalMeter = 2;
		double count = 1;
		double totalBig = 1;
		double totalSmall = 1;
		double calBigHrs = 0;
		double calSmallHrs = 0;
		double hrs = 0;
		double mins = 0;
		double calBigMins = 0;
		double calSmallMins = 0;
		double calBigSecs = 0;
		double calSmallSecs = 0;
		boolean flag = true;
		double secs = 0;

		if (meter <= 0) {
			throw new Exception(errorString);
		}
		for (double i = 0; i < meter; i++) {

			bigM = bx * mice;
			smallM = sx / mice;
			bx = bigM;
			sx = smallM;
			totalBig = totalBig + bigM;
			totalSmall = totalSmall + smallM;
			totalMeter = totalMeter + bigM + smallM;
			count++;
			
			 System.out.println("Small Mice" + sx); 
			 System.out.println("Big Mice" + bx);
			 System.out.println("totalBig " + totalBig); 
			 System.out.println("totalSmall "+ totalSmall);
			 System.out.println("TotalMeter " + totalMeter);
			 System.out.println("Total No of days" + count);
			 System.out.println("=========================");
			 
			if (totalMeter * 2 > meter) {
				calBigHrs = (totalBig * 2) / 24;
				calSmallHrs = (totalSmall / 2) / 24;
				/*
				 * calBigMins = calBigHrs / 60; calSmallMins = calSmallHrs / 60;
				 */
				for (int j = 1; j < 24; j++) {
					totalMeter = totalMeter + calBigHrs + calSmallHrs;
					totalBig=totalBig+calBigHrs;
					totalSmall=totalSmall+calSmallHrs;
				
					hrs++;
					
					System.out.println("Total No of hrs" + hrs); System.out.println("TotalMeter "
					  + totalMeter); System.out.println("meter" + meter);
					 
					if (totalMeter < meter) {
						for (int k = 1; k < 60; k++) {
							calBigMins = calBigHrs / 60;
							calSmallMins = calSmallHrs / 60;
							totalMeter = totalMeter + calBigMins + calSmallMins;
							totalBig=totalBig+calBigMins;
							totalSmall=totalSmall+calSmallMins;
							mins++;
							if (mins >= 60) {
								mins = 0;
								hrs++;
							}
							if (totalMeter < meter) {
								for (int s = 1; s < 60; s++) {
									calBigSecs = calBigMins / 60;
									calSmallSecs = calSmallMins / 60;
									totalBig=totalBig+calBigSecs;
									totalSmall=totalSmall+calSmallSecs;
									// System.out.println("Total No of calBigSecs" + calBigSecs);
									// System.out.println("Total No of calSmallSecs" + calSmallSecs);
									totalMeter = totalMeter + calBigSecs + calSmallSecs;
									secs++;
									if (secs >= 60) {
										secs = 0;
										mins++;
									}
									if (totalMeter >= meter) {
										flag = false;
										break;
									}
								}
							}
							if (totalMeter >= meter) {
								flag = false;
								break;
							}

						}
					}
					if (totalMeter >= meter) {
						flag = false;
						break;
					}
				}
				
				System.out.println("totalBig inside " + totalBig); 
				 System.out.println("totalSmall "+ totalSmall);
				/*
				 * System.out.println("Total No of TotalMeter" + totalMeter);
				 * System.out.println("Total No of calBigHrs" + calBigHrs);
				 * System.out.println("Total No of calSmallHrs" + calSmallHrs);
				 * System.out.println("Total No of calBigMins" + calBigMins);
				 * System.out.println("Total No of calSmallMins" + calSmallMins);
				 * System.out.println("Total No of hrs" + hrs);
				 * System.out.println("Total No of mins" + mins);
				 * System.out.println("Total No of secs" + secs);
				 */
				
				 System.out.println("Total No of calBigHrs" + calBigHrs);
				 System.out.println("Total No of calSmallHrs" + calSmallHrs);

			}
			if (!flag) {
				break;
			}

		}

		/*
		 * SYSTEM.OUT.PRINTLN("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 * SYSTEM.OUT.PRINTLN("TOTALBIG " + CALBIGHRS/MINS);
		 * SYSTEM.OUT.PRINTLN("TOTALSMALL " + CALSMALLHRS/MINS);
		 * SYSTEM.OUT.PRINTLN("TOTALBIG " + CALBIGHRS*HRS);
		 * SYSTEM.OUT.PRINTLN("TOTALSMALL " + CALSMALLMINS*HRS);
		 * 
		 * SYSTEM.OUT.PRINTLN("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 * SYSTEM.OUT.PRINTLN("TOTALMETER " + TOTALMETER);
		 * SYSTEM.OUT.PRINTLN("TOTAL NO OF DAYS" + COUNT);
		 * SYSTEM.OUT.PRINTLN("TOTAL NO OF HRS" + HRS);
		 * SYSTEM.OUT.PRINTLN("TOTAL NO OF MINS" + MINS);
		 * SYSTEM.OUT.PRINTLN("TOTAL NO OF SECS" + SECS);
		 */
		digDetails.setNoOfDays((int) count);
		digDetails.setNoOfHours((int) hrs);
		digDetails.setNoOfMins((int) mins);
		digDetails.setNoOfSecs((int) secs);
		digDetails.setTotalMeter(totalMeter);
		digDetails.setBigMiceDigged(totalBig);
		digDetails.setSmallMiceDigged(totalSmall);

		return digDetails;
	}
    
    public static void main(String arg[]) throws Exception {
    	Solution s=new Solution();
    	int[] A = {10,12, 3, 63, 4, 20,2, 21,8,9};
    	//System.out.println("Returned Positive integer" +s.solution(A));
    //	System.out.println(s.squareRoot(6000, 7000));
    	//System.out.println(s.smallestNumber(8987));
    	DiggingDetails diggingDetails=s.totalDays(8.45);
    	 System.out.println("Total no of days mice took for Digging ==== "+diggingDetails.getNoOfDays());
    	    System.out.println("Total no of Hours === "+diggingDetails.getNoOfHours());
    	   System.out.println("Total no of mins == "+diggingDetails.getNoOfMins());
    	   System.out.println("Total no of Secs  ==== "+diggingDetails.getNoOfSecs());
    	   DecimalFormat df = new DecimalFormat("#.##");      
    	   System.out.println("Total no of Meter  ====  "+df.format(diggingDetails.getTotalMeter()));
    }
}