import java.util.ArrayList;
import java.util.Scanner;

public class Tour {
		private static Joueur preneur;
		private static Joueur defense1;
		private static Joueur defense2;
		private static Joueur defense3;
		static char reussiOuNon;
		private String typeTour;
		private int ecart;
		private static String type = null;
		static int ecartInt = 0;
		private static boolean gainOuNon;
		
		static Scanner sc = new Scanner(System.in) ; 

		// Constructeur
		public Tour(Joueur preneur, Joueur defense1, Joueur defense2, Joueur defense3, String typeTour, int ecart, boolean gainOuNon) {
			Tour.preneur = preneur;
            Tour.defense1 = defense1;
            Tour.defense2 = defense2;
            Tour.defense3 = defense3;
            this.typeTour = typeTour;
            this.ecart = ecart;
            this.gainOuNon = gainOuNon;
		}
		
		// Instancie un objet Tour avec les valeurs d'entrées
		public static void nouvTour(Joueur preneur, Joueur defense1, Joueur defense2, Joueur defense3, String typeTour, int ecart, boolean gainOuNon) {

			Tour t = new Tour(preneur, defense1, defense2, defense3, typeTour, ecart, gainOuNon);
			t.attributionPoints();
			t.pointsMarques();
			Partie.afficheScores();
		}
		
		public static Joueur demandePreneur(){
			System.out.println("******************************");
			System.out.println("Quel joueur a pris la main?");
		    String joueurPreneur = sc.nextLine(); // Saisi du joueur preneur
			String joueurPreneurMin = joueurPreneur.toLowerCase(); // Transformation en minuscule
				 
			while (!joueurPreneurMin.equals(Joueur.getNomJoueur(0)) && !joueurPreneurMin.equals(Joueur.getNomJoueur(1)) && !joueurPreneurMin.equals(Joueur.getNomJoueur(2)) && !joueurPreneurMin.equals(Joueur.getNomJoueur(3))) {
			// Boucle while testant si le joueur ayant pris existe bien
			// Dans le cas ou le nom du preneur ne serait pas valide,
			// afficher les noms des joueurs et redemander un preneur
				System.out.println("Ce joueur n'existe pas");
				System.out.println("Veulliez taper le nom d'un joueur existant s'il vous plaît");
				System.out.println("Les joueurs s'appellent : ");
				System.out.println("Joueur 1 : " + Joueur.getNomJoueur(0) ) ;
				System.out.println("Joueur 2 : " + Joueur.getNomJoueur(1));
				System.out.println("Joueur 3 : " + Joueur.getNomJoueur(2));
				System.out.println("Joueur 4 : " + Joueur.getNomJoueur(3));
				System.out.println("Quel joueur a pris la main?");
				joueurPreneur = sc.nextLine();
				joueurPreneurMin = joueurPreneur.toLowerCase();
			}
			
			if ( joueurPreneurMin.equals(Joueur.getNomJoueur(0)) ) {
				System.out.println(Joueur.getJoueurId(1));
				return Joueur.getJoueurId(1) ;
			}
			if ( joueurPreneurMin.equals(Joueur.getNomJoueur(1)) ) {
				System.out.println("Joueur.getJoueurId(2)");
				return Joueur.getJoueurId(2) ;
			}
			if ( joueurPreneurMin.equals(Joueur.getNomJoueur(2)) ) {
				System.out.println("Joueur.getJoueurId(3)");
				return Joueur.getJoueurId(3) ;
			}
			if ( joueurPreneurMin.equals(Joueur.getNomJoueur(3)) ) {
				System.out.println("Joueur.getJoueurId(4)");
				return Joueur.getJoueurId(4) ;
			}
			else {
				return null ;
			}
		}
		
