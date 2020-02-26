package evgenyt.gtacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button[] carButtons = {findViewById(R.id.button_car1)};
        for (int idx = 0; idx < carButtons.length; idx++) {
            final int finalIdx = idx;
            carButtons[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carButtonPressed(finalIdx);
                }
            });
        }
    }

    private void carButtonPressed(int buttonIdx) {
        Intent intent = new Intent(this, CarListActivity.class);
        startActivityForResult(intent ,buttonIdx);
    }

}
