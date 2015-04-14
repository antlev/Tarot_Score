import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused") // import Exception utile uniquement pour la solution en attente
public class Partie {
	
	
	private String nomJoueur,nomJoueurSansEspaces,nomJoueurSansEspacesMin, joueurPreneur = "" ,joueurPreneurMin = "", type = "", ecart; // Déclaration des réponses des entrées en chaîne de caractères
	private char nouvPartie = 'O', nouvTour = ' ', repType = ' ', reussiOuNon = ' '; // Déclaration des réponses des entrées de caractères
	private int ecartInt=0, nbTour=0; // Déclaration des entiers
	private boolean gainOuNon, nextIntUtilise = false, annonceGrandChelemB = false, reussiGrandChelemB = false ; // Déclaration des réponses des entrées en chaîne en booléen
	
	Scanner sc = new Scanner(System.in) ;
	public static Joueur defense1,defense2,defense3;
	
	// Constructeur
	public Partie(int nbTour) throws InterruptedException {
        this.nbTour = nbTour;
	}
	
	public static void disBonjour() { 
		System.out.println("**************************************************");
		System.out.println("BONJOUR ET BIENVENUE SUR MON APPLICATION TAROT-SCORE");
		System.out.println("**************************************************");
		System.out.println("Cette application vous permettra de comptez vos");
		System.out.println( "scores au Tarot à 4 Joueurs");
		System.out.println("**************************************************");
		System.out.println("On commence une nouvelle partie") ;
		System.out.println("**************************************************");
	}

	public static void disAurevoir() throws InterruptedException{
	System.out.println("*************************************************");
	System.out.println("**Vous venez de choisir de quittez le programme**");
	System.out.println("*************************************************");
	System.out.println("------------Au revoir et à bientot :)------------"); 
	System.out.println("*************************************************");
	Thread.sleep(5000);
	}

	public void afficheGagnant(){
		
		// structure if pour donnez le gagnant de la partie
		ArrayList<Joueur> gagnant = new ArrayList<Joueur>();
		int tmpGagnant = 0 ; // variable permettant de comparer les scores et stocker le plus grand
		tmpGagnant = Joueur.stockJoueurs.get(0).getScore();
		gagnant.add(Joueur.stockJoueurs.get(0));
		if ( Joueur.stockJoueurs.get(1).getScore() > tmpGagnant ) {
			tmpGagnant = Joueur.stockJoueurs.get(1).getScore();
			gagnant.removeAll(gagnant);
			gagnant.add(Joueur.stockJoueurs.get(1));
		}else if (Joueur.stockJoueurs.get(1).getScore() == tmpGagnant) {
			gagnant.add(Joueur.stockJoueurs.get(1));
		}
		if ( Joueur.stockJoueurs.get(2).getScore() > tmpGagnant ) {
			tmpGagnant = Joueur.stockJoueurs.get(2).getScore();
			gagnant.removeAll(gagnant);
			gagnant.add(Joueur.stockJoueurs.get(2));
		}else if (Joueur.stockJoueurs.get(2).getScore() == tmpGagnant) {
			gagnant.add(Joueur.stockJoueurs.get(2));
		}
		if ( Joueur.stockJoueurs.get(3).getScore() > tmpGagnant ) {
			tmpGagnant = Joueur.stockJoueurs.get(3).getScore();
			gagnant.removeAll(gagnant);
			gagnant.add(Joueur.stockJoueurs.get(3));
		}else if (Joueur.stockJoueurs.get(3).getScore() == tmpGagnant) {
			gagnant.add(Joueur.stockJoueurs.get(3));
		}
		if (gagnant.size() == 1) {
			System.out.println("L'heureux gagnant est " + gagnant.get(0).getPrenom() + " avec " + gagnant.get(0).getScore() + " points");
		} 
		if (1 < gagnant.size() && gagnant.size() < 4 ) {
			
			System.out.println("Nous avons une égalité!");
			System.out.println("Les gagnants sont");
			for(int i=0 ; i < gagnant.size(); i++){
				System.out.println(gagnant.get(i).getPrenom() + " avec " + gagnant.get(i).getScore() + " points");
			}
		}
		if (gagnant.size() == 4) {
			System.out.println("Nous avons une égalité parfaite, tout le monde a le même score !");
			System.out.println("Score : " + gagnant.get(0).getScore());
		}
	}
	// Affiche le score des joueurs
	public static void afficheScores() {
		System.out.println("**************************************************");
		
		System.out.println("*************RECAPITULATIF DES SCORES*************");
		System.out.println("'" + Joueur.stockJoueurs.get(0).getPrenom() + "' totalise " + Joueur.stockJoueurs.get(0).getScore() + " points");					
		System.out.println("'" + Joueur.stockJoueurs.get(1).getPrenom() + "' totalise " + Joueur.stockJoueurs.get(1).getScore() + " points");					
		System.out.println("'" + Joueur.stockJoueurs.get(2).getPrenom() + "' totalise " + Joueur.stockJoueurs.get(2).getScore() + " points");					
		System.out.println("'" + Joueur.stockJoueurs.get(3).getPrenom() + "' totalise " + Joueur.stockJoueurs.get(3).getScore() + " points");					
		System.out.println("**************************************************");
	}
	