		public static ArrayList<Joueur> retourneDefense(Joueur preneur) {
			ArrayList<Joueur> defense123 = new ArrayList<Joueur>();
			for (int i = 1; i < 5; i++) {
				if (!Joueur.getJoueurId(i).equals(preneur)) { 
					defense123.add(Joueur.getJoueurId(i));
				}
			}
			return defense123;
		}
		
		public static String demandeType(){
			System.out.println("Est ce que '" + demandePreneur().getPrenom() + "' a pris une (P)etite, une (G)arde, une garde (S)ans, ou une garde (C)ontre?");
		    char repType = sc.nextLine().charAt(0); // Prise en compte uniquement de la première lettre entrée par l'utilisateur
			
			// Boucle while permettant de redemander le type de partie si la réponse n'est pas valable
			while (repType != 'P' && repType != 'G' && repType != 'S' && repType != 'C' && repType != 'p' && repType != 'g' && repType != 's' && repType != 'c') {
				System.out.println("Je n'ai pas compris votre saisi");
				System.out.println("Veulliez taper un des caractères suivants svp :");
				System.out.println("'p' ou 'P' pour une Petite");
				System.out.println("'g' ou 'G' pour une Garde");
				System.out.println("'s' ou 'S' pour une Garde-Sans");
				System.out.println("'c' ou 'C' pour une Garde-Contre");
			    repType = sc.nextLine().charAt(0); // Prise en compte uniquement de la première lettre entrée par l'utilisateur
			}
			if (repType == 'P'|| repType == 'p') { type = "Petite" ; }
			if (repType == 'G'|| repType == 'g') { type = "Garde" ; }
			if (repType == 'S'|| repType == 's') { type = "Garde-Sans" ; }
			if (repType == 'C'|| repType == 'c') { type = "Garde-Contre" ; }
			System.out.println("'" + demandePreneur().getPrenom() + "'" + " a donc pris une " + type);
			return type ;
		}
		
		public static int demandeEcart(){
			// Vérification que l'écart est un int 
			System.out.println("De combien de points d'écart?");
			boolean entier = false;	// permet de rentrer dans la boucle while (entier == false)
			boolean horsLimite = true; // permet de rentrer dans la boucle while (horsLimite == true)
			while ( horsLimite == true ) {
				String ecartDem = sc.nextLine(); // demande l'écart à l'utilisateur
				entier = isInteger(ecartDem);
				while (entier == false) {
					System.out.println("Apparement votre saisi n'est pas un entier");
					ecartDem = sc.nextLine(); // redemande l'écart à l'utilisateur
					entier = isInteger(ecartDem);
				}
		        ecartInt = Integer.valueOf(ecartDem).intValue(); // cast de l'ecart (String) en ecartInt (int)
		        if ( ecartInt < 0 ) {
		        	horsLimite = true;
					System.out.println("Veuillez retaper l'écart, l'écart ne peux pas être négatif");
					
		        } else {
		        	if ( ecartInt > 55 ) {
			        	horsLimite = true;
						System.out.println("Veuillez retaper l'écart, l'écart ne peux pas être supérieur à 55");
			        } else {
			        	horsLimite = false;
			        }
		        }
		        
			}

	        if (ecartInt == 0) {
	        	reussiOuNon = 'U' ;
				System.out.println("Vous cherchez à rentrer un écart de 0, le tour sera automatiquement réussi");
			}
	        return ecartInt ;
		}
		
