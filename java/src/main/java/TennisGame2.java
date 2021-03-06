public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String convertSrt(int score) {
        if (score == 1)
            return "Fifteen";
        if (score == 2)
            return "Thirty";
        if (score == 3)
            return "Forty";
        return "Love";
    }

    public String getScore() {
        String score1 = convertSrt (P1point);
        String score2 = convertSrt (P2point);
        String score = "";
        if (P1point == P2point && P1point < 4) {
            score = String.format ("%s-All", score1);
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            score = String.format ("%s-%s", score1, score2);
        }
        if (P2point > 0 && P1point == 0) {
            score = String.format ("%s-%s", score1, score2);
        }

        if (P1point > P2point && P1point < 4) {
            score = String.format ("%s-%s", score1, score2);
        }
        if (P2point > P1point && P2point < 4) {
            score = String.format ("%s-%s", score1, score2);
        }

        if (P1point > P2point && P2point >= 3) {
            score = String.format ("Advantage %s", player1Name);
        }

        if (P2point > P1point && P1point >= 3) {
            score = String.format ("Advantage %s", player2Name);
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = String.format ("Win for %s", player1Name);
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = String.format ("Win for %s", player2Name);
        }
        return score;
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            P1Score ();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            P2Score ();
        }
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            P1Score ();
        else
            P2Score ();
    }
}