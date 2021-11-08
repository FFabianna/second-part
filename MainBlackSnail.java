package ui;
import java.util.Scanner;
import model.BlackSnail;



public class MainBlackSnail{
	private Scanner sc;
	private BlackSnail systemBlack;


	
	public MainBlackSnail(){
		sc= new Scanner(System.in);
	}
	
	public static void main(String []args){
		// creando un objeto de la clase principal
		MainBlackSnail obBlack = new MainBlackSnail();
		obBlack.initSystem();
		int option= 0;
		//ciclo para ejecutar el menu mientras que el usuario no
		// elija la opciOn para salir (0)
		do {
		    option =obBlack.showMenuAndGetOptionProduct();
		    obBlack.answerOption(option);
		}while (option !=0);
	}
	
	public void initSystem(){
		System.out.println("");
		System.out.println("**************BIENVENIDO A BALCKSNAIL***************");
		System.out.println("");
	}
	
	public int showMenuAndGetOptionProduct() {
		int inputt;
		System.out.println("\n*-*-*-*-*-*-PRODUCT-*-*-*-*-*-*\n"+
		                    "(1) new product \n"+ 
							"(2) product information\n"+
							"(3) new season\n"+
							"(4) search movie\n"+
							"(5) search serie\n"+
		                    "(0) exit\n");
		inputt = sc.nextInt();
		return inputt;
	}
	
	/**
	 * Metodo que se encarga de llamar a los mEtodos que resuelven cada uno de los
	 * requerimientos de la aplicaciOn
	 * @param userOption, int es el nUmero ingresado por el usuario (no ha sido validado)
	 */
	public void answerOption(int option) {
		switch(option) {
		case 0:
			System.out.println("cerrando la aplicaciOn, bye");
			break;
		case 1:
			NewProduct();
			break;
		case 2:
			productInfo();
			break;
		case 3:
			newSeason();
			break;
		case 4:
			showMovie();
			break;
		case 5:
			showSerie();
			break;
		}
	}

	public void NewProduct(){
		String innput="";
		int optionCategory=0;
		String respCensurado="";
		String minAge="";
		String title="";
		String nameD="";
		String synopsis="";
		String premiereDate="";
		String productor="";
		String nameProta="";
		String censored="";
	
		System.out.println("(1) its serie \n"+ 
		"(2) its movie\n");
		innput =sc.nextLine();
		if (innput=="1"){
			System.out.println("Write the title of the serie");
			title=sc.nextLine();
			System.out.println("Write the name of the Director ");
			nameD= sc.nextLine();
			System.out.println("Write the synopsis: ");
			synopsis= sc.nextLine();
			System.out.println("Write the premiere date, for example: day/month/year ");
			premiereDate= sc.nextLine();
			System.out.println("Write the name of the Protagonists  ");
			nameProta= sc.nextLine();
			System.out.println("This serie must be censored? (yes) (no)");
			respCensurado =sc.nextLine();

			if(respCensurado=="yes"){
				System.out.println("Write the reason: ");
				censored=sc.nextLine();
			}else if(respCensurado=="no"){
				System.out.println("ok.");
			}
			systemBlack.addSerie(nameD,synopsis,premiereDate,title,nameProta,censored);
			newSeason();
			
		}else if(innput=="2"){
			System.out.println("Write the title of the serie");
			title=sc.nextLine();
			System.out.println("Write the name of the Director: ");
			nameD= sc.nextLine();
			System.out.println("Write the synopsis: ");
			synopsis= sc.nextLine();
			System.out.println("Write the premiere date, for example: day/month/year ");
			premiereDate= sc.nextLine();
			System.out.println("Write the minimun age allowed: ");
			minAge=sc.nextLine();
			parseInt(minAge);
			System.out.println("Write the name of the Producer: ");
			productor= sc.nextLine();
			systemBlack.addMovie(nameD,synopsis,premiereDate,title,minAge,productor,systemBlack.movieCategory(optionCategory));
			System.out.println("CATEGORY MOVIE ");
			System.out.println("choose the category\n"+
			"(1) Romantic\n"+
			"(2) Action\n"+
			"(3) Suspense\n"+
			"(4) Horror\n"+
			"(5) Comedy"
			);
			optionCategory=sc.nextInt();
			if(optionCategory>0 && optionCategory<=5){
				systemBlack.movieCategory(optionCategory);
				System.out.println("ok. ");
			}else{
				System.out.println("choose the category\n"+
				"(1) Romantic\n"+
				"(2) Action\n"+
				"(3) Suspense\n"+
				"(4) Horror\n"+
				"(5) Comedy"
				);
				optionCategory=sc.nextInt();
			}
		}
		systemBlack.addMovie(nameD,synopsis,premiereDate,title,minAge,productor,systemBlack.movieCategory(optionCategory));
		
	}
	
	
	private void parseInt(String innput) {
	}

	public void productInfo(){
		String title="";
		System.out.println("Write the title of the product that you need");
		title=sc.nextLine();
		systemBlack.showProduct(title);
	}
	
	public void newSeason(){
		int numSeasons=0;
		int cantEpiPr=0;
		int cantEpiPu=0;
		String titleSeason="";
		String premierDteSeason="";

		System.out.println("--SEASON--");
			System.out.println("Write the title of the season");
			titleSeason=sc.nextLine();
			System.out.println("Write the number seasons");
			numSeasons=sc.nextInt();
			System.out.println("number of episodes produced:");
			cantEpiPr=sc.nextInt();
			System.out.println("number of episodes published:");
			cantEpiPu=sc.nextInt();
			System.out.println("Write the premiere date of the season, for example: day/month/year ");
			premierDteSeason=sc.nextLine();
			systemBlack.addSeason(titleSeason,numSeasons,cantEpiPr,cantEpiPu,premierDteSeason);
			System.out.println("season "+titleSeason+"was saved");
	}

	public void showMovie(){
		
	}

	public void showSerie(){
		
	}


}