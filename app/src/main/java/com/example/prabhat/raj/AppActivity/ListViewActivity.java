package com.example.prabhat.raj.AppActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prabhat.raj.R;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    String selectedSubject;
    String subject[] ;
    String name[] = {"Prabhat Singh","Janmejay Singh","Vishal sharma","Abhishek Singh","nityanand yadav"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        subject=getResources().getStringArray(R.array.subject);
        listView = findViewById(R.id.ls11);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                persistantChoice();
                //Toast.makeText(ListViewActivity.this, "your name is :"+name[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void persistantChoice()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please Select your Subject");
        builder.setSingleChoiceItems(subject, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             selectedSubject = subject[i];
            }
        });
        builder.setPositiveButton("select", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ListViewActivity.this, "  Your subject is :"+selectedSubject, Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}
