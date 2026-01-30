package DesignPrinciple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

	@Test
	public void givenStateCodeCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount()
	        throws CensusAnalyserException {

	    StateCensusAnalyser analyser = new StateCensusAnalyser();

	    int count = analyser.loadStateCodeData(
	            "/Users/bharati/git/java_rfp/io_streams/DesignPrinciple/IndianStateCode.csv");

	    Assertions.assertEquals(10, count);
	}



}
