// Professor.java
// A "parte" que pode existir de forma independente.
public class Professor {
    private String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + "]";
    }
}

// Departamento.java
import java.util.ArrayList;
import java.util.List;

// O "todo" que agrega os professores.
public class Departamento {
    private String nome;
    private List<Professor> professores; // Lista de professores

    public Departamento(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    // Ponto chave da Agregação:
    // O departamento NÃO cria os professores, ele os recebe de fora.
    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void listarProfessores() {
        System.out.println("Professores do Departamento de " + nome + ":");
        for (Professor p : professores) {
            System.out.println("- " + p.getNome());
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. Criamos os objetos "parte" de forma independente.
        Professor prof1 = new Professor("João Silva");
        Professor prof2 = new Professor("Maria Souza");

        // 2. Criamos o objeto "todo".
        Departamento deptoComputacao = new Departamento("Ciência da Computação");

        // 3. Associamos as partes ao todo.
        deptoComputacao.adicionarProfessor(prof1);
        deptoComputacao.adicionarProfessor(prof2);

        deptoComputacao.listarProfessores();

        System.out.println("\n--- O departamento foi fechado ---");
        // 4. Destruímos (ou perdemos a referência para) o objeto "todo".
        deptoComputacao = null;

        // 5. Os objetos "parte" continuam a existir!
        System.out.println("O professor " + prof1.getNome() + " ainda existe.");
        System.out.println("A professora " + prof2.getNome() + " ainda existe.");
    }
}
