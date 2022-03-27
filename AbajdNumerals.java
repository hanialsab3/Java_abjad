import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AbajdNumerals {
	public static Map<String, Integer> abjad = new HashMap<String, Integer>();
	public static ArrayList<HashMap<String, Integer>> dic = new ArrayList<HashMap<String, Integer>>();

	
	public static void fill() {
		abjad.put("ا", 1);
		abjad.put("ب", 2);
		abjad.put("ج", 3);
		abjad.put("د", 4);
		abjad.put("ه", 5);
		abjad.put("و", 6);
		abjad.put("ز", 7);
		abjad.put("ح", 8);
		abjad.put("ط", 9);
		abjad.put("ي", 10);
		abjad.put("ك", 20);
		abjad.put("ل", 30);
		abjad.put("م", 40);
		abjad.put("ن", 50);
		abjad.put("س", 60);
		abjad.put("ع", 70);
		abjad.put("ف", 80);
		abjad.put("ص", 90);
		abjad.put("ق", 100);
		abjad.put("ر", 200);
		abjad.put("ش", 300);
		abjad.put("ت", 400);
		abjad.put("ث", 500);
		abjad.put("خ", 600);
		abjad.put("ذ", 700);
		abjad.put("ض", 800);
		abjad.put("ظ", 900);
		abjad.put("غ", 1000);
	}
		
	static ArrayList<String> split(String str) {
		  
	        String[] stringSplit = str.split(" ");
	  
	        ArrayList<String> abjdList = new ArrayList<String>(
	        Arrays.asList(stringSplit));
	  
	        
	        return abjdList;
	    }
		

	
	static HashMap<String, Integer> wordValue(String s){
		int counter=0;
		HashMap<String, Integer> wordmap = new HashMap<String, Integer>();
		try {
			for (int i = 0; i < s.length(); i++) {
		           counter+=abjad.get(String.valueOf(s.charAt(i)));      
		        }
		        wordmap.put(s, counter);
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		return wordmap;
		
    }
	
	static ArrayList<HashMap<String, Integer>> sentenceValue(String s){
		ArrayList<String> test= split(s);
		ArrayList<HashMap<String, Integer>> abjd = new ArrayList<HashMap<String, Integer>>();
		 for (String k : test) {
			abjd.add(wordValue(k));
		 }
		 return abjd;
	}
	
	static String contains (ArrayList<HashMap<String, Integer>> list , int x) {
		String word="";
		for (HashMap<String, Integer> map : list) {
			if (map.containsValue(x)) {
				word = map.keySet().toString();
			}
					
		}
		word= word.replaceAll("\\[", "").replaceAll("\\]", "");
		return word;
	}
	
	static int contains2 (ArrayList<HashMap<String, Integer>> list , int x) {
		int count = 0;
		String word="";
		for (HashMap<String, Integer> map : list) {
			if (map.containsValue(x)) {
				count+=1;
				word = map.keySet().toString();
			}
					
		}
		word= word.replaceAll("\\[", "").replaceAll("\\]", "");
		return count;
	}
	
  public static void main(String[] args) {
	fill();
	System.out.println(System.getProperty("file.encoding"));
	try {  
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.print("Please enter your text: ");
		String text=br.readLine();
		System.out.print("Enter a numerical value: ");
		int num =Integer.parseInt(br.readLine());
		dic= sentenceValue(text);
		String word = contains(dic,num);
		int count = contains2(dic, num);
		if (count==0) {
			System.out.format("Your text, \"%s\" does not contain a word with the entered Abjad numeral.", text);
		}
		else {
			
		System.out.format("Your text, \"%s\" contains the word (%s) and it's repeated %o times.", text, word, count);
			}
		}
		
	catch (IOException ioe) {
		System.out.println("Error while inputting data!");
	}
	
  }
}
