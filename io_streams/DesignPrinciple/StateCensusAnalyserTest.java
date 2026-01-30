import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    @Test
    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectCount() throws Exception {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        int count = analyser.loadStateCensusData("/Users/bharati/git/java_rfp/io_streams/DesignPrinciple/IndiaStateCensusData.csv");
        Assertions.assertEquals(10, count);
    }
}
