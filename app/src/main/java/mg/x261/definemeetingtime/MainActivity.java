package mg.x261.definemeetingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "YOUR_API_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Data> dataList = new ArrayList<>();
        try {
            TimezoneApi timezoneApi = new TimezoneApi(API_KEY);
            dataList.add(new Data(timezoneApi.getCurrentTime(41.8781, -87.6298), "Chicago (CDT)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(39.7392, -104.9903), "Denver (MDT)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(33.4484, -112.0740), "Phoenix (MST)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(34.0522, -118.2437), "Los Angeles (PDT)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(61.2181, -149.9003), "Anchorage (AKDT)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(21.3069, -157.8583), "Honolulu (HST)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(39.9042, 116.4074), "Beijing (CST)"));
            dataList.add(new Data(timezoneApi.getCurrentTime(-18.8792, 47.5079), "Antananarivo (EAT)"));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        MyAdapter adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}
