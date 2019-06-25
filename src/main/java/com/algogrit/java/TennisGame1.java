package com.algogrit.java;

public class TennisGame1 implements TennisGame {
    private static Integer GAME_POINT = 3;
    private static Integer WINNING_LEAD = 2;

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    private Boolean isScoreEven() {
        return player1.getScore() == player2.getScore();
    }

    private Player getPlayerWithLead() {
        return player1.getScore() > player2.getScore() ? player1 : player2;
    }

    private Boolean isEndGame() {
        return getPlayerWithLead().getScore() > GAME_POINT;
    }

    private Boolean hasWinner() {
        Integer diff = Math.abs(player1.getScore() - player2.getScore());

        return diff >= WINNING_LEAD;
    }

    private Boolean isWon() {
        return isEndGame() && hasWinner();
    }

    private String getEvenScore() {
        if(player1.getScore() >= GAME_POINT) {
            return "Deuce";
        }

        return player1.getEnglishScore() + "-All";
    }

    private String getEndGameScore() {
        Player playerWithLead = getPlayerWithLead();
        if (isWon()) {
            return "Win for " + playerWithLead.getName();
        }

        return "Advantage " + playerWithLead.getName();
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

    private Player findPlayerByName(String playerName) {
        return player1.isName(playerName) ? player1 : player2;
    }

    public void wonPoint(String playerName) {
        Player player = findPlayerByName(playerName);

        player.awardPoint();
    }
}
