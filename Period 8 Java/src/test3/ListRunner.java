package test3;

import java.util.ArrayList;

public class ListRunner {

	static ArrayList<Item> shoppingList;
	
	public static void main(String[] args){
		String[] justDescriptions=getDescriptions();
		initList(justDescriptions);
		doSomeShopping();
		printPirchasedItems();
	}

	private static void printPirchasedItems() {
		for(int i=0;i<shoppingList.size();i++){
			if(shoppingList.get(i).getPurchased()){
				System.out.println(shoppingList.get(i).getDescription());//1pt
				shoppingList.remove(shoppingList.get(i)); //1pt
				i--;//1pt
			}
		}
	}

	private static void doSomeShopping() {
		shoppingList.get(0).setPurchased(true);
		shoppingList.get(1).setPurchased(true);
	}

	private static void initList(String[] justDescriptions) {
		shoppingList=new ArrayList<Item>(); // 1pt
		for(String s:justDescriptions){//0.5 pt
			shoppingList.add(new Item(s)); //0.5 pt adding, 1pt creating item
		}
	}

	private static String[] getDescriptions() {
		String[] test = {"coffee","life","video games","potato chips"};
		return test;
	}

}
