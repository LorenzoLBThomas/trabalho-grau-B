// Classe dos n�veis do jogo

public class Nivel {
	private int[] arrayInt;
	private int id;

	public Nivel(int id) {
		this.id = id;
	}

	public int[] getArrayInt() {
		return arrayInt;
	}

	public void setArrayInt(int[] arrayInt) {
		this.arrayInt = arrayInt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void inicializaNivel(int quantJogadores) {
		arrayInt = new int[quantJogadores * 3];
		int[] arrayAux = new int[quantJogadores]; // Array auxiliar

		for (int i = 0; i < arrayInt.length; i++) {
			int aleatorio = ((int) (Math.random() * (quantJogadores)) + 1); // Sorteia aleat�riamente um n�mero
			arrayAux[aleatorio - 1] += 1; // Na posi��o "aleatorio - 1" (-1 pois o m�nimo do "aleatorio" � 1, n�o
											// zero"), �
											// incrementado 1 quando o valor referente a essa posi��o � sorteado.
			if (arrayAux[aleatorio - 1] <= 3) // Enquanto essa possi��o n�o � maior do que 3 (m�ximo de vezes que um
												// mesmo valor pode
												// aparecer), adiciona o valor no array principal.
				arrayInt[i] = aleatorio;
			else // Caso o n�mero sorteado j� tenha sido sorteado 3 vezes, o contador volta 1,
					// para o processo ser repetido novamente.
				i--;
		}
	}
}
