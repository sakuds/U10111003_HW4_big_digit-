
// U10111003 朱永捷

import java.util.ArrayList;

public class BigInteger {

	// Define datafields : two big integer and arraylist which store these integer
	private ArrayList<Integer> int1 = new ArrayList<>();
	private ArrayList<Integer> int2 = new ArrayList<>();
	private	ArrayList<Integer> totalA = new ArrayList<>();
	private	ArrayList<Integer> totalS = new ArrayList<>();
	private int size = int1.size();

	// No-argument constructor
	public BigInteger(){
	}

	// Constructorto store two big integer
	public BigInteger(String newStr1,String newStr2){
		setInt1(newStr1);
		setInt2(newStr2);
	}

	// Define a method which return String to Integer and store in arraylist
	public void setInt1(String newStr1){
		for (int i = newStr1.length()-1; i >= 0;i--) {
			int1.add(Integer.valueOf(String.valueOf(newStr1.charAt(i))));
		}
	}
	public void setInt2(String newStr2){
		for (int i = newStr2.length()-1; i >= 0;i--) {
			int2.add(Integer.valueOf(String.valueOf(newStr2.charAt(i))));
		}
	}

	// To compute length and add 0 in small number
	public void computeLength() {
		this.vsTwo();
		for (int i = int2.size() ; i < size ;i++) {
			int2.add(0);
		}
	}

	// Let int1 > int2 and set size
	public void vsTwo() {
		ArrayList<Integer> vs = new ArrayList<>();
		if (int1.size() > int2.size()) {
			size = int1.size();
		} else if (int1.size() < int2.size()) {
			size = int2.size();
			vs = int1;
			int1 = int2;
			int2 = vs;
		} else {
			size = int1.size();
			for (int i = 0 ; i < size ;i++) {
				if (int1.get(i) < int2.get(i)) {
					vs = int1;
					int1 = int2;
					int2 = vs;
				}
			}
		}
	}

	// To compute : Adding
	public void addInt(){
		this.computeLength();
		int com = 0;
		int temp = 0;
		int adding = 0;
		while (com < size) {
			adding = int1.get(com) + int2.get(com) + temp;
			if (adding > 9) {
				adding -=10;
				temp = 1;
			} else {
				temp = 0;
			}
			totalA.add(adding);
			com++;
		}
		if (temp == 1) {
			totalA.add(1);
		}

		// Print result
		for(int i = totalA.size()-1; i >= 0 ; i--)
			System.out.print(totalA.get(i) + "");
	}

	// To compute : Subtraction
	public void subtracInt(){
		this.computeLength();
		int com = 0;
		int temp = 0;
		int subtraction = 0;
		while (com < size) {
			subtraction = int1.get(com) - temp;
			if (subtraction < int2.get(com)) {
				subtraction +=10;
				subtraction -= int2.get(com);
				temp = 1;
			} else {
				subtraction = subtraction - int2.get(com);
				temp = 0;
			}
			totalS.add(subtraction);
			com++;
		}

		// Print result
		for(int i = totalS.size()-1; i >= 0 ; i--)
			System.out.print(totalS.get(i) + "");
	}

}
