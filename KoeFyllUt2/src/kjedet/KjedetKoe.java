package kjedet;
import adt.KoeADT;
import no.hvl.data102.exception.EmptyCollectionException;

//********************************************************************
// 
//  Representerer en samling k� implementer vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> foran, bak;

	/******************************************************************
	 * Oppretter en tom k�.
	 ******************************************************************/
	public KjedetKoe() {
		antall = 0;
		foran = bak = null;
	}

	/******************************************************************
	 * Legger inn et spesifisert element i k�en.
	 ******************************************************************/
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		
		if (foran==null) {
			foran = nyNode;	
		}
			bak=nyNode;
			antall++;
	}

	/******************************************************************
	 * Fjerner og returnerer elementet foran i k�en.
	 ******************************************************************/
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		
		T ut = foran.getElement();
		
		antall--;
		if(antall == 0) {		//Endra rekkef�lgen og litt p� denne
			foran=null;
			bak=null;
		} else {
			foran = foran.getNeste();
		}

		return ut;	
	}

	/******************************************************************
	 * Returnerer elementet foran i k�en ute � fjerne det.
	 ******************************************************************/
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		return foran.getElement();
		
	}

	/******************************************************************
	 * Returnerer sann hvis k�en er tom, usann ellers.
	 ******************************************************************/
	public boolean erTom() {
		return (antall == 0);
	}

	/******************************************************************
	 * Returnerer antall elementer i k�en.
	 ******************************************************************/
	public int antall() {
		return antall;
	}

	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene i k�en.
	 ******************************************************************/
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = foran;

		while (aktuell != null) {
			resultat = resultat + (aktuell.getElement()).toString() + "\n";
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}
}// class

