package DesignPrinciple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

	@Test
	public void givenStateCensusCSVFile_WhenDelimiterIncorrect_ShouldThrowCustomException() {

	    StateCensusAnalyser analyser = new StateCensusAnalyser();

	    try {
	        analyser.loadStateCensusData(
	                "/Users/bharati/git/java_rfp/io_streams/DesignPrinciple/IndiaStateCensusData.csv");
	    } catch (CensusAnalyserException e) {
	        Assertions.assertEquals(
	                CensusAnalyserException.ExceptionType.INVALID_DELIMITER,
	                e.type
	        );
	    }
	}

}
