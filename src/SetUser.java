import java.util.ArrayList;


public class SetUser {
	//stores user answers in a array list 
	public String setanswer(String a, ArrayList<String>b) {
		if (a.equalsIgnoreCase("A")) {
			a = b.get(0);
		} else if (a.equalsIgnoreCase("B")) {
			a = b.get(1);
		} else if (a.equalsIgnoreCase("C")) {
			a = b.get(2);
		} else if (a.equalsIgnoreCase("D")) {
			a = b.get(3);
		} else if (a.equalsIgnoreCase("E")){
			a = b.get(4);
		} else 
		{
			a = "Blank or Invalid Anwser";
		}
		
		return a;}
}

