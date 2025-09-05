
public class ContaPoupanca extends Conta{

	public int aniversarioConta;
	
	@Override
	public double calcularSaldoFinal() {
		return getSaldo() * 1.02;
	}

}
