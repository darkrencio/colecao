import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static BufferedReader reader;

    public static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" -- Bienvenido al PMNA -- ");
        ArrayList<Alumnes> alumnes = new ArrayList<Alumnes>();

        int operacio = 0;
        while (operacio != 5) {
            System.out.println("a Afegir un alumne ");
            System.out.println("m Mostra els alumnes i notes ");
            System.out.println("t Aprova a tothom");
            System.out.println("n Canviar nom");
            System.out.println("c Canviar nota evaluació ");
            System.out.println("? Ajuda ");
            System.out.println("x Sortir");

            String linia = reader.readLine();
            switch (linia) {
                case "a":
                    if (afegirAlumne(alumnes)) {
                        System.out.println("S'ha afegit l'alumne correctament.");
                    } else {
                        System.out.println("Hem tingut un problema al crear l'alumne, torni a provar.");
                    }
                    break;
                case "m":
                    mostra(alumnes);
                    break;
                case "t":
                    if (aprovaTothom(alumnes)){
                        System.out.println("S'han aprovat correctament.");
                    } else {
                        System.out.println("Error en aprovar a tothom.");
                    }
                    break;
                case "n":
                    if (canviaNom(alumnes)){
                        System.out.println("S'ha canviat el nom correctament.");
                    } else {
                        System.out.println("Error en la introducció de dades.");
                    }
                    break;
                case "c":
                    if (canviarNota(alumnes)){
                        System.out.println("S'ha canviat la nota correctament.");
                    } else {
                        System.out.println("Error en la introducció de dades.");
                    }
                    break;
                case "?":
                    System.out.println("a: Afegir un alumne.");
                    System.out.println("m: Mostra els alumnes");
                    System.out.println("t: Aprova a tots.");
                    System.out.println("n: Canvia el nom d'un alumne.");
                    System.out.println("c: Canvia la nota d'un alumne.");
                    System.out.println("x: Sortir.");
                    break;
                case "x":
                    break;
                default:
                    operacio = 5;
                    System.out.println("Adeu, bon dia tingui!");
            }
        }
    }

    public static boolean afegirAlumne (ArrayList<Alumnes> alumnes){
        try {
            System.out.println("Introduixi la nota, ex: <nom> <nota1> <nota2> <nota3>");
            String input = reader.readLine();
            String[] a = input.split(" ");
            int n1 = Integer.parseInt(a[1]);
            int n2 = Integer.parseInt(a[2]);
            int n3 = Integer.parseInt(a[3]);

            while (n1 > 10 && n1 < 0) {
                System.out.println("<Nota 1> Introdueix un numero entre 0 i 10. ");
                n1 = reader.read();
            }
            while (n2 > 10 && n2 < 0) {
                System.out.println("<Nota 2> Introdueix un numero entre 0 i 10. ");
                n1 = reader.read();
            }
            while (n3 > 10 && n3 < 0) {
                System.out.println("<Nota 3> Introdueix un numero entre 0 i 10. ");
                n1 = reader.read();
            }

            Alumnes alumn = new Alumnes(a[0], n1, n2, n3);

            alumnes.add(alumn);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static void mostra(ArrayList<Alumnes> alumnes){
        try{
            System.out.println("Student\t\t1st\t2nd\t3rd\t|Average\n------------------------------------------------");
            for (int i = 0; i < alumnes.size(); i++){
                String nom = alumnes.get(i).getNom();
                int nota1 = alumnes.get(i).getNota1(); int nota2 = alumnes.get(i).getNota2(); int nota3 = alumnes.get(i).getNota3();
                double avg = (nota1 + nota2 + nota3)/3;
                System.out.println(nom+"\t\t"+nota1+"\t"+nota2+"\t"+nota3+"\t|"+avg);
            }
        }catch (Exception e){
            System.out.println("Error en la impresió.");
        }
    }

    public static boolean aprovaTothom(ArrayList<Alumnes> alumnes){
        try{
            for (int i = 0; i < alumnes.size(); i++){
                int nota1 = alumnes.get(i).getNota1(); int nota2 = alumnes.get(i).getNota2(); int nota3 = alumnes.get(i).getNota3();
                if (nota1 < 5){
                    alumnes.get(i).setNota1(5);
                } else if (nota2 < 5){
                    alumnes.get(i).setNota2(5);
                } else if (nota3 < 5){
                    alumnes.get(i).setNota3(5);
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean canviaNom(ArrayList<Alumnes> alumnes){
        try {
            System.out.println("Introdueix el nom de l'alumne. ");
            String alum = reader.readLine();
            System.out.println("Introdueix el nou nom");
            String nou = reader.readLine();
            for (int i = 0; i < alumnes.size(); i++){
                if (alumnes.contains(alum)){
                    alumnes.get(i).setNom(nou);
                }else{
                    ;
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean canviarNota(ArrayList<Alumnes> alumnes){
        try{
            System.out.println("Introduixi la nota, ex: <nom> <evaluació> <nota>");
            String input = reader.readLine();
            String[] a = input.split(" ");
            int eva = Integer.parseInt(a[1]);
            int n = Integer.parseInt(a[2]);

            while (n < 0 && n > 10){
                System.out.println("La nota ha de ser entre 0 i 10.");
                String buena = reader.readLine();
                n = Integer.parseInt(buena);
            }

            System.out.println("Introdueix la nota de");
            for (int i = 0; i < alumnes.size(); i++){
                if (alumnes.contains(a[0])){
                    if (eva == 1){
                        alumnes.get(i).setNota1(n);
                    } else if (eva == 2){
                        alumnes.get(i).setNota1(n);
                    } else if (eva == 3){
                        alumnes.get(i).setNota1(n);
                    } else {
                        System.out.println("La evaluació no es correcte.");
                    }
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
