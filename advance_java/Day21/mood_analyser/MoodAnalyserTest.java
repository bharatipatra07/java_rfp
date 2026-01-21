import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    @Test
    void givenNullMood_ShouldReturnHAPPY() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        Assertions.assertEquals("HAPPY", analyser.analyseMood());
    }
}