		public static boolean demandeReussite(){
			if (reussiOuNon != 'U' ) {
				System.out.println("Est ce que " + demandePreneur().getPrenom() +" a ré(U)ssi sa " + type + " de " + ecartInt + " ou a t elle été (R)até?");
				reussiOuNon = sc.nextLine().charAt(0); // Prise en compte uniquement de la première lettre entrée par l'utilisateur 
			}
			
			// Boucle while permettant de savoir si le tour a été réussi ou non
			while ( reussiOuNon != 'R' && reussiOuNon !='U' && reussiOuNon != 'r' && reussiOuNon !='u')  {
				System.out.println("Je n'ai pas compris votre saisi");
				System.out.println("Veulliez taper un des caractères suivants svp :");
				System.out.println("'r' ou 'R' pour 'Raté'");
				System.out.println("'u' ou 'U' pour 'Réussi'");
				reussiOuNon = sc.nextLine().charAt(0); // Prise en compte uniquement de la première lettre entrée par l'utilisateur 
			}
		
		
			// Si le tour est réussi => gainOuNon == true
			if (reussiOuNon == 'U' || reussiOuNon == 'u') { 
				gainOuNon = true ;
				System.out.println("Donc finalement, '" + demandePreneur().getPrenom() +"' a réussi sa " + type + " de " + ecartInt + " points" );
		
			}
			// Si le tour est raté => gainOuNon == false
			else  {
				gainOuNon =  false ;
				System.out.println("Donc finalement, '" + demandePreneur().getPrenom() +"' a raté sa " + type + " de " + ecartInt + " points" );
			}
			return gainOuNon ;
		}

