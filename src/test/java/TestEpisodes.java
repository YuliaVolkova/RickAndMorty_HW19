import Episodes.Episodes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import Episodes.Result;

import rest.ApiRequest;

import java.io.IOException;

public class TestEpisodes {



    @Test
    public void test2() throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        Episodes episodes1 = om.readValue(ApiRequest.getRest("https://rickandmortyapi.com/api/episode"), Episodes.class);
        int i=1;
        do {
            for
            (Result l : episodes1.results) {
                System.out.print(l.name + " = " + l.air_date + "; ");
            }
            System.out.println(" ");


            if (episodes1.info.next != null) {
                episodes1 = om.readValue(ApiRequest.getRest(episodes1.info.next), Episodes.class);
                i++;
            } else{
                break;
            }
        }

        while (true );

    }
}
