package HashMap;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String [] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Dhruv", 10);
        map.put("Tilak", 20);
        map.put("Naman", 30);
        map.put("ritika", 40);

        System.out.println(map);//print entire map
        System.out.println(map.get("Tilak"));//get 1 element


        //check if key exists
        System.out.println(map.containsKey("Naman"));
        System.out.println(map.containsValue("Derek"));

        //if remove a key
        //map.remove("Dhruv");
        System.out.println(map);

        //check size;
        System.out.println(map.size());

        //iterate over hashmap
        for(String key : map.keySet()){
            System.out.println(key + " -> " + map.get(key));

        }
    }
}

//main functions of hashmap are :
//map.put(key,value)
//map.get(key)
//map.containsKey(key)
//map.remove(key)
//map.size(key)
//map.clear()



//containsValue(value) → value exist karta hai ya nahi
//isEmpty() → map khali hai ya nahi
//putIfAbsent(key, value) → agar key nahi hai tabhi put karo (bahut useful)
