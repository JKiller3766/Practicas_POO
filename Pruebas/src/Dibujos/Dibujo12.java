package Dibujos;

import jconsole.JConsole;

public class Dibujo12 {
	public static void main (String[] args) {
		int num, cont1, cont2 = 1, cont3 = 1;
		
		JConsole console = new JConsole(80, 20);
		
		num = console.readInt();
		cont1 = num;
		
		if (num > 0) {
			while (cont1 >= 1) {
				while (cont3 <= num - cont1) {
					console.print(" ");
					cont3++;
				}
				while (cont2 <= cont1) {
					console.print(cont2 + " ");
					cont2++;
				}
				console.println();
				cont1--;
				cont2 = 1;
				cont3 = 1;
			}
			
		} else {
			console.println("error");
		}
		
		
		
	}
}
