import java.util.Scanner;

public class CandyCrushSaga {

	public static int[][] game_board;
	public static int score = 0;
	static Scanner k = new Scanner(System.in);

	/**
	 * Oyun tahtasını oluşturur ve a * - 8 1 koyar Ilk tahta olduğu icin 3lüleri
	 * siler Oynanabilecek hamle var mı bakar
	 * 
	 * 
	 * 1 2 3 4 5 == a * - 8 1 int board oluşturuluyor simgeler böyle kodlaniyor
	 */
	public CandyCrushSaga(int line, int column) {

		game_board = new int[line][column];
		for (int i = 0; i < line; i++)
			for (int j = 0; j < column; j++)
				game_board[i][j] = (int) (Math.random() * 5 + 1);

		remove_same3char();
		canMove();
		displayBoard();

	}

	/**
	 * Oyun tahtasini ekrana basar
	 */
	public static void displayBoard() {
		for (int i = 0; i < game_board.length; i++) {
			for (int j = 0; j < game_board[0].length; j++) {
				if (game_board[i][j] == 1)
					System.out.print("a ");
				if (game_board[i][j] == 2)
					System.out.print("* ");
				if (game_board[i][j] == 3)
					System.out.print("- ");
				if (game_board[i][j] == 4)
					System.out.print("8 ");
				if (game_board[i][j] == 5)
					System.out.print("1 ");
			}
			System.out.println();
		}

	}

	/**
	 * yanyana veya dikeyde üstüste ayni olan 3lü simgeleri siler
	 */

	public static void remove_same3char() {

		// satirda ayni olanlari sildi
		for (int i = 0; i < game_board.length - 2; i++)
			for (int j = 0; j < game_board[0].length; j++)
				if (game_board[i][j] == game_board[i + 1][j]
						&& game_board[i][j] == game_board[i + 2][j]) {

					game_board[i][j] = game_board[i][j] + 1;

				}
		// sutunda ayni olanlari sildi
		for (int a = 0; a < game_board.length; a++)
			for (int b = 0; b < game_board[0].length - 2; b++)
				if (game_board[a][b] == game_board[a][b + 1]
						&& game_board[a][b] == game_board[a][b + 2]) {

					game_board[a][b] = game_board[a][b] + 1;

				}

	}

