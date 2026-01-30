package DesignPrinciple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    /**
     * TC1.2
     * Given the State Census CSV file
     * If incorrect
     * Then it should return a custom exception
     */
    @Test
    public void givenIncorrectCSVFile_WhenLoaded_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        try {
            analyser.loadStateCodeData(
                    "/Users/bharati/git/java_rfp/io_streams/DesignPrinciple/IndianStateCode.txt"
            );
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    e.type
            );
        }
    }
}
