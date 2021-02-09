package tebellKoeTest;

import adt.KoeADT;
import tabell.TabellKoe;
import testADT.TestkoeADT;

public class TebellKoeTest extends TestkoeADT{

	@Override
	protected KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}	
}