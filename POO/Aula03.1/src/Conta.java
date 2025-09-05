
public abstract class Conta {
	private String numero;
	private String titular;
	private double saldo;
	private String agencia;
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public void depositar(double valor) {
		saldo += valor;
		System.out.println(saldo);
	}
	
	public void sacar(double valor) {
		saldo -= valor;
		System.out.println(saldo);
	}
	
	public abstract double calcularSaldoFinal();
	
}
