package mood_analyser;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException(
                        MoodAnalysisException.ExceptionType.EMPTY_MOOD,
                        "Mood should not be empty"
                );
            }

            if (message.contains("Sad")) {
                return "SAD";
            }
            return "HAPPY";

        } catch (NullPointerException e) {
            throw new MoodAnalysisException(
                    MoodAnalysisException.ExceptionType.NULL_MOOD,
                    "Mood should not be null"
            );
        }
    }
}
