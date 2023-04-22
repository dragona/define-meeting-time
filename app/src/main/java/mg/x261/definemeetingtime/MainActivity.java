package mg.x261.definemeetingtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("8:25 PM", "Chicago (CDT)"));
        dataList.add(new Data("7:25 PM", "Denver (MDT)"));
        dataList.add(new Data("6:25 PM", "Phoenix (MST)"));
        dataList.add(new Data("6:25 PM", "Los Angeles (PDT)"));
        dataList.add(new Data("5:25 PM", "Anchorage (AKDT)"));
        dataList.add(new Data("3:25 PM", "Honolulu (HST)"));

        MyAdapter adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

}