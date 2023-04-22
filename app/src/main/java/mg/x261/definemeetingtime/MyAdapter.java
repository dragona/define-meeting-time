package mg.x261.definemeetingtime;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Data> dataList;

    public MyAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTextView;
        public TextView locationTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.time_text_view);
            locationTextView = itemView.findViewById(R.id.location_text_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.timeTextView.setText(data.getTime());
        holder.locationTextView.setText(data.getLocation());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}