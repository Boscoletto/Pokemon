class Charizard extends Pokemon implements IEvolvibile, IAttaccoSpeciale, IVolante {

    public Charizard() {
        super("Charizard", "Fuoco", 150, 60, 40);
    }

    @Override
    public void attacca(Pokemon avversario) {
        int danno = this.puntiAttacco - avversario.puntiDifesa;
        if (avversario.tipo.equals("Erba"))
            danno *= 1.25;
        avversario.subisciDanno(danno);
    }

    @Override
    public void evolvi() {
        if (puòEvolvere()) {
            this.nome = "Mega Charizard";
            this.puntiAttacco += 30;
            this.puntiSalute += 80;
            this.puntiDifesa += 20;
            System.out.println(nome + " si è evoluto in Mega Charizard!");
        } else {
            System.out.println(nome + " non ha abbastanza vittorie per evolversi.");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        int danno = (this.puntiAttacco * 2) - avversario.puntiDifesa;
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato una mossa speciale infuocata!");
    }

    @Override
    public void vola() {
        System.out.println(nome + " sta volando! L'avversario non può attaccare nel prossimo turno.");
    }
}
