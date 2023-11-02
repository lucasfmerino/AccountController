import java.util.Scanner;

/**
 * Loop
 */
public class Loop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double averageScore = 0;
        double movieReviewScore = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Qual a sua nota de avaliação para o filme?");
            movieReviewScore = scan.nextDouble();

            averageScore += movieReviewScore;
        }

        System.err.println("Movie Average Score :" + (averageScore/3));

        scan.close();
    }
}