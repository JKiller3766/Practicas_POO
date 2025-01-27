package Dibujos;

import jconsole.JConsole;

public class Dibujo05 {
	public static void main (String[] args) {
		int num, cont1 = 1, cont2 = 1;
		
		JConsole console = new JConsole(80, 20);
		
		num = console.readInt();
		
		if (num > 0) {
			while (cont1 <= num) {
				while (cont2 <= num) {
					if (cont2 == cont1) {
						console.print(cont2 + " ");
					} else {
						console.print("* ");
					}
						
					cont2++;
				}
				console.println();
				cont1++;
				cont2 = 1;
			}
		} else {
			console.println("error");
		}
		
		
		
	}
}
