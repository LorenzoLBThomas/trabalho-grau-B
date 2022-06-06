// Classe Principal, onde o jogo é executado

public class Principal {

	public static void main(String[] args) {
		int resp = Teclado.leInt("Quantos jogadores? ");
		while (resp < 2 || resp > 500) { // Verifica se a quantidade de jogadores está entre 2 e 500.
			System.out.println("São necessários dois jogadores no mínimo e o máximo são 500 jogadores.");
			resp = Teclado.leInt("Quantos jogadores? ");
		}
		Jogador[] arrayJogadores = new Jogador[resp]; // Cria um array de jogadores.

		for (int i = 0; i < resp; i++) { // Pergunta o nome dos jogadores e adiciona eles no array.
			arrayJogadores[i] = new Jogador(Teclado.leString("Digite o nome do jogador: "), i + 1);
		}

		Jogo j = new Jogo(resp, Teclado.leInt("Digite a quantidade de níveis desejada: ")); // Cria o jogo.

		for (int i = 0; !j.executaJogada(arrayJogadores[i]); i++) { // Executa as jogadas, utilizando o retorno do
																	// método como
																	// condição. Caso o jogador não ganhe, outra jogada
																	// será executada
			if (i + 1 == resp) // Impede que o i seja maior do que o números de índices do array (maior que a
								// quantidade de jogadores)
				i = -1;
		}

	}

}
