  package cracking.code.interviewQ.StackQueue;

abstract class Animal {
	
	String name;
	int order = 0;
	
	public Animal(String nm){
		this.name = nm;	
	}
	
	public void setOrder(int or){
		this.order = or;
	}
	
	public int getOrder(){
		return this.order;
	}	
	
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}	
}
