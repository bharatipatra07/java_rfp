package DesignPrinciple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    /**
     * TC1.3
     * Given the State Code CSV file
     * When file type is correct but data format is incorrect
     * Then it should throw INVALID_FILE_FORMAT exception
     */
    @Test
    public void givenCSVFileWithIncorrectType_WhenLoaded_ShouldThrowInvalidFileFormatException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception =
                Assertions.assertThrows(
                        CensusAnalyserException.class,
                        () -> analyser.loadStateCodeData(
                                "/Users/bharati/git/java_rfp/io_streams/DesignPrinciple/IndianStateCode_WrongDelimiter.csv"
                        )
                );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_FILE_FORMAT,
                exception.type
        );
    }
}
