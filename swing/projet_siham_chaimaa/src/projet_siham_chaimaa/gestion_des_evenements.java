package projet_siham_chaimaa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestion_des_evenements {

	private JFrame frame;
	private JTextField tcode_u;
	private JTextField tnom_u;
	private JTextField tprenom_u;
	private JTextField temail_u;
	private JTextField tid_e;
	private JTextField tn_salle;
	private JTextField tn_bloc;
	private JTextField tnbr_chaise;
	private JTextField tnbr_table;
	private JTextField tcapacite;
	private JTable ttable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_des_evenements window = new gestion_des_evenements();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst31;
    PreparedStatement pst32;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    private JTextField tdate_e;
    
	public gestion_des_evenements() {
		initialize();
		Table();
	}
     public void Connect() {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_salles","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	private void Table() {
		Connect();
		String [] entet = {"code","nom","prenom","email","type","id even","date even","n salle","n bloc","nbr chaise","nbr table","capacite"};
		String [] ligne = new String[12];
		
		DefaultTableModel model = new DefaultTableModel(null,entet);
		String sql = "select * from utilisateur";
		String sql1 = "select * from evenement";
		String sql2 = "select * from salle";
		Statement st = null;
		Statement st1 = null;
		Statement st2 = null;
		try {
			st = con.createStatement();
			st1 = con.createStatement();
			st2 = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			rs = st.executeQuery(sql);
		    rs1 = st1.executeQuery(sql1);
			rs2 = st2.executeQuery(sql2);
			
			while(rs.next() && rs1.next() && rs2.next()) {
				ligne[0]=rs.getString("code_u");
				ligne[1]=rs.getString("nom_u");
				ligne[2]=rs.getString("prenom_u");
				ligne[3]=rs.getString("email_u");
				ligne[4]=rs.getString("type_u");
				ligne[5]=rs1.getString("id_e");
				ligne[6]=rs1.getString("date_e");
				ligne[7]=rs2.getString("num_salle");
				ligne[8]=rs2.getString("num_bloc");
				ligne[9]=rs2.getString("nbr_chaise");
				ligne[10]=rs2.getString("nbr_table");
				ligne[11]=rs2.getString("capacite");
				model.addRow(ligne);
			}
			ttable.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 850, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 816, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des evenements");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 6, 781, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 112, 816, 207);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("code :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 20, 79, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 66, 79, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("prenom :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 101, 79, 25);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("email :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 136, 79, 25);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("type :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(244, 20, 79, 25);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("id even:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(244, 66, 79, 25);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("date even :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(244, 101, 79, 25);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("n salle :");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(244, 136, 79, 25);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("n bloc :");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(476, 20, 79, 25);
		panel_1.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("nbr chaise :");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_9.setBounds(476, 66, 79, 25);
		panel_1.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("nbr table :");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_10.setBounds(476, 101, 79, 25);
		panel_1.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("capacite :");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_11.setBounds(476, 136, 79, 25);
		panel_1.add(lblNewLabel_1_11);
		
		tcode_u = new JTextField();
		tcode_u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tcode_u.setBounds(77, 25, 140, 20);
		panel_1.add(tcode_u);
		tcode_u.setColumns(10);
		
		tnom_u = new JTextField();
		tnom_u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnom_u.setColumns(10);
		tnom_u.setBounds(77, 71, 140, 20);
		panel_1.add(tnom_u);
		
		tprenom_u = new JTextField();
		tprenom_u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tprenom_u.setColumns(10);
		tprenom_u.setBounds(77, 106, 140, 20);
		panel_1.add(tprenom_u);
		
		temail_u = new JTextField();
		temail_u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		temail_u.setColumns(10);
		temail_u.setBounds(77, 141, 140, 20);
		panel_1.add(temail_u);
		
		tid_e = new JTextField();
		tid_e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tid_e.setColumns(10);
		tid_e.setBounds(313, 71, 140, 20);
		panel_1.add(tid_e);
		
		tn_salle = new JTextField();
		tn_salle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tn_salle.setColumns(10);
		tn_salle.setBounds(313, 141, 140, 20);
		panel_1.add(tn_salle);
		
		tn_bloc = new JTextField();
		tn_bloc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tn_bloc.setColumns(10);
		tn_bloc.setBounds(550, 25, 140, 20);
		panel_1.add(tn_bloc);
		
		tnbr_chaise = new JTextField();
		tnbr_chaise.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnbr_chaise.setColumns(10);
		tnbr_chaise.setBounds(550, 71, 140, 20);
		panel_1.add(tnbr_chaise);
		
		tnbr_table = new JTextField();
		tnbr_table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnbr_table.setColumns(10);
		tnbr_table.setBounds(550, 106, 140, 20);
		panel_1.add(tnbr_table);
		
		tcapacite = new JTextField();
		tcapacite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tcapacite.setColumns(10);
		tcapacite.setBounds(550, 141, 140, 20);
		panel_1.add(tcapacite);
		
		JComboBox ttype_u = new JComboBox();
		ttype_u.setToolTipText("");
		ttype_u.addItem("etudiant");
		ttype_u.addItem("professeur");
		ttype_u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ttype_u.setBounds(313, 24, 122, 21);
		panel_1.add(ttype_u);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				try {
					pst = con.prepareStatement("insert into utilisateur(code_u,nom_u,prenom_u,email_u,type_u) values (?,?,?,?,?)");
					pst1 = con.prepareStatement("insert into evenement(id_e,date_e) values (?,?)");
					pst2 = con.prepareStatement("insert into salle(num_salle,num_bloc,nbr_chaise,nbr_table,capacite) values (?,?,?,?,?)");
					pst.setString(1,tcode_u.getText());
					pst.setString(2,tnom_u.getText());
					pst.setString(3,tprenom_u.getText());
					pst.setString(4,temail_u.getText());
					pst.setString(5,(String) ttype_u.getSelectedItem());
					pst1.setString(1,tid_e.getText());
					pst1.setString(2,tdate_e.getText());
					pst2.setString(1,tn_salle.getText());
					pst2.setString(2,tn_bloc.getText());
					pst2.setString(3,tnbr_chaise.getText());
					pst2.setString(4,tnbr_table.getText());
					pst2.setString(5,tcapacite.getText());
					pst.executeUpdate();
					pst1.executeUpdate();
					pst2.executeUpdate();
					con.close();
					
					JOptionPane.showMessageDialog(null,"evenement bien ajouter");
					Table();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(707, 46, 85, 21);
		panel_1.add(btnNewButton);
		
		tdate_e = new JTextField();
		tdate_e.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tdate_e.setBounds(323, 106, 130, 19);
		panel_1.add(tdate_e);
		tdate_e.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				String sqll = "DELETE from evenement where id_e =?";
				String sqll1 = "DELETE from utilisateur where code_u =?";
				String sqll2 = "DELETE from salle where num_salle =?";
				try {
					pst3 = con.prepareStatement(sqll);
					pst31 = con.prepareStatement(sqll1);
					pst32 = con.prepareStatement(sqll2);
					pst3.setString(1,tid_e.getText());
					pst31.setString(1,tcode_u.getText());
					pst32.setString(1,tn_salle.getText());
					pst3.executeUpdate();
					pst31.executeUpdate();
					pst32.executeUpdate();
					con.close();
					Table();
					JOptionPane.showMessageDialog(null, "evenement bien supprimer");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(707, 105, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 472, 816, -128);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 329, 812, 157);
		frame.getContentPane().add(scrollPane_1);
		
		ttable = new JTable();
		scrollPane_1.setViewportView(ttable);
		ttable.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
}
