import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
        private int id;
        private String prenom;
        private int score;
        private int tourgagne;
        private int tourperdu;
		public static ArrayList<Joueur> stockJoueurs = new ArrayList<Joueur>();
		public static ArrayList<String> stockNomJoueurs = new ArrayList<String>();

        public static Scanner sc = new Scanner(System.in) ;

        public Joueur(int id, String prenom, int score, int tourgagne, int tourperdu) {
                this.id = id;
                this.prenom = prenom;
                this.score = score;
                this.tourgagne = tourgagne;
                this.tourperdu = tourperdu;
        }
        
        public static void ajoutJoueur(int id){
    		
    		String nomJoueurSansEspacesMin = "";
    		boolean joueurExist = true ;
			while (nomJoueurSansEspacesMin.length() == 0) { // vérification que le nom du joueur n'est pas vide
				while (joueurExist == true ) {
    				joueurExist = false ;
					System.out.println("Veuillez donner un nom au joueur " + (id) ) ;
	    			String nomJoueur = sc.nextLine();
	    			String nomJoueurSansEspaces = nomJoueur.trim(); // Supprime les espaces
	    			nomJoueurSansEspacesMin = nomJoueurSansEspaces.toLowerCase(); // tranforme le nom en minusule pour éviter toute erreur dans les calculs toutes les saisies utilisateurs seront transformées en minuscule
	    			if (nomJoueurSansEspacesMin.length() == 0) {
	    				System.out.println("Votre saisie est vide") ;
        				joueurExist = true ;
	    			}
	    			else {
	    				for (int i = 0; i < stockNomJoueurs.size(); i++) {
	        				if (stockNomJoueurs.get(i).equals(nomJoueurSansEspacesMin)) {
	        				System.out.println("Ce joueur existe déjà") ;
	        				joueurExist = true ;
	        				}
	        			}
	    			}
				}
			}
		    stockNomJoueurs.add(nomJoueurSansEspacesMin); 
		    stockJoueurs.add(new Joueur(id, nomJoueurSansEspacesMin, 0,0,0)); // Instanciation de l'objet Joueur 
		    System.out.println("Création du joueur " + id + " : " + "'" + nomJoueurSansEspacesMin + "'") ;
    			
    	}

        public static void videJoueur() {
        	stockNomJoueurs.removeAll(stockNomJoueurs);
        }
    	//*******************************************Accesseurs et Mutateurs*******************************************
        public static Joueur getJoueurId(int id) {
					return stockJoueurs.get(id-1) ;
        }
        
        public static Joueur getJoueurNom(String nomJoueur) {
        	for (int i = 0; i < stockNomJoueurs.size(); i++) {
				if (stockNomJoueurs.get(i).equals(nomJoueur)) {
					return stockJoueurs.get(i) ;
				}
        	}
			return null;
        }
        
        public static String getNomJoueur(int i) {
    			return stockNomJoueurs.get(i) ;
        }
        
        public int getId() {
                return id;
        }
        
        public void setId(int id) {
                this.id = id;
        }
        
        public String getPrenom() {
                return prenom;
        }
        
        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }
        
        public int getScore() {
                return score;
        }
        
        public static int getScoreNom(String nomJoueur) {
        	for (int i = 0; i < stockNomJoueurs.size(); i++) {
				if (stockNomJoueurs.get(i).equals(nomJoueur)) {
					return stockJoueurs.get(i).getScore() ;
				}
        	}
			return 0 ;
        }
        
        public void setScore(int score) {
                this.score = score;
        }
        
        public int getTourgagne() {
        		return tourgagne;
        }
        
        public void setTourgagne(int tourgagne) {
        		this.tourgagne = tourgagne ;
        }
        
        public int getTourperdu() {
    		return tourperdu;
        }
        
        public void setTourperdu(int tourperdu) {
    		this.tourperdu = tourperdu;
        }
        
}