	public void nouvellePartie(){
		System.out.println("Voulez vous refaire une nouvelle partie ? (O/N)");
		nouvPartie = sc.nextLine().charAt(0);
		while (!(nouvPartie == 'O') && !(nouvPartie == 'o') && !(nouvPartie == 'N') && !(nouvPartie == 'n')) {
			if (nouvPartie == ' ') { // je ne comprend pas pourquoi ca ne marche pas si je fait == ''
				System.out.println("Votre saisi est vide") ;
			}
			System.out.println("Je n'ai pas compris votre saisi") ;
			System.out.println("Veulliez saisir 'o' ou 'O' pour lancer une nouvelle partie") ;
			System.out.println("Veulliez saisir 'n' ou 'N' pour quitter le programme") ;
			System.out.println("Voulez vous refaire une nouvelle partie ? (O/N)");
			nouvPartie = sc.nextLine().charAt(0); // Prise en compte  uniquement du premier caractère tapé
			}
	}
	
	public void setNbTour(int nbTour){
		this.nbTour=nbTour;
	}
	
	public int getNbTour(){
		return nbTour;
	}
}
/*
public void nouveauTour(String joueurPreneurMin) {

	// Ici le joueur 1 est preneur donc saisi en premiere entrée de l'objet joueur
	if (j.getPrenom() == joueurPreneurMin)
	
	if (j1.getPrenom().equals(joueurPreneurMin)) {
		Tour t = new Tour(j1, j2, j3, j4, type, ecartInt, gainOuNon);
		t.attributionPoints();
	}

	if ( gainOuNon == true) {
		System.out.println("'" + j1.getPrenom() + "' marque " + (t.scoreTour())*2 + " points durant ce tour");
		System.out.println("'" + j2.getPrenom() + "' - '" + j4.getPrenom() + "' - '" + j3.getPrenom() + "' perdent chacun " + t.scoreTour() + " points durant ce tour");
		j1.setTourgagne((j1.getTourgagne()+1));
	}
	else {
		System.out.println("'" + j1.getPrenom() + "' perd " + (t.scoreTour())*(-2) + " points durant ce tour");
		System.out.println("'" + j2.getPrenom() + "' - '" + j4.getPrenom() + "' - '" + j3.getPrenom() + "' gagnent chacun " + -(t.scoreTour()) + " points durant ce tour");
		j1.setTourperdu((j1.getTourperdu()+1));
	}

	// Ici le joueur 2 est preneur donc saisi en premiere entrée de l'objet joueur
	if (j2.getPrenom().equals(joueurPreneurMin)) {
		Tour t = new Tour(j2, j1, j3, j4, type, ecartInt, gainOuNon);
		t.attributionPoints();
		if ( gainOuNon == true) {
			System.out.println("'" + j2.getPrenom() + "' marque " + (t.scoreTour())*2 + " points durant ce tour");
			System.out.println("'" + j4.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j3.getPrenom() + "' perdent chacun " + t.scoreTour() + " points durant ce tour");
			j2.setTourgagne((j2.getTourgagne()+1));
		}
		else {
			System.out.println("'" + j2.getPrenom() + "' perd " + (t.scoreTour())*(-2) + " points durant ce tour");
			System.out.println("'" + j4.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j3.getPrenom() + "' gagnent chacun " + -(t.scoreTour()) + " points durant ce tour");
			j2.setTourperdu((j2.getTourperdu()+1));
		}
	}
	
	// Ici le joueur 3 est preneur donc saisi en premiere entrée de l'objet joueur
	if (j3.getPrenom().equals(joueurPreneurMin)) {
		Tour t = new Tour(j3, j2, j1, j4, type, ecartInt, gainOuNon);
		t.attributionPoints();
		if ( gainOuNon == true) {
			System.out.println("'" + j3.getPrenom() + "' marque " + (t.scoreTour())*2 + " points durant ce tour");
			System.out.println("'" + j2.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j4.getPrenom() + "' perdent chacun " + t.scoreTour() + " points durant ce tour");
			j3.setTourgagne((j3.getTourgagne()+1));
		}
		else {
			System.out.println("'" + j3.getPrenom() + "' perd " + (t.scoreTour())*(-2) + " points durant ce tour");
			System.out.println("'" + j2.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j4.getPrenom() + "' gagnent chacun " + -(t.scoreTour()) + " points durant ce tour");
			j3.setTourperdu((j3.getTourperdu()+1));
		}

	}
	
	// Ici le joueur 4 est preneur donc saisi en premiere entrée de l'objet joueur
	if (j4.getPrenom().equals(joueurPreneurMin)) {
		Tour t = new Tour(j4, j2, j1, j3, type, ecartInt, gainOuNon);
		t.attributionPoints();
		if ( gainOuNon == true) {
			System.out.println("'" + j4.getPrenom() + "' marque " + (t.scoreTour())*2 + " points durant ce tour");
			System.out.println("'" + j2.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j3.getPrenom() + "' perdent chacun " + t.scoreTour() + " points durant ce tour");
			j4.setTourgagne((j4.getTourgagne()+1));
		}
		else {
			System.out.println("'" + j4.getPrenom() + "' perd " + (t.scoreTour())*(-2) + " points durant ce tour");
			System.out.println("'" + j2.getPrenom() + "' - '" + j1.getPrenom() + "' - '" + j3.getPrenom() + "' gagnent chacun " + -(t.scoreTour()) + " points durant ce tour");
			j4.setTourperdu((j4.getTourperdu()+1));

		}
}	}
*/

