package edu.iisvolta;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Lavatrice {
	private int capacitÓ;
	private int livelloAcqua;	//max 6 litri
	private int temperatura;
	private int velocitÓRotazione;
	private boolean detersivo;
	private int stato;
	private float credito;
	private LocalTime dataOraAvvio;
	
	public Lavatrice(int capacitÓ) {
		super();
		if (capacitÓ!=8 && capacitÓ!= 10 && capacitÓ!=14) {
			System.out.println("CapacitÓ non valida. Impostata capacitÓ predefinita 8 kg");
			this.capacitÓ=8;
		} else			
			this.capacitÓ = capacitÓ;
		inizializza();
		
	}
	
	private void inizializza() {
		//inizializzazione attributi
		livelloAcqua=0;
		temperatura=0;
		velocitÓRotazione=0;
		stato=0;
		credito= 0;
		detersivo= false;
	}
	
	public void aggiungiAcqua(int litri) {
		if (litri<=0)
			System.out.println("QuantitÓ di acqua non valida");
		else if (livelloAcqua+litri>6)
			System.out.println("QuantitÓ di acqua superiore al livello massimo");
		else
			livelloAcqua+=litri;
	}
	
	public void setTemperatura(int gradi) {
		if (gradi==40 || gradi==60 || gradi==90)
			this.temperatura = gradi;
		else
			System.out.println("Temperatura non valida");		
	}
	
	public void setVelocitÓRotazione(int velocitÓRotazione) {
		if (velocitÓRotazione==600 || velocitÓRotazione==800 || velocitÓRotazione==1000)
			this.velocitÓRotazione = velocitÓRotazione;
		else
			System.out.println("VelocitÓ di rotazione non valida");	
	}
	
	public void aggiungiDetersivo() {
		detersivo=true;
	}
	
	public void aggiungiMoneta(float moneta) {
		if (moneta==0.10 || moneta==0.20 || moneta==0.50 || moneta==1.0 || moneta==2.0)
			credito+=moneta;		//credito=credito+moneta
		else
			System.out.println("Moneta non valida");
	}
	
	public float getCosto() {		
		switch(capacitÓ) {
			case 8:
				return 4.50f;			
			case 10:
				return 5.50f;			
			case 14:
				return 6.50f;
			default:
				return 0;		//mai vero		
		}
	}
	
	public void start() {
		if (credito<getCosto())
			System.out.println("Credito insufficiente");
		else if (livelloAcqua<4)
			System.out.println("Livello acqua insufficiente");
		else if (temperatura==0)
			System.out.println("Temperatura non impostata");
		else if (velocitÓRotazione==0)
			System.out.println("VelocitÓ di rotazione non impostata");
		else if (!detersivo)
			System.out.println("Detersivo non aggiunto");
		else if (stato!=0) 
			System.out.println("La lavatrice non Ŕ libera");
		else {				//ho verificato tutto=>avvio il lavaggio
			stato=1;		//lavaggio in corso
			dataOraAvvio=LocalTime.now();	//memorizzo la data/ora avvio
		}
	}	
	
	
	public void stop() {
		if (stato==1)
			stato=2;		//lavaggio terminato
		else
			System.out.println("Lavatrice giÓ ferma");
	}
	
	public String getStato() {
		LocalTime lt=LocalTime.now(); 	//data/ora corrente
		
		if (stato==1 && 								// lavaggio in corso
			SECONDS.between(dataOraAvvio, lt)>60)		// sono passati pi¨ di 60 secondi
			stato=2;		// lavaggio terminato
		
		switch(stato) {
			case 0:
				return "Libera";
			case 1:
				return "Lavaggio in corso. Tempo trascorso: "+ 
						SECONDS.between(dataOraAvvio, lt) ;
			case 2:
				return "Lavaggio terminato";
			default:
				return "";
		}
	}

	public int getCapacitÓ() {
		return capacitÓ;
	}

	public int getLivelloAcqua() {
		return livelloAcqua;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public int getVelocitÓRotazione() {
		return velocitÓRotazione;
	}

	public boolean detersivoAggiunto() {
		return detersivo;
	}

	public float getCredito() {
		return credito;
	}
		
	public void svuota() {
		if (stato==2) 
			inizializza();		
			
		else if (stato==0)
			System.out.println("Lavatrice giÓ vuota");
		else
			System.out.println("Lavaggio in corso");
			
	}
		
	
}