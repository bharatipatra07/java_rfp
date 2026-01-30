package DesignPrinciple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    @Test
    public void givenIncorrectCSVFile_WhenLoaded_ShouldThrowCustomException() {


        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {
            analyser.loadStateCensusData("/Users/bharati/git/java_rfp/DesignPrinciple/IndiaStateCensusData.csv");
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                e.type
            );
        }
    }
}
