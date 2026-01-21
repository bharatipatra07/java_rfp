package mood_analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoodAnalyserTest {

    // TC 3.1
    @Test
    void givenNullMood_ShouldThrowMoodAnalysisException() {
        MoodAnalyser analyser = new MoodAnalyser(null);

        MoodAnalysisException exception =
                Assertions.assertThrows(
                        MoodAnalysisException.class,
                        analyser::analyseMood
                );

        Assertions.assertEquals(
                MoodAnalysisException.ExceptionType.NULL_MOOD,
                exception.type
        );
    }

    // TC 3.2
    @Test
    void givenEmptyMood_ShouldThrowMoodAnalysisException() {
        MoodAnalyser analyser = new MoodAnalyser("");

        MoodAnalysisException exception =
                Assertions.assertThrows(
                        MoodAnalysisException.class,
                        analyser::analyseMood
                );

        AssertionError.assertEquals(
                MoodAnalysisException.ExceptionType.EMPTY_MOOD,
                exception.type
        );
    }
}
