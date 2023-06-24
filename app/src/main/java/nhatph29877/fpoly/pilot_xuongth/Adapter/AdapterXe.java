package nhatph29877.fpoly.pilot_xuongth.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nhatph29877.fpoly.pilot_xuongth.DAO.DaoCar;
import nhatph29877.fpoly.pilot_xuongth.Model.Car;
import nhatph29877.fpoly.pilot_xuongth.R;


public class AdapterXe extends RecyclerView.Adapter<AdapterXe.ViewHolder> {
    private Context context;
    private ArrayList<Car> listxe;
    private DaoCar daoCar;

    public AdapterXe(Context context, ArrayList<Car> listxe, DaoCar daoCar) {
        this.context = context;
        this.listxe = listxe;
        this.daoCar = daoCar;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_tenxe, item_hangxe, item_namsx, item_giaxe;
        ImageButton item_delete;
        RelativeLayout itemcar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tenxe = itemView.findViewById(R.id.item_tenxe);
            item_hangxe = itemView.findViewById(R.id.item_hangsx);
            item_namsx = itemView.findViewById(R.id.item_namsx);
            item_giaxe = itemView.findViewById(R.id.item_giaban);
            item_delete = itemView.findViewById(R.id.item_delete);
            itemcar = itemView.findViewById(R.id.itemcar);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.item_tenxe.setText(listxe.get(position).getTenxe());
        holder.item_hangxe.setText(listxe.get(position).getHangxe());
        holder.item_namsx.setText(String.valueOf(listxe.get(position).getNamsx()));
        holder.item_giaxe.setText(String.valueOf(listxe.get(position).getGiaxe()));
        holder.item_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = listxe.get(position).getId();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn Có Muốn Xóa Không");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        daoCar = new DaoCar(context);
                        if (daoCar.XoaXe(id) > 0) {
                            Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                             listxe.clear();
                             daoCar = new DaoCar(context);
                             listxe = daoCar.GetDSSCar();
                             notifyDataSetChanged();
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listxe.size();
    }


}
