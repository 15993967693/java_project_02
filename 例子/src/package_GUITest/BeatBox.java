package package_GUITest;
import java.awt.*;
import javax.swing.*;
import javax.xml.stream.events.StartDocument;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class BeatBox {
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;//把checkBox储存在ArrayList中
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	String[] instrumentsNames= {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal","Hand Clap","High Tom",
			"Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};//乐器名称，以string的array维护
	int[] instruments= {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BeatBox().buildGUi();
	}

	private void buildGUi() {
		// TODO Auto-generated method stub
		theFrame =new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout=new BorderLayout();
		JPanel background=new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkboxList=new ArrayList<JCheckBox>();
		Box buttonBox=new Box(BoxLayout.Y_AXIS);
		JButton start=new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop=new JButton("stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo=new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempListener());
		buttonBox.add(upTempo);
		
		JButton downTempo=new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		Box nameBox=new Box(BoxLayout.Y_AXIS);
		for(int i=0;i<16;i++) {
			nameBox.add(new Label(instrumentsNames[i]));
		}
		
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid =new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel=new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);
		for(int i=0;i<256;i++) {
			JCheckBox c=new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		setUpMidi();
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	}
	private void setUpMidi() {
		// TODO Auto-generated method stub
		try {
			sequencer =MidiSystem.getSequencer();
			sequencer.open();
			sequence=new Sequence(Sequence.PPQ, 4);
			track=sequence.createTrack();
			sequencer.setTempoInBPM(120);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	class MyStartListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			buildTrackAndStart();
		}
		
	}
	class MyStopListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sequencer.stop();
		}
		
	}
	class MyUpTempListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			float tempoFactor=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));
		}
		
	}
	class MyDownTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			float tempFactor=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempFactor*.97));
		}
		
	}
	public void buildTrackAndStart() {
		int[] trackList=null;
		sequence.deleteTrack(track);
		track=sequence.createTrack();
		
		for(int i=0;i<16;i++) {
			trackList=new int[16];
			int key=instruments[i];
			for(int j=0;j<16;j++) {
				JCheckBox jCheckBox=(JCheckBox) checkboxList.get(j+(16*1));
				if(jCheckBox.isSelected()) {
					trackList[j]=key;
					
				}else {
					trackList[j]=0;
				}
			}
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		// TODO Auto-generated method stub
		MidiEvent event=null;
		try {
			ShortMessage aMessage=new ShortMessage();
			aMessage.setMessage(comd,chan,one,two);
			event=new MidiEvent(aMessage, tick);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return event;
	}

	private void makeTracks(int[] List) {
		// TODO Auto-generated method stub
		for(int i=0;i<16;i++) {
			int key=List[i];
			if(key!=0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
	public class MySendListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean[] checkboxState=new boolean[256];
			for(int i=0;i<256;i++) {
				JCheckBox checkBox=(JCheckBox) checkboxList.get(i);//逐个取得状态并加入到数组中
				if(checkBox.isSelected()) {
					checkboxState[i]=true;
				}
				
			}
			try {
				FileOutputStream fileStream =new FileOutputStream(new File("Checkbox.ser"));
				ObjectOutputStream os =new ObjectOutputStream(fileStream);
				os.writeObject(checkboxState);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	public class MyReadInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean[] checkboxState=null;
			try {
				FileInputStream fileInputStream=new FileInputStream(new File("Checkbox.ser"));
				ObjectInputStream is =new ObjectInputStream(fileInputStream);
				checkboxState=(boolean[]) is.readObject();//读取文件中的对象并将读取回来的Object类型转换为boolean数组
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			for(int i=0;i<256;i++) {
				JCheckBox checkBox=(JCheckBox) checkboxList.get(i);
				if(checkboxState[i]) {
					checkBox.setSelected(true);
				}
				else {
					checkBox.setSelected(false);
				}
			}
			sequencer.stop();
			buildTrackAndStart();
		}
		
		
	}

}
