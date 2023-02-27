package conta.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null)
            conta.visualizar();
        else
            System.out.println("A conta número: " + numero + " não foi encontrada!");
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas)
            conta.visualizar();
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("A conta foi criada!");
    }

    @Override
    public void atualizar(Conta conta) {
        var buscarConta = buscarNaCollection(conta.getNumero());

        if (buscarConta != null) {
            listaContas.set(listaContas.indexOf(buscarConta), conta);
            System.out.println("A conta número: " + conta.getNumero() + " foi atualizada!");
        } else
            System.out.println("A conta número: " + conta.getNumero() + " não foi encontrada!");
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            if (listaContas.remove(conta))
                System.out.println("A conta número: " + numero + " foi excluída!");
        } else
            System.out.println("A conta número: " + numero + " não foi encontrada!");

    }

    @Override
    public void sacar(int numero, float valor) {
        var buscaConta = buscarNaCollection(numero);

        if (buscaConta != null) {

            if(listaContas.get(listaContas.indexOf(buscaConta)).sacar(valor) == true)
                System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");

        }else
            System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
    }

    @Override
    public void depositar(int numero, float valor) {
        var buscaConta = buscarNaCollection(numero);

        if (buscaConta != null) {
            var indiceConta = listaContas.indexOf(buscaConta);
            listaContas.get(indiceConta).depositar(valor);
            System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");
        }else
            System.out.println("\nA Conta numero: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
    }

    @Override
    public void transferir(int numero, int destino, float valor) {
        var buscaContaOrigem = buscarNaCollection(numero);
        var buscaContaDestino = buscarNaCollection(destino);

        if (buscaContaOrigem != null && buscaContaDestino != null) {

            if (listaContas.get(listaContas.indexOf(buscaContaOrigem)).sacar(valor) == true) {
                listaContas.get(listaContas.indexOf(buscaContaDestino)).depositar(valor);
                System.out.println("\nA Transferência foi efetuado com sucesso!");
            }
        }else
            System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
    }

    // Implementar métodos auxiliares

    public int gerarNumero(){ // Gera o número da conta automaticamente
        return listaContas.size() + 1;
    }

    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }

    public int retornaTipo(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta.getTipo();
            }
        }

        return 0;
    }

}
