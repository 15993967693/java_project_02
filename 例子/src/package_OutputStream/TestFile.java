package package_OutputStream;

import java.io.File;

import javax.naming.directory.DirContext;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("Chapter 7");
		file.mkdir();
		
		if(file.isDirectory()) {
			String[] dirContents=file.list();
			for(int i=0;i<dirContents.length;i++) {
				System.out.println(dirContents[i]);
			}
		}
	}

}
