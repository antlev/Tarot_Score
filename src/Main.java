import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		char nouvTour = 'o';
		char nouvPartie = 'o';
		
		Scanner sc = new Scanner(System.in);
		
		while (nouvPartie == 'o' || nouvPartie == 'O') {
			Partie.disBonjour();
			int id = 1;	// id des joueurs allant de 1 à 4
			for ( id = 1; id < 5; id++ ) {
				Joueur.ajoutJoueur(id);  //
			}
			Partie p = new Partie(0);
			while (nouvTour == 'o' || nouvTour == 'O') {
				Joueur preneur = Tour.demandePreneur(); // Demande et retourne le preneur du tour
				String typeTour = Tour.demandeType(); // Demande et retourne le type du tour
				int ecart = Tour.demandeEcart();	// Demande et retourne l'écart du tour
				boolean gainOuNon = Tour.demandeReussite();	// Demande et retourne la réussite du tour
				Tour.nouvTour(preneur, Tour.retourneDefense(preneur).get(0), Tour.retourneDefense(preneur).get(1), Tour.retourneDefense(preneur).get(2), typeTour, ecart, gainOuNon);
				Tour.demandeBonus();
				System.out.println("Voulez vous ajouter un nouveau tour (O/N) ");
				nouvTour = sc.nextLine().charAt(0);
				while (!(nouvTour == 'O') && !(nouvTour == 'o') && !(nouvTour == 'N') && !(nouvTour == 'n')) {
					if (nouvTour == ' ') { // je ne comprend pas pourquoi ca ne marche pas si je fait == ''
						System.out.println("Votre saisi est vide") ;
					} else {
						System.out.println("Je n'ai pas compris votre saisi") ;
					}
					System.out.println("Veulliez saisir 'o' ou 'O' pour lancer un nouveau tour") ;
					System.out.println("Veulliez saisir 'n' ou 'N' pour quitter la partie") ;
					System.out.println("Voulez vous ajouter un nouveau tour? (O/N)") ;
					nouvTour = sc.nextLine().charAt(0); // Prise en compte  uniquement du premier caractère tapé
				}
			}
			Partie.afficheScores();
			p.afficheGagnant();
			System.out.println("Voulez vous faire une autre partie (O/N) ");
			nouvPartie = sc.nextLine().charAt(0);
			while (!(nouvPartie == 'O') && !(nouvPartie == 'o') && !(nouvPartie == 'N') && !(nouvPartie == 'n')) {
				if (nouvPartie == ' ') { // je ne comprend pas pourquoi ca ne marche pas si je fait == ''
					System.out.println("Votre saisi est vide") ;
				} else {
					System.out.println("Je n'ai pas compris votre saisi") ;
				}
				System.out.println("Veulliez saisir 'o' ou 'O' pour lancer un nouveau tour") ;
				System.out.println("Veulliez saisir 'n' ou 'N' pour quitter la partie") ;
				System.out.println("Voulez vous ajouter un nouveau tour? (O/N)") ;
				nouvPartie = sc.nextLine().charAt(0); // Prise en compte  uniquement du premier caractère tapé
			}
			Joueur.videJoueur();

		}
		Partie.disAurevoir();
		sc.close();
	}

}