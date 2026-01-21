package com.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyserTest {

    @Test
    public void givenSadMessage_ShouldReturnSAD() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am feeling sad today");
        String result=moodAnalyser.analyseMood();
        assertEquals("SAD",result);
    }

    @Test
    public void givenHappyMessage_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am feeling happy!");
        String result=moodAnalyser.analyseMood();
        assertEquals("HAPPY", result);
    }

    @Test
    public void givenNullMessage_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String result=moodAnalyser.analyseMood();
        assertEquals("HAPPY", result);
    }
}
