package conta;

import conta.model.Conta;
import conta.util.Cores;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        // Criamos os objetos contas 1 e 2
        Conta c1 = new Conta(1, 123, 1, "Erica Araújo", 30000.0f);
        Conta c2 = new Conta(2, 123, 1, "Dener Cardoso", 50000.0f);

        // Conta da Érica
        c1.visualizar(); // Visualizamos a conta 1
        c1.setSaldo(35000.0f); // Atualizamos o saldo da conta 1
        System.out.println("\n\n" + c1.getSaldo()); // Mostramos o saldo da conta 1
        c1.depositar(10000.0f); // Efetuamos o depósito na conta 1
        c1.visualizar(); // Visualizamos a conta 1

        // Conta do Dener
        c2.visualizar(); // Visualizamos a conta 2
        if (c2.sacar(100000.0f)) // Se verdadeiro então efetuamos o saque na conta 2
            System.out.println(c2.getSaldo()); // Mostramos o saldo da conta 2

        int opcao;

        while (true){

            System.out.println(Cores.TEXT_PURPLE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                BANCO DO BRAZIL COM Z                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                          ");
            System.out.println("            2 - Listar todas as Contas               ");
            System.out.println("            3 - Buscar Conta por Numero              ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada: ");

            opcao = leia.nextInt();

            if (opcao == 9){
                System.out.println("Banco do Brazil com Z - O seu futuro começa aqui!");
                leia.close();
                System.exit(0);
            }

            switch (opcao){
                case 1:
                    System.out.println("Criar conta\n\n");

                    break;

                case 2:
                    System.out.println("Listar todas as contas\n\n");

                    break;

                case 3:
                    System.out.println("Consultar dados da conta - por número\n\n");

                    break;

                case 4:
                    System.out.println("Atualizar dados da conta\n\n");

                    break;

                case 5:
                    System.out.println("Apagar a conta\n\n");

                    break;

                case 6:
                    System.out.println("Saque\n\n");

                    break;

                case 7:
                    System.out.println("Depósito\n\n");

                    break;

                case 8:
                    System.out.println("Transferência entre contas\n\n");

                    break;

                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        }

    }
}
