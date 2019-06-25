package utilityData;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCsv {
	@Parameters("browser")
	@Test
	public static void main() throws IOException {
		Readingcsv reader=new Readingcsv("C:\\Users\\PANKAJ\\Desktop\\dummy.csv");
		reader.getDataFromCSV();
	}
}
