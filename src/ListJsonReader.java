import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class ListJsonReader{
    private ArrayList<Chance> chancecards = new ArrayList<>();
    private ArrayList<CommunityChest> communitycards = new ArrayList<>();



    public ListJsonReader(){
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("list.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");
            for(Object i:chanceList){
                String item = ((String)((JSONObject)i).get("item"));
                chancecards.add(new Chance(item));


                 /*
				 And you can add these items to any datastructure (e.g. array, linkedlist, etc.)
				 */

            }
            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");
            for(Object i:communityChestList){

                //You can reach items by using:
                String item = ((String)((JSONObject)i).get("item"));
                communitycards.add(new CommunityChest(item));
                //And you can add these items to any datastructure (e.g. array, linkedlist, etc.)

            }
        }

        catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Chance> getChancecards() {
        return chancecards;
    }

    public ArrayList<CommunityChest> getCommunitycards() {
        return communitycards;
    }
}

