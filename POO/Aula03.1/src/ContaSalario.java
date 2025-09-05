
public class ContaSalario extends Conta {
	
	public String empresaConveniada;

	@Override
	public double calcularSaldoFinal() {
		return getSaldo();
	}
	
	public void sacar(double valor) {
		if(valor > 1000 ) {
			System.out.println("Operação inválida!");
		} else {
		setSaldo(getSaldo() - valor);
		System.out.println(getSaldo());
		}
	}
}
