import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class gui extends  JFrame{
	
	JTable jt;
	DefaultTableModel dtm;
	   public gui() {
		   jt = new JTable();
		   String[]rows = {"Date", "Time", "Country", "City", "Device", "Scans"};
		   String [] [] cols = {{},{}};
		   dtm = new DefaultTableModel(cols, rows);
		   jt.setModel(dtm);
		   JScrollPane sp = new JScrollPane();
		   sp.setViewportView(jt);
		   add(sp);
		   setSize(500,500);
		   setVisible(true);
		   setLocationRelativeTo(null);
		   
	   }

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		new gui();
		
		
		
		
		
		//CSV = Comma-Separated Values 
		  //   text file that uses a comma to separate values
		  
		  String file = "src\\test.csv";
		  BufferedReader reader = null;
		  String line = "";
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   while((line = reader.readLine()) != null) {
		    
		    String[] row = line.split(",");
		    //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		//use this if your values already contain commas
		    for(String index : row) {
		     System.out.printf("%-10s", index);
		    }
		    System.out.println();
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		 }

	

}
