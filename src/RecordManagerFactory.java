import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;
import java.io.*;
public class RecordManagerFactory  {

	
	
	
	// Create an empty record manager
static 	RecordManager createManager() {
		RecordManager m = new RecordM();
		return m;
	}

	// Read records from file. Assume that the file is correct.
	@SuppressWarnings("resource")
	static RecordManager read(String fileName)throws Exception {
		
		RecordManager m = createManager();
		Scanner scan = new Scanner(new File(fileName));
		
		try {
			
			String s = null;
		
			while(scan.hasNextLine()) {
				
				s = scan.nextLine();	
				String a[] = s.split(" ");
				
				SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
				Date start = dateForm.parse(a[2]);
				Date end = dateForm.parse(a[3]);
				
				Record r = new Record(a[0],a[1],start,end);
				m.addRecord(r);
		
			}
		
		}catch(Exception e) {
			scan.close();
			return m ;
		}
	
	return m;
	
	}
	
	
	
}
