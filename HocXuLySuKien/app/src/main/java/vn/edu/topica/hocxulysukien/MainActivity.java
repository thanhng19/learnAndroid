package vn.edu.topica.hocxulysukien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText txa,txtB;
    Button btnTru;
    Button btnchia;
    Button btnnhan;
    Button btnan;
    Button btnclose;
    View.OnClickListener suKienChiaSe=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls(); //dùng để khởi tạo control
        addEvent(); //
    }

    private void addEvent() {
        //bất kì thao tác nào vào màn hình sẽ hiển thị cái này (onclick)
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhepTru();
            }
        });{
        }
        suKienChiaSe=new View.OnClickListener() {
            @Override
            //tự động hứng control khi sử dụng
            public void onClick(View v) {
                if(v.getId()==R.id.btnnhan){
                    xuLyPhepNhan();
                }
                else if(v.getId()==R.id.btnchia){
                    xuLyPhepChia();
                }
            }
        };
        btnnhan.setOnClickListener(suKienChiaSe);
        btnchia.setOnClickListener(suKienChiaSe);
        btnan.setOnLongClickListener(this); //trỏ đến cái sự kiện LongClick
        btnclose.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a=Integer.parseInt(txa.getText().toString()); //lấy giá trị từ id txta
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a/b;
        Toast.makeText(MainActivity.this,""+a+" : "+b+" = "+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepNhan() {
        int a=Integer.parseInt(txa.getText().toString()); //lấy giá trị từ id txta
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a*b;
        Toast.makeText(MainActivity.this,""+a+" x "+b+" = "+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepTru() {
        int a=Integer.parseInt(txa.getText().toString()); //lấy giá trị từ id txta
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a-b;
        Toast.makeText(MainActivity.this,""+a+" - "+b+" = "+c,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txa= (EditText) findViewById(R.id.txta); //tự động lấy control nạp lên bộ nhớ
        txtB= (EditText) findViewById(R.id.txtB);
        btnTru= (Button) findViewById(R.id.btnTru);
        btnnhan= (Button) findViewById(R.id.btnnhan);
        btnchia= (Button) findViewById(R.id.btnchia);
        btnan= (Button) findViewById(R.id.btnan);
        btnclose= (Button) findViewById(R.id.btnclose);
    }

    public void xuLyPhepCong(View view){
        int a=Integer.parseInt(txa.getText().toString()); //lấy giá trị từ id txta
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a+b;
        Toast.makeText(MainActivity.this,""+a+" + "+b+" = "+c,Toast.LENGTH_LONG).show();
    }
        @Override
        public boolean onLongClick(View v){
        if(v.getId() == R.id.btnan) {
            btnan.setVisibility(View.INVISIBLE); //Nhấn lâu sẽ mất
        }
        return false;
    }
    public class MyEvent implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnclose){
                finish();
            }
        }
    }
    public void xuLyDoiManHinhKhac(View v){
        Button btnchange=new Button(MainActivity.this){
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                addControls(); //dùng để khởi tạo control
                addEvent(); //
                return super.performClick();
            }
        };
        btnchange.setText("Quay về đi em");
        btnchange.setWidth(80);
        btnchange.setHeight(50);
        setContentView(btnchange);
    }
}

