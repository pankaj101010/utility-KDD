package utilityData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class CsvReader {
	public static void main(String[] args) throws IOException {
		try {
		CSVReader csv = new CSVReader(new FileReader("C:\\Users\\PANKAJ\\Desktop\\dummy.csv"));
		 String [] csvCell;
		 while ((csvCell = csv.readNext()) != null) {   
		for (int i = 0; i < csvCell.length-1;) {
		String username = csvCell[i];
		String pass = csvCell[i+1];
		System.out.print("username : "+username +" password : "+pass);
		System.out.println();
		i+=2;
		}

		}
		} catch (FileNotFoundException e) {
		System.err.println("File not found");
		}
		}
}
