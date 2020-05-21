package com.trip.generics;

public class TestGenerics {

	public static void main(String[] args)
	{
/*		Container c = new Container();
		List<Object> elements = new ArrayList<>();
		elements.add("annn"); elements.add(900.90);
		c.porocessElements(elements);*/
		
		Glass<Juice> liquid = new Glass<Juice>(); //Juice -> Liquid, but in generic Juice is not subtype of Liquid
		Glass<Water> liq1 =  new Glass<Water>();
		Glass<Wine> wineGlass = new WineGlass<Wine>();
		
		Glass<Liquid> liquid1 = new Glass<Liquid>(); 
		
		Tray tray = new Tray();
		tray.add(new Glass<String>());
		
		Glass<OrangeJuice>  og = new Glass<OrangeJuice>();
		tray.remove(og);
		
		tray.replace(liquid1);
	}

}

