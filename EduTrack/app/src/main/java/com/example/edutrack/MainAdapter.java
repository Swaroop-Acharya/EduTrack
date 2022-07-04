package com.example.edutrack;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder,final int position, @NonNull MainModel model) {
        holder.Title.setText(model.getTitle());
        holder.Mark.setText(model.getMark());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final DialogPlus dialogPlus=DialogPlus.newDialog(holder.Title.getContext())
                      .setContentHolder(new ViewHolder(R.layout.update_marks))
                      .setExpanded(true,1400)
                      .create();

                View view =dialogPlus.getHolderView();

                EditText title=view.findViewById(R.id.up_class);
                EditText mark=view.findViewById(R.id.up_mark);

                Button btnUpdate=view.findViewById(R.id.btnUpdate);

                title.setText(model.getTitle());
                mark.setText(model.getMark());
                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map= new HashMap<>();
                        map.put("Title",title.getText().toString());
                        map.put("Mark",mark.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("SaveMarks")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.Title.getContext() , "Data updated successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.Title.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });
        
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.Title.getContext());
                builder.setTitle("Are you sure ?");
                builder.setMessage("Deleted data can't be undo");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("SaveMarks")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.Title.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marks_display_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        Button btnEdit,btnDelete;
        TextView Title,Mark;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Title =(TextView) itemView.findViewById(R.id.Title);
            Mark=(TextView)itemView.findViewById(R.id.Marks);

            btnEdit=(Button)itemView.findViewById(R.id.btnEdit);
            btnDelete=(Button)itemView.findViewById(R.id.btnDelete);


        }
    }
}
