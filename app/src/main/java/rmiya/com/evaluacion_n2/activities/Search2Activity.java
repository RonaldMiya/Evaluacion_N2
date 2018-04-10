package rmiya.com.evaluacion_n2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rmiya.com.evaluacion_n2.R;
import rmiya.com.evaluacion_n2.adapters.CompanyAdapter;
import rmiya.com.evaluacion_n2.models.Company;
import rmiya.com.evaluacion_n2.repositories.CompanyRepository;

public class Search2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    CompanyAdapter companyAdapter;
    TextView textView;
    Bundle extra;
    String values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        extra = getIntent().getExtras();
        if (extra != null) {
            values = extra.getString("value");
        }
        else {
            Log.d("error", null);
        }

        companyAdapter = new CompanyAdapter();
        companyAdapter.setCompany(listarCompanies(values));
        recyclerView.setAdapter(companyAdapter);

    }


    private List<Company> listarCompanies(String busqueda){
        List<Company> companies = CompanyRepository.getList();
        List<Company> companies2 = new ArrayList<>();

        for ( int i = 0; i < companies.size(); i++ ) {
            if(companies.get(i).getName().contains(busqueda) || companies.get(i).getName().toLowerCase().contains(busqueda)){
                companies2.add(companies.get(i));
            }
        }
        return companies2;
    }

}

// Filtro pagina
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });

//    private void filter(String s) {
//
//        ArrayList<Company> filteredList = new ArrayList<>();
//
//        for (Company item : mExampleList) {
//            if (item.getName().toLowerCase().contains(s.toLowerCase())) {filteredList.add(item);}
//        }
//
//        companyAdapter.filterList(filteredList);
//
//    }
