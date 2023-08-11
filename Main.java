import java.util.ArrayList;
import java.util.List;

class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

class AgenciaBancaria {
    private int numeroAgencia;
    private List<ContaBancaria> contas;

    public AgenciaBancaria(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void realizarDeposito(int numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso.");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void realizarSaque(int numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}

public class Main {
    public static void main(String[] args) {
        AgenciaBancaria agencia1 = new AgenciaBancaria(1);
        AgenciaBancaria agencia2 = new AgenciaBancaria(2);

        ContaBancaria conta1 = new ContaBancaria(1, "João");
        ContaBancaria conta2 = new ContaBancaria(2, "Maria");
        ContaBancaria conta3 = new ContaBancaria(3, "Pedro");

        agencia1.adicionarConta(conta1);
        agencia2.adicionarConta(conta2);
        agencia2.adicionarConta(conta3);

        agencia1.realizarDeposito(1, 100.0);
        agencia2.realizarSaque(2, 30.0);

        System.out.println("Saldo da conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: " + conta2.getSaldo());
        System.out.println("Saldo da conta 3: " + conta3.getSaldo());
        
    }
}

