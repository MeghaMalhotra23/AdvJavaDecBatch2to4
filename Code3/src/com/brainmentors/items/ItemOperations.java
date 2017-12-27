package com.brainmentors.items;

import java.util.ArrayList;
import java.util.Collections;

public class ItemOperations {
	private ItemOperations(){}
	private ArrayList<Item> itemList = new ArrayList<>();
	private static ItemOperations itemOperations =null;
	public String addItem(Item item){
		this.itemList.add(item);
		return "Item Added...";
	}
	
	public void sort(){
		Collections.sort(itemList, new SortByName());
	}
	
	public boolean remove(int id, String name){
		int index = this.searchItem(id, name);
		if(index>=0){
			
			itemList.remove(index);
			return true;
		}
		return false;
	}
	
	public int searchItem(int id, String name){
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		return itemList.indexOf(item);
		//return itemList.contains(item);
	}
	public ArrayList<Item> getItems(){
		return itemList;
	}
	
	public  static ItemOperations getInstance(){
		synchronized(ItemOperations.class){
		if(itemOperations==null){
			itemOperations = new ItemOperations();
		}
		}
		return itemOperations;
	}

}
