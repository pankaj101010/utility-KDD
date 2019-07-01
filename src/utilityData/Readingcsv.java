package utilityData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class Readingcsv {
	public String filePath = "";
	private File file;
	private CSVReader csv;
	private FileReader fr;
	private BufferedReader br;
	private String s;
	int coloumn=0;
	int rows=0;
	public Readingcsv(String filePath) {
		this.filePath = filePath;
		this.file = new File(filePath);
	}
	private void setUpConnection()  {
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
		}
		
	}
	public int rowCount() {
		setUpConnection();
		try {
			while((s=br.readLine())!=null) {
				rows++;
				String[] csvvalues = s.split(",");
				 coloumn=csvvalues.length;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}
	
	public int coloumnCount() {
		return coloumn;
	}
	/*
	public int[] noOfLinesinFile() throws IOException {
		int[] data = new int[2];
		while ((s = br.readLine()) != null) {
			data[0]++;
			String[] csvvalues = s.split(",");
			data[1] = csvvalues.length;
		}
		return data;
	}
	*/

	public Object[][] getDataFromCSV() throws IOException {
		Object[][] data = new Object[][];
		System.out.println(coloumn);
		csv = new CSVReader(fr);
		Object[] csvCell;
		int i = 0;
		while ((csvCell = csv.readNext()) != null) {
			for (; i < data.length;) {
				for (int j = 0; j < csvCell.length; j++) {
					data[i][j] = csvCell[j];
				}
				i++;
				break;
			}
		}
		return data;
	}
}
