import java.util.Scanner;
import java.text.DecimalFormat;

public class app {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        String nome;
        String tipoConta;
        double saldo = (2500);
        int operacoes;

        String menuConta = ("""
                   \nOpções:
                1- Conta Corrente
                2- Conta Poupança
                3- Conta PJ
                   \nDigite sua opção:""");

        String menuOperacao = ("""
                   \nOperações:
                1- Consultar Saldo
                2- Receber Valor
                3- Transferir Valor
                4- Sair
                \nDigite a operação desejada:
                """);

        System.out.println("\nDigite seu nome: ");
        nome = leitura.nextLine();

        while (true) {
            System.out.println(menuConta);
            int opcoes = leitura.nextInt();
            if (opcoes >= 1 && opcoes <= 3) {
                if (opcoes == 1) {
                    tipoConta = "Corrente";
                } else if (opcoes == 2) {
                    tipoConta = "Poupança";
                } else {
                    tipoConta = "PJ";
                }
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.printf("""
                \n********************************
                \nDados iniciais do cliente:
                Nome:            %s
                Tipo da conta:   %s
                Saldo inicial:   R$ %s
                \n*********************************
                """, nome, tipoConta, df.format(saldo));

        System.out.println(menuOperacao);
        while (true) {
            operacoes = leitura.nextInt();
            if (operacoes == 4) {
                System.out.println("Finalizou a sessão.");
                break;
            } else if (operacoes >= 5) {
                System.out.println(menuOperacao);
            } else if (operacoes == 1) {
                System.out.println("Seu saldo atualizado é: R$ " + df.format(saldo) + "\n" +
                        "Digite 5 para rever o Menu ou 4 para Finalizar!");
            } else if (operacoes == 2) {
                System.out.println("Digite o valor que ira receber:");
                double valorReceber = leitura.nextDouble();
                saldo += valorReceber;
                System.out.println("Seu saldo atualizado é: R$ " + df.format(saldo) + "\n" +
                        "Digite 5 para rever o Menu ou 4 para Finalizar!");
            } else if (operacoes == 3) {
                System.out.println("Digite o valor que quer transferir:");
                double valorTransferir = leitura.nextDouble();
                if (saldo > valorTransferir) {
                    saldo -= valorTransferir;
                    System.out.println("Seu saldo atualizado é: R$ " + df.format(saldo) + "\n" +
                            "Digite 5 para rever o Menu ou 4 para Finalizar!");
                } else if (saldo < valorTransferir) {
                    System.out.println("Seu saldo é insuficiente para essa tranzação.\n" +
                            "Seu saldo é de: R$ " + df.format(saldo) + "\n" +
                            "Digite 5 para rever o Menu ou 4 para Finalizar!");
                }
            }
        }
    }
}

