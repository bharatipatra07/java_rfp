package mood_analyser;

public class MoodAnalysisException extends Exception {

    enum ExceptionType {
        NULL_MOOD,
        EMPTY_MOOD
    }

    ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
