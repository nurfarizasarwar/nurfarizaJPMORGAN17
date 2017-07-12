
class Trade {
String Entity;
String BuySell;
double AgreedFx;
String Currency;
String InDate;
String StDate;
int Units;
double Price;
double Amount;
String NewStDate;

Trade(String Entity, String BuySell, double AgreedFx, String Currency,
		String InDate, String StDate, int Units, double Price)
{
	this.Entity = Entity;
	this.BuySell = BuySell;
	this.AgreedFx = AgreedFx;
	this.Currency = Currency;
	this.InDate = InDate;
	this.StDate = StDate;
	this.Units = Units;
	this.Price = Price;
	
	
}
public String GetEntity(){ return Entity; }
public String GetBuySell(){ if (BuySell == "B"){return "B-OutGoing";} else; {return "S-InComing";} }
public double GetAgreedFx(){ return AgreedFx; }
public String GetCurrency(){ return Currency; }
public String GetInDate(){ return InDate; }
public String GetStDate(){ return StDate; }
public int GetUnits(){ return Units; }
public double GetPrice(){ return Price; }
public double GetAmount(){ return Amount; }
public String GetNewStDate(){ return NewStDate; }


public void SetAmount(double Amount){ this.Amount = Amount;}
public void SetNewStDate(String NewStDate){ this.NewStDate = NewStDate;}


}
