package rmiya.com.evaluacion_n2.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

import rmiya.com.evaluacion_n2.R;
import rmiya.com.evaluacion_n2.activities.DescriptionActivity;
import rmiya.com.evaluacion_n2.activities.MainActivity;
import rmiya.com.evaluacion_n2.models.Company;

/**
 * Created by Alumno on 5/04/2018.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<Company> company;
    private View itemView;
    Company emp;
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();


    public void setCompany(List<Company> company){
        this.company = company;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameCompany;
        TextView addresCompany;
        TextView phoneCompany;
        ImageView logoCompany;

        public ViewHolder(View itemView) {
            super(itemView);

            nameCompany = itemView.findViewById(R.id.name_company);
            addresCompany = itemView.findViewById(R.id.addres_company);
            phoneCompany = itemView.findViewById(R.id.phone_company);
            logoCompany = itemView.findViewById(R.id.logo_company);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_company, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Company emp = company.get(position);

        this.emp = emp;

        int resId = holder.itemView.getContext().getResources().getIdentifier(emp.getLogo(), "drawable", holder.itemView.getContext().getPackageName());

        holder.logoCompany.setImageResource(resId);

        holder.logoCompany.setImageResource(resId);
        holder.nameCompany.setText(emp.getName());
        holder.addresCompany.setText(emp.getAddres());
        final String tele = String.valueOf(emp.getPhone());
        holder.phoneCompany.setText(tele);

//        holder.itemView.setOnClickListener(this);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DescriptionActivity.class);
                intent.putExtra("info", emp.getInfo());
                intent.putExtra("link", emp.getUrl());
                intent.putExtra("email", emp.getEmail());
                intent.putExtra("phone", tele);
                intent.putExtra("logo", emp.getLogo());
                intent.putExtra("name", emp.getName());
                intent.putExtra("address", emp.getAddres());
                itemView.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return company.size();
    }


    public void filterList(ArrayList<Company> filteredList) {
        company = filteredList;
        notifyDataSetChanged();
    }


}
