package SeleniumAutomation;
//package p1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

//import com.google.gson.JsonArray;
 
public class JSONReadExample 
{
    public static void main(String[] args) throws Exception 
    {
    	ParseMyresponse();
    	
    }
    
    public static void ParseMyresponse() throws FileNotFoundException, IOException, ParseException
    {
    	JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader("E:\\Selenium\\docs\\data.json"));
        
    	JSONArray s = (JSONArray) obj.get("items");
    	JSONObject obj1=(JSONObject)s.get(0);
    	System.out.println("id is " +obj1.get("ID"));
   
    	JSONObject obj2=(JSONObject)obj1.get("Content");
    	JSONObject obj3=(JSONObject)obj2.get("Headers");
    	JSONArray s1 = (JSONArray) obj3.get("Subject");
    	System.out.println(" Subject is " +s1.get(0));
    }
}