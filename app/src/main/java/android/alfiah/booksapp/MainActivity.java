package android.alfiah.booksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editSearch;
    private Button buttonSearch;
    private RecyclerView recyclerView;
    private ArrayList<ItemData> values;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSearch=findViewById(R.id.edit_query);
        buttonSearch=findViewById(R.id.button_search);
        recyclerView=findViewById(R.id.recycler_view);
        values=new ArrayList<>();
        itemAdapter= new ItemAdapter(this, values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            }
        });
    }

    private void searchBooks(){
       String querystring=editSearch.getText().toString();

       ConnectivityManager connMgr=(ConnectivityManager)
               getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo networkInfo=connMgr.getActiveNetworkInfo();
       if(networkInfo!=null && networkInfo.isConnected() && querystring.length()>0){

       }else{
           Toast.makeText(this,
                   "Please check your Internet connection!", Toast.LENGTH_SHORT).show();
       }

    }
}
