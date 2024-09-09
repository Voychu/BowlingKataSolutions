import org.example.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTests {

    @Test
    public void gameCorrectlyCountsWithDigitsStrikesAndSparesAndNulls(){

        String[] scores = {"32", "5/", "16", "--", "43", "22", "71", "51", "--", "13"};
        Game game = new Game(scores);
        int score = game.getTotalScore();


        String[] scores2 = {"3/", "5/", "16", "--", "43", "22", "71", "51", "--", "13"};
        Game game2 = new Game(scores2);
        int score2 = game2.getTotalScore();

        String[] scores3 = {"5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/5"};
        Game game3 = new Game(scores3);
        int score3 = game3.getTotalScore();


        String[] scores4 = {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"};
        Game game4 = new Game(scores4);
        int score4 = game4.getTotalScore();

        String[] scores5 = {"9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-" };
        Game game5 = new Game(scores5);
        int score5 = game5.getTotalScore();

        assertNotNull(game);
        assertEquals(score,52);

        assertNotNull(game2);
        assertEquals(score2,62);

        assertNotNull(game3);
        assertEquals(score3,150);

        assertNotNull(game4);
        assertEquals(score4,300);

        assertNotNull(game5);
        assertEquals(score5,90);


    }
}
