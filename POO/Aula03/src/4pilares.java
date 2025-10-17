// Arquivo: Personagem.java

/**
 * 1. ABSTRAÇÃO
 * Esta é uma classe abstrata que serve como um modelo para todos os personagens do jogo.
 * Ela define o que um "Personagem" É, em sua essência: tem nome, vida, nível e pode atacar.
 * Não podemos criar um objeto diretamente de "Personagem" (ex: new Personagem()),
 * porque ela é uma ideia, um conceito, e não algo concreto.
 * O método "atacar()" é abstrato, pois não sabemos como um "personagem genérico" ataca.
 * Cada tipo específico de personagem (Guerreiro, Mago) implementará seu próprio ataque.
 */
public abstract class Personagem {

    // ---------------------------------------------------------------------------------
    // 2. ENCAPSULAMENTO
    // Os atributos (estado do objeto) são declarados como 'private'.
    // Isso significa que eles só podem ser acessados e modificados pelos métodos
    // da própria classe (getters, setters, construtor, etc).
    // Isso protege os dados de modificações indevidas e esconde a complexidade interna.
    // Por exemplo, ninguém de fora pode fazer "personagem.vida = 99999;".
    // ---------------------------------------------------------------------------------
    private String nome;
    private int vida;
    private int nivel;

    // Construtor para inicializar os atributos essenciais de um personagem.
    public Personagem(String nome, int vida, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.nivel = nivel;
    }

    /**
     * Método abstrato.
     * Declara "o quê" o personagem faz (atacar), mas não "como" ele faz.
     * As subclasses (Guerreiro, Mago) serão OBRIGADAS a fornecer uma implementação
     * concreta para este método. Isso é parte fundamental da Abstração e do Polimorfismo.
     */
    public abstract void atacar();

    /**
     * Método concreto que será herdado por todas as subclasses.
     * Demonstra o encapsulamento em ação: a vida só pode ser alterada
     * através de um método controlado.
     */
    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.println(this.nome + " recebeu " + dano + " de dano e agora tem " + this.vida + " de vida.");
        if (this.vida <= 0) {
            System.out.println(this.nome + " foi derrotado!");
        }
    }

    // Métodos "getters" para permitir o acesso (somente leitura) aos atributos encapsulados.
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }
}

// Arquivo: Guerreiro.java

/**
 * 3. HERANÇA
 * A classe Guerreiro "estende" a classe Personagem.
 * Isso significa que Guerreiro É-UM Personagem e herda todos os seus
 * atributos (nome, vida, nivel) e métodos (receberDano, getters).
 * Além disso, adiciona características e comportamentos específicos, como o atributo "forca".
 */
public class Guerreiro extends Personagem {

    private int forca;

    // O construtor da subclasse deve chamar o construtor da superclasse
    // para inicializar os atributos herdados. Isso é feito com "super()".
    public Guerreiro(String nome, int forca) {
        super(nome, 150, 1); // Um guerreiro sempre começa com 150 de vida e nível 1
        this.forca = forca;
    }

    // ---------------------------------------------------------------------------------
    // 4. POLIMORFISMO (SOBRESCRITA / OVERRIDING)
    // Aqui implementamos o método abstrato "atacar()" herdado de Personagem.
    // A anotação @Override indica ao compilador que estamos sobrescrevendo
    // um método da superclasse. Isso é Polimorfismo, pois o mesmo método "atacar()"
    // terá comportamentos diferentes dependendo do tipo do objeto (Guerreiro ou Mago).
    // ---------------------------------------------------------------------------------
    @Override
    public void atacar() {
        System.out.println(getNome() + " ataca com sua espada! Dano causado: " + this.forca);
    }

