package kjedetKoeTest;
import adt.KoeADT;
import kjedet.KjedetKoe;
import testADT.TestkoeADT;

public class KjedetKoeTest extends TestkoeADT{

	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}	
}