package test;
import dominio.JubiladoDiscapacidad;
import dominio.JubiladoVejez;
import dominio.Jubilado;
import dominio.JubiladoPatron;
import java.util.ArrayList;
import java.util.Scanner;

public class TestJubilado {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jubilado> jubilados = new ArrayList<>();
    static ArrayList<String> jubiladoV =new ArrayList<>();
    static ArrayList<String> jubiladoD =new ArrayList<>();
    static ArrayList<String> jubiladoP =new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;        
        String cedula, nombres;
        int anios;
        do {
            op = menu(op);
            if (op != 5 && op != 4) {
                entrada.nextLine();
                System.out.print("Cedula: ");
                cedula = entrada.nextLine();
                System.out.print("Nombres: ");
                nombres = entrada.nextLine();
                System.out.print("Anios Aporte:  ");
                anios = entrada.nextInt();
                datos(op, cedula, nombres,anios);
                
            }
            if (op == 4) {
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoPatron) {
                        ((JubiladoPatron) jub).bonoSueldo();
                        jubiladoP.add(((JubiladoPatron) jub).toString());
                    }
                    
                    if (jub instanceof JubiladoDiscapacidad){
                        jubiladoD.add(((JubiladoDiscapacidad) jub).toString());
                    }
                        
                    if (jub instanceof JubiladoVejez) {
                      jubiladoV.add(((JubiladoVejez) jub).toString());
                    }
                }
                System.out.println("----------------------------------------------");
                System.out.println("\n||Jubilados por Vejez||\n");
                for (String jv : jubiladoV) {
                    System.out.println(jv);
                }
                
                System.out.println("----------------------------------------------");
                System.out.println("\n||Jubilados por Discapacidad||\n");
                for (String jd : jubiladoD) {       
                    System.out.println(jd);
                }
                
                System.out.println("----------------------------------------------");
                System.out.println("\n||Jubilados Patronal||\n");
                for (String jp : jubiladoP) {
                    System.out.println(jp);
                }


                
            }
        } while (op != 5);
    }

    public static int menu(int op) {
        System.out.println("Menu Jubilado");
        System.out.print("1. Vejez\n2. Invalidez\n3. Patronal\n4. Reporte\n5. Salir\nEscoja una Opcion. ");
        op = entrada.nextInt();
        return op;
    }

    public static void datos(int op, String cedula, String nombres, int anios) {
        double porcentaje;
        int tipo;
        switch (op) {
            case 1:
                jubilados.add(new JubiladoVejez(cedula, nombres, anios));               
                break;
            case 2:
                System.out.print("Porcentaje de discapacidad: ");
                porcentaje = entrada.nextDouble();
                jubilados.add(new JubiladoDiscapacidad(cedula, nombres, anios, porcentaje));
                break;
            case 3:
                System.out.print("Porcentaje de Inflacion: ");
                porcentaje = entrada.nextDouble();
                System.out.print("Tipo Empresa <<1>> publica <<2>> privada ");
                tipo = entrada.nextInt();
                jubilados.add(new JubiladoPatron(cedula, nombres, anios, porcentaje, tipo));
                         
        }
    }
    

}
