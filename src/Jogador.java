// Classe do Jogador

public class Jogador {
	private String nome;
	private int id, nivel;

	// Construtor
	public Jogador(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
