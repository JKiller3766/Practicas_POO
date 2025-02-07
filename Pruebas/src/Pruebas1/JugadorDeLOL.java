package Pruebas1;

public class JugadorDeLOL {
	
	private String nombre;
	private int edad;
	private String rango;
	private int añosSinCoito;
	
	public JugadorDeLOL(String nom, int añosDesdeSuNacimiento, String rank) {
		nombre = nom;
		edad = añosDesdeSuNacimiento;
		rango = rank;
		añosSinCoito = añosDesdeSuNacimiento;
	}
	
	public String getNombre() {return nombre;}
	public int getEdad() {return edad;}
	public String getRango() {return rango;}
	public int getAñosSinAfecto() {return añosSinCoito;}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public void setEdad(int añosDesdeSuNacimiento) {
			edad = añosDesdeSuNacimiento;
			añosSinCoito = añosDesdeSuNacimiento;
		}
	
	public void setRango(String rank) {
		rango = rank;
	}
	
}
