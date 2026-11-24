import java.util.ArrayList;
import java.util.List;

public final class Calculatrice {
    private static volatile Calculatrice instance = null;

    public int x;
    public int y;
    private int compteurOperations = 0;
    private final List<String> historique = new ArrayList<>();

    private Calculatrice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Calculatrice getInstance() {
        return getInstance(0, 0);
    }

    public static Calculatrice getInstance(int x, int y) {
        if (instance == null) {
            synchronized (Calculatrice.class) {
                if (instance == null) {
                    instance = new Calculatrice(x, y);
                }
            }
        }
        return instance;
    }

    private void enregistrer(String op) {
        compteurOperations++;
        historique.add(compteurOperations + ". " + op);
    }

    public int somme(int a, int b) {
        int r = a + b;
        enregistrer(a + " + " + b + " = " + r);
        return r;
    }

    public int soustraction(int a, int b) {
        int r = a - b;
        enregistrer(a + " - " + b + " = " + r);
        return r;
    }

    public int produit(int a, int b) {
        int r = a * b;
        enregistrer(a + " * " + b + " = " + r);
        return r;
    }

    public float moyenne(int a, int b) {
        float r = (a + b) / 2f;
        enregistrer("moyenne(" + a + ", " + b + ") = " + r);
        return r;
    }

    public int getCompteurOperations() {
        return compteurOperations;
    }

    public void afficheHistorique() {
        System.out.println("Historique (" + compteurOperations + " opérations) :");
        historique.forEach(l -> System.out.println("  " + l));
    }

    public void affiche() {
        System.out.println("Instance : x=" + x + ", y=" + y
                + ", opérations=" + compteurOperations);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
