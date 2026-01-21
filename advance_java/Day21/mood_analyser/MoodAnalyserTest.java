import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    @Test
    void givenAnyMood_ShouldReturnHAPPY() {
        MoodAnalyser analyser = new MoodAnalyser();
        String mood = analyser.analyseMood("I am in Any Mood");
        Assertions.assertEquals("HAPPY", mood);
    }

}
