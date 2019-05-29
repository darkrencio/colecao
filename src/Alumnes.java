public class Alumnes {
    private String nom;
    private int nota1;
    private int nota2;
    private int nota3;

    Alumnes(){}

    Alumnes(String nom, int nota1, int nota2, int nota3){
        this.nom = nom;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }
    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public String getNom() {
        return nom;
    }
    public int getNota1() {
        return nota1;
    }
    public int getNota2() {
        return nota2;
    }
    public int getNota3() {
        return nota3;
    }
}