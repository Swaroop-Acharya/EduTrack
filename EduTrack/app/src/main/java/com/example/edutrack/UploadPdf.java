package com.example.edutrack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadPdf extends AppCompatActivity {
    EditText editText;
    Button btn;

    StorageReference storageReference;
    DatabaseReference databaseReference;
    ActivityResultLauncher<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf);



        editText=findViewById(R.id.select_pdf);
        btn=findViewById(R.id.uploadBtn);


        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("uploadPDF");

        btn.setEnabled(false);




        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPdf();
            }
        });


    }

    private void selectPdf() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),
                12);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            btn.setEnabled(true);

            editText.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") +1));

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadPDFFileFirebase(data.getData());
                }
            });
        }
    }

    private void uploadPDFFileFirebase(Uri data) {

        final ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("File is uploading...");
        progressDialog.show();

        StorageReference reference=storageReference.child("uploadPDF"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri=uriTask.getResult();

                        putPdf putPdf=new putPdf(editText.getText().toString(),uri.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(putPdf);
                        Toast.makeText(UploadPdf.this, "File is uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getBytesTransferred();
                        progressDialog.setMessage("File Uploaded..."+(int)progress+"%");


                    }
                });

    }

    public void retrievePDF(View view) {
        startActivity(new Intent(getApplicationContext(),RetrievePDF.class));
    }
}