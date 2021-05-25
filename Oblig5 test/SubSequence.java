public class SubSequence {
	private String sequence;
	private int occurences = 1;
	public SubSequence (String s) {sequence = s;}
	// public void addOne ( ) {occurences++;}
	public String nokkel() {return sequence;}
	public int antall () {return occurences;}
	public void leggTil(int ant) {occurences = occurences + ant;}
}
