package Dibujos;

import jconsole.JConsole;

public class Dibujo01 {
	public static void main (String[] args) {
		int num1, num2, cont1 = 1, cont2 = 1;
		
		JConsole console = new JConsole(80, 20);
		
		num1 = console.readInt();
		num2 = console.readInt();
		
		if (num1 > 0 && num2 > 0) {
			while (cont2 <= num2) {
				while (cont1 <= num1) {
					console.print("* ");
					cont1++;
				}
				console.println("* ");
				cont2++;
			}
		} else {
			console.println("error");
		}
		
		
		
	}
}
