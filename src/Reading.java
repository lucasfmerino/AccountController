import java.util.Scanner;

/**
 * Reading
 */
public class Reading {

    public static void main(String[] args) {
        Scanner readScanner = new Scanner(System.in);

        System.out.println("Digite seu filme vaforito: ");
        String movie = readScanner.nextLine();

        System.out.println("Qual o ano de lançamento do filme?");
        int releaseYear = readScanner.nextInt();

        System.out.println("Qual a sua avaliação para o filme (0 a 10.0)?");
        double movieReviewScore = readScanner.nextDouble();

        // IMPRIMINDO OS RESULTADOS
        System.out.println(movie);
        System.out.println(releaseYear);
        System.out.println(movieReviewScore);

        // FECHANDO O SCANNER
        readScanner.close();
    }
}