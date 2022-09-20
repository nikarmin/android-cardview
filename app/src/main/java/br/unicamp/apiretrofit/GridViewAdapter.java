package br.unicamp.apiretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.zip.DeflaterInputStream;

public class GridViewAdapter extends BaseAdapter {

    private List<Dog> listaDog;
    Context context;

    public GridViewAdapter(Context context, List<Dog> parametroList){
        this.listaDog = parametroList;
        this.context = context;
    }

    // retorna tamanho da lista
    @Override
    public int getCount() {
        return this.listaDog.size();
    }

    // pegar determinado item, pelo índice 'pos'
    @Override
    public Object getItem(int pos) {
        return this.listaDog.get(pos);
    }

    // retornar id do objeto
    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.layout_gridview, viewGroup, false);

        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvRaca = view.findViewById(R.id.tvRaca);
        ImageView imgDog = view.findViewById(R.id.ivDog);

        final Dog dog = listaDog.get(pos);

        tvNome.setText(dog.getNome());
        tvRaca.setText(dog.getRaca());

        if (dog.getImage() != null && dog.getImage().length() > 0)
            Picasso.get().load(dog.getImage()).into(imgDog);
        else
            Toast.makeText(context, "URL da imagem está vazia!", Toast.LENGTH_LONG).show();

        return null;
    }
}
