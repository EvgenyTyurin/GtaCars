package evgenyt.lossantoscars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import evgenyt.lossantoscars.R;
import evgenyt.lossantoscars.data.AppData;
import evgenyt.lossantoscars.data.Car;
import evgenyt.lossantoscars.utils.ResourcesLoader;

public class MainActivity extends AppCompatActivity {

    private Button[] carButtons = new Button[2];
    private ImageView[] specImages = new ImageView[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // prepare ui
        specImages[0] = findViewById(R.id.imageCar1);
        specImages[1] = findViewById(R.id.imageCar2);
        carButtons[0] = findViewById(R.id.button_car1);
        carButtons[1] = findViewById(R.id.button_car2);
        for (int idx = 0; idx < carButtons.length; idx++) {
            final int finalIdx = idx;
            carButtons[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carButtonPressed(finalIdx);
                }
            });
        }
        // prepare resources
        ResourcesLoader.getInstance(this);
    }

    private void carButtonPressed(int buttonIdx) {
        Intent intent = new Intent(this, CarListActivity.class);
        startActivityForResult(intent, buttonIdx);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
            return;
        String carName = CarListActivity.getSelectedCar(data);
        carButtons[requestCode].setText(carName);
        Car car = AppData.getInstance().getCarByName(carName);
        Picasso.get().load(car.getStatImage()).into(specImages[requestCode]);
    }

}
