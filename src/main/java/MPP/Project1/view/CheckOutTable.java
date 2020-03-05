package MPP.Project1.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import MPP.Project1.model.Lend;

public class CheckOutTable {

	private JFrame frame;
	private JTable table;
	private static List<Lend> lend = new ArrayList<Lend>();

	/**
	 * Launch the application.
	 */
	public void checkOutRecord(final List<Lend> lend) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOutTable window = new CheckOutTable(lend);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckOutTable(List<Lend> lend) {
		this.lend = lend;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Object []Cdfheaders1= {"MemberName","Book Title", "LendDate", "DueDate"};
		
		JLabel lblNewLabel = new JLabel("Check out Record");
		lblNewLabel.setBounds(10, 11, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 31, 414, 220);
		
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(Cdfheaders1);
		Object rowdata[] = new Object[4];
		if(lend != null) {
			for(int i = 0 ; i <lend.size() ;++i) {
				rowdata[0]=lend.get(i).getMember().getFirst_name();
				rowdata[1]=lend.get(i).getBook().getBook().getTitle();
				rowdata[2]=lend.get(i).getLendDate() ;
				rowdata[3]=lend.get(i).getDueDate();
				model.addRow(rowdata);
			}
			table.setModel(model);
		}	
		
		scrollPane.setViewportView(table);
	}
}
