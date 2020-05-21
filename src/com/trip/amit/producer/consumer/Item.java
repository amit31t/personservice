package com.trip.amit.producer.consumer;

public class Item 
{
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", id=" + id + "]";
	}
	
	public Item() {
	}	
	public Item(int id) {
		this.id = id;
	}
	public void process(Item item)
	{
		System.out.println("Item processed "+item.toString());
	}
	
	public Item createItem(int id)
	{
		Item item = new Item(id);
		System.out.println("Item added "+item.toString());
		return item;
	}
}
