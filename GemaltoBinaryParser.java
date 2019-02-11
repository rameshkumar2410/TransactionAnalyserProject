package com.gemalto.binaryparser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class GemaltoBinaryParser {
	
	public static void  convertBinaryToTextFormat(String inFile,String outFile) throws IOException {
	      File inputFile = new File(inFile);
	      File outputFile = new File(outFile);	      
	      int ch;
	      StringBuffer strContent = new StringBuffer("");
	      FileInputStream fin = new FileInputStream(inputFile);
	      int charCnt = 0;
	      int readableCnt = 0;
	      int cutoff = 1000; // for testing, set to -1 for all input.
	      while( (ch = fin.read()) != -1) {
	         ++charCnt;
	         if( cutoff != -1 && charCnt >= cutoff ) {
	            System.out.println("debug: Hit cutoff="+cutoff);
	            break;
	         }
	         char readable = '.'; 
	         if( Character.isLetter(ch)
	         ||  Character.isDigit(ch)
	         ||  Character.isSpaceChar(ch)
	         ) {
	            strContent.append((char)ch);
	            readable = (char)ch;
	            ++readableCnt;
	         } else {
	            int chekStr=ch;
	      	   System.out.printf("checkStr===  : "+ chekStr+"---");
	      	   if(chekStr == 6) {
	      		   strContent.append("{\n"); 
	      	//	   continue;
	      	   }
	      	   if(chekStr == 1) {
	      		 strContent.append(" 1 \n");   
	      	   }
	        	 System.out.printf("looks like non-readable===  : "+ ch);
	         }
	         System.out.printf("%6d: ch=%04d 0x%04x %c\n", charCnt, ch, ch, readable);
	      }
			 strContent.append("\n}");   

	      FileWriter fw = new FileWriter(outputFile);
	      fw.write(strContent.toString());
	      fw.close();
	      fin.close();
	      
	      System.out.println("total chars: "+charCnt);
	      System.out.println("readable chars: "+readableCnt);
	      System.out.println("\n--- BEGIN READABLE STUFF---");
	      System.out.println(strContent);
	      System.out.println("\n--- END BEGIN READABLE STUFF---");
		
	}

   public static void main(String[] args) throws IOException {
	    String inputFile = "C:\\Users\\Ramesh\\Desktop\\Gemalto\\input_3";
	    String outputFile = "C:\\Users\\Ramesh\\Desktop\\Gemalto\\demo2.txt";
	    GemaltoBinaryParser.convertBinaryToTextFormat(inputFile,outputFile);
   }

}