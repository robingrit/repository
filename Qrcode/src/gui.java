import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Action;
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
import org.json.simple.parser.ParseException;

public class gui extends JFrame {
	public static ArrayList<JsonBean> orderList1 = new ArrayList<JsonBean>();
	public static ArrayList<JsonBean> orderList2 = new ArrayList<JsonBean>();
	public static ArrayList<JsonBean> orderList3 = new ArrayList<JsonBean>();
	JTable jt;
	DefaultTableModel dtm;

	static int qrOption = 1;

	public gui() {

		JFrame frame = new JFrame("Java Qr Code");
		frame.setSize(500, 500);
		;
//		   
//		   
//		 //Panel Code
		JPanel jPanel = new JPanel();
		BoxLayout verticalLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
		jPanel.setLayout(verticalLayout);
		frame.add(jPanel);

	

		JLabel data_label = new JLabel("Qr Code 1");
		data_label.setAlignmentX(JLabel.CENTER);
		data_label.setBackground(Color.BLACK);
		data_label.setForeground(Color.WHITE);
		data_label.setOpaque(true);
		EmptyBorder emptyBorder1 = new EmptyBorder(20, 20, 20, 20);
		data_label.setBorder(emptyBorder1);
		jPanel.add(data_label);

		////////
		JLabel data_label2 = new JLabel("Qr Code 2");
		data_label2.setAlignmentX(JLabel.CENTER);
		data_label2.setBackground(Color.BLACK);
		data_label2.setForeground(Color.WHITE);
		data_label2.setOpaque(true);
		data_label2.setBorder(emptyBorder1);

		JLabel data_label3 = new JLabel("Qr Code 3");
		data_label3.setAlignmentX(JLabel.CENTER);
		data_label3.setBackground(Color.BLACK);
		data_label3.setForeground(Color.WHITE);
		data_label3.setOpaque(true);
		data_label3.setBorder(emptyBorder1);

		

		DefaultTableModel data = new DefaultTableModel();
		DefaultTableModel data2 = new DefaultTableModel();
		DefaultTableModel data3 = new DefaultTableModel();

		try {
			int start = 0;
			if (start == 0) {

				start = 1;

				data.addColumn("Country");
				data.addColumn("City");
				data.addColumn("Device");
				data.addColumn("count");

			}
			for (JsonBean string : orderList1) {

				Vector row = new Vector();
				row.add(string.loc);
				row.add(string.city);
				row.add(string.device);
				row.add(string.count);

				data.addRow(row);

			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}

		try {
			int start = 0;
			if (start == 0) {

				start = 1;

				data2.addColumn("Country");
				data2.addColumn("City");
				data2.addColumn("Device");
				data2.addColumn("count");

			}
			for (JsonBean string : orderList2) {

				Vector row = new Vector();
				row.add(string.loc);
				row.add(string.city);
				row.add(string.device);
				row.add(string.count);

				data2.addRow(row);

			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}
		try {
			int start = 0;
			if (start == 0) {

				start = 1;

				data3.addColumn("Country");
				data3.addColumn("City");
				data3.addColumn("Device");
				data3.addColumn("count");

			}
			for (JsonBean string : orderList2) {

				Vector row = new Vector();
				row.add(string.loc);
				row.add(string.city);
				row.add(string.device);
				row.add(string.count);

				data3.addRow(row);

			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}
		JTable jTable2 = new JTable();
		JScrollPane jScrollPane2 = new JScrollPane();
		JTable jTable3 = new JTable();
		JScrollPane jScrollPane3 = new JScrollPane();
		JTable jTable4 = new JTable();
		JScrollPane jScrollPane4 = new JScrollPane();

		System.out.println("qr " + qrOption);

		System.out.println("option 1");
		jTable2.setModel(data);
		jScrollPane2.getViewport().add(jTable2);

		jPanel.add(jScrollPane2);

		qrOption++;
		System.out.println("option 2");
		jPanel.add(data_label2);
		jTable3.setModel(data2);
		jScrollPane3.getViewport().add(jTable3);

		jPanel.add(jScrollPane3);

		System.out.println("option 3");
		jPanel.add(data_label3);
		jTable4.setModel(data3);

		jScrollPane4.getViewport().add(jTable4);

		jPanel.add(jScrollPane4);

		frame.setVisible(true);

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		openJson();

		new gui();

	}

	public static void openJson() throws FileNotFoundException, IOException {
		try {
			System.out.println("openJson ");
//			
			for (int j = 1; j < 4; j++) {
				jsonReader.JsonRead(j);
				if (j == 1) {
					orderList1.addAll(jsonReader.ParseQr());
				} else if (j == 2) {
					orderList2.addAll(jsonReader.ParseQr());
				} else {
					orderList3.addAll(jsonReader.ParseQr());
				}

			}

		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
