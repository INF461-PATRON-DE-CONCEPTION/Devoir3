public class TestCalculatrice {
    public static void main(String[] args) {
        Calculatrice c1 = Calculatrice.getInstance(8, 3);
        c1.somme(2, 5);
        c1.soustraction(10, 4);

        Calculatrice c2 = Calculatrice.getInstance(16, 19);
        c2.produit(6, 7);
        c2.moyenne(8, 3);

        c1.affiche();
        System.out.println("Meme instance ? " + (c1 == c2));
        System.out.println("Compteur via c2 : " + c2.getCompteurOperations());
        c2.afficheHistorique();
    }
}