		public static void demandeBonus(){
				System.out.println("Il y a t-il eu un bonus? ( grand (C)helem ? une (M)isère ? ou une (P)oignée ? ou le petit mené au (B)out ? )");
				char bonus = sc.nextLine().charAt(0);
				while (bonus != 'c' && bonus != 'C' && bonus != 'm' && bonus != 'M' && bonus != 'p' && bonus != 'P' && bonus != 'b' && bonus != 'B') {
					System.out.println("Je n'ai pas compris votre saisie");
					System.out.println("Veulliez taper un des caractères suivants svp :");
					System.out.println("'c' ou 'C' pour ajouter un grand chelem");
					System.out.println("'m' ou 'M' pour ajouter une misère");
					System.out.println("'p' ou 'P' pour ajouter une poignée");
					System.out.println("'b' ou 'B' pour ajouter un petit au bout");
					bonus = sc.nextLine().charAt(0);
				}
				boolean annonceGrandChelemB = false;
				boolean reussiGrandChelemB = false;
				while (bonus == 'c' && bonus == 'C' && bonus == 'm' && bonus == 'M' && bonus == 'p' && bonus == 'P' && bonus == 'b' && bonus == 'B') {
						if (bonus == 'c' || bonus == 'C') {
						System.out.println("Il y a eu un grand chelem");
						System.out.println("A t-il été annoncé ?");
						char annonceGrandChelem = sc.nextLine().charAt(0);
						if (annonceGrandChelem == 'o' || annonceGrandChelem ==  'O') {
							annonceGrandChelemB = true ;
						} else {
							annonceGrandChelemB = false ;
						}
						System.out.println("A t-il été réussi ?");
						char reussiGrandChelem = sc.nextLine().charAt(0);
						if (reussiGrandChelem == 'o' || reussiGrandChelem ==  'O') {
							reussiGrandChelemB = true ;
						} else {
							reussiGrandChelemB = false ;
						}
						System.out.println("Qui en est le bénéficiaire ?");
						char benificiaireGC = sc.nextLine().charAt(0);
						}
						if (bonus == 'm' || bonus == 'M') {
							System.out.println("Il y a eu une misère");
							System.out.println("Qui en est le bénéficiaire ?");
							String beneficiaireMisere = sc.nextLine();
							while (beneficiaireMisere != Joueur.stockNomJoueurs.get(0) && beneficiaireMisere != Joueur.stockNomJoueurs.get(1) && beneficiaireMisere != Joueur.stockNomJoueurs.get(2) && beneficiaireMisere != Joueur.stockNomJoueurs.get(3)) {
								System.out.println("Ce joueur n'existe pas");
								System.out.println("Veulliez taper le nom d'un joueur existant s'il vous plaît");
								System.out.println("Les joueurs s'appellent : ");
								System.out.println("Joueur 1 : " + Joueur.stockNomJoueurs.get(0));
								System.out.println("Joueur 2 : " + Joueur.stockNomJoueurs.get(1));
								System.out.println("Joueur 3 : " + Joueur.stockNomJoueurs.get(2));
								System.out.println("Joueur 4 : " + Joueur.stockNomJoueurs.get(3));
								System.out.println("Qui en est le bénéficiaire ?");
								beneficiaireMisere = sc.nextLine();
							}
						}
						if (bonus == 'p' || bonus == 'P') {
							System.out.println("Il y a t-il eu une poignée");
							System.out.println("Qui en est le bénéficiaire ?");
							System.out.println("(S)imple (D)ouble ou (T)riple ?");
						}
						if (bonus == 'b' || bonus == 'B') {
							System.out.println("Il y a eu le petit mené au bout");
							System.out.println("Qui en est le bénéficiaire ?");
							System.out.println("A t-il remporté le plis ou a été mangé ?");

						}
						System.out.println("Voulez vous rajouter un bonus ? ");
						bonus = sc.nextLine().charAt(0);
				}
				Tour.grandChelem(reussiGrandChelemB,annonceGrandChelemB);
			}
		// Calcul le total des points du tour (mais ne l'affecte pas au score!)
		public int scoreTour() {
			int plusOuMoins = -1;
            if (this.gainOuNon) {
                    plusOuMoins = 1;
            }
            int coeffMult = 1;
            switch(this.typeTour) {
            	case "Petite":
            		coeffMult = 1;
            	break;
            	case "Garde":
            		coeffMult = 2;
            	break;            	
            	case "Garde-Sans":
            		coeffMult = 4;
            	break;            	
            	case "Garde-Contre":
            		coeffMult = 6;
            	break;
            	default:
            }
            return (25 + this.ecart) * coeffMult * plusOuMoins;
		}
		// Attribut le total calculé au dessus aux joueurs
		public void attributionPoints() {
			 int resultat = scoreTour();
                     preneur.setScore(preneur.getScore() + 2 * resultat);
                     defense1.setScore(defense1.getScore() - resultat);
                     defense2.setScore(defense2.getScore() - resultat);
                     defense3.setScore(defense3.getScore() - resultat);
        }
		// Affiche les points marqués et perdus
		public void pointsMarques() {
			 int resultat = scoreTour();
			 if (resultat >= 0) {
                 System.out.println(preneur.getPrenom() + " marque " + 2 * resultat + " points");
                 System.out.println(defense1.getPrenom() + " perd " + resultat + " points");
                 System.out.println(defense2.getPrenom() + " perd " + resultat + " points");
                 System.out.println(defense3.getPrenom() + " perd " + resultat + " points");
			 } else {
                 System.out.println(preneur.getPrenom() + " perd " + 2 * resultat + " points");
                 System.out.println(defense1.getPrenom() + " marque " + resultat + " points");
                 System.out.println(defense2.getPrenom() + " marque " + resultat + " points");
                 System.out.println(defense3.getPrenom() + " marque " + resultat + " points");
			 }
        }
		// Attribut les points si le petit est mené au bout
		public void petitAuBout(Joueur preneur, boolean reussi) {
			int coeffMult = 1;
	           switch(this.typeTour) {
           	case "Petite":
           		coeffMult = 1;
           	break;
           	case "Garde":
           		coeffMult = 2;
           	break;            	
           	case "Garde-Sans":
           		coeffMult = 4;
           	break;            	
           	case "Garde-Contre":
           		coeffMult = 6;
           	break;
           	default:
           }
			if(reussi == true) {
                preneur.setScore(preneur.getScore() + 20 * coeffMult);
                defense1.setScore(defense1.getScore() - 10 * coeffMult);
                defense2.setScore(defense2.getScore() - 10 * coeffMult);
                defense3.setScore(defense3.getScore() - 10 * coeffMult);
			} else {
                preneur.setScore(preneur.getScore() - 20 * coeffMult);
                defense1.setScore(defense1.getScore() + 10 * coeffMult);
                defense2.setScore(defense2.getScore() + 10 * coeffMult);
                defense3.setScore(defense3.getScore() + 10 * coeffMult);
			}

		}
		// Attribut les points dans le cas d'un grand chelem
		public static void grandChelem(boolean reussiOuNon, boolean annonce) {
			if (reussiOuNon) {
                if (annonce) {
                    preneur.setScore(preneur.getScore() + 800);
                    defense1.setScore(defense1.getScore() -400);
                    defense2.setScore(defense2.getScore() - 400);
                    defense3.setScore(defense3.getScore() - 400);
                } else {
                    preneur.setScore(preneur.getScore() + 400);
                    defense1.setScore(defense1.getScore() -200);
                    defense2.setScore(defense2.getScore() - 200);
                    defense3.setScore(defense3.getScore() - 200);
                }
			} else {
                if (annonce) {
                    preneur.setScore(preneur.getScore() - 400);
                    defense1.setScore(defense1.getScore() + 200);
                    defense2.setScore(defense2.getScore() + 200);
                    defense3.setScore(defense3.getScore() + 200);
                }

			}
		}
		// Attribut les points dans le cas d'une misère
		public void misere(Joueur preneur) {
            preneur.setScore(preneur.getScore() + 40);
            defense1.setScore(defense1.getScore() -20);
            defense2.setScore(defense2.getScore() - 20);
            defense3.setScore(defense3.getScore() - 20);
		}
		// Attribut les points dans le cas d'une simple poignée
		public void simplePoignee(Joueur preneur) {
	           preneur.setScore(preneur.getScore() + 40);
	            defense1.setScore(defense1.getScore() -20);
	            defense2.setScore(defense2.getScore() - 20);
	            defense3.setScore(defense3.getScore() - 20);
		}
		// Attribut les points dans le cas d'une double poignée
		public void doublePoignee(Joueur preneur) {
	           	preneur.setScore(preneur.getScore() + 80);
	            defense1.setScore(defense1.getScore() -40);
	            defense2.setScore(defense2.getScore() - 40);
	            defense3.setScore(defense3.getScore() - 40);
		}
		// Attribut les points dans le cas d'une triple poignée
		public void triplePoignee(Joueur preneur) {
	           preneur.setScore(preneur.getScore() + 120);
	            defense1.setScore(defense1.getScore() - 60);
	            defense2.setScore(defense2.getScore() - 60);
	            defense3.setScore(defense3.getScore() - 60);
		}

	//*******************************************Accesseurs et Mutateurs*******************************************
	 public Joueur getPreneur() {
             return preneur;
     }

     public void setPreneur(Joueur preneur) {
             Tour.preneur = preneur;
     }

     public Joueur getDefense1() {
             return defense1;
     }

     public void setDefense1(Joueur defense1) {
    	 	Tour.defense1 = defense1;
     }

     public Joueur getDefense2() {
             return defense2;
     }

     public void setDefense2(Joueur defense2) {
    	 	Tour.defense2 = defense2;
     }

     public Joueur getDefense3() {
             return defense3;
     }

     public void setDefense3(Joueur defense3) {
    	 	Tour.defense3 = defense3;
     }

     public String getTypeTour() {
             return typeTour;
     }

     public void setTypeTour(String typeTour) {
             this.typeTour = typeTour;
     }

     public int getEcart() {
             return ecart;
     }

     public void setEcart(int ecart) {
             this.ecart = ecart;
     }

     public boolean isGainOuNon() {
             return gainOuNon;
     }

     public void setGainOuNon(boolean gainOuNon) {
             this.gainOuNon = gainOuNon;
     }
     
 	 public static boolean isInteger( String input) { // Fonction retournant true si l'entrée est un int et false sinon
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
}
