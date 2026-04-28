package vista;

import java.util.Scanner;

public class Consola {
	public int pideNum(String texto) {
		Scanner teclado = new Scanner(System.in);
		int num=-1;
		boolean numOk=false;
		
		do {
			System.out.print(texto);
            try {
                num = teclado.nextInt();
                numOk = true;
            } catch (Exception e) {
                System.out.println("Introduzca un numero, no letras!!");
                teclado.nextLine(); 
            }
			
		}while(!numOk);
		return num;
	}
	
	public float pideFloat(String texto) {
        Scanner teclado = new Scanner(System.in);
        float num = -1f; 
        boolean numOK = false;
        do {
            System.out.print(texto);
            try {
                num = teclado.nextFloat();
                numOK = true;
            } catch (Exception e) {
                System.out.println("Introduzca un numero, no letras!!");
                teclado.nextLine(); 
            }
        } while (!numOK);
        return num;
    }

    
    public String pideCadena(String texto) {
        Scanner teclado = new Scanner(System.in);
        String cadena;

        System.out.print(texto);
        cadena = teclado.nextLine();

        return cadena;
    }

    
    public void muestraCadena(String texto) {
        System.out.println(texto);
    }
}
