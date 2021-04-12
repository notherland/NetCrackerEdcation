import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * class describing a game dice
 */
public class DiceImpl implements Dice {

    /**
     * Scanner for input
     */
    private Scanner in;
    /**
     * array of wins nubmer for every player
     */
    private int[] scorelist;
    /**
     * number pf players and number of dice
     */
    private int n, m;

    /**
     * Constructor without parameters
     */
    public DiceImpl() {
        in = new Scanner(System.in);
        System.out.println("Please input number of players and number of dice");

        n = in.nextInt();
        m = in.nextInt();

        if (n > 0 && m > 0) {
            scorelist = new int[n];
        } else {
            System.out.println("Input is incorrect");
        }
    }

    /**
     * starting a game function
     */
    @Override
    public void start() {
        int lastwinner = 0;
        int maxmumwins = 0;
        int winner = 0;
        System.out.println("Game has started");
        for (int i = 0; maxmumwins < 7; i++) {
            System.out.println("\nRound " + i);
            lastwinner = round(lastwinner);
            scorelist[lastwinner]++;
            if (scorelist[lastwinner] > maxmumwins) {
                maxmumwins = scorelist[lastwinner];
                winner = lastwinner;
            }
            System.out.println(lastwinner + " wins " + i + " round");
            System.out.println("Players results : ");
            System.out.println(Arrays.toString(scorelist));

        }

        System.out.println(winner + " player wins");
    }

    /**
     * function for one round
     *
     * @param lastwinner
     * @return
     */
    private int round(int lastwinner) {
        int winner = 0;
        int winnerscore = 0;
        int player = 0;
        int score = 0;

        System.out.println("Score : ");
        for (int i = 0; i < n; i++) {
            player = (i + lastwinner) % n;
            score = playerTurn(player);
            System.out.println(score);

            if (score > winnerscore) {
                winner = player;
                winnerscore = score;
            }
        }

        return winner;
    }

    /**
     * function for player's turn
     *
     * @param playernum
     * @return
     */
    private int playerTurn(int playernum) {
        System.out.println(playernum + " " + "player turn");
        System.out.println("Press Enter to roll a dice");
        in.nextLine();

        int sum = 0;
        int number;

        for (int i = 0; i < m; i++) {
            number = random();
            sum += number;
        }

        return sum;
    }

    /**
     * function generating random number from 1 to 6
     */
    private int random() {
        Random random = new Random();
        int min = 1;
        int max = 6;
        int diff = max - min;

        return random.nextInt(diff + 1) + min;
    }
}
