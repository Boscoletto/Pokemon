class Squirtle extends Pokemon implements IEvolvibile, IAttaccoSpeciale {

    public Squirtle() {
        super("Squirtle", "Acqua", 110, 35, 40);
    }

    @Override
    public void attacca(Pokemon avversario) {
        // Logica dell'attacco, ad esempio con una formula semplice
        int danno = this.puntiAttacco - avversario.puntiDifesa;
        if (avversario.tipo.equals("Fuoco")) {
            danno *= 1.25;
        }
        avversario.subisciDanno(danno);
    }

    @Override
    public void evolvi() {
        if (puòEvolvere()) {
            this.nome = "Wartortle";
            this.puntiAttacco += 20;
            this.puntiSalute += 50;
            this.puntiDifesa += 10;
            System.out.println(nome + " si è evoluto in Wartortle!");
        } else {
            System.out.println(nome + " non ha abbastanza vittorie per evolversi.");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        // Danno maggiore per mossa speciale (ad esempio idoneo per attacco idrico potente)
        int danno = (this.puntiAttacco * 2) - avversario.puntiDifesa;
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato una mossa speciale: Idronato!");
    }
}
