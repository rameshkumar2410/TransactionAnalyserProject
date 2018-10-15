package com.hoolah.transactionanalyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Ramesh
 * This Class is for Transaction Management it will get the results of Processed Transaction
 */
public class TransactionManager {

	private static final String CSV_FILE_PATH = "D:\\TransactionAnalyser.csv";

	private static final String csvSplitBy = ",";

	private static SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final String REVERSAL="REVERSAL";

	public static List<TransactionAnalyserBO> getTransactionAnalyserList(String file, String merchant) {
		BufferedReader br = null;
		String line = "";
		List<TransactionAnalyserBO> transactionAnalyserBOList = null;
		List<String> reversalIdList;
		try {
			FileReader fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			transactionAnalyserBOList = new ArrayList<TransactionAnalyserBO>();
			reversalIdList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				TransactionAnalyserBO transactionAnalyserBO = new TransactionAnalyserBO();
				String[] transactionDetails = line.split(csvSplitBy);
				transactionAnalyserBO.setId(transactionDetails[0]);
				transactionAnalyserBO.setTransactionDate(sdf.parse(sdf.format(inSDF.parse(transactionDetails[1]))));
				transactionAnalyserBO.setAmount(Double.valueOf(transactionDetails[2]));
				transactionAnalyserBO.setMerchant(transactionDetails[3].trim());
				transactionAnalyserBO.setType(transactionDetails[4]);
				if (transactionDetails.length > 5) {
					transactionAnalyserBO.setRelatedTransaction(transactionDetails[5]);
				}
				if (transactionAnalyserBO.getMerchant().equals(merchant.trim())) {
					transactionAnalyserBOList.add(transactionAnalyserBO);
					if (transactionAnalyserBO.getRelatedTransaction() != null
							&& transactionAnalyserBO.getRelatedTransaction().length() > 0) {
						reversalIdList.add(transactionAnalyserBO.getRelatedTransaction().trim());
					}
				}
			}
			Iterator<TransactionAnalyserBO> itr = transactionAnalyserBOList.iterator();
			while (itr.hasNext()) {
				TransactionAnalyserBO transactionAnalyserBO = itr.next();
				if (reversalIdList.contains(transactionAnalyserBO.getId())) {
					itr.remove();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return transactionAnalyserBOList;
	}

	public static String getProcessedTransactionList(String fileName, String fromDate, String toDate, String merchant) {

		double sumAmount = 0;
		int numberOfTransactions = 0;
		double averageAmount = 0;
		List<TransactionAnalyserBO> transactionAnalyserBOList = TransactionManager.getTransactionAnalyserList(fileName,
				merchant);
		Date convertedFromDate;
		Date convertedToDate;
		StringBuffer sb = new StringBuffer();
		try {
			convertedFromDate = sdf.parse(sdf.format(inSDF.parse(fromDate)));
			convertedToDate = sdf.parse(sdf.format(inSDF.parse(toDate)));
			for (TransactionAnalyserBO transactionAnalyserBO : transactionAnalyserBOList) {
				if (transactionAnalyserBO.getTransactionDate().after(convertedFromDate)
						&& transactionAnalyserBO.getTransactionDate().before(convertedToDate)) {
					if(!transactionAnalyserBO.getType().trim().equals(REVERSAL)) {
						sumAmount = sumAmount + transactionAnalyserBO.getAmount();
						numberOfTransactions++;
					}
				}
			}
			averageAmount = sumAmount / numberOfTransactions;
			sb.append(numberOfTransactions + "~" + averageAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

	public static void main(String arg[]) {

		String transactionDetail = TransactionManager.getProcessedTransactionList(CSV_FILE_PATH, "20/08/2018 12:00:00",
				"20/08/2018 13:00:00", " Kwik-E-Mart");
		String[] str = transactionDetail.split("~");
		System.out.println("Number of transactions = " + str[0]);
		System.out.println("Average Transaction Value = " + str[1]);

	}
}

