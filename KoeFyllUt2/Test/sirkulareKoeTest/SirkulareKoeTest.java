package sirkulareKoeTest;

import adt.KoeADT;
import sirkulaer.SirkulaerKoe;
import testADT.TestkoeADT;

public class SirkulareKoeTest extends TestkoeADT{

	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}	
}
