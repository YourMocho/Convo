import java.util.ArrayList;


public class Convo {

	ArrayList<Person> convo;
	Person transcript;
	
	Convo() {
		convo = new ArrayList<Person>();
		transcript = new Person("Transcript");
	}
	
	public void addPerson(Person p) {
		convo.add(p);
	}
	
	public void addText(String s) {
		String[] temp = new String[2];
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ',') {
				temp[0] = s.substring(0, i);
				temp[1] = s.substring(i+1);
				break;
			}
		}
			
		transcript.add(temp[1]);
		
		boolean found = false;
		
		for(int i = 0; i < convo.size(); i++) {
			if(temp[0].equals(convo.get(i).getName())) {
				convo.get(i).add(temp[1]);
				found = true;
			}
		}
		if(!found)
			convo.add(new Person(temp[0], temp[1]));
		
	}
	
	public void printSummary() {
		for(int i = 0; i < convo.size(); i++) {
			//for(int i = 4; i < 5; i++) {
			System.out.println(convo.get(i).getName() + ": "+ convo.get(i).size() + " messages containing " + convo.get(i).countWords() + " words, with an average of " + convo.get(i).countWords()/(float)convo.get(i).size() + " words per message");
			System.out.println("Most used words: \n" + convo.get(i).mostFrequWords());
		}
		System.out.println("Total: "+ transcript.size() + " messages containing " + transcript.countWords() + " words, with an average of " + transcript.countWords()/(float)transcript.size() + " words per message");
	}
}
