package sg.edu.rp.c346.id20042321.dynamiclistviewcolorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd, btnDelete, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        etElement = findViewById (R.id.editTextColor);
        btnAdd = findViewById (R.id.buttonAddItem);
        lvColour = findViewById (R.id.listViewColor);
        etIndexElement = findViewById (R.id.editTextIndex);
        btnDelete = findViewById (R.id.buttonRemoveItem);
        btnUpdate = findViewById (R.id.buttonUpdateItem);



        aaColours = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter (aaColours);

        btnAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String newItem = etElement.getText().toString ();
                int pos = Integer.parseInt (etIndexElement.getText().toString ());
                alColours.add(pos, newItem);
                aaColours.notifyDataSetChanged ();
            }
        });

        btnDelete.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt (etIndexElement.getText ().toString ());
                alColours.remove (pos);
                aaColours.notifyDataSetChanged ();
                }
        });

        btnUpdate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt (etIndexElement.getText ().toString ());
                String updateItem = etElement.getText ().toString ();
                alColours.set(pos, updateItem);
                aaColours.notifyDataSetChanged ();
            }
        });

    }
}