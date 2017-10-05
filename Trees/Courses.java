package algorithm.binaryTree;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Courses {
		String name = "";
		int value =0;
		
		public Courses(String name){
			this.name = name;
		}
		
		@Override
		public int hashCode(){
			final int prime = 31;
			int result = 1;
			//result = prime*result + Courses.this.hashCode();
			result = prime*result + ((name==null)?0:name.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj){
			if(this == obj){
				return true;
			}
			if(this == null){
				return false;
			}
			if(getClass() != obj.getClass()){
				return false;
			}
			Courses other = (Courses)obj;
			
			if(name == null){
				if(other.name != null)
					return false;
				}else if(!name.equals(other.name))
				return false;
			
			return true;
	}
	
	public static void main(String asg[]){
		Map<Courses,Integer> tree = new HashMap<Courses,Integer>();
		
		Courses c1 = new Courses("Eng");
		System.out.println(c1.toString());
		Courses c2 = new Courses("math");
		System.out.println(c1.hashCode());
		Courses c3 = new Courses("Eng");
		System.out.println(c1.hashCode());
		Courses c4 = new Courses("Eng");
		System.out.println(c1.hashCode());
		Courses c5 = new Courses("math");
		System.out.println(c1.hashCode());
		Courses c6 = new Courses("tami");
		System.out.println(c1.hashCode());
		Courses c7 = new Courses("tami");
		
		List<Courses> ls = new ArrayList<Courses>();
		ls.add(c1);
		System.out.println("ArrayList"+ls.hashCode());
		ls.add(c2);
		System.out.println("ArrayList"+ls.hashCode());
		ls.add(c3);
		System.out.println("ArrayList"+ls.hashCode());
		ls.add(c4);
		System.out.println("ArrayList"+ls);
		ls.add(c5);
		System.out.println("ArrayList"+ls);
		ls.add(c6);
		System.out.println("ArrayList"+ls);
		ls.add(c7);
		System.out.println("ArrayList"+ls);
		
		for(Courses cs : ls){
		if(tree.containsKey(cs)){
			tree.put(cs, tree.get(cs)+1);
		}else{
			tree.put(cs, 1);
		}
		
		System.out.println("");
		
		}	
	}
}
