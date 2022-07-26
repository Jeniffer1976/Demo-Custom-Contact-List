package sg.edu.rp.c346.id21025290.democustomcontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact> alContactList;
    CustomAdapter caContact;
    ImageView iv;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.listViewContacts);
        iv = findViewById(R.id.iv);
        tb = findViewById(R.id.toggleButton);
        alContactList = new ArrayList<>();
        Contact item1 = new Contact("Mary", 65, 1234567, 'F');
        Contact item2 = new Contact("Ken", 65, 7654321, 'M');
        alContactList.add(item1);
        alContactList.add(item2);

        caContact = new CustomAdapter(this, R.layout.row, alContactList);
        lvContact.setAdapter((caContact));

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageUrl = "";
                if (tb.isChecked()) {
                    imageUrl = "https://64.media.tumblr.com/a0426353ff765986c063c98fc3ad7078/4778aa772ec45630-cb/s540x810/b68730b696955d443a863a4d88ef299c413ae9c8.jpg";
                } else {
                    imageUrl = "https://www.sweetestmenu.com/wp-content/uploads/2018/08/oreocheesecake10.jpg";

                }
                Picasso.with(MainActivity.this).load(imageUrl).into(iv);
            }
        });


    }
}