import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws IOException {

		Convo dropball = new Convo();
		
		String filename = "data/convo2.csv";
		
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			throw new IOException();
		}

		while (fileIn.hasNextLine()) {
			try{
				
				dropball.addText(fileIn.nextLine());

			}
			catch (Exception e) {
				//System.out.println(Long.parseLong(temp[0]) + " " + temp[0] + " 743177548");
			}
			
		}
		fileIn.close();
		
		//Chris.print();
//		System.out.println(dropball.convo.size());
//		for(int i = 0; i < dropball.convo.size(); i++) {
//			System.out.println(dropball.convo.get(i).getName());
//		}
		
		
		
		dropball.printSummary();
	}
	
//	743177548	chris
//	1522473278	ed
//	1416621208	matt
//	1192868616	timo
//	1008399177	myles

}