	/**
	 * Oyun tahtasinda oynanabilecek hamle var mi
	 */
	public static void canMove() {
/**
		for(int i=0; i<game_board.length; i++)
			for(int j=0; j<game_board[0].length; j++)
		if(game_board[i][j]!=game_board[i+1][j] ||
				game_board[i][j]!=game_board[i][j+1] ||
				game_board[i][j]!=game_board[i][j+2] ||
				game_board[i+2][j]!=game_board[i+1][j] )
			shuffle();
	*/
	}
	/**
	 * Oyun tahtasinda oynanabilecek hamle kalmayinca karıştırır
	 */
	public static void shuffle() {

		int sayac1 = 0, sayac2 = 0, sayac3 = 0, sayac4 = 0, sayac5 = 0;
		// hangi simgeden ne kadar var önce sayiyor
		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length; j++) {
				if (game_board[i][j] == 1)
					sayac1++;
				if (game_board[i][j] == 2)
					sayac2++;
				if (game_board[i][j] == 3)
					sayac3++;
				if (game_board[i][j] == 4)
					sayac4++;
				if (game_board[i][j] == 5)
					sayac5++;
			}
		// tahtayi sifirliyor
		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length; j++)
				game_board[i][j] = 0;
		// tahtaya simgeleri dağıtıyor. dağıtamıyor random atıyor
		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length; j++)
				game_board[i][j] = (int) (Math.random() * 5 + 1);

	}

	/**
	 * Oyun tahtasinda yanyana olanlari patlatir ve üsttekileri düşürür
	 */

	public static void exploded() {

		for (int i = 0; i < game_board.length - 2; i++)
			for (int j = 0; j < game_board[0].length; j++)
				// 3tane yanyana eşit ise
				if (game_board[i][j] == game_board[i + 1][j]
						&& game_board[i + 1][j] == game_board[i + 2][j])
					score += (int) (Math.pow(3, 2));

		for (int i = 0; i < game_board.length - 3; i++)
			for (int j = 0; j < game_board[0].length; j++)
				// 4tane yanyana eşit ise
				if (game_board[i][j] == game_board[i + 1][j]
						&& game_board[i + 1][j] == game_board[i + 2][j]
						&& game_board[i + 3][j] == game_board[i + 2][j])
					score += (int) (Math.pow(4, 2));

		for (int i = 0; i < game_board.length - 4; i++)
			for (int j = 0; j < game_board[0].length; j++)
				// 5tane yanyana eşit ise
				if (game_board[i][j] == game_board[i + 1][j]
						&& game_board[i + 1][j] == game_board[i + 2][j]
						&& game_board[i + 3][j] == game_board[i + 2][j]
						&& game_board[i + 4][j] == game_board[i + 3][j])
					score += (int) (Math.pow(5, 2));

		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length - 2; j++)
				// 3tane üstüste eşit ise
				if (game_board[i][j] == game_board[i][j + 1]
						&& game_board[i][j + 1] == game_board[i][j + 2])
					score += (int) (Math.pow(3, 2));

		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length - 3; j++)
				// 4tane üstüste eşit ise
				if (game_board[i][j] == game_board[i][j + 1]
						&& game_board[i][j + 1] == game_board[i][j + 2]
						&& game_board[i][j + 3] == game_board[i][j + 2])
					score += (int) (Math.pow(4, 2));

		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length - 4; j++)
				// 5tane üstüste eşit ise
				if (game_board[i][j] == game_board[i][j + 1]
						&& game_board[i][j + 1] == game_board[i][j + 2]
						&& game_board[i][j + 3] == game_board[i][j + 2]
						&& game_board[i][j + 4] == game_board[i][j + 3])
					score += (int) (Math.pow(5, 2));

	}

	/**
	 * Oyun tahtasinda ayni olanlari siler üsttekileri düşürür
	 */
	public static void dropped() {

		//yanyana satirdakileri siler üstten düşürür
		for (int i = 0; i < game_board.length; i++)
			for (int j = 0; j < game_board[0].length - 2; j++)

				if (game_board[i][j] == game_board[i][j + 1]
						&& game_board[i][j + 1] == game_board[i][j + 2]
						&& game_board[i][j] == game_board[i][j + 2]) {
					if (i == 0) {
						game_board[0][j] = (int) (Math.random() * 5 + 1);
						game_board[0][j + 1] = (int) (Math.random() * 5 + 1);
						game_board[0][j + 2] = (int) (Math.random() * 5 + 1);
					} else {
						for (int f = 0; f < i; f++) {
							game_board[i - f][j] = game_board[i - 1 - f][j];
							game_board[i - f][j + 1] = game_board[i - 1 - f][j + 1];
							game_board[i - f][j + 2] = game_board[i - 1 - f][j + 2];

						}
					}
				}

		
		// üstüste sutundakileri siler üstten düşürür
		for (int i = 0; i < game_board.length-2; i++)
			for (int j = 0; j < game_board[0].length; j++)

				if (game_board[i][j] == game_board[i+1][j]
						&& game_board[i+1][j] == game_board[i+2][j]
						&& game_board[i][j] == game_board[i+2][j]) {
					if (i == 0) {
						game_board[0][j] = (int) (Math.random() * 5 + 1);
					} else {
						for (int f = 0; f < j; f++) {
							game_board[i][j-f] = game_board[i][j-1-f];
							game_board[i+1][j-f] = game_board[i+1][j-1-f];
							game_board[i+2][j-f] = game_board[i+1][j-1-f];

						}
					}
				}
		

	}

	/**
	 * Oyun tahtasinda iki taşın yerini değiştirir
	 */
	public static void changePlace(int a, int b, int c, int d) {
		int temp;
		temp = game_board[c][d];
		game_board[c][d] = game_board[a][b];
		game_board[a][b] = temp;
		exploded();
		dropped();
		displayBoard();
	}

	/**
	 * Oyun tahtasinda değiştirilmek istenen taşlar yer değiştirebiliyor mu en
	 * az 3 tane simgeyi yanyana getiriyorsa değiştirebilir
	 */
	public static void canChangePlace(int a, int b, int c, int d) {

		changePlace(a, b, c, d);
	}

	/**
	 * Oyunu asıl oynatan metottur
	 */
	public static void play(int hamle_sayisi, int gereken_puan) {
		String hamle_1, hamle_2;

		for (int i = 0; i < hamle_sayisi; i++) {
			System.out.println("Puan : " + score);
			System.out.println("Kalan hamle sayisi : " + (hamle_sayisi - i));
			System.out.println("Bir sonraki hamleyi giriniz : ");
			hamle_1 = k.next();
			hamle_2 = k.next();
			String ilk_ = hamle_1.substring(0, hamle_1.indexOf(","));
			String iki_ = hamle_1.substring(hamle_1.indexOf(",") + 1);
			String uc_ = hamle_2.substring(0, hamle_2.indexOf(","));
			String dort_ = hamle_2.substring(hamle_2.indexOf(",") + 1);
			int a = Integer.parseInt(ilk_);
			int b = Integer.parseInt(iki_);
			int c = Integer.parseInt(uc_);
			int d = Integer.parseInt(dort_);

			canChangePlace(a, b, c, d);
			if (hamle_sayisi - 1 == 0 && gereken_puan >= score)
				System.out.println("Kaybettiniz. Puanininz : " + score);
			if (hamle_sayisi - 1 == 0 && gereken_puan < score)
				System.out.println("Kazandiniz. Puaniniz : " + score);

		}
	}
	
public static void main(String []args){
		
		Scanner k=new Scanner(System.in);
		System.out.println("Tahta Büyüklüğü : " );
		int line=k.nextInt();
		int column=k.nextInt();
		System.out.println("Maksimum hamle sayisi : ");
		int number_of_moves = k.nextInt();
		System.out.println("Ulasilmasi gereken puan : ");
		int required_score = k.nextInt();
		CandyCrushSaga css=new CandyCrushSaga(line, column);
		play(number_of_moves, required_score);
		
		
		
		
		
	}

}

