package com.algogrit.java;

public class TennisGame1 implements TennisGame {
    private static Integer WINNABLE_POINT = 3;
    private static Integer ADVANTAGE_POINT = 1;

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    private Boolean isEndGame() {
        return player1.getScore() > WINNABLE_POINT || player2.getScore() > WINNABLE_POINT;
    }

    private Boolean isScoreEven() {
        return player1.getScore() == player2.getScore();
    }

    private Boolean isGamePoint() {
        return isEndGame() && hasAdvantagedPlayer();
    }

    private Boolean hasAdvantagedPlayer() {
        Integer diff = Math.abs(player1.getScore() - player2.getScore());

        return diff == ADVANTAGE_POINT;
    }

    private Player getAdvantagedPlayer() {
        if (player1.getScore() > player2.getScore()) {
            return player1;
        } else {
            return player2;
        }
    }

    private String getEvenScore() {
        if(player1.getScore() < WINNABLE_POINT) {
            return player1.getEnglishScore() + "-All";
        }

        return "Deuce";
    }

    private String getEndGameScore() {
        Player advantagedPlayer = getAdvantagedPlayer();
        if (isGamePoint()) {
            return "Advantage " + advantagedPlayer.getName();
        }

        return "Win for " + advantagedPlayer.getName();
    }

    private String getNormalScore() {
        return player1.getEnglishScore() + "-" + player2.getEnglishScore();
    }

    public String getScore() {
        if(isScoreEven()) {
            return getEvenScore();
        }

        if(isEndGame()) {
            return getEndGameScore();
        }

        return getNormalScore();
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            player1.awardPoint();
        } else {
            player2.awardPoint();
        }
    }
}
