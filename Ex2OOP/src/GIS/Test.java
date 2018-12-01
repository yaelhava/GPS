package GIS;

import java.util.Iterator;

import Algorithms.MultiCSV;
import File_format.Csv2kml;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MultiCSV c = new MultiCSV("C:\\Test");
		ProjectGIS P = c.getProject();
		c.export();
	
//			Iterator it = P.iterator();
//			while(it.hasNext()) {  
//			LayerGIS l = (LayerGIS) it.next();
//				Iterator<GIS_element> itt = l.iterator();
//				while(itt.hasNext()) {
//				GIS_element e = itt.next();
//				System.out.println(e.getData());
			//	}
		//	}
			
	}


}
