package la.funka.apphoroscopo;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;


public class ListaZodiacoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_zodiaco);

        Resources res = getResources();
        String[] signos_zodiaco_list = res.getStringArray(R.array.signos_zodiaco_list);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, signos_zodiaco_list);
        setListAdapter(adapter);

    }

}
