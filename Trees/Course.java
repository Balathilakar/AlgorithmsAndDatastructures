package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Course {
	 String name = "";
     Integer value = 0;
      
      
     public Course(String name)
     {
        super();
        this.name = name;
     }
      
     @Override
     public int hashCode()
     {
        final int prime = 31;
        int result = 1;
        result = prime * result + getOuterType().hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
     }
     
     private Course getOuterType() {
    	    return Course.this;
    	}
     
     @Override
     public boolean equals(Object obj)
     {
        if (this == obj)
           return true;
        if (obj == null)
           return false;
        if (getClass() != obj.getClass())
           return false;
        Course other = (Course) obj;
         
        if (name == null)
        {
           if (other.name != null)
              return false;
        }
        else if (!name.equals(other.name))
           return false;
        return true;
     }
  }
   

  class CourseComparator implements Comparator<Course> {

     @Override
     public int compare(Course o1, Course o2)
     {
        // descending order
        return o2.value - o1.value;
     }
      
  }


  public List<String> getRankedCourses(String user) {
      
     List<String> friends = getDirectFriendsForUser(user);
     Set<String> socialNetwork = new HashSet<String>();
      
     for(String friend: friends) {
         
        socialNetwork.add(friend);
        List<String> friendOfFriends = getDirectFriendsForUser(friend);
         
        for(String friendOfFriend : friendOfFriends) {
           if(!friendOfFriend.equals(user)) {
              socialNetwork.add(friendOfFriend);
           }
        }
     }
      
     System.out.println("Social Network: " + socialNetwork.toString());
      
     List<String> userCourses = getAttendedCoursesForUser(user);
     Map<Course, Integer> tree = new HashMap<Course, Integer>();
      
     for(String friend : socialNetwork) {
         
        List<String> courses = getAttendedCoursesForUser(friend);
         
        for(String course : courses) {
           if(!userCourses.contains(course)) {
              Course courseObj = new Course(course);
               
              if(tree.containsKey(courseObj)) {
                 Integer value = tree.get(courseObj);
                 courseObj.value = ++value;
              }
              else {
                 courseObj.value = 1;
              }
              System.out.println("Adding course " + courseObj.name + " with value " + courseObj.value);
              // have to remove otherwise key will not be updated
              tree.remove(courseObj);
              tree.put(courseObj, courseObj.value);
               
           }
            
        }
         
     }
     // sorting
     List<Course> coursesObj = new ArrayList<Course>(tree.keySet()); 
     Collections.sort(coursesObj, new CourseComparator());
      
     // getting only the names of the courses to return
     List<String> courses = new ArrayList<String>();
     for(Course course : coursesObj) {
        courses.add(course.name);
     }
      
     return courses;
  }
}
