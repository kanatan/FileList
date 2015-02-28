package filetree;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileTree extends JScrollPane{

	public FileTree(){
		JLabel label=new JLabel("パスが設定されていません。");
		label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		setViewportView(label);
	}

	public FileTree(String path) {
		setTree(path);
	}

	public void setTree(String path){
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(path);
		createNodes(top, new File(path));
		setViewportView(new JTree(top));
	}

	private void createNodes(DefaultMutableTreeNode tree, File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory()||(files[i].isFile() && !files[i].getPath().endsWith(".class"))){
					DefaultMutableTreeNode subtree = new DefaultMutableTreeNode(files[i].getName());
					createNodes(subtree, files[i]);
					tree.add(subtree);
				}
			}
		}
	}
}
