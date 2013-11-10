package op;

public class Probability implements Comparable<Object>{
	public String afterLetter;
	public int occurances;
	
	public Probability(String let){
		afterLetter = let;
		occurances = 0;
	}
	
	public void incProb(){
		occurances++;
	}
	
	public boolean equals(Object obj) {
		Probability p = (Probability) obj;
		return p.afterLetter == this.afterLetter;
	}

	@Override
	public int compareTo(Object o) {
		Probability temp = (Probability)o;
		if(temp.occurances > this.occurances){
			return -1;
		} else if(temp.occurances < this.occurances){
			return 1;
		} else {
			return 0;
		}
	}
}
