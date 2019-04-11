import java.util.*;

public class MAp {
    public static void main(String args[]){
     Map map =new HashMap();
     map.put("","");
     map.put("a","");
     map.put("aaaa","a");
     removeMapEmptyValue(map);
     System.out.print(map.toString());
    }
    public static Map<String,String> removeMapEmptyValue(Map<String,String> paramMap){
        Set<String> set = paramMap.keySet();
        Iterator<String> it = set.iterator();
        List<String> listKey = new ArrayList<String>();
        while (it.hasNext()) {
 String str = it.next();
 if(paramMap.get(str)==null || "".equals(paramMap.get(str))){
                listKey.add(str) ;
}
        }
for (String key : listKey) {
paramMap.remove(key);
}

return null;
}}
