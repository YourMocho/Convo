import java.util.ArrayList;

public class Person {

	ArrayList<String> messages = new ArrayList<String>();
	String name;
	
	Person(String s) {
		name = s;
	}
	
	Person(String s, String data) {
		name = s;
		add(data);
	}
	
	public void add(String data) {
		messages.add(data);
	}
	
	public void print() {
		for(int i = 0; i < messages.size(); i++) {
			System.out.println(messages.get(i));
		}
	} 
	
	public int countWords() {
		int count = 0;
		
		for(int i = 0; i < messages.size(); i++) {
			String[] temp = messages.get(i).split(" ");
			count += temp.length;
		}
		
		return count;
	}
	
	public int size() {
		return messages.size();
	}
	
	public String getName() {
		return name;
	}
	
	public String mostFrequWords() {
		ArrayList<String[]> words = new ArrayList<String[]>();
		
		for(int i = 0; i < messages.size(); i++) {
			String[] temp = messages.get(i).split(" ");
			
			for(int k = 0; k < temp.length; k++) {
				boolean found = false;
				for(int m = 0; m < words.size(); m++){
					if(words.get(m)[0].equalsIgnoreCase(temp[k])) {
						String[] temp2 = {words.get(m)[0], Integer.toString((Integer.parseInt(words.get(m)[1]) + 1))};
						words.set(m, temp2); 
						found = true;
						break;
					}
				}
				if(!found) {
					String[] temp1 = {temp[k] , "1"};
					words.add(temp1);
				}
				
			}
			
		}
		
		String[] remove = {"the" , "is" , "to" , "and" , "a" , "it" , "in" , "you" , "that" , "of", " " , "are"};
		for (int i = 0; i < words.size(); i++) {
			for (int k = 0; k < remove.length; k++) {
				if(words.get(i)[0].equalsIgnoreCase(remove[k]))
					words.remove(i);
			}
		}
		
		
		for (int i = 1; i < words.size(); i++) {
			int j = i;
			String[] temp = words.get(i);
			while (j > 0
					&& Integer.parseInt(words.get(j - 1)[1]) < Integer
							.parseInt(temp[1])) {
				words.set(j, words.get(j - 1));
				j--;
			}
			words.set(j, temp);
		}
		
		String[] find = {"lol" , "lel" , "gay" , "fuck" , "fucking" , "shit" , "cunt" , "fag" , "fagit"};
		
		String result = "";
		for(int i = 0; i < words.size(); i++) {
			for (int k = 0; k < find.length; k++) {
				if(words.get(i)[0].equalsIgnoreCase(find[k])) //.toLowerCase().contains("lel"))
					result += (i+1) + ". " + words.get(i)[0] + " - " + words.get(i)[1] + " times \n";
			}
			//System.out.println(words.get(i)[0]);
		}
		return result;
	}
	
	
	
}
