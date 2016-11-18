package id.sch.smktelkom_mlg.tugas01.xirpl5023.biodata_siswa;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama ;
    EditText etHobi ;
    Button bOK;
    Spinner spJurusan;
    RadioButton rbLk, rbPr;
    CheckBox cbMensan, cbBDI, cbSpitek;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etHobi = (EditText) findViewById(R.id.editTextHobi);
        bOK = (Button) findViewById(R.id.buttonOK);
        spJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        rbLk = (RadioButton) findViewById(R.id.radioButtonlk);
        rbPr = (RadioButton) findViewById(R.id.radioButtonper);
        cbMensan= (CheckBox) findViewById(R.id.checkBoxMensan);
        cbBDI = (CheckBox) findViewById(R.id.checkBoxBDI);
        cbSpitek = (CheckBox) findViewById(R.id.checkBoxSpitek);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();

            }
        });
    }

    private void doProcess() {
        {
            if (isValid());

            String nama = etNama.getText().toString();
            String hobi = etHobi.getText().toString();
            String hasil= " Organisasi yang diikuti\n";
            String hasil1= "Jenis kelamin ";
            {
                int startlen = hasil.length();
                if (cbMensan.isChecked()) hasil+=cbMensan.getText()+"\n";
                if (cbBDI.isChecked()) hasil+=cbBDI.getText()+"\n";
                if (cbSpitek.isChecked()) hasil+=cbSpitek.getText()+"\n";

                if (hasil.length()==startlen) hasil+="Tidak ada pilihan";
            }
            {
                if (rbLk.isChecked()) hasil1+=rbLk.getText()+"\n";
                if (rbPr.isChecked()) hasil1+=rbPr.getText()+"\n";
            }

            tvHasil.setText(nama+" dengan hobi "+hobi+" dari kelas "+spJurusan.getSelectedItem().toString()+",   "+hasil+hasil1);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String kelas = etHobi.getText().toString();



        if (nama.isEmpty())
        {
            etNama.setError("Nama Belum diisi");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if (kelas.isEmpty())
        {
            etHobi.setError("Hobi belum diisi");
        }
        else
        {
            etHobi.setError(null);
        }

        return false;

    }

}