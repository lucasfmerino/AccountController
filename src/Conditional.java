public class Conditional {
    public static void main(String[] args) {
        int releaseYear = 2022;
        boolean includedInThePlan = false;
        // double movieReviewScore = 8.1;
        String planType = "plus";

        if (releaseYear >= 2022) {
            System.out.println("Lançamento que os clientes estão curtindo!");
        } else {
            System.out.println("Filme retrô que vale a pena assistir");
        }

        if (includedInThePlan || planType.equals("plus")) {
            System.out.println("Filme liberado");
        } else {
            System.out.println("Para assistir à este filme é necessáio assinar o plano \"PLUS\"");
        }
    }
}
