package org.example.zzz.utils;

import java.lang.reflect.InvocationTargetException;

public class StringClassFinder {
    public static void main(String[] args) {
        checkMethod();
    }

    static void checkMethod() {
        Bullet bullt = new Bullet("Royal Enfield", "Bullet 350");
        try {
            @SuppressWarnings("unchecked cast")
            Class<Bullet> bulletClass = (Class<Bullet>) Class.forName("org.example.zzz.utils.Bullet");
            bulletClass.getMethod("showInfo").invoke(bullt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class Bullet {
    String name;
    String company;

    public Bullet(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public void showInfo() {
        System.out.println("Bullt ka Naam hai " + name + ". Aur bullt ki company hai: " + company + ". " +
                "Mainu pata hunda ki iss bullt vich company RE hai. Phir bhi maje len vich likh diya si." +
                "Koi na, Moj karo.");
    }
}


