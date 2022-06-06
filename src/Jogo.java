// Classe com a principal lógica do jogo

public class Jogo {
	private Nivel[] arrayNivel;
	private int quantJogadores;

	public Jogo(int quantJogadores, int quantNiveis) {
		arrayNivel = new Nivel[quantNiveis];
		this.quantJogadores = quantJogadores;
		for (int i = 0; i < arrayNivel.length; i++) { // Laço para criar e inicializar os níveis
			this.arrayNivel[i] = new Nivel(i + 1);
			this.arrayNivel[i].inicializaNivel(quantJogadores);
		}
	}

	public void imprimeCenario() {
		for (int i = 0; i < arrayNivel.length; i++) { // Altera os níveis
			for (int c = 1; c <= quantJogadores * 3; c++) { // Altera as posições dos níveis
				System.out.print(c + " / ");
			}
			System.out.println("\n");
		}
	}

	public void imprimeCenarioRespostas() { // Método apenas para conferir durante o desenvolvimento. Contém as
											// respostas do jogo.
		for (int i = 0; i < arrayNivel.length; i++) {
			for (int c = 0; c < arrayNivel[i].getArrayInt().length; c++) {
				System.out.print(arrayNivel[i].getArrayInt()[c] + " / ");
			}
			System.out.println("\n");
		}
	}

	public boolean executaJogada(Jogador j) {
		imprimeCenario();
		for (int i = 0; i < arrayNivel.length; i++) { // Começa o jogo. Caso o
			System.out.println("É a vez de " + j.getNome());
			int resp = Teclado.leInt("Digite o número desejado: ");
			if (resp > quantJogadores * 3 || resp <= 0) { // Verifica se a opção escolhida existe. Caso não exista, o
															// jogador perde a
															// vez.
				System.out.println("Opção inválida. Perdeu a vez :(");
				return false;
			}
			if (arrayNivel[i].getArrayInt()[resp - 1] == j.getId()) // Verifica se a resposta do usuário é igual ao ID
																	// dele (se
																	// acertou ou não). A posição é "resp - 1" pois o
																	// valor mínimo da
																	// resposta é 1, e não 0, que é o valor mínimo da
																	// posição do array
				System.out.println("Parabéns! Você acertou!");
			else {
				System.out.println("Errou :(");
				return false;
			}
		}
		System.out.println("PARABÉNS, " + j.getNome() + "! VOCÊ GANHOU O JOGO!");
		return true;
	}
}