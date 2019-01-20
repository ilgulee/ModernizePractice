package ilgulee.com.modernizepractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutomobileRecyclerAdapter extends RecyclerView.Adapter<AutomobileRecyclerAdapter.AutomobileViewHolder> {
    private List<Automobile> automobiles = new ArrayList<>();

    public void addAutomobile(Automobile automobile) {
        this.automobiles.add(automobile);
        notifyDataSetChanged();
    }

    public void updateData(List<Automobile> automobiles) {
        this.automobiles.addAll(automobiles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AutomobileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new AutomobileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutomobileViewHolder automobileViewHolder, int i) {
        Automobile automobile = automobiles.get(i);
        automobileViewHolder.textMaker.setText(automobile.getMaker());
        automobileViewHolder.textModel.setText(automobile.getModel());
    }

    @Override
    public int getItemCount() {
        return automobiles.size();
    }

    public class AutomobileViewHolder extends RecyclerView.ViewHolder {
        public TextView textMaker;
        public TextView textModel;

        public AutomobileViewHolder(@NonNull View itemView) {
            super(itemView);
            textMaker = itemView.findViewById(R.id.maker_text);
            textModel = itemView.findViewById(R.id.model_text);
        }
    }
}
