class Bulbasaur extends Pokemon implements IEvolvibile, IAttaccoSpeciale {

    public Bulbasaur() {
        super("Bulbasaur", "Erba", 120, 40, 30);
    }

    @Override
    public void attacca(Pokemon avversario) {
        // Logica dell'attacco, ad esempio con una formula semplice
        int danno = this.puntiAttacco - avversario.puntiDifesa;
        if (avversario.tipo.equals("Acqua") || avversario.tipo.equals("Terra")) {
            danno *= 1.25;
        }
        avversario.subisciDanno(danno);
    }

    @Override
    public void evolvi() {
        if (puòEvolvere()) {
            this.nome = "Ivysaur";
            this.puntiAttacco += 20;
            this.puntiSalute += 50;
            this.puntiDifesa += 10;
            System.out.println(nome + " si è evoluto in Ivysaur!");
        } else {
            System.out.println(nome + " non ha abbastanza vittorie per evolversi.");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        // Danno maggiore per mossa speciale (ad esempio Attacco Solare)
        int danno = (this.puntiAttacco * 2) - avversario.puntiDifesa;
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato una mossa speciale: Attacco Solare!");
    }
}
