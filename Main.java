package com.hoolah.transactionanalyser;

import java.text.DecimalFormat;
class Main {
  private static final String errorString = "Invalid Input meter cannot be less than 0";
  public static void main(String[] args) throws Exception {
    
   DiggingDetails diggingDetails= Main.getDiggingInfo(9.46);
   /* System.out.println("Total no of days mice took for Digging ==== "+diggingDetails.getNoOfDays());
    System.out.println("Total no of Hours === "+diggingDetails.getNoOfHours());
   System.out.println("Total no of mins == "+diggingDetails.getNoOfMins());
   System.out.println("Total no of Secs  ==== "+diggingDetails.getNoOfSecs());*/
   DecimalFormat df = new DecimalFormat("#.##");    
   System.out.println("Number of days needed =="+diggingDetails.getNoOfDays() +" Days  " + diggingDetails.getNoOfHours() +" Hours "+
   diggingDetails.getNoOfMins()  +" Minutes  "+
   diggingDetails.getNoOfSecs()   +" Seconds  "); 
   
   System.out.println("Total No of Meter Digged===  "+df.format(diggingDetails.getTotalMeter()));
   //Slight Variation of Mice total will be there its due to the secs.
   System.out.println("Total  BigMice Digged====  "+df.format(diggingDetails.getBigMiceDigged()));
   
    System.out.println("Total  Small Mice Digged ====  "+df.format(diggingDetails.getSmallMiceDigged()));
    
   System.out.println("Total No of Meter Digged===  "+df.format(diggingDetails.getTotalMeter()));
  }

	public static DiggingDetails getDiggingInfo(double meter) throws Exception {
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
			/*
			 * System.out.println("Small Mice" + sx); System.out.println("Big Mice" + bx);
			 * System.out.println("totalBig " + totalBig); System.out.println("totalSmall "
			 * + totalSmall); System.out.println("TotalMeter " + totalMeter);
			 * System.out.println("Total No of days" + count);
			 * System.out.println("=========================");
			 */
			if (totalMeter * 2 > meter) {
				calBigHrs = (totalBig * 2) / 24;
				calSmallHrs = (totalSmall / 2) / 24;
        	totalBig=totalBig+calBigHrs;
					totalSmall=totalSmall+calSmallHrs;
				/*
				 * calBigMins = calBigHrs / 60; calSmallMins = calSmallHrs / 60;
				 */
				for (int j = 1; j < 24; j++) {
					totalMeter = totalMeter + calBigHrs + calSmallHrs;
					hrs++;
					/*
					 * System.out.println("Total No of hrs" + hrs); System.out.println("TotalMeter "
					 * + totalMeter); System.out.println("meter" + meter);
					 */
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
									totalMeter = totalMeter + calBigSecs;
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
				
			}
			if (!flag) {
				break;
			}

		}

		/*
		 * System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 * System.out.println("totalBig " + calBigHrs/mins);
		 * System.out.println("totalsmall " + calSmallHrs/mins);
		 * System.out.println("totalBig " + calBigHrs*hrs);
		 * System.out.println("totalsmall " + calSmallMins*hrs);
		 * 
		 * System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 * System.out.println("TotalMeter " + totalMeter);
		 * System.out.println("Total No of days" + count);
		 * System.out.println("Total No of hrs" + hrs);
		 * System.out.println("Total No of mins" + mins);
		 * System.out.println("Total No of secs" + secs);
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
    

}