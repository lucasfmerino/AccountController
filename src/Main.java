import java.util.ArrayList;
import java.util.Scanner;

import model.Account;
import model.Client;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean online = true;
        ArrayList<Account> accountsList = new ArrayList<>();

        int accountNumber = 0;
        int agencyNumber = 123;

        while (online) {
            System.out.println(
                    """
                            ***********************************

                            Bem vindo a central de operações!"

                            ***********************************



                                1 - Entrar na conta

                                2 - Cadastrar nova conta


                            Digite a opção dsejada:
                            """);

            String option = sc.nextLine();

            switch (option) {
                case "1":
                    login(sc, accountsList);
                    break;

                case "2":
                    accountsList.add(clientRegister(sc, accountNumber, agencyNumber));
                    accountNumber++;
                    break;

                case "closeAdmin":
                    online = false;
                    System.out.println("Finalizando central de operações ...");
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    break;

                default:
                    System.out.println("Operação inválida");
                    break;
            }
        }

    sc.close();

    }

    public static Account clientRegister(Scanner sc, int accountNumber, int agencyNumber) {
        System.out.println("Informe seu nome:");
        String name = sc.nextLine();

        System.out.println("informe seu CPF: ");
        String document = sc.nextLine();

        String password = "";
        String confirmPassword = "error";
        while (!password.equals(confirmPassword)) {
            System.out.println("Cadastre sua senha: ");
            password = sc.nextLine();

            System.out.println("Confirme sua senha: ");
            confirmPassword = sc.nextLine();
            if (!password.equals(confirmPassword)) {
                System.out.println("Operação inválida. A senhas devem ter o mesmo valor");
            }
        }
        Client newClient = new Client();
        newClient.setName(name);
        newClient.setDocument(document);

        Account newAccount = new Account();
        newAccount.setAccountNumber((1000 + accountNumber));
        newAccount.setAgencyNumber(agencyNumber);
        newAccount.setClient(newClient);
        newAccount.setPassword(password);

        System.out.println("Cadastro realizado com sucesso!");

        return newAccount;
    }

    public static void login(Scanner sc, ArrayList<Account> accountsList) {
        System.out.println("Digite seu nome:");
        String myName = sc.nextLine();
        System.out.println("Digite sua senha:");
        String myPassword = sc.nextLine();

        Account loggedInAccount = null;

        for (Account account : accountsList) {
            if (account.getClient().getName().equals(myName) && account.getPassword().equals(myPassword)) {

                loggedInAccount = account; // Armazenando a conta encontrada
                System.out.println("Login realizado com sucesso!");
                break;
            }
        }

        if (loggedInAccount != null) {
            boolean login = true;

            while (login) {

                System.out.println(
                        """
                                ***********************************

                                Bem vindo a sua conta!

                                Nome: %s
                                Conta: %s
                                Saldo: %.2f

                                ***********************************

                                Operações

                                    1 - Consultar saldo.

                                    2 - Depositar

                                    3 - Transferir

                                    4 - Sair

                                Digite a opção dsejada:
                                """.formatted(
                                loggedInAccount.getClient().getName(),
                                loggedInAccount.getAccountNumber(),
                                loggedInAccount.getBalance()));

                String operation = sc.nextLine();

                switch (operation) {
                    case "1":
                        Double balance = loggedInAccount.getBalance();
                        System.out.println("Saldo: R$ %.2f".formatted(balance));
                        break;

                    case "2":
                        System.out.println("Inserir valor a ser depositado: ");
                        Double deposit = sc.nextDouble();
                        sc.nextLine();
                        loggedInAccount.deposit(deposit);
                        System.out.println("Operação realizada com sucesso");
                        break;

                    case "3":
                        Account recipientAccount = null;

                        System.out.println("Inserir o número da conta do destinatário: ");
                        int recipientAccountNumber = sc.nextInt();
                        sc.nextLine();

                        for (Account recipient : accountsList) {
                            if (recipient.getAccountNumber() == (recipientAccountNumber)) {
                                recipientAccount = recipient;
                                break;
                            }
                        }

                        if (recipientAccount == null) {
                            System.out.println("Não existe uma conta cadastrada com esse número.");
                            break;
                        }

                        System.out.println("Inserir valor da transferência: ");
                        Double transferAmount = sc.nextDouble();
                        sc.nextLine();

                        if (loggedInAccount.getBalance() >= transferAmount) {
                            loggedInAccount.transfer(transferAmount);
                            recipientAccount.deposit(transferAmount);
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                        break;

                    case "4":
                        login = false;
                        break;

                    default:
                        System.out.println("Operação inválida");
                        ;
                        break;
                    
                }
            }
        }
    }
}

