package package6;
import javax.sound.midi.*;
public class MusicTest {
	public void play() {
		try {
			Sequencer player=MidiSystem.getSequencer();
			player.open();//创建sequencer
			
			Sequence seq=new Sequence(Sequence.PPQ, 4);//创建sequence
			
			Track track=seq.createTrack();//从sequence中创建track
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);
			
			MidiEvent noteOn=new MidiEvent(a, 1);//midiEvent
			
			track.add(noteOn);//将track填入midienent
			
			ShortMessage b =new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteOff=new MidiEvent(b, 16);
			track.add(noteOff);
			
			
			player.setSequence(seq);//将sequence送入sequencer
			player.start();//开始
			//System.out.println("Successfully got a sequencer");
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Bummer");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicTest mt =new MusicTest();
		mt.play();
	}

}
