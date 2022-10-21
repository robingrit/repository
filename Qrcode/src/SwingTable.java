

	import javax.swing.*;
	import javax.swing.border.EmptyBorder;
	import javax.swing.event.TableModelEvent;
	import javax.swing.event.TableModelListener;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.InputStreamReader;
	import java.util.Vector;



	

	@SuppressWarnings("rawtypes")
	public class SwingTable extends  JFrame {
		
		
		
		public SwingTable() {
		System.out.println("=============Java GUI Swing Table=================");


        JFrame frame=new JFrame("Java Swing Table");
        frame.setSize(500,500);


        //Panel Code
        JPanel jPanel=new JPanel();
        BoxLayout verticalLayout=new BoxLayout(jPanel,BoxLayout.Y_AXIS);
        jPanel.setLayout(verticalLayout);
        frame.add(jPanel);



        //Label
//        JLabel static_data_label=new JLabel("Static Data Table");
//        static_data_label.setAlignmentX(JLabel.CENTER);
//        static_data_label.setBackground(Color.BLACK);
//        static_data_label.setForeground(Color.WHITE);
//        static_data_label.setOpaque(true);
//        EmptyBorder emptyBorder=new EmptyBorder(20,20,20,20);
//        static_data_label.setBorder(emptyBorder);
//        jPanel.add(static_data_label);
//
//        //Data and Column
//        String column[]={"Name","Email","Age"};
//        String data[][]={
//                {"Rahul","rahul@gmail.com","30"},
//                {"Vishal","vishal@gmail.com","31"},
//                {"Aman","aman@gmail.com","29"}
//        };

        //table
        //JTable jTable=new JTable(data,column);

//        JScrollPane jScrollPane=new JScrollPane();
//        jScrollPane.getViewport().add(jTable);
//        jPanel.add(jScrollPane);

        //Label
        JLabel dynamic_data=new JLabel("Dynamic Data Table");
        dynamic_data.setAlignmentX(JLabel.CENTER);
        dynamic_data.setBackground(Color.BLACK);
        dynamic_data.setForeground(Color.WHITE);
        dynamic_data.setOpaque(true);
        EmptyBorder emptyBorder2=new EmptyBorder(20,20,20,20);
        dynamic_data.setBorder(emptyBorder2);
        jPanel.add(dynamic_data);

        DefaultTableModel table_data=new DefaultTableModel();
        for (int i=0;i<30;i++){
            if(i==0){
                table_data.addColumn("ID");
                table_data.addColumn("Name");
                table_data.addColumn("Email");
                table_data.addColumn("Age");
            }
            else{
                Vector row=new Vector();
                row.add(""+i);
                row.add("Rahul "+i);
                row.add("Rahul"+i+"@gmail.com");
                row.add("2"+i);
                table_data.addRow(row);
            }
        }


        //Dynamic Table With Data
        JTable table2=new JTable();
        table2.setModel(table_data);
        JScrollPane jScrollPane1=new JScrollPane();
        jScrollPane1.getViewport().add(table2);


        jPanel.add(jScrollPane1);

       
		
	}
	    public static void main(String args[]){
	    	new SwingTable ();
	        
	        

	        
	}
	
}