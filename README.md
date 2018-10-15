# TransactionAnalyserProject
Transaction Analyser Project

I have created a BO class for Tranasaction Analyser, Using that i have written the business logic in TransactionManager class

Steps to Execute the Program
============================

1.Download the com/hoolah/transactionanalyser package from github.(https://github.com/rameshkumar2410/TransactionAnalyserProject)

2.Copy the TransactionAnalyser.csv file to D drive ("D:\\TransactionAnalyser.csv")

3.Run the TransactionManager.Java class and it will give the output.

4.if you want to do different test case, Change the existing input details in 

Main method.

eg:

String transactionDetail = TransactionManager.getProcessedTransactionList(CSV_FILE_PATH, "20/08/2018 12:00:00",
				"20/08/2018 13:00:00", " Kwik-E-Mart");

String transactionDetail = TransactionManager.getProcessedTransactionList(CSV_FILE_PATH, "20/08/2018 12:00:00",
				"20/08/2018 13:00:00", "  MacLaren");

5.I have added few more data in CSV file for testing you can see the TransactionAnalyser.csv file.

6.if you wanted to test with the Original csv file which you shared in mail, Please copy and paste the TransactionAnalyserOriginal.csv file in D drive and change the TransactionManager class file path as well("D:\\TransactionAnalyserOriginal.csv")

Thanks,
Ramesh
