import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TP2 {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		exercice1_partie_2();

		scanner.close();
	}

	/**
	 * Make the user choose an exercise to play
	 */
	public static void chooseExercise() {
		String[][] exercises = { { "0. Exercice 1 : Nombre de Fibonacci v1 ", "exercice1_v1" },
				{ "1. Exercice 1 : Nombre de Fibonacci v2", "exercice1_v2" },
				{ "2. Exercice 1 : Nombre de Fibonacci v3", "exercice1_v3" },
				{ "3. Exercice 2 : Chiffres d’un nombre entier", "exercice2" },
				{ "4. Exercice 3.1 : Boucle imbriquées : nombres premiers", "exercice3_1" },
				{ "5. Exercice 3.2 : Boucle imbriquées : nombres premiers", "exercice3_2" },
				{ "6. Exercice 4.1.1 : Tri comptage", "exercice4_1_1" },
				{ "7. Exercice 4.1.2 : Tri comptage", "exercice4_1_2" },
				{ "8. Exercice 4.2 : Tri à bulles", "exercice4_2" },
				{ "9. Partie 2 Exercice 1 : Quick Sort", "exercice1_partie_2" },
				{ "10. Partie 2 Exercice 2 : Suite de Conway", "exercice2_partie_2" } };

		boolean retry = true;

		while (retry) {
			for (String[] exercise : exercises) {
				System.out.println(exercise[0]);

			}

			System.out.print("Choisi un exercice:");

			int choice = scanner.nextInt();

			try {

				System.out.println(exercises[choice][0]);
				Method method = Class.forName("TP2").getMethod(exercises[choice][1]);
				method.invoke(exercises[choice][1]);

			} catch (Exception e) {

				System.out.print("Choisi un exercice:");
				e.printStackTrace();

			}

			boolean retrySame = false;
			do {
				System.out.println("Encore une fois ? [0] Oui/[1] Autre exercice");
				if (scanner.nextInt() == 0) {
					retrySame = true;
					try {
						System.out.println(exercises[choice][0]);
						Method method = Class.forName("TP2").getMethod(exercises[choice][1]);
						method.invoke(exercises[choice][1]);

					} catch (Exception e) {

						System.out.print("Erreur");
						e.printStackTrace();

					}
				} else {
					retrySame = false;
				}
			} while (retrySame);
		}
	}

	/**
	 * Return the fibonacci sequence for the user input, without array and recursion
	 */
	public static void exercice1_v1() {
		System.out.print("Saisir un nombre entre 2 et 46 : ");
		int userInput = scanner.nextInt();
		int fnMinus1 = 1;
		int fnMinus2 = 0;
		int current = 0;
		System.out.print(fnMinus2 + " ");
		System.out.print(fnMinus1 + " ");

		for (int i = 2; i <= userInput; i++) {
			current = fnMinus1 + fnMinus2;
			fnMinus2 = fnMinus1;
			fnMinus1 = current;
			System.out.print(current + " ");
		}
		System.out.println("");

		System.out.println("Fibo à F" + userInput + " = " + current);

	}

	/**
	 * Return the fibonacci sequence for the user input, with array and without
	 * recursion
	 */
	public static void exercice1_v2() {

		System.out.print("Saisir un nombre entre 2 et 46 : ");
		int userInput = scanner.nextInt();

		int[] fibo = new int[userInput + 1];

		fibo[0] = 0;
		System.out.print(fibo[0] + " ");

		fibo[1] = 1;
		System.out.print(fibo[1] + " ");

		for (int i = 2; i <= userInput; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
			System.out.print(fibo[i] + " ");
		}
		System.out.println("");

		System.out.println("Fibo à F" + userInput + " = " + fibo[userInput]);

	}

	/**
	 * Return the fibonacci sequence for the user input, with recursion
	 */
	public static void exercice1_v3() {
		System.out.print("Saisir un nombre entre 2 et 46 : ");
		int userInput = scanner.nextInt();
		for (int i = 0; i <= userInput; i++) {
			System.out.print(fib(i) + " ");
		}
		System.out.println("");
		System.out.println("Fibo à F" + userInput + " = " + fib(userInput));

	}

	/**
	 * Return the fibonacci number for a given position
	 * 
	 * @param position
	 * @return integer
	 */
	public static int fib(int position) {
		if (position <= 1) {
			return position;
		} else {
			return fib(position - 1) + fib(position - 2);
		}

	}

	/**
	 * Return the user number but upside down
	 */
	public static void exercice2() {
		System.out.print("Saisir un nombre : ");
		int userInput = scanner.nextInt();
		int inversed = 0;
		int userInputLenght = Integer.toString(userInput).length();
		for (int i = 0; i < userInputLenght; i++) {
			int nextNumber = userInput % 10;
			System.out.println("---> " + nextNumber);
			inversed = (inversed * 10) + nextNumber;
			userInput = userInput / 10;
		}
		System.out.println("A l’envers le nombre est " + inversed);

	}

	/**
	 * Return if a number is prime
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number) {
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0 || number == 1) {
			return false;
		}
		for (int i = 3; i < number / 2; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return if user digit is prime
	 */
	public static void exercice3_1() {
		System.out.print("Saisir un nombre : ");
		int userInput = scanner.nextInt();
		if (isPrime(userInput)) {
			System.out.println(userInput + " est un nombre premier");
		} else {
			System.out.println(userInput + " n'est pas un nombre premier");
		}
	}

	/**
	 * Return all the prime number inferior or equal to the user number
	 */
	public static void exercice3_2() {
		System.out.print("Saisir un nombre : ");
		int userInput = scanner.nextInt();
		for (int i = 0; i <= userInput; i++) {
			if (isPrime(i)) {
				System.out.println("----> " + i);

			}
		}
	}

	/**
	 * Return this array [9, 4, 6, 4, 7, 2, 7] sort asc
	 */
	public static void exercice4_1_1() {

		int[] countedValues = exercice4_1_2();
		List<Integer> sortedValuesList = new ArrayList<Integer>();

		for (int i = 0; i < countedValues.length; i++) {

			for (int j = 0; j < countedValues[i]; j++) {
				sortedValuesList.add(i);
			}

		}
		System.out.println(sortedValuesList);

	}

	/**
	 * Return the number of occurence for each int in this array [9, 4, 6, 4, 7, 2,
	 * 7]
	 */
	public static int[] exercice4_1_2() {

		int[] values = { 9, 4, 6, 4, 7, 2, 7 };

		int countedValues[] = new int[Arrays.stream(values).max().getAsInt() + 1];
		Arrays.fill(countedValues, 0);

		for (int i = 0; i < values.length; i++) {
			countedValues[values[i]] += 1;
		}

		return countedValues;

	}

	/**
	 * Return the array sorted with bubble sort
	 */

	public static void exercice4_2() {
		int[] values = { 2023, 2016, 2014, 2032, 2011, 2022, 2014, 1992, 2014, 1998, 2020, 2028, 2011, 2009, 2017, 2001,
				2028, 2014, 2025 };

		for (int j = 0; j < values.length - 1; j++) {

			for (int i = 0; i < values.length - 1; i++) {

				if (values[i] > values[i + 1]) {
					int current = values[i];
					values[i] = values[i + 1];
					values[i + 1] = current;
				}

			}

		}
		System.out.println(Arrays.toString(values));
	}

	public static void exercice1_partie_2() {
		int[] values = { 6, 3, 7, 9, 1, 5, 4 };
		System.out.println("values initial : " + Arrays.toString(values));

		int min = 0;

		int max = 6;
		quickSort(values, min, max);

	}

	public static void quickSort(int[] values, int min, int max) {

		int currentPivotValue = values[max];
		int comparateurValue = values[min];
		int beforePivotPosition = max - 1;
		while (min < max) {

			// System.out.println(comparateurValue + " > " + currentPivotValue + " = " +
			// (comparateurValue > currentPivotValue));
			if (comparateurValue > currentPivotValue) {
				values[min] = values[beforePivotPosition];
				values[beforePivotPosition] = currentPivotValue;
				values[max] = comparateurValue;
				max--;

			} else {
				min++;
			}

			System.out.println("---------------");
			System.out.println("values trié    : " + Arrays.toString(values));
		}

		// left
		int pivotIndexLeft = max - 1;
		if (pivotIndexLeft - min > 2) {
			System.out.println("---gauche---" + Arrays.toString(values));
			quickSort(values, min, pivotIndexLeft);
		}

		// right
		int comparedIndexRight = max + 1;

		if (max - comparedIndexRight > 2) {
			System.out.println("---droite---" + Arrays.toString(values));
			quickSort(values, comparedIndexRight, max);
		}

	}

	public static void exercice2_partie2() {
		// TODO Auto-generated method stub

	}

}