    // ---------------------------------------------------------------------------------
    // 4. POLIMORFISMO (SOBRECARGA / OVERLOADING)
    // Este é um exemplo de sobrecarga. Temos dois métodos com o mesmo nome ("atacar"),
    // mas com listas de parâmetros diferentes (um não tem parâmetros, o outro tem).
    // Isso permite que um objeto da classe Guerreiro possa atacar de formas diferentes.
    // ---------------------------------------------------------------------------------
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " usa um ataque especial em " + alvo.getNome() + "!");
        alvo.receberDano(this.forca + 10); // Ataque especial causa mais dano
    }
}

// Arquivo: Mago.java

/**
 * 3. HERANÇA
 * A classe Mago também herda de Personagem, reutilizando a estrutura básica.
 * Adiciona um atributo específico: "mana".
 */
public class Mago extends Personagem {

    private int mana;

    public Mago(String nome, int mana) {
        super(nome, 80, 1); // Magos começam com menos vida (80)
        this.mana = mana;
    }

    // ---------------------------------------------------------------------------------
    // 4. POLIMORFISMO (SOBRESCRITA / OVERRIDING)
    // O Mago também implementa o método "atacar()", mas de uma maneira
    // completamente diferente do Guerreiro. Esta é a essência da sobrescrita.
    // ---------------------------------------------------------------------------------
    @Override
    public void atacar() {
        if (this.mana >= 10) {
            System.out.println(getNome() + " lança uma bola de fogo!");
            this.mana -= 10;
        } else {
            System.out.println(getNome() + " está sem mana para atacar!");
        }
    }
}

// Arquivo: Jogo.java
import java.util.ArrayList; // Importando a classe ArrayList
import java.util.List;

public class Jogo {

    public static void main(String[] args) {
        System.out.println("--- Bem-vindo ao Jogo de RPG Demo ---");

        // Criando instâncias concretas das subclasses
        Guerreiro aragorn = new Guerreiro("Aragorn", 25);
        Mago gandalf = new Mago("Gandalf", 100);

        // USO DO ARRAYLIST
        // Criamos uma lista que pode armazenar qualquer objeto do tipo "Personagem".
        // Graças à Herança e ao Polimorfismo, podemos adicionar tanto um Guerreiro
        // quanto um Mago na mesma lista, pois ambos SÃO-UM Personagem.
        List<Personagem> grupoDeHerois = new ArrayList<>();
        grupoDeHerois.add(aragorn);
        grupoDeHerois.add(gandalf);

        System.out.println("\n--- Demonstração do Polimorfismo (Sobrescrita) ---");

        // Aqui está a mágica do Polimorfismo:
        // O loop trata cada item da lista simplesmente como um "Personagem".
        // Ele não precisa saber se é um Guerreiro ou um Mago.
        // Ao chamar `heroi.atacar()`, o Java (em tempo de execução) verifica o tipo
        // real do objeto (Guerreiro ou Mago) e chama a implementação CORRETA do método.
        for (Personagem heroi : grupoDeHerois) {
            heroi.atacar();
        }

        System.out.println("\n--- Demonstração do Polimorfismo (Sobrecarga) ---");
        // Chamando as duas versões do método "atacar" da classe Guerreiro
        aragorn.atacar(); // Chama o método sem parâmetros
        aragorn.atacar(gandalf); // Chama o método sobrecarregado que recebe um alvo

        System.out.println("\n--- Demonstração do Encapsulamento e Herança ---");
        // Não podemos fazer isso (o atributo 'vida' é private):
        // gandalf.vida = 0; // -> ISSO GERARIA UM ERRO DE COMPILAÇÃO!

        // Usamos o método público "receberDano", que foi herdado da classe Personagem.
        // A lógica de como a vida é alterada está protegida (encapsulada) dentro do método.
        System.out.println("O Mago " + gandalf.getNome() + " tem " + gandalf.getVida() + " de vida antes do ataque.");
        aragorn.atacar(gandalf);
        System.out.println("O Mago " + gandalf.getNome() + " tem " + gandalf.getVida() + " de vida após o ataque.");
    }
}
