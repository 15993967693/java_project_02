package package_GUITest;

import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener {

	@Override
	public void controlChange(ShortMessage arg0) {
		// TODO Auto-generated method stub
		System.out.println("la");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMusicPlayer2 miniMusicPlayer2=new MiniMusicPlayer2();
		miniMusicPlayer2.go();
	}
	public void go() {
		try {
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			int[] eventsIWant= {127};
			sequencer.addControllerEventListener(this, eventsIWant);
			
			Sequence seq =new Sequence(Sequence.PPQ, 4);
			Track track=seq.createTrack();
			for(int i=5;i<60;i+=4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(176, 1, 127, 0, 1));
				track.add(makeEvent(128, 1, i, 100, i+2));
			}
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
