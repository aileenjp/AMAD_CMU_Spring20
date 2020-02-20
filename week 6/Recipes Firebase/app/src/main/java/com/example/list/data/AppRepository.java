package com.example.list.data;

import com.example.list.model.Recipe;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class AppRepository {

    // Cloud Firestore instance
    private FirebaseFirestore db;

    //recipe collection
    private CollectionReference reciperef;

    public AppRepository(){
        db = FirebaseFirestore.getInstance();
        reciperef = db.collection("recipes");
    }

    //options to set up the adapter
    public FirestoreRecyclerOptions<Recipe> getOptions(){
        Query myquery = reciperef;
        FirestoreRecyclerOptions<Recipe> options = new FirestoreRecyclerOptions.Builder<Recipe>()
                .setQuery(myquery, Recipe.class)
                .build();
        return options;
    }

    public void insertRecipe(Recipe newRecipe){
        reciperef.add(newRecipe);
    }

    public void deleteRecipe(String id){
        reciperef.document(id).delete();
    }
}
