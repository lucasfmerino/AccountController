public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");

        int releaseYear = 2022;
        System.out.println("Ano de lançamento: " + releaseYear);

        boolean includedInThePlan = true;
        System.out.println(includedInThePlan);

        double filmReviewScore = 8.1;
        System.out.println(filmReviewScore);

        //Média aritimética de 3 notas
        double avarageScore = (9.8 + 6.3 + 8.0) / 3;
        System.out.println(avarageScore);

        String sinopse;
        sinopse = 
                """ 
                Filme de aventura dos anos 80!

                Um herói ...

                ... muita ação
                    
                """;

        System.out.println(sinopse);

        int classification = (int) (avarageScore / 2);
        System.out.println(classification);

        int tempCelsius = 32;
        System.out.println(tempCelsius);

        int tempFahernheit = (int) (tempCelsius * 1.8) + 32;
        System.out.println(tempFahernheit);

    }
}
