import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    @Test
    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() throws Exception {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        int numberOfRecords =
                analyser.loadStateCensusData("src/test/resources/IndiaStateCensusData.csv");

        Assertions.assertEquals(10, numberOfRecords);
    }
}
