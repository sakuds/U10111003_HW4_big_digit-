
// U10111003 朱永捷

import java.util.ArrayList;

public class BigFloat {

	// Define datafields : two big integer and arraylist which store these integer
	private ArrayList<Integer> int1 = new ArrayList<>();
	private ArrayList<Integer> int2 = new ArrayList<>();
	private ArrayList<Integer> float1 = new ArrayList<>();
	private ArrayList<Integer> float2 = new ArrayList<>();
	private	ArrayList<Integer> totalA = new ArrayList<>();
	private	ArrayList<Integer> totalfA = new ArrayList<>();
	private	ArrayList<Integer> totalS = new ArrayList<>();
	private	ArrayList<Integer> totalfS = new ArrayList<>();
	private int size = 0;
	private int sizef = 0;

	// No-argument constructor
	public BigFloat(){
	}

	// Constructorto store two big integer
	public BigFloat(String newStr1,String newStr2){
		setInt1(newStr1);
		setInt2(newStr2);
		setFloat1(newStr1);
		setFloat2(newStr2);
	}

	// Define a method which return String to Integer and store in arraylist
	public void setInt1(String newStr1){
		if (newStr1.contains(".")) {
			int temp = newStr1.indexOf(".")-1;
			for (int i = temp; i >= 0;i--) {
				int1.add(Integer.valueOf(String.valueOf(newStr1.charAt(i))));
			}
		} else {
			for (int i = newStr1.length()-1; i >= 0;i--) {
				int1.add(Integer.valueOf(String.valueOf(newStr1.charAt(i))));
			}
		}
	}
	public void setInt2(String newStr2){
		if (newStr2.contains(".")) {
			int temp = newStr2.indexOf(".")-1;
			for (int i = temp; i >= 0;i--) {
				int2.add(Integer.valueOf(String.valueOf(newStr2.charAt(i))));
			}
		} else {
			for (int i = newStr2.length()-1; i >= 0;i--) {
				int2.add(Integer.valueOf(String.valueOf(newStr2.charAt(i))));
			}
		}
	}
	public void setFloat1(String newStr1){
		if (newStr1.contains(".")) {
			int temp = newStr1.indexOf(".")+1;
			for (int i = temp; i <= newStr1.length()-1;i++) {
				float1.add(Integer.valueOf(String.valueOf(newStr1.charAt(i))));
			}
		} else {
			float1.add(0);
		}
	}
	public void setFloat2(String newStr2){
		if (newStr2.contains(".")) {
			int temp = newStr2.indexOf(".")+1;
			for (int i = temp; i <= newStr2.length()-1;i++) {
				float2.add(Integer.valueOf(String.valueOf(newStr2.charAt(i))));
			}
		} else {
			float2.add(0);
			float2.add(0);
		}
	}

	// To compute length and add 0 in small number
	public void computeLength() {
		this.vsTwo();
		for (int i = int2.size() ; i < size ;i++) {
			int2.add(0);
		}
		if (float1.size() < sizef ) {
			for (int i = float1.size() ; i < sizef ;i++) {
				float1.add(0);
			}
		} else if (float2.size() < sizef ) {
			for (int i = float2.size() ; i < sizef ;i++) {
				float2.add(0);
			}
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
			vs = float1;
			float1 = float2;
			float2 = vs;
		} else {
			size = int1.size();
			for (int i = 0 ; i < size ;i++) {
				if (int1.get(i) < int2.get(i)) {
					vs = int1;
					int1 = int2;
					int2 = vs;
					vs = float1;
					float1 = float2;
					float2 = vs;
				}
			}
		}
		if (float1.size() > float2.size()) {
			sizef = float1.size();
		} else {
			sizef = float2.size();
		}
	}

	// To compute : Adding
	public void addFlo(){
		this.computeLength();
		int com = sizef-1;
		int temp = 0;
		int adding = 0;
		while (com >= 0) {
			adding = float1.get(com) + float2.get(com) + temp;
			if (adding > 9) {
				adding -=10;
				temp = 1;
			} else {
				temp = 0;
			}
			totalfA.add(adding);
			com--;
		}
		com = 0;
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
		System.out.print(".");
		for(int i = totalfA.size()-1; i >= 0 ; i--)
			System.out.print(totalfA.get(i) + "");
	}

	// To compute : Subtraction
	public void subtracFlo(){
		this.computeLength();
		int com = sizef-1;
		int temp = 0;
		int subtraction = 0;
		while (com >= 0) {
			subtraction = float1.get(com) - temp;
			if (subtraction < float2.get(com)) {
				subtraction +=10;
				subtraction -= float2.get(com);
				temp = 1;
			} else {
				subtraction = subtraction - float2.get(com);
				temp = 0;
			}
			totalfS.add(subtraction);
			com--;
		}
		com = 0;
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
		System.out.print(".");
		for(int i = totalfS.size()-1; i >= 0 ; i--)
			System.out.print(totalfS.get(i) + "");
	}
}
