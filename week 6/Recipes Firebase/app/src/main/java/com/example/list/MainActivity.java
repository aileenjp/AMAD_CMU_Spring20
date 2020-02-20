package com.example.list;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.list.data.AppRepository;
import com.example.list.model.Recipe;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private AppRepository appRepository;
    private RecyclerView recyclerView;
    private FirestoreRecyclerAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get the recycler view
        recyclerView = findViewById(R.id.recyclerView);

        //divider line between rows
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //set a layout manager on the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setuprepo();

        setupadapter();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //create a vertical linear layout to hold edit texts
                LinearLayout layout = new LinearLayout(MainActivity.this); //try getApplicationContext()
                layout.setOrientation(LinearLayout.VERTICAL);

                //create edit texts and add to layout
                final EditText nameEditText = new EditText(MainActivity.this);
                nameEditText.setHint("Recipe name");
                layout.addView(nameEditText);
                final EditText urlEditText = new EditText(MainActivity.this);
                urlEditText.setHint("URL");
                layout.addView(urlEditText);

                //create alert dialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Add Recipe");
                dialog.setView(layout);
                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get entered data
                        String recipeName = nameEditText.getText().toString();
                        String recipeURL = urlEditText.getText().toString();
                        if (recipeName.trim().length() > 0) {
                            //create new recipe item
                            Recipe newRecipe = new Recipe(recipeName, recipeURL);
                            //add to Firebase
                            appRepository.insertRecipe(newRecipe);
                        }
                        Snackbar.make(view, "Item added", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                //sets cancel action
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // cancel
                    }
                });
                //present alert dialog
                dialog.show();
            }
        });
    }

    private void setuprepo() {
        appRepository = new AppRepository();
    }

    private void setupadapter() {
        FirestoreRecyclerOptions<Recipe> options = appRepository.getOptions();
        recipeAdapter = new RecipeAdapter(options, this, appRepository);
        recyclerView.setAdapter(recipeAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipeAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipeAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
