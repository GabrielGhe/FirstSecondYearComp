package op;

import java.util.ArrayList;

public class AfterLetter {
	ArrayList<Probability> probs;

	public AfterLetter() {
		probs = new ArrayList<Probability>();
	}

	public void add(String letter) {
		boolean found = false;
		Probability proTemp = null;
		for (Probability pro : probs) {
			if (pro.afterLetter == letter) {
				found = true;
				proTemp = pro;
			}
		}
		if (found) {
			proTemp.incProb();
		} else {
			probs.add(new Probability(letter));
		}
	}

	public String get() {
		String toReturn = "";
		int highest = -1;
		Probability prob;
		if (Math.random() * 10 > 5) {
			for (int i = 0; i < probs.size(); i++) {
				prob = probs.get(i);
				if (prob.occurances > highest) {
					toReturn = prob.afterLetter;
				}
			}
		} else {
			Probability pro = probs.get((int) (Math.random() * probs.size()));
			return pro.afterLetter;
		}
		return toReturn;
	}

}
