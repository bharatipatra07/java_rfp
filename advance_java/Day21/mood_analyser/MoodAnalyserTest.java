import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    @Test
    void givenHappyMoodInConstructor_ShouldReturnHAPPY() {
        MoodAnalyser analyser = new MoodAnalyser("I am in Happy Mood");
        Assertions.assertEquals("HAPPY", analyser.analyseMood());
    }
}
