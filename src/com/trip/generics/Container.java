package com.trip.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Container
{

	public <M> M addAndReturn(M element, Collection<M> col)
	{
		col.add(element);
		return element;
	}
	public void porocessElements(List<?> elements)
	{
		//Object obj = new Object();
		//elements.add(obj);
		for(Object str : elements)
		{
			System.out.print(" "+str);
		}
	}
	
}

interface Product<M>
{
	M next();
}