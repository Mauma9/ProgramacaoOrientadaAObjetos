public class Principal {
    public static void main(String[] args) {
        // Criando e testando Conta Corrente
        ContaCorrente cc = new ContaCorrente();
        cc.setNumero("12345-6");
        cc.setTitular("João Silva");
        cc.setAgencia("0001");
        cc.setSaldo(1000);
        cc.limeteChequeEspecial = 500;  
        
        System.out.println("Conta Corrente:");
        cc.depositar(200);
        cc.sacar(100);
        System.out.println("Saldo Final Conta Corrente: " + cc.calcularSaldoFinal());
        System.out.println();

        // Criando e testando Conta Poupança
        ContaPoupanca cp = new ContaPoupanca();
        cp.setNumero("98765-4");
        cp.setTitular("Maria Oliveira");
        cp.setAgencia("0002");
        cp.setSaldo(1500);
        cp.aniversarioConta = 15;
        
        System.out.println("Conta Poupança:");
        cp.depositar(300);
        cp.sacar(200);
        System.out.println("Saldo Final Conta Poupança: " + cp.calcularSaldoFinal());
        System.out.println();

        // Criando e testando Conta Salário
        ContaSalario cs = new ContaSalario();
        cs.setNumero("11223-7");
        cs.setTitular("Carlos Souza");
        cs.setAgencia("0003");
        cs.setSaldo(800);
        cs.empresaConveniada = "Empresa XYZ";

        System.out.println("Conta Salário:");
        cs.depositar(150);
        cs.sacar(500); // saque válido
        cs.sacar(1200); // saque inválido (acima de 1000)
        System.out.println("Saldo Final Conta Salário: " + cs.calcularSaldoFinal());
    }
}
