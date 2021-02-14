package AsstAPI;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

public class CryptoPrice {

    public static void findPriceOfBitcoin() {

        String baseURl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=USD";
        URL url;
        String key = "1c51e09a6dmshbf06f77f423fa6ap14adfdjsne9e38d557ee6";

        try {
            //URL connection
            url = new URL(baseURl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            //Test URL connection
            int status = con.getResponseCode();
            if (status != 200) {
                System.out.printf("Error: Could not load");
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream())));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                //Close connection
                in.close();
                con.disconnect();

                System.out.println("Output" + content.toString());

                //Parse JSON 
                JSONObject obj = new JSONObject(content.toString());
                String bitcoinPrice = obj.getString("bitcoin");
                System.out.println("Bitcoin price" + bitcoinPrice);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

