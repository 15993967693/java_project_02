package package_GUITest;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.sound.midi.spi.*;
import java.io.*;
import javax.swing.*;



import java.awt.*;

public class MiniMusicPlayer3 {
	static JFrame f =new JFrame("My first Music Video");
	static MyDrawerPanel m1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMusicPlayer3 miniMusicPlayer3=new MiniMusicPlayer3();
		miniMusicPlayer3.go();
	}

	private void go() {
		// TODO Auto-generated method stub
		setUpGui();
		try {
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(m1, new int[] {127});
			Sequence seq=new Sequence(Sequence.PPQ,4);
			Track track=seq.createTrack();
			int r=0;
			for(int i=0;i<60;i+=4) {
				r=(int)((Math.random()*50)+1);
				track.add(makeEvent(144, 1, r, 100, r));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i+2));
				sequencer.setSequence(seq);
				sequencer.setTempoInBPM(120);
				sequencer.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void setUpGui() {
		// TODO Auto-generated method stub
		m1=new MyDrawerPanel();
		f.setContentPane(m1);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}
	class MyDrawerPanel extends JPanel implements ControllerEventListener{
		boolean msg=false;
		@Override
		public void controlChange(ShortMessage event) {
			// TODO Auto-generated method stub
			msg=true;
			repaint();
		}
		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D graphics2d=(Graphics2D) g;
				int r=(int)(Math.random()*250);
				int gr=(int)(Math.random()*250);
				int b=(int)(Math.random()*250);
				g.setColor(new Color(r, gr, b));
				int ht=(int)((Math.random()*120)+10);
				int width=(int)((Math.random()*120)+10);
				int x=(int)((Math.random()*40)+10);
				int y=(int)((Math.random()*40)+10);
				g.fillRect(x, y, ht, width);
				msg=false;
			}
		}
		
	}
	public static MidiEvent makeEvent(int comd ,int chan, int one, int two, int tick) {
		// TODO Auto-generated method stub
		MidiEvent event=null;
		try {
			ShortMessage a =new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event=new MidiEvent(a, tick);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return event;
	}
}
