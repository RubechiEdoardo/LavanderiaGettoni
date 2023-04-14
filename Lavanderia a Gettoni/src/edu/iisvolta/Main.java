package edu.iisvolta;

import java.util.Scanner;

import it.edu.iisvolta.Console;

public class Main {

	public static void main(String[] args) {
		// inizializzo le lavatrici
		Scanner s=new Scanner(System.in);
		String scelta, lav;
		int numLavatrice=1;
		
		Lavatrice l1=new Lavatrice(8);
		Lavatrice l2=new Lavatrice(10);
		Lavatrice l3=new Lavatrice(14);
		
		Lavatrice lavatriceSelezionata=l1;
		
		do {
			menu();
			Console.setCursorPosition(1, 70);
			System.out.print("Lavatrice selezionata: "+numLavatrice);
			mostraLavatrice(l1, 1);	//chiamata al metodo: indico il valore effettivo (argomento)
			mostraLavatrice(l2, 11);	//chiamata al metodo: indico il valore effettivo (argomento)
			mostraLavatrice(l3, 21);	//chiamata al metodo: indico il valore effettivo (argomento)
			Console.setCursorPosition(15, 1);
			
			System.out.print("Inserisci la tua scelta: ");
			scelta=s.nextLine();
			switch (scelta) {
			case "1":		//scelta lavatrice
				System.out.print("Quale lavatrice vuoi scegliere (1-3)? ");
				lav=s.nextLine();
				switch(lav) {
				case "1":
					lavatriceSelezionata=l1;
					numLavatrice=1;
					break;
				case "2":
					lavatriceSelezionata=l2;
					numLavatrice=2;
					break;
				case "3":
					lavatriceSelezionata=l3;
					numLavatrice=3;
					break;
				default:
					System.out.println("Lavatrice non valida!");
					break;
				}
				break;
				
			case "2": 	//aggiungi acqua 
				System.out.print("Quanta acqua vuoi aggiungere? ");
				int litri=Integer.parseInt(s.nextLine());
				lavatriceSelezionata.aggiungiAcqua(litri);
				break;
				
			case "3": 	//imposta temperatura 
				System.out.print("Che temperatura vuoi impostare? ");
				int temp=Integer.parseInt(s.nextLine());
				lavatriceSelezionata.setTemperatura(temp);
				break;
				
			case "4": 	//imposta numero di giri 
				System.out.print("Inserisci il numero di giri: ");
				int giri=Integer.parseInt(s.nextLine());
				lavatriceSelezionata.setVelocit‡Rotazione(giri);;
				break;
				
			case "5": 	//aggiungi detersivo 				
				lavatriceSelezionata.aggiungiDetersivo();
				break;
				
			case "6": 	//aggiungi moneta 	
				System.out.print("Che moneta vuoi aggiungere? ");
				float moneta=Float.parseFloat(s.nextLine());
				lavatriceSelezionata.aggiungiMoneta(moneta);
				break;
				
			case "7": 	//avvio 				
				lavatriceSelezionata.start();
				break;
				
			case "8": 	//stop 				
				lavatriceSelezionata.stop();
				break;
				
			case "9": 	//stop 				
				lavatriceSelezionata.svuota();
				break;
				
			}
			System.out.println();
			System.out.println("Premi Enter per continuare...");
			s.nextLine();
			
			
		} while (!scelta.equals("0"));
		s.close();
		

	}
	
	private static void menu() {
		Console.clear();
		System.out.println("**** LAVANDERIA A GETTONI ****");
		System.out.println();
		System.out.println("1) Scegli lavatrice");
		System.out.println("2) Aggiungi acqua");
		System.out.println("3) Imposta temperatura");
		System.out.println("4) Imposta numero giri");
		System.out.println("5) Aggiungi detersivo");
		System.out.println("6) Aggiungi moneta");		
		System.out.println("7) Avvio");
		System.out.println("8) Stop");
		System.out.println("9) Svuota");
		System.out.println("0) Esci");
		
	}
	
	//dichiarazione metodo: indico parametri generici
	private static void mostraLavatrice(Lavatrice lav, int posizioneY) {	
		Console.setCursorPosition(posizioneY+2, 70);
		System.out.print("  capacit‡: "+lav.getCapacit‡());
		Console.setCursorPosition(posizioneY+3, 70);
		System.out.print("  stato: "+lav.getStato());
		Console.setCursorPosition(posizioneY+4, 70);
		System.out.print("  livello acqua: "+lav.getLivelloAcqua());
		Console.setCursorPosition(posizioneY+5, 70);
		System.out.print("  temperatura: "+lav.getTemperatura());
		Console.setCursorPosition(posizioneY+6, 70);
		System.out.print("  velocit‡ rotazione: "+lav.getVelocit‡Rotazione());
		Console.setCursorPosition(posizioneY+7, 70);
		System.out.print("  detersivo: "+lav.detersivoAggiunto());
		Console.setCursorPosition(posizioneY+8, 70);
		System.out.print("  costo: "+lav.getCosto());
		Console.setCursorPosition(posizioneY+9, 70);
		System.out.print("  credito: "+lav.getCredito());
	}

}
