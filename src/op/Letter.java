package op;

public class Letter {
	private AfterLetter after;
	
	public Letter(){
		after = new AfterLetter();
	}
	
	public void addAfter(String letter){
		after.add(letter);
	}
	
	public String get(){
		return after.get();
	}
}
