import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static void main(String[] args) {
		MainFrame frame = new MainFrame("33");
		frame.setVisible(true);
	}
	public MainFrame(String pp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Main.png")).getImage();
		lblNewLabel.setBounds(124, 66, 200, 80);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rock");
		lblNewLabel_1.setBounds(136, 181, 72, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Paper");
		lblNewLabel_2.setBounds(136, 222, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Scisssors");
		lblNewLabel_3.setBounds(136, 254, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("");
		textField.setBounds(246, 186, 67, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("");
		textField_1.setBounds(246, 219, 67, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setText("");
		textField_2.setBounds(246, 251, 67, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  setVisible(false);
		          String rockValue = textField.getText();
		          String paperValue = textField_1.getText();
		          String scissorsValue = textField_2.getText();
		          int rockNumber = Integer.parseInt(rockValue);
		          int paperNumber = Integer.parseInt(paperValue);
		          int scissorsNumber = Integer.parseInt(scissorsValue);
		          GameFrame anotherClass = new GameFrame(rockNumber,paperNumber,scissorsNumber);
		          anotherClass.display();
		          
		        }
		      });
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(186, 309, 89, 23);
		contentPane.add(btnNewButton);	
	}
	
}
