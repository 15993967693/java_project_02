package package6;
import java.util.Calendar;
public class TestCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.set(2019, 1,14,20,17);			//时间设定为
		long day1=c.getTimeInMillis();
		day1+=1000*60*60;
		c.setTimeInMillis(day1);
		System.out.println(c.get(c.HOUR_OF_DAY));
		c.add(c.DATE, 35);
		System.out.println(c.getTime());
		c.roll(c.DATE, 35);
		System.out.println(c.getTime());
	}

}
