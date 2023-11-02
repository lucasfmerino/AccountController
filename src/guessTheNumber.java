import java.util.Random;
import java.util.Scanner;

/**
 * guessTheNumber
 */
public class guessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int secretNumber = new Random().nextInt(100);
        int maxAttempts = 5;
        int checkNumber = 0;

        System.out.println("Descubra qual o número secreto entre 0 e 100.");
        while (maxAttempts > 0) {
            System.out.println("Você tem %d chances".formatted(maxAttempts));
            System.out.println("Dê o seu palpite: ");

            checkNumber = sc.nextInt();

            if (checkNumber == secretNumber) {
                System.out.println("Parabéns!! Você acertou. O número secreto é: " + secretNumber);
                maxAttempts = 0;
            } else if (maxAttempts > 1){
                System.out.println("Não foi desta vez!");
                maxAttempts--;

                // IMPLEMENTAR DICA:
                if (checkNumber > secretNumber && maxAttempts > 0) {
                    System.out.println("O número secreto é MENOR do que %d".formatted(checkNumber));
                } else if (checkNumber < secretNumber && maxAttempts > 0) {
                    System.out.println("O número secreto é MAIOR do que %d".formatted(checkNumber));
                }
            } else {
                System.out.println("Game Over! O número secreto era: " + secretNumber);
                maxAttempts--;
            }
        }

        sc.close();
    }
}