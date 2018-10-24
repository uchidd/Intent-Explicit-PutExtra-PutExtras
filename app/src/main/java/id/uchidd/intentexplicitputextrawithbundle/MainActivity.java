package id.uchidd.intentexplicitputextrawithbundle;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    //TODO 1: Deklarasi
    CoordinatorLayout clMain;
    EditText txtNama, txtNIS, txtAsalSekolah, txtAlamat;
    RadioButton rb_laki, rb_perempuan;
    CheckBox cbHoby1, cbHoby2, cbHoby3;
    Button btnKirimData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 2: Inisialisasi
        clMain = (CoordinatorLayout)findViewById(R.id.clMain);
        txtNama = (EditText)findViewById(R.id.txtNama);
        txtNIS = (EditText)findViewById(R.id.txtNIS);
        txtAsalSekolah = (EditText)findViewById(R.id.txtAsalSekolah);
        txtAlamat = (EditText)findViewById(R.id.txtAlamat);
        rb_laki = (RadioButton)findViewById(R.id.rb_laki);
        rb_perempuan = (RadioButton)findViewById(R.id.rb_perempuan);
        cbHoby1 = (CheckBox)findViewById(R.id.cbHoby1);
        cbHoby2 = (CheckBox)findViewById(R.id.cbHoby2);
        cbHoby3 = (CheckBox)findViewById(R.id.cbHoby3);
        btnKirimData = (Button)findViewById(R.id.btnKirimData);

        //TODO 3: Action/Event
        btnKirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 5: Panggil Method ValidatorEditText
                validasiEditText();
            }
        });
    }

    //TODO 4: Membuat Proses Validasi Untuk EditText
    public void validasiEditText(){
        if(txtNama.getText().toString().length()==0){
            txtNama.setError("Isi Nama Lengkap Dulu Bro!!");
            txtNama.requestFocus();
        }else if(txtNIS.getText().toString().length()==0){
            txtNIS.setError("Isi NIS Dulu Bro!!");
            txtNIS.requestFocus();
        }else if(txtAsalSekolah.getText().toString().length()==0){
            txtAsalSekolah.setError("Isi Asal Sekolah Dulu Bro!!");
            txtAsalSekolah.requestFocus();
        }else if(txtAlamat.getText().toString().length()==0){
            txtAlamat.setError("Isi Alamat Dulu Bro!!");
            txtAlamat.requestFocus();
        }else {
            AlertDialog.Builder dialogBuilder;
            dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Inputan")
                    .setMessage("Nama Lengkap: " + txtNama.getText().toString()
                            + "\nNIS: " + txtNIS.getText().toString()
                            + "\nAsal Sekolah: " + txtAsalSekolah.getText().toString()
                            + "\nAlamat: " + txtAlamat.getText().toString())
                    .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = dialogBuilder.create();
            dialog.show();
        }
    }
}