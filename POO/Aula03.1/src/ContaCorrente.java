
public class ContaCorrente extends Conta {

	public double limeteChequeEspecial;
	
	@Override
	public double calcularSaldoFinal() {
		return getSaldo() - 15;
	}
	
}
