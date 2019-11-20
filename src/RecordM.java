
public class RecordM implements RecordManager {
	
	Map<String , Map< String , List<Record> > > m = new BST <String , Map< String , List<Record> > > ();



	
	@Override
	public Map<String, Map<String, List<Record>>> getFromMap() {


	return m ;
	
	}

	@Override
	public void addRecord(Record record) {
		
	
		if(m.find(record.from)) {
			
			Map<String, List<Record> > m2 = m.retrieve();
			
			if(m2.find(record.to) ) {
				m2.retrieve().insert(record);;
				
			}else {
				
				List<Record> l = new LinkedList<Record>();
				l.insert(record);
				m2.insert(record.to , l );
				
			}
		}else {
				
			Map<String, List<Record> > m2 = new BST < String , List<Record> >();
			List<Record> l = new LinkedList<Record>(); 
			l.insert(record);
			m2.insert(record.to, l);
			m.insert(record.from , m2) ;
			
		}
		
		
	}

	@Override
	public List<Record> callsFrom(String nb) {

		
		List<Record> l = new LinkedList<Record>();
		
		if(m.find(nb) ) {
		
			Map< String, List<Record> > m2 = m.retrieve();
			
			List<Pair <String , List<Record> > > s = m2.getAll();
			
			s.findFirst();
		
				while(s != null) {
					List<Record> q = s.retrieve().second;
					
					q.findFirst();	 
					while(q != null) {
						l.insert(q.retrieve());
						q.remove();
					}
				  
					s.remove();
				}
		
		 return l ;
		}
	 	
	    return null;
	}
	

	
	

	@Override
	public boolean callFrom(String nb1, String nb2) {

		if(m.find(nb1)) { 
		if(m.retrieve().find(nb2))
			
		return true;
		
		}
		
		return false;
	
	}
 
	@Override
	public int nbKeyCompCallFrom(String nb1, String nb2) {
		
		int num = 0;

		if(m.find(nb1)) {
		num = m.nbKeyComp(nb1);	
		if(m.retrieve().find(nb2)) 
			num += m.retrieve().nbKeyComp(nb2);
		}
		
		return num;
			
		}
			
		
	}

	
	

