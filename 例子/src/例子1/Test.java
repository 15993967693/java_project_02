package 例子1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import package_qq.New;

public class Test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Person person=new Person();
//		Person person1=new Person();
//		person.setName("yanghaolin");
//		person.print();
//		person1.setName("mayun");
//		person1.print();
//		person.print();
		//Person.print();
		System.out.println(Nowtime());
	}
	public static Date Nowtime() {
		Date date=new Date();
		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
        String time=temp.format(date); // 输出已经格式化的现在时间（24小时制） 
        Date utilDate=null;
		try {
			utilDate = temp.parse(time);
			Date date2=new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
