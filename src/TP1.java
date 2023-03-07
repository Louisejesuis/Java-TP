import java.util.InputMismatchException;
import java.util.Scanner;

public class TP1 {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		chooseExercise();

		scanner.close();
	}

	/**
	 * Make the user choose an exercise to play
	 */
	public static void chooseExercise() {
		String[] exercises = { "1. Exercice 1.1 : Un programme qui nous salue ", "2. Exercice 1.2 : Permutation",
				"3. Exercice 2.1 : Longueur d’une chaîne", "4. Exercice 2.2 : Bissextile", "5. Exercice 3.1 : Min/Max",
				"6. Exercice 4.1 : Devinette avec un while", "7. Exercice 4.2 : Devinette 2 avec un do/while",
				"8. Exercice 4.2 : Devinette 2 avec un do/while v2" };

		boolean retry = true;

		while (retry) {

			for (String exercise : exercises) {
				System.out.println(exercise);
			}

			System.out.print("Choisi un exercice:");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println(exercises[0]);
				exercice1_1();
				break;
			case 2:
				System.out.println(exercises[1]);
				exercice1_2();
				break;
			case 3:
				System.out.println(exercises[2]);
				exercice2_1();
				break;
			case 4:
				System.out.println(exercises[3]);
				exercice2_2();
				break;
			case 5:
				System.out.println(exercises[4]);
				exercice3_1();
				break;
			case 6:
				System.out.println(exercises[5]);
				exercice4_1();
				break;
			case 7:
				System.out.println(exercises[6]);
				exercice4_2();
				break;
			case 8:
				System.out.println(exercises[7]);
				exercice4_2_v2();
				break;
			default:
				System.out.println("Choix invalide.");
			}

			System.out.println("Continuer ? [y/n]");
			if (scanner.next() == "n") {
				retry = false;
			}
		}
	}

	/**
	 * Return the first name, last name and age of the user
	 */
	public static void exercice1_1() {

		System.out.print("Prénom : ");
		String firstName = scanner.next();

		System.out.print("Nom : ");
		String lastName = scanner.next();

		int age = 0;
		while (true) {
			System.out.print("Age : ");
			try {
				age = scanner.nextInt();
				if (age < 0) {
					System.out.println("L'âge doit être supérieur à 0, recommencer.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Âge invalide, recommencer.");
				scanner.next();
			}
		}
		System.out.println("Bonjour " + firstName + " " + lastName + " (" + age + " ans).");
	}

	/**
	 * Swap the value of x and y give by the user
	 */
	public static void exercice1_2() {

		int xInitial = 0;
		int yInitial = 0;

		while (true) {
			System.out.print("Saisir valeur de x : ");
			try {
				xInitial = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Nombre invalide.");
				scanner.next();
			}
		}
		System.out.println();
		while (true) {
			System.out.print("Saisir valeur de y : ");
			try {
				yInitial = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Nombre invalide.");
				scanner.next();
			}
		}

		int x = yInitial;
		int y = xInitial;

		System.out.print("Les valeurs sont permutées, x vaut " + x + " et y vaut " + y);

	}

	/**
	 * Return the longest string
	 */
	public static void exercice2_1() {

		System.out.print("Saisir une première chaîne de caractère : ");
		String firstString = scanner.next();

		System.out.print("Saisir une seconde chaîne de caractère : ");
		String secondString = scanner.next();

		if (firstString.length() > secondString.length()) {
			System.out.print(firstString + " est la chaîne la plus longue.");

		} else if (secondString.length() > firstString.length()) {
			System.out.print(secondString + " est la chaîne la plus longue.");

		} else {
			System.out.print("Les deux chaînes sont de la même longueur.");

		}
	}

	/**
	 * Test if the year is a leap year
	 */
	public static void exercice2_2() {

		System.out.print("Saisir une année : ");
		int year = scanner.nextInt();

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.print("L’année " + year + " est bissextile.");

		} else {
			System.out.print("L’année " + year + " n'est pas bissextile.");

		}

	}

	/**
	 * Return a list of 10 random value between 0, 10 and the min and max
	 */
	public static void exercice3_1() {

		int min = 101;
		int minPosition = 0;

		int max = -1;
		int maxPosition = 0;

		for (int i = 1; i <= 10; i++) {
			int rand = (int) (Math.random() * 101);
			if (rand > max) {
				max = rand;
				maxPosition = i;
			}
			if (rand < min) {
				min = rand;
				minPosition = i;
			}
			System.out.println("Le nombre " + i + " vaut " + rand);
		}
		System.out.println("Le maximum vaut " + max + " (numéro " + maxPosition + ") le minimum vaut " + min
				+ " (numéro " + minPosition + ").");
	}

	/**
	 * The computer makes the user guess a number between 0 and 100
	 */
	public static void exercice4_1() {
		int numberToGuess = (int) (Math.random() * 101);
		int round = 1;
		boolean find = false;

		while (!find) {
			System.out.print("Entrer un nombre : ");
			int userGuess = scanner.nextInt();
			int gap = Math.abs(numberToGuess - userGuess);

			if (gap == 0) {
				find = true;
				System.out.println("-----> gagné (" + round + " tentative(s))");

			} else if (gap != 0 && gap <= 5) {
				System.out.println("-----> chaud");
			} else if (gap <= 20) {
				System.out.println("-----> tiède");
			} else {
				System.out.println("-----> froid");
			}
			round++;
		}

	}

	/**
	 * The user makes the computer guess a number between 0 and 100
	 */
	public static void exercice4_2() {
		System.out.print("Entrez un nombre à trouver entre 0 et 100 : ");
		int numberToGuess = scanner.nextInt();

		int computerGuess = -1;

		int min = -1;
		int max = 101;

		do {
			computerGuess = (int) (Math.random() * (max - min + 1) + min);
			System.out.println("L'ordinateur tente : " + computerGuess);
			if (computerGuess < numberToGuess) {
				System.out.println("C'est trop petit !");
				min = computerGuess + 1;
			} else if (computerGuess > numberToGuess) {
				System.out.println("C'est trop grand !");
				max = computerGuess - 1;
			}

		} while (numberToGuess != computerGuess);

		System.out.println("Trouvé c'est " + computerGuess);

	}

	/**
	 * The user makes the computer guess a number between 0 and 100
	 */
	public static void exercice4_2_v2() {
		System.out.print("Entrez un nombre à trouver entre 0 et 100 : ");
		int numberToGuess = scanner.nextInt();

		int computerGuess = 50;

		int min = -1;
		int max = 101;

		do {
			computerGuess = (min + max) / 2;
			System.out.println("L'ordinateur tente : " + computerGuess);
			if (computerGuess < numberToGuess) {
				System.out.println("C'est trop petit !");
				min = computerGuess + 1;
			} else if (computerGuess > numberToGuess) {
				System.out.println("C'est trop grand !");
				max = computerGuess - 1;
			}

		} while (numberToGuess != computerGuess);

		System.out.println("Trouvé c'est " + computerGuess);

	}
}