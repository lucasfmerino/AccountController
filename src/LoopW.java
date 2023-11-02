import java.util.Scanner;

/**
 * Loop
 */
public class LoopW {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double averageScore = 0;
        double movieReviewScore = 0;
        int totalScores = 0;

        while (movieReviewScore != -1) {

            System.out.println("Digite a uma nota de 0 à 10 para avaliar o filme ou -1 para encerrar o programa.");

            movieReviewScore = scan.nextDouble();

            if (movieReviewScore != -1) {
                averageScore += movieReviewScore;
                totalScores++;
            }
        }

        System.err.println("Movie Average Score :" + (averageScore / totalScores));

        scan.close();
    }
}