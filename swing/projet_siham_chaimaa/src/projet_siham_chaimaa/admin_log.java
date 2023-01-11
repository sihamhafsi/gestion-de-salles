package projet_siham_chaimaa;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import projet_siham_chaimaa.gestion_des_salles;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_log {
	 JFrame frame;
	private JTextField lpass;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_log window = new admin_log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public admin_log() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(35, 24, 637, 50);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("espace direction");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(148, 122, 442, 192);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 40, 101, 13);
		panel_1.add(lblNewLabel_1);
		
		lpass = new JTextField();
		lpass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lpass.setBounds(193, 37, 96, 19);
		panel_1.add(lpass);
		lpass.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=lpass.getText().toString();
				if(password.equals("admin")) {
					JOptionPane.showMessageDialog(null, "CONNEXION REUSSITE");
					frame.setVisible(false);
					gestion_des_salles g=new gestion_des_salles();
					g.main(null);	
				}
				else 
					JOptionPane.showMessageDialog(null, " PASSWORD ERRONE !");	
			}
		});
		btnNewButton.setBounds(175, 117, 101, 38);
		panel_1.add(btnNewButton);
	}
}