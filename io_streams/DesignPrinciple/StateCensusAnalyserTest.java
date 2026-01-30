package DesignPrinciple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

	@Test
	public void givenStateCensusCSVFile_WhenHeaderIncorrect_ShouldThrowCustomException() {

	    StateCensusAnalyser analyser = new StateCensusAnalyser();

	    try {
	        analyser.loadStateCensusData(
	                "src/test/resources/IndiaStateCensusData_WrongHeader.csv");
	    } catch (CensusAnalyserException e) {
	        Assertions.assertEquals(
	                CensusAnalyserException.ExceptionType.INVALID_HEADER,
	                e.type
	        );
	    }
	}


}