/*if ( j1.getTourgagne() != 0 || j1.getTourperdu() != 0 ) {
System.out.println(j1.getPrenom() + " a pris et remporté la main " + j1.getTourgagne() + " fois");
System.out.println(j1.getPrenom() + " a pris et raté la main " + j1.getTourperdu() + " fois");
} 
else {
System.out.println(j1.getPrenom() + " n'a jamais pris la main");
}
if ( j2.getTourgagne() != 0 || j2.getTourperdu() != 0 ) {
System.out.println(j2.getPrenom() + " a pris et remporté la main " + j2.getTourgagne() + " fois");
System.out.println(j2.getPrenom() + " a pris et raté la main " + j2.getTourperdu() + " fois");
}
else {
System.out.println(j2.getPrenom() + " n'a jamais pris la main");
}
if ( j3.getTourgagne() != 0 || j3.getTourperdu() != 0 ) {
System.out.println(j3.getPrenom() + " a pris et remporté la main " + j3.getTourgagne() + " fois");
System.out.println(j3.getPrenom() + " a pris et raté la main " + j3.getTourperdu() + " fois");
}
else {
System.out.println(j3.getPrenom() + " n'a jamais pris la main");
}
if ( j4.getTourgagne() != 0 || j4.getTourperdu() != 0 ) {
System.out.println(j4.getPrenom() + " a pris et remporté la main " + j4.getTourgagne() + " fois");
System.out.println(j4.getPrenom() + " a pris et raté la main " + j4.getTourperdu() + " fois");
}
else {
System.out.println(j4.getPrenom() + " n'a jamais pris la main");
}*/
