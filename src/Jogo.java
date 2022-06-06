// Classe com a principal l�gica do jogo

public class Jogo {
	private Nivel[] arrayNivel;
	private int quantJogadores;

	public Jogo(int quantJogadores, int quantNiveis) {
		arrayNivel = new Nivel[quantNiveis];
		this.quantJogadores = quantJogadores;
		for (int i = 0; i < arrayNivel.length; i++) { // La�o para criar e inicializar os n�veis
			this.arrayNivel[i] = new Nivel(i + 1);
			this.arrayNivel[i].inicializaNivel(quantJogadores);
		}
	}

	public void imprimeCenario() {
		for (int i = 0; i < arrayNivel.length; i++) { // Altera os n�veis
			for (int c = 1; c <= quantJogadores * 3; c++) { // Altera as posi��es dos n�veis
				System.out.print(c + " / ");
			}
			System.out.println("\n");
		}
	}

	public void imprimeCenarioRespostas() { // M�todo apenas para conferir durante o desenvolvimento. Cont�m as
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
		for (int i = 0; i < arrayNivel.length; i++) { // Come�a o jogo. Caso o
			System.out.println("� a vez de " + j.getNome());
			int resp = Teclado.leInt("Digite o n�mero desejado: ");
			if (resp > quantJogadores * 3 || resp <= 0) { // Verifica se a op��o escolhida existe. Caso n�o exista, o
															// jogador perde a
															// vez.
				System.out.println("Op��o inv�lida. Perdeu a vez :(");
				return false;
			}
			if (arrayNivel[i].getArrayInt()[resp - 1] == j.getId()) // Verifica se a resposta do usu�rio � igual ao ID
																	// dele (se
																	// acertou ou n�o). A posi��o � "resp - 1" pois o
																	// valor m�nimo da
																	// resposta � 1, e n�o 0, que � o valor m�nimo da
																	// posi��o do array
				System.out.println("Parab�ns! Voc� acertou!");
			else {
				System.out.println("Errou :(");
				return false;
			}
		}
		System.out.println("PARAB�NS, " + j.getNome() + "! VOC� GANHOU O JOGO!");
		return true;
	}
}