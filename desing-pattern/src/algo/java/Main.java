package algo.java;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		/*
		 * Y obj = new Y(); obj.f();
		 */
		
		String str ="ab";
		char duplicatChar = str.charAt(0);
		if(str.length()==0) System.out.println();
		if(str.length()==1) System.out.println(duplicatChar+"1");
        int index =0;
		for(int i=1;i<str.length();i++) {
			char x = str.charAt(i);
			char y = str.charAt(i-1);
			if(x!=y) {
				System.out.print(y+""+(i-index));
				index = i;
			}
			
			if(i == str.length()-1) {
				System.out.print(x+""+(i-index+1));
				index = i;
			}
		}
	}
}
