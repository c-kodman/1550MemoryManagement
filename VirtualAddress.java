

public class VirtualAddress{
	private char RW;
	private int page;
	private final int offsetPage = 12;//2^12 bits
	private final int upperOrderBits = 10;
	private final int lowerOrderBits = 22;//this is the offset plus the upper order bits that I will shift to leave only the lower
	
	public VirtualAddress(int address, char RW){
		//shift right 12 bits to remove offset
		this.page = address >> offsetPage; //0041f
		this.RW = RW;
	}

	public int getUpperOrderBits(){
		return this.page >> upperOrderBits;//shifted to remove the lower 10 bits
	}

	public int getLowerOrderBits(){
		return this.page << lowerOrderBits;//shifted to remove the upper order 10 bits (and offset)
	}

	public char getRW(){
		return RW;
	}


}