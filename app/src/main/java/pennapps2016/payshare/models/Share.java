package pennapps2016.payshare.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by David on 1/23/2016.
 */
public class Share implements Serializable {
    public String title, description, o_payer,id="", tag;
    public double price;
    public ArrayList<String> people;
    public Share(){

    }
    public Share(JSONObject object) throws JSONException {
        title = object.getString("title");
        description = object.getString("description");
        o_payer = object.getString("o_payer");
        id = object.getString("_id");
        tag = object.getString("tag");
        price = object.getDouble("price");
        people = new ArrayList<String>(Arrays.asList(object.getString("people").split(",")));
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("title",title);
        object.put("description",description);
        object.put("o_payer",o_payer);
        object.put("tag",tag);
        object.put("price",price);
        object.put("people",android.text.TextUtils.join(",",people));
        if(!id.equals("")){
            object.put("_id",id);
        }
        return object;
    }
}
