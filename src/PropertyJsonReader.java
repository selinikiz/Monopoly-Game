import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class PropertyJsonReader {
    private ArrayList<Square> squares = new ArrayList<>();


    public PropertyJsonReader(){
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray Land = (JSONArray) jsonfile.get("1");
            for(Object i:Land){

                //You can reach items by using statements below:
                int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                String name = (String)((JSONObject)i).get("name");
                int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                squares.add(new Land(id,name,cost));
                //And you can add these items to any data structure (e.g. array, linkedlist etc.

            }
            JSONArray RailRoad = (JSONArray) jsonfile.get("2");
            for(Object i:RailRoad){
                //You can reach items by using statements below:
                int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                String name =(String)((JSONObject)i).get("name");
                int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                squares.add(new Railroad(id,name,cost));
                //And you can add these items to any data structure (e.g. array, linkedlist etc.
            }

            JSONArray Company = (JSONArray) jsonfile.get("3");
            for(Object i:Company){
                //You can reach items by using statements below:
                int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                String name =(String)((JSONObject)i).get("name");
                int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                squares.add(new Company(id,name,cost));
            }

        } catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
    public void addsquares() {
        squares.add(new Go(1));
        squares.add(new CommunityChest(3));
        squares.add(new CommunityChest(18));
        squares.add(new CommunityChest(34));
        squares.add(new Jail(11));
        squares.add(new FreeParking(21));
        squares.add(new GotoJail(31));
        squares.add(new Tax(5));
        squares.add(new Tax(39));
        squares.add(new Chance(8));
        squares.add(new Chance(23));
        squares.add(new Chance(37));

    }

    public ArrayList<Square> getSquares() {
        return squares;
    }
    //You can add function(s) if you want
}

