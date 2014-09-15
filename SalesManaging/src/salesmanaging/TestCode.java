package salesmanaging;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Timer;

public class TestCode {

	public static void main(String[] args) {
		Date date=new Date(new java.util.Date().getTime());
		Timestamp ts=new Timestamp(date.getTime());
		Time t=new Time(date.getTime());
		System.out.println(date);
	}

}
