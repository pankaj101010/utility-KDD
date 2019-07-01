package utilityData;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCsv {
	@Parameters("browser")
	@Test
	public static void main() throws IOException {
		Readingcsv reader=new Readingcsv("C:\\Users\\PANKAJ\\Desktop\\dummy.csv");
		System.out.println(reader.rowCount());
		System.out.println(reader.coloumnCount());
  for ( Object[] s: reader.getDataFromCSV()) {
	System.out.println(s[0]);
	System.out.println(s[1]);
}
		//System.out.println(reader.getDataFromCSV());
	}
}
