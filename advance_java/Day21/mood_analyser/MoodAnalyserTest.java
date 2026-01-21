import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    @Test
    void givenSadMood_ShouldReturnSAD() {
        MoodAnalyser analyser = new MoodAnalyser();
        String mood = analyser.analyseMood("I am in Sad Mood");
        Assertions.assertEquals("SAD", mood);
    }

}
