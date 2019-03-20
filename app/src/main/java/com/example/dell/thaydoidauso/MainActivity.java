package com.example.dell.thaydoidauso;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;

import android.content.ContentProviderOperation;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> list;
    private ListView listview;
    private Button updateall;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.txt_yes);
        try {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS}, 1);
            } else {
                addlist();
                ContactAdapter contactAdapter1 = new ContactAdapter(list);
                updateall = findViewById(R.id.updateall_tv);
                listview = findViewById(R.id.listview);
                listview.setAdapter(contactAdapter1);
                setclick();

            }
        } catch (Exception e) {
        }

    }

    public void setclick() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = list.get(position);
                ArrayList<Character> basodau;
                ArrayList<Character> bonsodau;
                ArrayList<Character> baysodau;
                String name = contact.getContactName();
                String phone = contact.getContactPhoneNumber();
                long contactID = contact.getcontactID();
                basodau = new ArrayList<>();
                bonsodau = new ArrayList<>();
                baysodau = new ArrayList<>();
                for (int i = 0; i <= 3; i++) {
                    char so = phone.charAt(i);
                    bonsodau.add(so);
                }
                for (int i = 0; i <= 2; i++) {
                    char so = phone.charAt(i);
                    basodau.add(so);
                }
                for (int i = 0; i <= 6; i++) {
                    char so = phone.charAt(i);
                    baysodau.add(so);
                }
                setupItemUpdate(basodau, bonsodau, phone, name, contactID);

            }
        });
        updateall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = list.size() - 1; i <= 0; i--) {
                    Contact contact = list.get(i);
                    long contactID = contact.getcontactID();
                    String phone = contact.getContactPhoneNumber();
                    String name = contact.getContactName();
                    ArrayList<Character> basodau;
                    ArrayList<Character> bonsodau;
                    ArrayList<Character> baysodau;
                    basodau = new ArrayList<>();
                    bonsodau = new ArrayList<>();
                    baysodau = new ArrayList<>();
                    for (int i1 = 0; i1 <= 3; i1++) {
                        char so = phone.charAt(i1);
                        bonsodau.add(so);
                    }
                    for (int i2 = 0; i2 <= 2; i2++) {
                        char so = phone.charAt(i2);
                        basodau.add(so);
                    }
                    for (int i3 = 0; i3 <= 6; i3++) {
                        char so = phone.charAt(i3);
                        baysodau.add(so);
                    }
                    setupAllUpdate(basodau, bonsodau, phone, contactID);
                }
            }

        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Đã truy cập danh bạ", Toast.LENGTH_SHORT).show();
                    addlist();
                    ContactAdapter contactAdapter = new ContactAdapter(list);
                    listview = findViewById(R.id.listview);
                    updateall = findViewById(R.id.updateall_tv);
                    listview.setAdapter(contactAdapter);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Contact contact = list.get(position);
                            ArrayList<Character> basodau;
                            ArrayList<Character> bonsodau;
                            ArrayList<Character> baysodau;
                            String name = contact.getContactName();
                            String phone = contact.getContactPhoneNumber();
                            long contactID = contact.getcontactID();
                            basodau = new ArrayList<>();
                            bonsodau = new ArrayList<>();
                            baysodau = new ArrayList<>();
                            for (int i = 0; i <= 3; i++) {
                                char so = phone.charAt(i);
                                bonsodau.add(so);
                            }
                            for (int i = 0; i <= 2; i++) {
                                char so = phone.charAt(i);
                                basodau.add(so);
                            }
                            for (int i = 0; i <= 6; i++) {
                                char so = phone.charAt(i);
                                baysodau.add(so);
                            }
                            setupItemUpdate(basodau, bonsodau, phone, name, contactID);

                        }
                    });


                    updateall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            for (int i = list.size() - 1; i <= 0; i--) {
                                Contact contact = list.get(i);

                                final long contactID = contact.getcontactID();
                                String phone = contact.getContactPhoneNumber();
                                ArrayList<Character> basodau;
                                ArrayList<Character> bonsodau;
                                ArrayList<Character> baysodau;
                                basodau = new ArrayList<>();
                                bonsodau = new ArrayList<>();
                                baysodau = new ArrayList<>();
                                for (int i2 = 0; i2 <= 2; i2++) {
                                    char so = phone.charAt(i2);
                                    basodau.add(so);
                                }
                                for (int i1 = 0; i1 <= 3; i1++) {
                                    char so = phone.charAt(i1);
                                    bonsodau.add(so);
                                }
                                for (int i3 = 0; i3 <= 6; i3++) {
                                    char so = phone.charAt(i3);
                                    baysodau.add(so);
                                }
                                setupAllUpdate(basodau, bonsodau, phone, contactID);
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Hãy cho phép truy cập danh bạ", Toast.LENGTH_SHORT).show();
                }
        }
        return;
    }

    public void setupAllUpdate(ArrayList<Character> basodau,
                               ArrayList<Character> bonsodau, String phone, long contactID) {
        String phonenew = "";
        ArrayList<Character> viettel = new ArrayList<Character>();
        viettel.add('0');
        viettel.add('1');
        viettel.add('6');
        ArrayList<Character> VinaMobi = new ArrayList<Character>();
        VinaMobi.add('0');
        VinaMobi.add('1');
        VinaMobi.add('2');
        ArrayList<Character> VietnamMobile1 = new ArrayList<Character>();
        ArrayList<Character> VietnamMobile2 = new ArrayList<Character>();


        if (basodau.equals(VinaMobi)) {
            for (int vn = 0; vn <= 9; vn++) {
                VinaMobi.clear();
                VinaMobi.add('0');
                VinaMobi.add('1');
                VinaMobi.add('2');
                String stringvn = String.valueOf(vn);
                char sothu3 = stringvn.charAt(0);
                VinaMobi.add(sothu3);
                if (bonsodau.equals(VinaMobi)) {
                    if (vn == 0) {
                        phonenew = phone.replace("0120", "070");
                        break;
                    } else if (vn == 1) {
                        phonenew = phone.replace("0121", "079");

                        break;
                    } else if (vn == 2) {
                        phonenew = phone.replace("0122", "077");

                        break;
                    } else if (vn == 3) {
                        phonenew = phone.replace("0123", "083");
                        break;
                    } else if (vn == 4) {
                        phonenew = phone.replace("0124", "084");
                        break;
                    } else if (vn == 5) {
                        phonenew = phone.replace("0125", "085");
                        break;
                    } else if (vn == 6) {
                        phonenew = phone.replace("0126", "076");
                        break;
                    } else if (vn == 7) {
                        phonenew = phone.replace("0127", "081");
                        break;
                    } else if (vn == 8) {
                        phonenew = phone.replace("0128", "078");
                        break;
                    } else if (vn == 9) {
                        phonenew = phone.replace("0129", "082");
                        break;
                    }
                }
                VinaMobi.clear();
            }
        } else if (basodau.equals(viettel)) {
            for (int vt = 2; vt <= 9; vt++) {
                viettel.clear();
                viettel.add('0');
                viettel.add('1');
                viettel.add('6');
                String stringvt = String.valueOf(vt);
                char sothu3 = stringvt.charAt(0);
                viettel.add(sothu3);

                if (bonsodau.equals(viettel)) {
                    if (vt == 2) {
                        phonenew = phone.replace("0162", "032");
                        break;
                    } else if (vt == 3) {
                        phonenew = phone.replace("0163", "033");
                        break;
                    } else if (vt == 4) {
                        phonenew = phone.replace("0164", "034");
                        break;
                    } else if (vt == 5) {
                        phonenew = phone.replace("0165", "035");
                        break;
                    } else if (vt == 6) {
                        phonenew = phone.replace("0166", "036");
                        break;
                    } else if (vt == 7) {
                        phonenew = phone.replace("0167", "037");
                        break;
                    } else if (vt == 8) {
                        phonenew = phone.replace("0168", "038");
                        break;
                    } else if (vt == 9) {
                        phonenew = phone.replace("0169", "039");
                        break;
                    }
                }
                viettel.clear();
            }
        } else {
            phonenew = phone;
        }
        dialogforAllUpdate(phonenew, contactID);


    }

    public void setupItemUpdate(ArrayList<Character> basodau,
                                ArrayList<Character> bonsodau, String phone, String name, long contactID) {
        String phonenew = "";
        String fullnumbe4 = "";
        ArrayList<Character> viettel = new ArrayList<Character>();
        viettel.add('0');
        viettel.add('1');
        viettel.add('6');
        ArrayList<Character> VinaMobi = new ArrayList<Character>();
        VinaMobi.add('0');
        VinaMobi.add('1');
        VinaMobi.add('2');
        ArrayList<Character> VietnamMobile1 = new ArrayList<Character>();
        ArrayList<Character> VietnamMobile2 = new ArrayList<Character>();


        if (basodau.equals(VinaMobi)) {
            for (int vn = 0; vn <= 9; vn++) {
                VinaMobi.clear();
                VinaMobi.add('0');
                VinaMobi.add('1');
                VinaMobi.add('2');
                String stringvn = String.valueOf(vn);
                char sothu3 = stringvn.charAt(0);
                VinaMobi.add(sothu3);
                if (bonsodau.equals(VinaMobi)) {
                    if (vn == 0) {
                        phonenew = phone.replace("0120", "070");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 1) {
                        phonenew = phone.replace("0121", "079");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 2) {
                        phonenew = phone.replace("0122", "077");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 3) {
                        phonenew = phone.replace("0123", "083");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 4) {
                        phonenew = phone.replace("0124", "084");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 5) {
                        phonenew = phone.replace("0125", "085");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 6) {
                        phonenew = phone.replace("0126", "076");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 7) {
                        phonenew = phone.replace("0127", "081");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 8) {
                        phonenew = phone.replace("0128", "078");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vn == 9) {
                        phonenew = phone.replace("0129", "082");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    }
                }
                VinaMobi.clear();
            }
        } else if (basodau.equals(viettel)) {
            for (int vt = 2; vt <= 9; vt++) {
                viettel.clear();
                viettel.add('0');
                viettel.add('1');
                viettel.add('6');
                String stringvt = String.valueOf(vt);
                char sothu3 = stringvt.charAt(0);
                viettel.add(sothu3);

                if (bonsodau.equals(viettel)) {
                    if (vt == 2) {
                        phonenew = phone.replace("0162", "032");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 3) {
                        phonenew = phone.replace("0163", "033");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 4) {
                        phonenew = phone.replace("0164", "034");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 5) {
                        phonenew = phone.replace("0165", "035");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 6) {
                        phonenew = phone.replace("0166", "036");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 7) {
                        phonenew = phone.replace("0167", "037");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 8) {
                        phonenew = phone.replace("0168", "038");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    } else if (vt == 9) {
                        phonenew = phone.replace("0169", "039");
                        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
                        break;
                    }
                }
                viettel.clear();
            }
        } else {
            phonenew = phone;
            fullnumbe4 = phone;


        }
        themdaucham(phonenew, fullnumbe4, contactID, name, phone);
    }


    private ArrayList<Contact> addlist() {
        String contactName = "";
        String contactPhone = "";
        list = new ArrayList<>();
        Uri contacts = ContactsContract.Contacts.CONTENT_URI;
        Uri Dataa = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor contactRaw = getContentResolver().query(contacts, new String[]{ContactsContract.Contacts._ID}, null, null, "display_name");
        assert contactRaw != null;
        if (contactRaw.moveToFirst()) {
            do {
                long contactID = contactRaw.getLong(contactRaw.getColumnIndex(ContactsContract.Contacts._ID));
                Cursor displaynameContacts = getContentResolver().query(contacts, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, ContactsContract.Contacts._ID + "=" + contactID, null, null);
                Cursor displayPhoneContacts = getContentResolver().query(Dataa, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID, null, null);
                assert displaynameContacts != null;
                if (displaynameContacts.moveToFirst()) {
                    contactName = displaynameContacts.getString(displaynameContacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                }
                assert displayPhoneContacts != null;
                if (displayPhoneContacts.moveToFirst()) {
                    contactPhone = displayPhoneContacts.getString(displayPhoneContacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                try {
                    contactPhone = contactPhone.replace(" ", "");
                    contactPhone = contactPhone.replace("+84", "0");
                    char s = contactPhone.charAt(10);
                    list.add(new Contact(contactName, contactPhone, contactID));
                    list.size();
                } catch (Exception e) {

                }
                displaynameContacts.close();
                displayPhoneContacts.close();
            } while (contactRaw.moveToNext());
            contactRaw.close();
        }
        return list;
    }


    public void Update(long contactID, String phonenew) {
        ArrayList<ContentProviderOperation> operations = new ArrayList<>();

        ContentProviderOperation.Builder builder = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
        builder.withSelection(ContactsContract.Data.CONTACT_ID + "=?" + " AND " + ContactsContract.Data.MIMETYPE + "=?" + " AND " + ContactsContract.CommonDataKinds.Organization.TYPE + "=?", new String[]{String.valueOf(contactID), ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE, String.valueOf(ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)});
        builder.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phonenew);
        operations.add(builder.build());
        try {
            this.getContentResolver().applyBatch(ContactsContract.AUTHORITY, operations);
        } catch (Exception e) {

        }

    }

    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void dialog(final long contactID, final String phonenew, String phone, String name, String fullnumbe4) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.getWindow().setContentView(R.layout.custom_dialog);
        TextView nameofnumber = dialog.findViewById(R.id.contactName);
        TextView socu = dialog.findViewById(R.id.contactNumberOld);
        TextView somoi = dialog.findViewById(R.id.contactNumberNew);
        Button cancel = dialog.findViewById(R.id.btn_no);
        Button ok = dialog.findViewById(R.id.btn_yes);
        nameofnumber.setText("(" + name + ")");
        socu.setText(phone);
        somoi.setText(fullnumbe4);
        dialog.show();

        dialog.setCanceledOnTouchOutside(false);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Update(contactID, phonenew);
                    dialog.dismiss();
                    addlist();
                    ContactAdapter adapter = new ContactAdapter(list);
                    listview.setAdapter(adapter);
                } catch (Exception e) {

                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


    public void dialogforAllUpdate(final String phonenew, final long contactID) {
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setMessage(R.string.dialogalltitle);
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Update(contactID, phonenew);
                    addlist();
                    ContactAdapter adapter = new ContactAdapter(list);
                    listview.setAdapter(adapter);
                } catch (Exception e) {

                }

            }
        });
        builder.show();

    }

    public void themdaucham(String phonenew, String fullnumbe4, long contactID, String name, String phone) {
        ArrayList<String> fullnumber;
        ArrayList<Character> startOfNumberphone;
        ArrayList<Character> midOfNumberphone;
        ArrayList<Character> endOfNumberphone;
        startOfNumberphone = new ArrayList<>();
        midOfNumberphone = new ArrayList<>();
        endOfNumberphone = new ArrayList<>();
        fullnumber = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            char chars = phonenew.charAt(i);
            startOfNumberphone.add(chars);
        }

        for (int i = 0; i <= 5; i++) {
            char chars = phonenew.charAt(i);
            midOfNumberphone.add(chars);
        }
        midOfNumberphone.remove(2);
        midOfNumberphone.remove(1);
        midOfNumberphone.remove(0);

        for (int i = 0; i <= 9; i++) {
            char chars = phonenew.charAt(i);
            endOfNumberphone.add(chars);
        }
        endOfNumberphone.remove(5);
        endOfNumberphone.remove(4);
        endOfNumberphone.remove(3);
        endOfNumberphone.remove(2);
        endOfNumberphone.remove(1);
        endOfNumberphone.remove(0);

        startOfNumberphone.add('.');
        midOfNumberphone.add('.');
        String startofnumber = startOfNumberphone.toString();
        String endofnumber = endOfNumberphone.toString();
        String midofnumber = midOfNumberphone.toString();

        fullnumber.add(startofnumber);
        fullnumber.add(midofnumber);
        fullnumber.add(endofnumber);
        String fullnumbe = fullnumber.toString();
        String fullnumbe1 = fullnumbe.replace(" ", "");
        String fullnumbe2 = fullnumbe1.replace(",", "");
        String fullnumbe3 = fullnumbe2.replace("[", "");
        fullnumbe4 = fullnumbe3.replace("]", "");
        dialog(contactID, phonenew, phone, name, fullnumbe4);
    }

    class ContactAdapter extends BaseAdapter {
        ArrayList<Contact> list;

        public ContactAdapter(ArrayList<Contact> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView contactName, contactPhone, contactChudautine;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.custom_listview, parent, false);
            }
            Contact contact;
            contact = (Contact) getItem(position);
            contactName = convertView.findViewById(R.id.contactName);
            contactPhone = convertView.findViewById(R.id.contactPhone);
            contactChudautine = convertView.findViewById(R.id.chudautien);
            String contactName1 = contact.getContactName();
            char a = contactName1.charAt(0);
            contactName.setText(contact.getContactName());
            contactPhone.setText(contact.getContactPhoneNumber());
            contactChudautine.setText("" + a);
            if (a == '9') {
            } else {
                Drawable view = getDrawable(R
                        .drawable.solidtv);
                contactChudautine.setBackground(view);

            }
            return convertView;
        }
    }


}
