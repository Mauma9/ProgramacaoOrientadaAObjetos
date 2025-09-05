
public class Principal {
	public static void main(String[] args) {
		Carro carro1 = new Carro();
		carro1.marca = "Honda";
		carro1.modelo = "Civic";
		carro1.preco = 120000;
		carro1.potencia = 184;
		
		System.out.println(carro1.marca);
		carro1.acelerar();
	}
}
