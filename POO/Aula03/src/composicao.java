// Motor.java
// A "parte" que não deve existir sem o "todo".
public class Motor {
    private int potencia;

    // O motor é criado com uma potência específica.
    public Motor(int potencia) {
        this.potencia = potencia;
        System.out.println("Motor de " + potencia + "cv criado.");
    }

    public void ligar() {
        System.out.println("Motor ligado.");
    }

    public void desligar() {
        System.out.println("Motor desligado.");
    }

    public int getPotencia() {
        return potencia;
    }
}

// Carro.java
// O "todo" que é composto por um motor.
public class Carro {
    private String modelo;
    private Motor motor; // O objeto "parte" é uma variável de instância.

    // Ponto chave da Composição:
    // O construtor do Carro CRIA a instância do Motor.
    // O motor não é recebido de fora, ele é criado aqui dentro.
    public Carro(String modelo, int potenciaMotor) {
        this.modelo = modelo;
        this.motor = new Motor(potenciaMotor); // O Carro gerencia o ciclo de vida do Motor
    }

    public void ligarCarro() {
        System.out.println("Ligando o " + modelo + "...");
        motor.ligar();
    }

    public void desligarCarro() {
        System.out.println("Desligando o " + modelo + "...");
        motor.desligar();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. Criamos o objeto "todo". A "parte" (Motor) é criada automaticamente dentro dele.
        Carro meuCarro = new Carro("Fusca", 65);

        // 2. Usamos o carro, que por sua vez usa seu motor.
        meuCarro.ligarCarro();

        System.out.println("\n--- O carro foi para o ferro-velho ---");
        // 3. Destruímos a referência para o objeto "todo".
        meuCarro = null;
        
        // Neste ponto, não temos mais acesso ao objeto 'meuCarro'.
        // O objeto 'Motor' que pertencia a ele também se torna inacessível.
        // O Garbage Collector do Java irá eventualmente liberar a memória de ambos.
        // Não há como recuperar aquele motor específico de 65cv. Ele "morreu" com o carro.
        System.out.println("O objeto Carro e seu Motor interno estão agora elegíveis para coleta de lixo.");
    }
}
