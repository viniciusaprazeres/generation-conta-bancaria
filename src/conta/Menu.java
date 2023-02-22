package conta;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import conta.util.Cores;

import java.io.IOException;
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


        // Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Vinicius", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
        cc1.sacar(8900.0f);
        cc1.visualizar();


        // Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

        int opcao, numero, numeroDestino, agencia, tipo, aniversario;
        float saldo, limite, valor;
        String titular;

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
                    
                    System.out.println("Número da agência: ");
                    agencia = leia.nextInt();

                    System.out.println("Nome do titular: ");
                    leia.skip("\\R?");
                    titular = leia.nextLine();
                    
                    do {
                        System.out.println("Tipo da conta (1-CC / 2-CP): ");
                        tipo = leia.nextInt();
                    } while(tipo < 1 && tipo > 2);

                    System.out.println("Saldo da conta: ");
                    saldo = leia.nextFloat();
                    

                    switch(tipo){
                        case 1 -> {
                            System.out.println("Limite da conta corrente: ");
                            limite = leia.nextFloat();
                            ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
                            cc.visualizar();
                        }
                        case 2 -> {
                            System.out.println("Aniversário da conta poupança: ");
                            aniversario = leia.nextInt();
                            ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
                            cp.visualizar();
                        }
                    }

                    keyPress();
                    break;

                case 2:
                    System.out.println("Listar todas as contas\n\n");

                    keyPress();
                    break;

                case 3:
                    System.out.println("Consultar dados da conta - por número\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    keyPress();
                    break;

                case 4:
                    System.out.println("Atualizar dados da conta\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    System.out.println("Número da agência: ");
                    agencia = leia.nextInt();

                    System.out.println("Nome do titular: ");
                    leia.skip("\\R?");
                    titular = leia.nextLine();
                    
                    // Busca do tipo
                    tipo = 0;

                    System.out.println("Saldo da conta: ");
                    saldo = leia.nextFloat();
                    

                    switch(tipo){
                        case 1 -> {
                            System.out.println("Limite da conta corrente: ");
                            limite = leia.nextFloat();
                            ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
                            cc.visualizar();
                        }
                        case 2 -> {
                            System.out.println("Aniversário da conta poupança: ");
                            aniversario = leia.nextInt();
                            ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
                            cp.visualizar();
                        }
                    }

                    keyPress();
                    break;

                case 5:
                    System.out.println("Apagar a conta\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    // Chamada para o método deletar

                    keyPress();
                    break;

                case 6:
                    System.out.println("Saque\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    System.out.println("Valor do saque: ");
                    valor = leia.nextFloat();

                    // Chamada para o método sacar

                    keyPress();
                    break;

                case 7:
                    System.out.println("Depósito\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    System.out.println("Valor do depósito: ");
                    valor = leia.nextFloat();

                    // Chamada para o método depositar

                    keyPress();
                    break;

                case 8:
                    System.out.println("Transferência entre contas\n\n");

                    System.out.println("Número da conta - Origem: ");
                    numero = leia.nextInt();

                    System.out.println("Número da conta - Destino: ");
                    numeroDestino = leia.nextInt();

                    System.out.println("Valor da transferência: ");
                    valor = leia.nextFloat();

                    // Chamada para o método de transferência

                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção inválida");
                    
                    keyPress();
                    break;
            }
        }

    }

    public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
    
}
