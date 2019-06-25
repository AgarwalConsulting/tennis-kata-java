package com.algogrit.java;

import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private Integer score = 0;

    public static List<String> scoreEnglishNames = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean isName(String name) {
        return this.name.equals(name);
    }

    public Integer getScore() {
        return score;
    }

    public void awardPoint() {
        this.score += 1;
    }

    public String getEnglishScore() {
        return scoreEnglishNames.get(score);
    }
}
