package HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(20));
        set.remove(20);
        System.out.println(set);
    }
}

//add(element)
//Element add karta hai. Agar already hai toh add nahi karega.
//contains(element)
//Element hai ya nahi (sabse useful)
//remove(element)
//Element delete karta hai
//size()
//Kitne elements hain
//isEmpty()
//Set khali hai ya nahi
//clear()
//Saara set khali kar deta hai
//iterator()
//Iteration ke liye (advanced)