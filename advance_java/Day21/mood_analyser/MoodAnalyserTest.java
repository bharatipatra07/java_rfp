import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    @Test
    void givenSadMoodInConstructor_ShouldReturnSAD() {
        MoodAnalyser analyser = new MoodAnalyser("I am in Sad Mood");
        Assertions.assertEquals("SAD", analyser.analyseMood());
    }

}
