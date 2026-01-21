package com.junit;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {}

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        if(message == null || message.isEmpty()) {
            return "HAPPY";
        }
        if(message.toLowerCase().contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
