abstract class Pokemon {
    protected String nome;
    protected String tipo;
    protected int puntiSalute;
    protected int puntiAttacco;
    protected int puntiDifesa;
    protected int vittorie;

    public Pokemon(String nome, String tipo, int puntiSalute, int puntiAttacco, int puntiDifesa) {
        this.nome = nome;
        this.tipo = tipo;
        this.puntiSalute = puntiSalute;
        this.puntiAttacco = puntiAttacco;
        this.puntiDifesa = puntiDifesa;
        this.vittorie = 0;
    }

    public abstract void attacca(Pokemon avversario);

    public void subisciDanno(int danno) {
        this.puntiSalute -= danno;
        if (this.puntiSalute < 0) this.puntiSalute = 0;
    }

    public void visualizzaStato() {
        System.out.println(nome + " - Salute: " + puntiSalute + " | Attacco: " + puntiAttacco + " | Difesa: " + puntiDifesa);
    }

    public boolean èVivo() {
        return this.puntiSalute > 0;
    }

    public boolean puòEvolvere() {
        return vittorie >= 3;
    }

    public void incrementaVittorie() {
        vittorie++;
    }

    public void evolvi() {
        if (puòEvolvere()) {
            System.out.println(nome + " si è evoluto!");
            // Modificare le statistiche durante l'evoluzione (a seconda del Pokémon)
            this.puntiAttacco += 20;
            this.puntiSalute += 50;
            this.puntiDifesa += 10;
        }
    }

    public abstract void eseguiMossaSpeciale(Pokemon avversario);
}
