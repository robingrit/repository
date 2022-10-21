import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
public class gui extends  JFrame{
	
	JTable jt;
	DefaultTableModel dtm;
	   public gui() {

		   
	 JFrame frame=new JFrame("Java Swing Table");
	        frame.setSize(500,500);
	        ;
//		   
//		   
//		 //Panel Code
	        JPanel jPanel=new JPanel();
        BoxLayout verticalLayout=new BoxLayout(jPanel,BoxLayout.Y_AXIS);
	        jPanel.setLayout(verticalLayout);
           frame.add(jPanel);
           
		   
		   
		   
	        
	        
	        
	        // Qr kod 3
	        
	        JLabel csv_data_label=new JLabel("Qr Code QMXB");
	        csv_data_label.setAlignmentX(JLabel.CENTER);
	        csv_data_label.setBackground(Color.BLACK);
	        csv_data_label.setForeground(Color.WHITE);
	        csv_data_label.setOpaque(true);
	        EmptyBorder emptyBorder1=new EmptyBorder(20,20,20,20);
	        csv_data_label.setBorder(emptyBorder1);
	        jPanel.add(csv_data_label);
	        
	        
	        //Parse cvs
	        File csv_file= new File("src\\QMXB-1666270569463.csv");
	        DefaultTableModel csv_data =new DefaultTableModel();
	        
	        try {
	        	int start= 0;
	        	InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(csv_file));
	        	CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
	        			for(CSVRecord csvRecord:csvParser) {
	        				if(start ==0) {
	        					System.out.println("körs");
	        					start= 1;
	        				csv_data.addColumn(csvRecord.get(0));
	        				csv_data.addColumn(csvRecord.get(1));
	        				csv_data.addColumn(csvRecord.get(2));
	        				csv_data.addColumn(csvRecord.get(3));
	        				csv_data.addColumn(csvRecord.get(4));
	        				csv_data.addColumn(csvRecord.get(5));
	        				}
	        				
	        			
	        			else {
	        				Vector row = new Vector();
	        				row.add(csvRecord.get(0));
	        				row.add(csvRecord.get(1));
	        				row.add(csvRecord.get(2));
	        				row.add(csvRecord.get(3));
	        				row.add(csvRecord.get(4));
	        				row.add(csvRecord.get(5));
	        				csv_data.addRow(row);
	        			}
	        			}
	        }
	        catch(Exception e){
	        	System.out.println(e.toString());
	        	
	        }
	        JTable jTable2 = new JTable();
	        jTable2.setModel(csv_data);
	        JScrollPane jScrollPane2 = new JScrollPane();
	        jScrollPane2.getViewport().add(jTable2);
	        
	        jPanel.add(jScrollPane2);
	        
	        
	        
	        //listner till Table
	        jTable2.getModel().addTableModelListener(new TableModelListener() {
				
				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        
	        frame.setVisible(true);
	        
	        

		   
	   }

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		new gui();
		
		
		
		
		
		//CSV = Comma-Separated Values 
		  //   text file that uses a comma to separate values
		  
		  String file = "src\\QMXB-1666270569463.csv";
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
