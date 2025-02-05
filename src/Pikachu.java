class Pikachu extends Pokemon implements IEvolvibile, IAttaccoSpeciale {

    public Pikachu() {
        super("Pikachu", "Elettrico", 100, 40, 30);
    }

    @Override
    public void attacca(Pokemon avversario) {
        // Logica dell'attacco, ad esempio con una formula semplice
        int danno = this.puntiAttacco - avversario.puntiDifesa;
        if (avversario.tipo.equals("Acqua")) danno *= 1.25;
        avversario.subisciDanno(danno);
    }

    @Override
    public void evolvi() {
        if (puòEvolvere()) {
            this.nome = "Raichu";
            this.puntiAttacco += 20;
            this.puntiSalute += 50;
            this.puntiDifesa += 10;
            System.out.println(nome + " si è evoluto in Raichu!");
        } else {
            System.out.println(nome + " non ha abbastanza vittorie per evolversi.");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        // Danno maggiore per mossa speciale
        int danno = (this.puntiAttacco * 2) - avversario.puntiDifesa;
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato una mossa speciale!");
    }
}
