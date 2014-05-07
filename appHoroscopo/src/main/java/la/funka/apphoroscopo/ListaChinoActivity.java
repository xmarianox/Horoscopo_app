package la.funka.apphoroscopo;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class ListaChinoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chino);

        Resources res = getResources();
        String[] lista_signos_chinos = res.getStringArray(R.array.signos_chinos_list);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista_signos_chinos);
        setListAdapter(adapter);

    }


}
