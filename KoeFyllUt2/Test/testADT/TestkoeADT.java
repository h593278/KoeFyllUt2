package testADT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.KoeADT;
import no.hvl.data102.exception.EmptyCollectionException;

/**
 * Test for KoeADT.
 * 
 * @author Ole Anders Nødland, Odd Rosland, Andrea Myhre Svendheim, Nasra Salim Tahil
 */

public abstract class TestkoeADT {
	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	/**
	 * Henter ein ny koe for hver test
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	/**
	 * Test på at en ny kø er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * tester op ut og innputt.
	 */
	@Test
	public void innOgUt() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på ut og inn med duplikate verdier.
	 */
	@Test
	public void inOgUtMedDuplikater() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}
	/**
	 * Testing på ut og inn og lesing av førte verdi.
	 */
	@Test
	public void innUtInnInnUtFoerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("pop eller peek feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en kø med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på at en kø med null elementer er tom.
	 */
	@Test
	public void inUtErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på størrelsen
	 */
	@Test
	public void stor() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Forsøk på å ta ut av en tom kø skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void OutFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { koe.utKoe(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}

