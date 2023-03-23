import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static javax.swing.UIManager.getString;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        JSONArray responeJSON = new JSONArray();
        ArrayList<ResponseModel> responseModels = new ArrayList<>();
        for (int i=0; i<responeJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responeJSON.getJSONObject(i);
            resModel.setMsg(myJSONObject.getString("massage"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComment(myJSONObject.getString("comment"));
            responseModels.add(resModel);
        }
        System.out.println("Response are: ");
        for(int index=0; index<responseModels.size();index++){
            System.out.println("MASSAGE : " + responseModels.get(index).getMsg());
            System.out.println("STATUS : " + responseModels.get(index).getStatus());
            System.out.println("COMMENT : " + responseModels.get(index).getComment());

        }
    }
}
