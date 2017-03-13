import java.io.File;
import java.util.ArrayList;

public class Filehandler {

	//file reader
	public byte[] reader(File filetoread) {
		Long length = filetoread.length();
		int l = length.intValue();
		byte[] bytes = new byte[l];
		return bytes;

	}

	//compare user answers with the correct answers
	public int compareanswers(ArrayList<String> correct,
			ArrayList<String> user, String[] questions) {
		int numcorrect = 0;
		for (int k = 0; k < user.size(); k++) {
			if (user.get(k).equals(correct.get(k))) {
				numcorrect = numcorrect + 1;
				System.out.println(questions[k]);
				System.out.println("The correct answer: " + correct.get(k));
				System.out.println("Your answer was: " + user.get(k) + "\n");

			} else {
				System.out.println(questions[k]);
				System.out.println("The correct answer: " + correct.get(k));
				System.out.println("Your answer was: " + user.get(k) + "\n");
			}
		}

		return numcorrect;

	}
}
