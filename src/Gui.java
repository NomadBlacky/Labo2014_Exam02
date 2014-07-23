import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Gui extends JFrame implements ActionListener {
	
	private JTextArea area;
	private JButton button;
	private JButton loadButton;
	
	public Gui() {
		
		this.setLayout(new FlowLayout());
		
		area = new JTextArea(10, 30);
		this.add(area);
		
		button = new JButton();
		button.setText("せーぶ");
		button.addActionListener(this);
		this.add(button);
		
		loadButton = new JButton("ろーど", null);
		loadButton.addActionListener(this);
		this.add(loadButton);
	}

	public static void main(String[] args) {
		
		Gui gui = new Gui();
		gui.setBounds(50, 50, 800, 600);
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == button) {
			try {
				PrintWriter writer = new PrintWriter("./test.txt");
				writer.println(area.getText());
				writer.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == loadButton) {
			Scanner scanner;
			try {
				scanner = new Scanner(new File("./test.txt"));
				StringBuilder sb = new StringBuilder();
				while(scanner.hasNext()) {
					sb.append(scanner.nextLine());
					sb.append('\n');
				}
				area.setText(sb.toString());
				scanner.close();

			} catch (FileNotFoundException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
		
		
	}
}
