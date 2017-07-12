import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;



public class MainClass {
	private static Calendar calendar;
	static Date SettlementDate;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		/*Array Sample Data */
		List<Trade> tradelist = new ArrayList<Trade>();		

		tradelist.add(new Trade("FOO","B",0.5,"AED","01/01/2016", "02/01/2016",200,100.25));
		tradelist.add(new Trade("BAR","S",0.2,"AED","05/01/2016", "07/06/2016",450,150.5));
		tradelist.add(new Trade("COO","B",1.5,"SAR","01/01/2017", "11/06/2017",1,10.0));
		tradelist.add(new Trade("COO","B",1.5,"JPY","01/01/2017", "12/06/2017",1,10.0));
		tradelist.add(new Trade("COO","B",1.5,"MYR","01/01/2017", "13/06/2017",1,10.0));
		tradelist.add(new Trade("FOO","S",0.5,"AED","01/01/2017", "09/06/2017",2,11.0));
		tradelist.add(new Trade("BOO","S",2.5,"KRD","01/01/2017", "10/06/2017",3,12.0));
		tradelist.add(new Trade("COO","S",1.5,"SAR","01/01/2017", "11/06/2017",4,13.0));
		tradelist.add(new Trade("COO","S",1.5,"SGD","01/01/2017", "12/06/2017",5,14.0));
		tradelist.add(new Trade("COO","S",1.5,"SAR","01/01/2017", "13/06/2017",6,15.0));

		/* for Loop to calculate USDSetAmount */
for (int i = 0; i < tradelist.size(); i++) {
	tradelist.get(i).SetAmount(tradelist.get(i).GetAgreedFx() * tradelist.get(i).GetUnits()* tradelist.get(i).GetPrice());
	
	String StringStDate = tradelist.get(i).GetStDate();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	calendar = Calendar.getInstance();
    calendar.setTime(sdf.parse(StringStDate));

	int DOW = calendar.get(Calendar.DAY_OF_WEEK);

	
	String Curr = tradelist.get(i).GetCurrency();
	
	
	if (Curr == "AED" || Curr == "SAR") {
		switch (DOW) {
		case 6:
			calendar.add(Calendar.DATE, 2);  // number of days to add Friday
			break;
		case 7:
			calendar.add(Calendar.DATE, 1);  // number of days to add Saturday
			break;
		}}
		else {
			switch (DOW) {
		case 7:
			calendar.add(Calendar.DAY_OF_MONTH, 2);  // number of days to add Saturday
			break;
		case 1:
			calendar.add(Calendar.DAY_OF_MONTH, 1);  // number of days to add Sunday
			break;
			}}
	
	StringStDate = sdf.format(calendar.getTime());  // dt is now the new date 

	int DOW1 = calendar.get(Calendar.DAY_OF_WEEK);
	
	
	tradelist.get(i).SetNewStDate(StringStDate);
	
}

/* Sort based on StatementDate+Output Print*/
tradelist
.sort(Comparator.comparing(Trade::GetNewStDate).thenComparing(Trade::GetBuySell).thenComparing(Trade::GetAmount));
Collections.reverse(tradelist);


System.out.println("\n");
System.out.println("Entity"+"\t"+"Buy/Sell"+"\t"+"AgrFx"+"\t"+"Curr"+"\t"+"IntroDate"+"\t"+"SettleDate"+"\t"+"SettleNewDate"+"\t"+"Units"+"\t"+"Price"+"\t"+"Amnt");

for (int i = 0; i < tradelist.size(); i++) {
	System.out.print(tradelist.get(i).GetEntity()+"\t");
	System.out.print(tradelist.get(i).GetBuySell()+"\t");
	System.out.print(tradelist.get(i).GetAgreedFx()+"\t");
	System.out.print(tradelist.get(i).GetCurrency()+"\t");
	System.out.print(tradelist.get(i).GetInDate()+"\t");
	System.out.print(tradelist.get(i).GetStDate()+"\t");
	System.out.print(tradelist.get(i).GetNewStDate()+"\t");
	System.out.print(tradelist.get(i).GetUnits()+"\t");
	System.out.print(tradelist.get(i).GetPrice()+"\t");
	System.out.println(tradelist.get(i).GetAmount()+"\t");	
}
	}  

}

