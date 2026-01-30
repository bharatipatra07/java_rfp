package DesignPrinciple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    @Test
    public void givenIncorrectCSVFile_WhenLoaded_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {
            analyser.loadStateCensusData("wrong/path/IndiaStateCensusData.csv");
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    e.type
            );
        }
    }
}
