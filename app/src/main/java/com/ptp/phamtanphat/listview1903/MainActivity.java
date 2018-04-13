package com.ptp.phamtanphat.listview1903;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mangten;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        mangten = new ArrayList<>();
        mangten.add("Nguyen Van A");
        mangten.add("Nguyen Van B");
        mangten.add("Nguyen Van C");
        mangten.add("Nguyen Van D");
        mangten.add("Nguyen Van E");
        //Tham so 1 : Du lieu duoi dang man hinh`
        //Tham so 2 : Du lieu duoi dang layout(So do ve chi tiet ben trong ban ve)
        //Tham so 3 : Du lieu de xay dung
        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangten);
        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, mangten.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                Toast.makeText(MainActivity.this, mangten.remove(position), Toast.LENGTH_SHORT).show();
                //Cap nhat lai du lieu khi co thay doi
                //Chi su dung cho viec them xoa sua du trong mang con thay doi sang 1 gia tri khac
                // thi khong the thuc hien notifyDataSetChanged
//                arrayAdapter.notifyDataSetChanged();
                //Hop thoai thong bao : AlertDialog
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setMessage("Ban co muon xoa du lieu " + mangten.get(position));
                alertdialog.setTitle("Xac nhan ben duoi");
                //Drawable resource : android.R.drawable
                //Drawable : R.drawable
                alertdialog.setIcon(android.R.drawable.stat_sys_warning);
                alertdialog.setCancelable(false);
                //Nut co
                alertdialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mangten.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                //Nut khong
                alertdialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertdialog.setNeutralButton("Huy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Xoa tat ca du lieu trong hop thoai
                        dialog.dismiss();
                        //Tat view cua hop thoai nhung van con hoat dong
                        dialog.cancel();
                    }
                });
                alertdialog.show();
                return true;
            }
        });
        Yeu cau :
            View : 1 edittext nhan du lieu nguoi dung truyen vao
                   1 button xac nhan them du lieu
                   1 button cap nhat du lieu
            Code :
                1 - Click button them du lieu nguoi dung tu edittext
                2 - Su kien click button cap nhat
                    * Long click vao item trong list view do du lieu len edittext
                    * Click vao button cap nhat sau khi da chinh sua xong du lieu
    }

}
