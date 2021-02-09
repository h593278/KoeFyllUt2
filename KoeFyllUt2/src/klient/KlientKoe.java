package klient;

import adt.KoeADT;
import no.hvl.data102.exception.EmptyCollectionException;
import tabell.TabellKoe;

public class KlientKoe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KoeADT<Character> tegnKoe = new TabellKoe<>();
		//Bytte ut med KjedetKoe og med SirkulaerKoe
		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();
		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(streng.charAt(i));
		}
		//System.out.println(tegnKoe); // kall p� toString()
		try {
			while (!tegnKoe.erTom()) {
				char tegn = tegnKoe.utKoe();
				System.out.print(tegn);
			}
		} catch (EmptyCollectionException e) {
			System.out.print(e.getMessage());

		}
		
	}

}
