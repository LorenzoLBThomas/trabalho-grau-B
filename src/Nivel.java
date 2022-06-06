// Classe dos níveis do jogo

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
			int aleatorio = ((int) (Math.random() * (quantJogadores)) + 1); // Sorteia aleatóriamente um número
			arrayAux[aleatorio - 1] += 1; // Na posição "aleatorio - 1" (-1 pois o mínimo do "aleatorio" é 1, não
											// zero"), é
											// incrementado 1 quando o valor referente a essa posição é sorteado.
			if (arrayAux[aleatorio - 1] <= 3) // Enquanto essa possição não é maior do que 3 (máximo de vezes que um
												// mesmo valor pode
												// aparecer), adiciona o valor no array principal.
				arrayInt[i] = aleatorio;
			else // Caso o número sorteado já tenha sido sorteado 3 vezes, o contador volta 1,
					// para o processo ser repetido novamente.
				i--;
		}
	}
}
