package DesignPrinciple;
public class CensusAnalyserException extends Exception {

	public enum ExceptionType {
	    CENSUS_FILE_PROBLEM,
	    INVALID_FILE_FORMAT,
	    INVALID_DELIMITER
	}


    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

