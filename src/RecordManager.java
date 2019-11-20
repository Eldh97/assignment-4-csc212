public interface RecordManager {

	// Return all call records as a map of maps of list of records. The first map is index by the caller, whereas the second is indexed by the receiver.
	Map<String, Map<String, List<Record>>> getFromMap();

	// Add a record to the set of records.
	void addRecord(Record record);

	// Returns the list of all call records made from the number nb.
	List<Record> callsFrom(String nb);

	// Checks if any call was made from nb1 to nb2.
	boolean callFrom(String nb1, String nb2);

	// Return the number of key comparisons needed to check if a call is made from nb1 to nb2.
	int nbKeyCompCallFrom(String nb1, String nb2);
	
	
}
