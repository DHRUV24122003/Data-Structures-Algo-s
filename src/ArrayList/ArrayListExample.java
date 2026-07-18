package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2,4);
        System.out.println(list);
        System.out.println(list.get(1));//to get an element on an index
        System.out.println(list.size());
        System.out.println(list.contains(2));
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.remove(Integer.valueOf(1)));
    }
}



//add(element)
//End me element add karta hai
//add(index, element)
//Kisi specific index pe insert karta hai
//get(index)
//Index pe value laata hai
//set(index, element)
//Index pe value change karta hai
//remove(index)
//Index se element delete
//remove(Object)
//Value se delete (pehle occurrence)
//size()
//Kitne elements hain
//contains(element)
//Element hai ya nahi
//isEmpty()
//List khali hai ya nahi
//clear()
//Saari list khali kar deta hai