package package_List;
import java.util.*;
import java.io.*;

public class Jukebox1 {
	ArrayList<String> songList=new ArrayList<String>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void go() {
		getSongs();
	}
	private void getSongs() {
		// TODO Auto-generated method stub
		try {
			File file =new File("SongList.txt");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null) {
				addSong(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void addSong(String lineToPrase) {
		// TODO Auto-generated method stub
		String[] tokens=lineToPrase.split("/");
		songList.add(tokens[0]);
	}
}
