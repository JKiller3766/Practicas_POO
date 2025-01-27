package Dibujos;

import jconsole.JConsole;

public class Dibujo06 {
	public static void main (String[] args) {
		int num, cont1 = 1, cont2 = 1;
		
		JConsole console = new JConsole(80, 20);
		
		num = console.readInt();
		
		if (num >= 3 && num % 2 == 1) {
			while (cont1 <= num) {
				while (cont2 <= num) {
					if (cont1 == 1) {
						console.print("T ");
					} else if (cont1 == num){
						console.print("B ");
					} else if (cont2 == 1){
						console.print("E ");
					} else if (cont2 == num){
						console.print("D ");
					} else if (cont1 == num/2+1 && cont2 == num/2+1) {
						console.print("C ");
					} else {
						console.print("  ");
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
