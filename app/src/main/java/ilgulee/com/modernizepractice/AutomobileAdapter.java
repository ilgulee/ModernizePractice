package ilgulee.com.modernizepractice;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutomobileAdapter extends BaseAdapter {
    private List<Automobile> automobiles = new ArrayList<>();

    public void addAutomobile(Automobile automobile) {
        this.automobiles.add(automobile);
        notifyDataSetChanged();
    }

    public void updateData(List<Automobile> automobiles) {
        this.automobiles = automobiles;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.automobiles.size();
    }

    @Override
    public Object getItem(int position) {
        return this.automobiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        final Automobile automobile = (Automobile) getItem(position);
        ((TextView) view.findViewById(android.R.id.text1)).setText(automobile.getMaker() + " " + automobile.getModel());
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                automobiles.remove(position);
                notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }
}
