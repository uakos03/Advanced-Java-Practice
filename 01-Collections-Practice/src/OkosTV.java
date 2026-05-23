public class OkosTV extends Keszulek {
        private int kepatlo;

        public OkosTV(String gyarto, int ar, int kepatlo) {
            super(gyarto,ar);
            this.kepatlo = kepatlo;
        }

    public int getKepatlo() {
        return kepatlo;
    }

    @Override
        public String toString() {
            return super.toString() + " Képátló: " + getKepatlo() + " cm";
        }
}
