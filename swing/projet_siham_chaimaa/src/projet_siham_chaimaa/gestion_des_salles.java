package projet_siham_chaimaa;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class gestion_des_salles {
	JFrame frame;
	private final JLabel lblNewLabel = new JLabel("gestion des salles");
	private JTextField lcode_a;
	private JTextField lnom_a;
	private JTextField lemail_a;
	private JTextField lid_e;
	private JTextField ldate_e;
	private JTextField ln_salle;
	private JTable ttable1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_des_salles window = new gestion_des_salles();
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
    PreparedStatement pst33;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet r1;
    ResultSet r2;
    ResultSet r3;
    private JTextField ln_bloc;
    private JTextField ln_chaise;
    private JTextField ln_table;
    private JTextField lcapacite;
	public gestion_des_salles() {
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
			String [] entet = {"code admin","nom admin","email ","id even","date even","n salle"};
			String [] ligne = new String[6];
			
			DefaultTableModel model = new DefaultTableModel(null,entet);
			String sql = "select * from admin";
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
				while(rs.next() && rs1.next() && rs2.next() ) {
					ligne[0]=rs.getString("code_a");
					ligne[1]=rs.getString("nom_a");
					ligne[2]=rs.getString("email_a");
					ligne[3]=rs1.getString("id_e");
					ligne[4]=rs1.getString("date_e");
					ligne[5]=rs2.getString("num_salle");
					model.addRow(ligne);
				}
				ttable1.setModel(model);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 894, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 846, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 91, 846, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("code admin :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 24, 91, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nom admin :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 68, 91, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("email admin :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 113, 91, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("id even :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 142, 91, 24);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("date even :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(20, 176, 91, 24);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_6 = new JLabel("n salle :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(250, 19, 91, 24);
		panel.add(lblNewLabel_1_6);
		
		lcode_a = new JTextField();
		lcode_a.setBounds(103, 29, 123, 19);
		panel.add(lcode_a);
		lcode_a.setColumns(10);
		
		lnom_a = new JTextField();
		lnom_a.setColumns(10);
		lnom_a.setBounds(103, 73, 123, 19);
		panel.add(lnom_a);
		
		lemail_a = new JTextField();
		lemail_a.setColumns(10);
		lemail_a.setBounds(103, 118, 123, 19);
		panel.add(lemail_a);
		
		lid_e = new JTextField();
		lid_e.setColumns(10);
		lid_e.setBounds(103, 147, 123, 19);
		panel.add(lid_e);
		
		ldate_e = new JTextField();
		ldate_e.setColumns(10);
		ldate_e.setBounds(103, 176, 123, 19);
		panel.add(ldate_e);
		
		ln_salle = new JTextField();
		ln_salle.setColumns(10);
		ln_salle.setBounds(325, 29, 123, 19);
		panel.add(ln_salle);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				try {
					pst = con.prepareStatement("insert into admin(code_a,nom_a,email_a) values (?,?,?)");
					pst1 = con.prepareStatement("insert into evenement(id_e,date_e) values (?,?)");
					pst2 = con.prepareStatement("insert into salle(num_salle,num_bloc,nbr_chaise,nbr_table,capacite) values (?,?,?,?,?)");
					pst.setString(1,lcode_a.getText());
					pst.setString(2,lnom_a.getText());
					pst.setString(3,lemail_a.getText());
					pst1.setString(1,lid_e.getText());
					pst1.setString(2,ldate_e.getText());
					pst2.setString(1,ln_salle.getText());
					pst2.setString(2,ln_bloc.getText());
					pst2.setString(3,ln_chaise.getText());
					pst2.setString(4,ln_table.getText());
					pst2.setString(5,lcapacite.getText());
					pst.executeUpdate();
					pst1.executeUpdate();
					pst2.executeUpdate();
					con.close();
					
					JOptionPane.showMessageDialog(null,"reservation bien ajouter");
					Table();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(547, 51, 114, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				String sqll = "DELETE from evenement where id_e =?";
				String sqll2 = "DELETE from salle where num_salle =?";
				try {
					pst33 = con.prepareStatement(sqll);
					pst32 = con.prepareStatement(sqll2);
					pst33.setString(1,lid_e.getText());
					pst32.setString(1,ln_salle.getText());
					pst33.executeUpdate();
					pst32.executeUpdate();
					con.close();
					Table();
					
					JOptionPane.showMessageDialog(null, "reservation bien supprimer");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(547, 136, 114, 39);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("n bloc :");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6_1.setBounds(250, 48, 91, 24);
		panel.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("nbr chaise:");
		lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6_2.setBounds(250, 79, 91, 24);
		panel.add(lblNewLabel_1_6_2);
		
		JLabel lblNewLabel_1_6_3 = new JLabel("nbr table:");
		lblNewLabel_1_6_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6_3.setBounds(250, 113, 91, 24);
		panel.add(lblNewLabel_1_6_3);
		
		JLabel lblNewLabel_1_6_4 = new JLabel("capacite:");
		lblNewLabel_1_6_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6_4.setBounds(250, 151, 91, 24);
		panel.add(lblNewLabel_1_6_4);
		
		ln_bloc = new JTextField();
		ln_bloc.setColumns(10);
		ln_bloc.setBounds(325, 53, 123, 19);
		panel.add(ln_bloc);
		
		ln_chaise = new JTextField();
		ln_chaise.setColumns(10);
		ln_chaise.setBounds(325, 84, 123, 19);
		panel.add(ln_chaise);
		
		ln_table = new JTextField();
		ln_table.setColumns(10);
		ln_table.setBounds(325, 118, 123, 19);
		panel.add(ln_table);
		
		lcapacite = new JTextField();
		lcapacite.setColumns(10);
		lcapacite.setBounds(325, 156, 123, 19);
		panel.add(lcapacite);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 860, 76);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 348, 860, 147);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 840, -114);
		panel_3.add(scrollPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 838, 127);
		panel_3.add(scrollPane_2);
		
		ttable1 = new JTable();
		scrollPane_2.setViewportView(ttable1);
		
		JLabel lblNewLabel_2 = new JLabel("liste des reservations");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(392, 320, 163, 18);
		frame.getContentPane().add(lblNewLabel_2);
	}
}