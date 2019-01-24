import java.util.Scanner;


public class TestClass {

	static final int QUESTION = 0;
	static final int ANSWER = 1;
	static final int START_OF_CHOICES = 2;

	//init questions, answers, and choices
	static String[][] multiChoice = new String[][]{
	    {"1. Which country currently emits the most greenhouse gases?", "B", "A. United States", "B. China", "C. India", "D. England"},
	    {"2. Question 2?", "C", "A. Option 1", "B. Option 2", "C. Option 3", "D. Option 4"},
	    {"3. Question 3?", "A", "A. Option 1", "B. Option 2", "C. Option 3", "D. Option 4"},
	    {"4. Question 2?", "D", "A. Option 1", "B. Option 2", "C. Option 3", "D. Option 4"}};
	
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

	    //loop through each question
	    for (int questionIndex = 0; questionIndex < multiChoice.length; questionIndex++) {
	        //print current question as well as its choices
	        printQuestion(questionIndex);
	        do {
	            //display instruction for input. It's good to put hint like A  - D so that the user will now what to enter
	            System.out.print("\nYour Answer [A - D]: ");

	        } while (!isCorrectAnswer(questionIndex, input.next().charAt(0)));  //continue asking for answer if the user entered an incorrect one
	    }
	}

	//method that checks whether the user's answer is correct for a particular question
	static boolean isCorrectAnswer(int questionNum, char userAnswer) {
	    //true if matched, false otherwise
	    boolean rightAnswer = (userAnswer + "").equalsIgnoreCase(multiChoice[questionNum][ANSWER]);
	    //equivalent to if rightAnswer is true then display "Correct", else, display "Incorrect"
	    System.out.println(rightAnswer ? "Correct!\n" : "Incorrect!\n");

	    return rightAnswer;
	}

	//method that prints a specific question and its choices
	static void printQuestion(int questionNum) {
	    System.out.println(multiChoice[questionNum][QUESTION]);
	    int lastColumn = multiChoice[questionNum].length;
	    for (int x = START_OF_CHOICES; x < lastColumn; x++) {
	        System.out.println("\t" + multiChoice[questionNum][x]);
	    }
	}

}
