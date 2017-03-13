import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Phuoc Nguyen
 *
 */
public class FinalProject {
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException {
		// List directory for users to see the kinds of tests
		File file = new File("c://test//tests//math.txt");
		file = new File(file.getParent());
		for (File f : file.listFiles()) {
			System.out.println(f.getName());
		}
		// let user pick which test they want
		Scanner input = new Scanner(System.in);
		System.out.print("Pick a Test (Do not type in the .txt): ");
		String listanswer = input.nextLine();

		// create new files based on what users want
		File questionfile = new File("c://test//tests//" + listanswer + ".txt");
		File answerfile = new File("c://test//answers//" + listanswer + "answers.txt");
		InputStream questionin = new FileInputStream(questionfile);
		InputStream answerin = new FileInputStream(answerfile);

		// read question file
		Filehandler filetoread = new Filehandler();
		byte[] qbytes = filetoread.reader(questionfile);
		questionin.read(qbytes);
		String quesbytes = new String(qbytes);
		// split question file by line
		String[] questionsfromfile = quesbytes.split("\n");

		// read answer files
		byte[] abytes = filetoread.reader(answerfile);
		answerin.read(abytes);
		String ansbytes = new String(abytes);
		// split Answers using semicolon
		String[] answersfromfile = ansbytes.split(";");
		//array to list trimmed
		ArrayList<String> answer = new ArrayList<String>();
		for (int i = 0; i < answersfromfile.length; i++)
			answer.add(i,answersfromfile[i].trim());
		
		// another array list of multiple choices for easy display
		String[] words = ansbytes.split("\n");
		ArrayList<String> answerlist = new ArrayList<String>();
		// Fill the array for display (each row in each element).
		for (String temp : words) {
			String displayanswer = temp.replaceAll(";", "  ");
			answerlist.add(displayanswer);
		}

		System.out.println("" + "\n******** BEGIN TEST ********\n");
		// display questions and choices 1 at a time and ask for user answer
		// new array list to store user answers
		ArrayList<String> useranswers = new ArrayList<String>();
		for (int i = 0; i < questionsfromfile.length; i++) {
			System.out.println("Q " + ": " + questionsfromfile[i]);
			System.out.println(answerlist.get(i));
			System.out.print("What is your answer: ");
			String User = input.nextLine();
			// make user answer an answer that matches one from the ones read
			// from a file
			SetUser changeanswer = new SetUser();
			useranswers.add(changeanswer.setanswer(User, answer));
			System.out.print("\n");
			// remove first 5 indexes to move up previous indexes for new question
			for (int j = 4; j > -1; j--) {
				answer.remove(j);
			}

		}
		System.out.println("" + "\n******** END OF TEST ********\n");
		// close all files and scanners
		questionin.close();
		answerin.close();
		input.close();

		// get the correct answers from file
		File correctfile = new File("c://test//answers//" + listanswer
				+ "correct.txt");
		InputStream correctin = new FileInputStream(correctfile);
		// read correct files
		byte[] cbytes = filetoread.reader(correctfile);
		correctin.read(cbytes);
		String corbytes = new String(cbytes);
		// split correct answers using line
		String[] correctfromfile = corbytes.split("\n");
		//array to list trimmed
		ArrayList<String> correctanswers = new ArrayList<String>();
		for (int i = 0; i < correctfromfile.length; i++)
			correctanswers.add(i,correctfromfile[i].trim());

		// compare the 2 arrays for correctness and display
		int correct = filetoread.compareanswers(correctanswers, useranswers,
				questionsfromfile);
		//close file
		correctin.close();
		//print score
		System.out.println("You got " + correct + "/" + useranswers.size()
				+ " questions right");

		/* for (int j = 0; j < useranswers.size(); j++) {
		// String value = useranswers.get(j);
		// System.out.println(value);
		// }
		// for (int y = 0; y < correctanswers.size(); y++) {
		// String value = correctanswers.get(y);
		// System.out.println(value);}
		 * */

	}

}
