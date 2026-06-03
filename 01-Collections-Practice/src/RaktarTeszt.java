import java.util.*;

public class RaktarTeszt {
    public static void main(String[] args) {
        //Listak gyakorlasa
        List<OkosTV> tvLista = new ArrayList<>();
        Map<String, OkosTV> raktar = ellenorzottBeolvasas(tvLista);
        kiIratas(tvLista, raktar);
        int tvDB = tvLista.size();
        System.out.println(tvDB);
        OkosTV legdragabb = legdragabbTV(tvLista);
        System.out.println(legdragabb);
        keresesVonalkodAlapjan(raktar);


    }
    public static Map<String, OkosTV> ellenorzottBeolvasas(List<OkosTV> lista) {
        Scanner scanner = new Scanner(System.in);
        Map<String, OkosTV> raktar = new HashMap<>();
        System.out.println("Beolvasó rendszer!");

        while (true) {
            System.out.println("Add meg a TV vonalkódját: (vagy kilépéshez: X)");
            String vonalkod = scanner.nextLine();

            if(vonalkod.equalsIgnoreCase("X")) {
                break;
            }

            System.out.println("Add meg a gyártó nevét: (vagy kilépéshez: X)");
            String gyarto = scanner.nextLine();

            if(gyarto.equalsIgnoreCase("X")) {
                break;
            }

            try {
                int ar;
                do {
                    System.out.println("Add meg az árat: ");
                    ar = Integer.parseInt(scanner.nextLine());
                    if (ar <= 0) {
                        System.out.println("Hiba! Az ár nem lehet 0 vagy negatív!");
                    }
                } while (ar <= 0);

                int atlo;
                do {
                    System.out.println("Add meg a TV képátlóját: ");
                    atlo = Integer.parseInt(scanner.nextLine());
                    if (atlo <= 0) {
                        System.out.println("Hiba! Az átló nem lehet 0 vagy negatív!");
                    }
                } while (atlo <= 0);

                OkosTV ujTV = new OkosTV(gyarto, ar, atlo);
                lista.add(ujTV);
                raktar.put(vonalkod, ujTV);

            } catch (Exception e) {
                System.out.println("Hiba: " + e.getMessage());
            }
        }
        return raktar;
    }

    public static void kiIratas(List<OkosTV> lista, Map<String, OkosTV> raktar) {
        System.out.println("TV lista:");
        for (OkosTV tv : lista) {
            System.out.println(tv);
        }

        System.out.println("Raktár tartalma:");
        System.out.println(raktar);
    }
    public static OkosTV legdragabbTV (List<OkosTV> lista) {
        OkosTV max = lista.get(0);
        for (OkosTV okosTV : lista) {
            if (max.getAr() < okosTV.getAr()) {
                max = okosTV;
            }
        }
            return max;
    }
    public static void keresesVonalkodAlapjan(Map<String, OkosTV> raktar) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Azonnali Kereső Rendszer");
        System.out.println("Add meg a keresett TV vonalkódját: ");
        String keresettVonalkod = scanner.nextLine();

        if (raktar.containsKey(keresettVonalkod)) {

            OkosTV talaltTV = raktar.get(keresettVonalkod);

            System.out.println("Sikeres találat! A termék adatai:");
            System.out.println(talaltTV);

        } else {
            System.out.println("Hiba! Nincs ilyen vonalkódú TV a raktárban.");
        }
    }
}
