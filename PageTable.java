import java.util.*;

public class PageTable{
	//update valid, dirty, reference bits etc
	//Hashmap<upper 10 bits, Hashmap>...next Hashmap<lower 10 bit, pageTableEntry>
 	public HashMap<Integer, HashMap<Integer, PageTableEntry>> firstLevel = new HashMap<Integer, HashMap<Integer, PageTableEntry>>();
 	//the upper order bits map to the second level, and the lower order bits map to the page table entry
 	public PageTableEntry get(VirtualAddress virtualAddress){//gets a page table entry from a virtual address
 		//virtualAddress is the key, PageTableEntry is the value
 		HashMap<Integer, PageTableEntry> secondLevel = firstLevel.get(virtualAddress.getUpperOrderBits());//the hashmap that is mapped in firstLevel

 		if(secondLevel == null){
 			return null;
 		} else {
 			return secondLevel.get(virtualAddress.getLowerOrderBits());
 		}
 	}

 	public void insert(PageTableEntry pageTableEntry){
 		HashMap<Integer, PageTableEntry> secondLevel = firstLevel.get(pageTableEntry.virtualAddress.getUpperOrderBits());//the hashmap that is mapped in firstLevel
 		
 		if(secondLevel == null){
 			secondLevel = new HashMap<Integer, PageTableEntry>(); 
 			firstLevel.put(pageTableEntry.virtualAddress.getUpperOrderBits(), secondLevel);
 		}

 		secondLevel.put(pageTableEntry.virtualAddress.getLowerOrderBits(), pageTableEntry);
 	}

 	public void remove(PageTableEntry pageTableEntry){
 		//write co that correctly assumes the 2nd level exists!!!!
 		HashMap<Integer, PageTableEntry> secondLevel = firstLevel.get(pageTableEntry.virtualAddress.getUpperOrderBits());//the hashmap that is mapped in firstLevel
 		secondLevel.remove(pageTableEntry.virtualAddress.getLowerOrderBits());

 		if(secondLevel.isEmpty()){
 			firstLevel.remove(pageTableEntry.virtualAddress.getUpperOrderBits());
 		}
 	}

 	


	

}