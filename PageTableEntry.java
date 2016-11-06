

public class PageTableEntry{
	public boolean dirtyBit = false;
	public boolean referenceBit = true;
	public int pageFrameNumber; 
	public VirtualAddress virtualAddress;
	
	public PageTableEntry(int pageFrameNumber, VirtualAddress virtualAddress){
		this.pageFrameNumber = pageFrameNumber;
		this.virtualAddress = virtualAddress;
	}

	public void setDirtyBit(boolean dirtyBit){
		this.dirtyBit = dirtyBit;
		}

	public void setReferenceBit(boolean referenceBit){
		this.referenceBit = referenceBit;
	}



}

