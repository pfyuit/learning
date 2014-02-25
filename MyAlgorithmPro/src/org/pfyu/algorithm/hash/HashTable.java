package org.pfyu.algorithm.hash;

public class HashTable {
	
	public DataItem[] dataArray;
	public int maxSize;
	public DataItem noItem = new DataItem(-1, null);
	
	public HashTable(int maxSize){
		this.maxSize = maxSize;
		dataArray = new DataItem[this.maxSize];
	}
	
	public int hashFunc(int key){
		return key % maxSize;
	}
	
	public int hashFunc1(int key){
		return 5- key % 5;
	}
	
	
	public void insert(DataItem data){
		int key = data.key;
		int hashValue = hashFunc(key);
		while(dataArray[hashValue] != null && dataArray[hashValue].key != -1){
			hashValue += hashFunc1(key);
			hashValue %= maxSize;
		}
		dataArray[hashValue] = data;
	}
	
	public DataItem remove(int key){
		int hashValue = hashFunc(key);
		while(dataArray[hashValue] != null){
			if(dataArray[hashValue].key == key){
				DataItem temp = dataArray[hashValue];
				dataArray[hashValue] = noItem;
				return temp;
			}
			
			hashValue += hashFunc1(key);
			hashValue %= maxSize;
		}
		return null;
	}
	
	public DataItem find(int key){
		int hashValue = hashFunc(key);
		while(dataArray[hashValue] != null){
			if(dataArray[hashValue].key == key){
				return dataArray[hashValue];
			}
			
			hashValue += hashFunc1(key);
			hashValue %= maxSize;
		}
		return null;
	}
	
	public void display(){
		for(int i = 0; i< dataArray.length ; i++){
			if(dataArray[i] != null && dataArray[i].key != -1){
				System.out.println(dataArray[i].key + ":"+dataArray[i].data);
			} else {
				System.out.println("*");
			}
		}
	}


	public static void main(String[] args) {
		HashTable table = new HashTable(500);
		
		//insert
		table.insert(new DataItem(2,"hello"));
		table.insert(new DataItem(3,"hello"));
		table.insert(new DataItem(5,"hello"));
		table.insert(new DataItem(67,"hello"));
		table.insert(new DataItem(34,"hello"));
		table.insert(new DataItem(22,"hello"));
		table.insert(new DataItem(70,"hello"));
		
		//find
		System.out.println(table.find(34).key+":"+table.find(34).data);
		
		//delete
		DataItem item = table.remove(34);
		System.out.println(item.key+":"+item.data);
		
		//display
		table.display();
	}

}


class DataItem {
	public int key;
	public String data;
	
	public DataItem(int key, String data){
		this.key = key;
		this.data = data;
	}
}
