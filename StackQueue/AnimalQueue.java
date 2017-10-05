package cracking.code.interviewQ.StackQueue;

import java.util.LinkedList;

public class AnimalQueue {
	
	public static void main(String ag[]){
			AnimalQueue aq = new AnimalQueue();
			
			Dog d1 = new Dog("Sam");
			Dog d2 = new Dog("K");
			Dog d3 = new Dog("q");
			Dog d4 = new Dog("i");
			
			Cat c1 = new Cat("c1");
			Cat c2 = new Cat("c2");
			Cat c3 = new Cat("c3");
			Cat c4 = new Cat("c4");
			
			aq.enqueue(d1);
			aq.enqueue(d2);
			aq.enqueue(d3);
			aq.enqueue(d4);
			
			aq.enqueue(c1);
			aq.enqueue(c2);
			aq.enqueue(c3);
			aq.enqueue(c4);
			
			aq.dequeueAny();
			aq.dequeueCat();
			aq.dequeueAny();
			aq.dequeueDog();
	}
	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int order = 0;
	
public void enqueue(Animal a){
		
		order++;
		a.setOrder(order);
		
		if(a instanceof Dog){
			dogs.add((Dog)a);
		}else if(a instanceof Cat){
			cats.add((Cat)a);
		}
	}	
	
public Animal dequeueAny(){
	
	if(dogs.size() == 0){
		return dequeueCat();
	}else if(cats.size() == 0){
		return dequeueDog();
	}
	
	Animal dog = dogs.getLast();
	Animal cat = cats.getLast();
	
	if(dog.isOlderThan(cat)){
		return dequeueDog();
	}else{
		return dequeueCat();
	}
}

	public Animal dequeueCat(){
		return cats.poll();	
	}
	
	public Animal dequeueDog(){
		return dogs.poll();
	}

}
