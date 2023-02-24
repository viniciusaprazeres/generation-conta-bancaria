package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import conta.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        ContaController contas = new ContaController();

        // Algumas contas de exemplo para testes
        System.out.println("\nCriar Contas\n");
        // Exemplos de contas correntes
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);
        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);
        // Exemplos de contas poupanças
        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp1);
        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
        contas.cadastrar(cp2);

        contas.listarTodas();


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

            try {
                opcao = leia.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Digite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

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
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                            // cc.visualizar();
                        }
                        case 2 -> {
                            System.out.println("Aniversário da conta poupança: ");
                            aniversario = leia.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                            // cp.visualizar();
                        }
                    }

                    keyPress();
                    break;

                case 2:
                    System.out.println("Listar todas as contas\n\n");
                    contas.listarTodas();
                    keyPress();
                    break;

                case 3:
                    System.out.println("Consultar dados da conta - por número\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();
                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;

                case 4:
                    System.out.println("Atualizar dados da conta\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    if (contas.buscarNaCollection(numero) != null) {

                        System.out.println("Número da agência: ");
                        agencia = leia.nextInt();

                        System.out.println("Nome do titular: ");
                        leia.skip("\\R?");
                        titular = leia.nextLine();

                        // Busca do tipo
                        tipo = contas.retornaTipo(numero);

                        System.out.println("Saldo da conta: ");
                        saldo = leia.nextFloat();


                        switch (tipo) {
                            case 1 -> {
                                System.out.println("Limite da conta corrente: ");
                                limite = leia.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                            }
                            case 2 -> {
                                System.out.println("Aniversário da conta poupança: ");
                                aniversario = leia.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                            }
                        }
                    } else
                        System.out.println("A conta não foi encontrada!");

                    keyPress();
                    break;

                case 5:
                    System.out.println("Apagar a conta\n\n");

                    System.out.println("Número da conta: ");
                    numero = leia.nextInt();

                    // Chamada para o método deletar
                    contas.deletar(numero);
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
