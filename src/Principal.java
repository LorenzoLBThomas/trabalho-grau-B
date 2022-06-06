// Classe Principal, onde o jogo � executado

public class Principal {

	public static void main(String[] args) {
		int resp = Teclado.leInt("Quantos jogadores? ");
		while (resp < 2 || resp > 500) { // Verifica se a quantidade de jogadores est� entre 2 e 500.
			System.out.println("S�o necess�rios dois jogadores no m�nimo e o m�ximo s�o 500 jogadores.");
			resp = Teclado.leInt("Quantos jogadores? ");
		}
		Jogador[] arrayJogadores = new Jogador[resp]; // Cria um array de jogadores.

		for (int i = 0; i < resp; i++) { // Pergunta o nome dos jogadores e adiciona eles no array.
			arrayJogadores[i] = new Jogador(Teclado.leString("Digite o nome do jogador: "), i + 1);
		}

		Jogo j = new Jogo(resp, Teclado.leInt("Digite a quantidade de n�veis desejada: ")); // Cria o jogo.

		for (int i = 0; !j.executaJogada(arrayJogadores[i]); i++) { // Executa as jogadas, utilizando o retorno do
																	// m�todo como
																	// condi��o. Caso o jogador n�o ganhe, outra jogada
																	// ser� executada
			if (i + 1 == resp) // Impede que o i seja maior do que o n�meros de �ndices do array (maior que a
								// quantidade de jogadores)
				i = -1;
		}

	}

}
