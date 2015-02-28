package filetree;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public final class FileTreeTester extends JFrame implements ActionListener{
	JTextField path=new JTextField("フォルダパスを入れてください。");
	FileTree fileTree=new FileTree();

	public FileTreeTester() {
		super("FileTreeTester");
		setSize(400,600);
		setLocationRelativeTo(null);
		path.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent event){
				path.selectAll();
			}
		});
		path.addActionListener(this);
		JButton set=new JButton("Set");
		set.setMargin(new Insets(0, 0, 0, 0));
		set.addActionListener(this);
		JSplitPane pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,path,set);
		pane.setDividerLocation(325);
		pane.setDividerSize(0);
		add(pane,BorderLayout.NORTH);
		add(fileTree);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		fileTree.setTree(path.getText());
	}

	public static void main(String[] args) {
		new FileTreeTester();
	}
}
