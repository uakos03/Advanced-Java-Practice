import java.util.*;

public class RaktarTeszt {
    public static void main(String[] args) {
        //Listak gyakorlasa
        List<OkosTV> tvLista = new ArrayList<>();
        ellenorzottBeolvasas(tvLista);
        kiIratas(tvLista);
        int tvDB = tvLista.size();
        System.out.println(tvDB);
        OkosTV legdragabb = legdragabbTV(tvLista);
        System.out.println(legdragabb);

        Map<String, OkosTV> raktar = new HashMap<>();
        //HashMap

        




    }
    public static void ellenorzottBeolvasas(List<OkosTV> lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Beolvasó rendszer!");




        while (true) {
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

                lista.add(new OkosTV(gyarto,ar,atlo));

            } catch (Exception e) {
                System.out.println("Hiba: " + e.getMessage());
            }
        }
    }

    public static void kiIratas(List<OkosTV> lista ) {
        for (OkosTV elem : lista) {
            System.out.println(elem);
        }
    }
    public static OkosTV legdragabbTV (List<OkosTV> lista) {
        OkosTV max = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            if (max.getAr() < lista.get(i).getAr()) {
                max = lista.get(i);
            }
        }
            return max;
    }

}
