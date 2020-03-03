package evgenyt.gtacars.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import evgenyt.gtacars.R;
import evgenyt.gtacars.data.AppData;
import evgenyt.gtacars.data.GtaCar;

public class CarListActivity extends AppCompatActivity {

    private static final String EXTRA_CAR_SELECTED = "gtacars.car_selected";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carlist);
        List<GtaCar> carList = AppData.getInstance().getCarList();
        List<String> carNamesList = new ArrayList<>();
        for (GtaCar gtaCar : carList) {
            carNamesList.add(gtaCar.getName());
        }
        final ListAdapter arrayAdapter = new ArrayAdapter<>(this,
                R.layout.list_item, carNamesList);
        ListView carListView = findViewById(R.id.car_list);
        carListView.setAdapter(arrayAdapter);
        carListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                intent.putExtra(EXTRA_CAR_SELECTED,
                        String.valueOf(arrayAdapter.getItem(position)));
                finish();
            }
        });
    }

    static String getSelectedCar(Intent intent) {
        return intent.getStringExtra(EXTRA_CAR_SELECTED);
    }

}
