package com.example.intentovacio.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.intentovacio.Domain.ListDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ManagmentReservas {
    private Context context;
    private String hola= "hola";
    private TinyDB tinyDB;


    public ManagmentReservas(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }

    public void insertFood(ListDomain item) {
        ArrayList<ListDomain> listPop = getListReservas();
        boolean existAlready = false;
        Random n = new Random();

        /*
        for (int i = 0; i < listPop.size(); i++) {
            if (listPop.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        */

        if (existAlready) {
            listPop.get(n.nextInt(4) + 1).setCode(item.getCode());
        } else {
            listPop.add(item);
        }
        tinyDB.putListObject("Reservas", listPop);
        Toast.makeText(context, "Reserva realizada", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ListDomain> getListReservas() {
        return tinyDB.getListObject("Reservas");
    }

    public void minusNumber(ArrayList<ListDomain> listItem, int position, ChangeCodeItemsListener changeCodeItemsListener) {
        if (listItem.get(position).getCode() == 1) {
            listItem.remove(position);
        } else {
            listItem.get(position).setCode(listItem.get(position).getCode() - 1);
        }
        tinyDB.putListObject("Reservas", listItem);
        changeCodeItemsListener.change();
    }
}
