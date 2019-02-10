
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class Entry extends JFrame {

	private JPanel contentPane;
	private JTextField txtGov;
	private JTextField txtCardsExistsTotal;
	private JTextField txtCardsPC;
	private JTextField txtCardsTotalDistributed;
	private JTextField txtCardsPVC;
	private JTextField txtCardsReturned;
	private JTextField txtCardsRemained;
	private JLabel lblCardsExistsTotal;
	private JLabel lblCardsPc;
	private JLabel lblCardsDistrinutedpcv;
	private JLabel lblCardsReturned;
	private JLabel lblCardsRemained;
	private JLabel lblCardsTotalDistributed;
	private JTable table;
	private JLabel lblEntryDate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblCardDistributionDaily;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Entry() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Daily Report System - Entry");
		setBounds(100, 100, 1090, 600);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGovernorate = new JLabel("Governorate");
		lblGovernorate.setForeground(Color.BLUE);
		lblGovernorate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGovernorate.setBounds(20, 54, 89, 23);
		contentPane.add(lblGovernorate);

		txtGov = new JTextField();
		txtGov.setText("\u0628\u063A\u062F\u0627\u062F - \u0627\u0644\u0631\u0635\u0627\u0641\u0629");
		txtGov.setEnabled(false);
		txtGov.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtGov.setColumns(10);
		txtGov.setBounds(191, 54, 130, 20);
		contentPane.add(txtGov);

		JLabel lblVrc = new JLabel("VRC");
		lblVrc.setForeground(Color.BLUE);
		lblVrc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVrc.setBounds(20, 108, 89, 23);
		contentPane.add(lblVrc);

		JComboBox cbVRC = new JComboBox();
		cbVRC.setMaximumRowCount(80);
		cbVRC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbVRC.setBounds(191, 108, 130, 20);
		contentPane.add(cbVRC);

		txtCardsExistsTotal = new JTextField();
		txtCardsExistsTotal.setEditable(false);
		txtCardsExistsTotal.setText("100000");
		txtCardsExistsTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsExistsTotal.setBounds(191, 154, 130, 20);
		contentPane.add(txtCardsExistsTotal);
		txtCardsExistsTotal.setColumns(10);

		txtCardsPC = new JTextField();
		txtCardsPC.setText("0");

		txtCardsPC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsPC.setColumns(10);
		txtCardsPC.setBounds(191, 196, 130, 20);
		contentPane.add(txtCardsPC);

		txtCardsTotalDistributed = new JTextField();
		txtCardsTotalDistributed.setEditable(false);
		txtCardsTotalDistributed.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsTotalDistributed.setColumns(10);
		txtCardsTotalDistributed.setBounds(191, 294, 130, 20);
		contentPane.add(txtCardsTotalDistributed);

		txtCardsPVC = new JTextField();
		txtCardsPVC.setText("0");
		txtCardsPVC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsPVC.setColumns(10);
		txtCardsPVC.setBounds(191, 244, 130, 20);
		contentPane.add(txtCardsPVC);

		txtCardsReturned = new JTextField();
		txtCardsReturned.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsReturned.setColumns(10);
		txtCardsReturned.setBounds(191, 347, 130, 20);
		contentPane.add(txtCardsReturned);

		txtCardsRemained = new JTextField();
		txtCardsRemained.setEditable(false);
		txtCardsRemained.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCardsRemained.setColumns(10);
		txtCardsRemained.setBounds(191, 422, 130, 20);
		contentPane.add(txtCardsRemained);

		lblCardsExistsTotal = new JLabel("Cards Exists Total");
		lblCardsExistsTotal.setForeground(Color.BLUE);
		lblCardsExistsTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsExistsTotal.setBounds(20, 153, 149, 23);
		contentPane.add(lblCardsExistsTotal);

		lblCardsPc = new JLabel("Cards Distrinuted-PC");
		lblCardsPc.setForeground(Color.BLUE);
		lblCardsPc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsPc.setBounds(20, 196, 149, 23);
		contentPane.add(lblCardsPc);

		lblCardsDistrinutedpcv = new JLabel("Cards Distrinuted-PVC");
		lblCardsDistrinutedpcv.setForeground(Color.BLUE);
		lblCardsDistrinutedpcv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsDistrinutedpcv.setBounds(20, 244, 149, 23);
		contentPane.add(lblCardsDistrinutedpcv);

		lblCardsReturned = new JLabel("Cards Returned");
		lblCardsReturned.setForeground(Color.BLUE);
		lblCardsReturned.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsReturned.setBounds(20, 347, 149, 23);
		contentPane.add(lblCardsReturned);

		lblCardsRemained = new JLabel("Cards Remained");
		lblCardsRemained.setForeground(Color.BLUE);
		lblCardsRemained.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsRemained.setBounds(20, 422, 149, 23);
		contentPane.add(lblCardsRemained);

		lblCardsTotalDistributed = new JLabel("Cards Total Distributed");
		lblCardsTotalDistributed.setForeground(Color.BLUE);
		lblCardsTotalDistributed.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardsTotalDistributed.setBounds(10, 293, 159, 23);
		contentPane.add(lblCardsTotalDistributed);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 51, 700, 391);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.GRAY);

		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int col) {
				if (row == 0 || col == 0 || col == 1 || col == 2 || col == 9)
					return false;
				return true;
			}
		};

		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(table);
		table.setBackground(Color.GRAY);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		JSpinner dtStart = new JSpinner();
		dtStart.setModel(
				new SpinnerDateModel(new Date(1549400400000L), new Date(1517864400000L), null, Calendar.DAY_OF_YEAR));
		dtStart.setBounds(422, 499, 118, 20);
		contentPane.add(dtStart);
		JComponent edt = new JSpinner.DateEditor(dtStart, "dd MM yyyy");
		dtStart.setEditor(edt);

		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn;
				try {
					conn = DBconnection.connect();
					String startDate = new SimpleDateFormat("yyyy/MM/dd").format(dtStart.getValue());
					int startDay = Integer.parseInt(startDate.substring(startDate.length() - 2));
					int startMonth = Integer.parseInt(startDate.substring(5, 7));
					int startYear = Integer.parseInt(startDate.substring(0, 4));
					ResultSet rs = DBconnection.LoadTable(conn, startDay, startMonth, startYear);
					if (rs != null) {
						table.setModel(DbUtils.resultSetToTableModel(rs));

					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnLoadData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadData.setBounds(550, 479, 118, 59);
		contentPane.add(btnLoadData);

		JSpinner dtInsertDate = new JSpinner();
		dtInsertDate.setEnabled(false);
		dtInsertDate.setModel(new SpinnerDateModel(new Date(1549400400000L), new Date(1549400400000L),
				new Date(1549400400000L), Calendar.DAY_OF_WEEK));
		dtInsertDate.setBounds(191, 378, 118, 20);
		contentPane.add(dtInsertDate);
		JComponent editor = new JSpinner.DateEditor(dtInsertDate, "dd MM yyyy");
		dtInsertDate.setEditor(editor);

		JButton btnInsertData = new JButton("Insert Data");
		btnInsertData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (cbVRC.getSelectedItem().toString().equals("---")) {
						JOptionPane.showMessageDialog(null, "Please Select VRC");
						return;
					}

					int vrcId = Integer.parseInt(cbVRC.getSelectedItem().toString()
							.substring(cbVRC.getSelectedItem().toString().length() - 4));
					Connection conn = DBconnection.connect();

					String strDate = new SimpleDateFormat("yyyy/MM/dd").format(dtInsertDate.getValue());

					int day = Integer.parseInt(strDate.substring(strDate.length() - 2));
					int month = Integer.parseInt(strDate.substring(5, 7));
					int year = Integer.parseInt(strDate.substring(0, 4));

					if (DBconnection.Insert(conn, vrcId, Integer.parseInt(txtCardsPC.getText()),
							Integer.parseInt(txtCardsPVC.getText()), Integer.parseInt(txtCardsReturned.getText()), day,
							month, year, DBconnection.currentUserId)) {
						JOptionPane.showMessageDialog(null, "Inserted Sucessfully");
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		});

		btnInsertData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnInsertData.setBounds(94, 459, 110, 59);
		contentPane.add(btnInsertData);

		lblEntryDate = new JLabel("Entry Date");
		lblEntryDate.setForeground(Color.BLUE);
		lblEntryDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEntryDate.setBounds(20, 376, 149, 23);
		contentPane.add(lblEntryDate);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = DBconnection.connect();

					if (table.getSelectedRow() > 0) {

						int entryId = (int) table.getValueAt(table.getSelectedRow(), 0);
						int cardsDistrinutedPC = Integer
								.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
						int cardsDistrinutedPVC = Integer
								.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
						int cardsReturned = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
						int entryDay = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
						int entryMonth = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 7).toString());
						int entryYear = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString());

						// System.out.println(cardsDistrinutedPC+":"+ cardsDistrinutedPVC
						// +":"+cardsReturned+":"+ entryDay+":"+ entryMonth+":"+ entryYear
						// +":"+DBconnection.currentUserId+":"+entryId);

						if (DBconnection.Update(conn, cardsDistrinutedPC, cardsDistrinutedPVC, cardsReturned, entryDay,
								entryMonth, entryYear, DBconnection.currentUserId, entryId)) {
							JOptionPane.showMessageDialog(null, "Updated Sucessfully");
						}
						else {
							JOptionPane.showMessageDialog(null, "Error Updating Data");
						}
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(704, 479, 110, 59);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = DBconnection.connect();

					if (table.getSelectedRow() > 0) {

						int entryId = (int) table.getValueAt(table.getSelectedRow(), 0);

						if (DBconnection.Delete(conn, entryId)) {
							JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
						}
						else {
							JOptionPane.showMessageDialog(null, "Error Deleting Data");
						}
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(839, 481, 110, 59);
		contentPane.add(btnDelete);

		lblCardDistributionDaily = new JLabel("Cards Distribution Daily Report");
		lblCardDistributionDaily.setForeground(Color.BLUE);
		lblCardDistributionDaily.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCardDistributionDaily.setBounds(500, 17, 206, 23);
		contentPane.add(lblCardDistributionDaily);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txtGov, cbVRC,
				txtCardsExistsTotal, txtCardsPC, txtCardsPVC, txtCardsReturned, txtCardsRemained, lblGovernorate,
				lblVrc, txtCardsTotalDistributed, lblCardsExistsTotal, lblCardsPc, lblCardsDistrinutedpcv,
				lblCardsReturned, lblCardsRemained, lblCardsTotalDistributed }));

		loadVrcCB(cbVRC);
	}

	private void loadVrcCB(JComboBox cb) throws ClassNotFoundException, SQLException {
		Connection conn = DBconnection.connect();
		ResultSet rs = DBconnection.LoadVrc(conn);

		if (rs != null) {
			cb.addItem("---");
			while (rs.next()) {
				cb.addItem(rs.getString("VrcName") + " - " + rs.getString("VrcId"));
			}
		}
		rs.close();

	}
}
