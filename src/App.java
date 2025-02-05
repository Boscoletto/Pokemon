import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Allenatore allenatore1 = new Allenatore();
        allenatore1.aggiungiPokemon(new Pikachu());
        allenatore1.aggiungiPokemon(new Bulbasaur());

        Allenatore allenatore2 = new Allenatore();
        allenatore2.aggiungiPokemon(new Charizard());
        allenatore2.aggiungiPokemon(new Squirtle());
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        while (allenatore1.haPokemonDisponibili() && allenatore2.haPokemonDisponibili()) {
            
            Pokemon pokemon1 = allenatore1.scegliPokemon();
            Pokemon pokemon2 = allenatore2.scegliPokemon();
            System.out.println("Inizia la battaglia tra " + pokemon1.nome + " e " + pokemon2.nome);

          
            while (pokemon1.èVivo() && pokemon2.èVivo()) {
                
                System.out.println("\nCosa vuole fare " + pokemon1.nome + " (contro " + pokemon2.nome + ")?");
                System.out.println("1. Attaccare");
                System.out.println("2. Eseguire Mossa Speciale");
                
               
                if (pokemon1 instanceof ICorazzato) {
                    System.out.println("3. Difendersi (Attiva Corazza)");
                }

                System.out.print("Scegli un'azione: ");
                int scelta1 = scanner.nextInt();
                switch (scelta1) {
                    case 1:
                        pokemon1.attacca(pokemon2);
                        break;
                    case 2:
                        pokemon1.eseguiMossaSpeciale(pokemon2);
                        break;
                    case 3:
                        if (pokemon1 instanceof ICorazzato) {
                            ((ICorazzato) pokemon1).attivaCorazza();
                        } else {
                            System.out.println(pokemon1.nome + " non può attivare la Corazza!");
                        }
                        break;
                    default:
                        System.out.println("Azione non valida. L'allenatore ha scelto di attaccare.");
                        pokemon1.attacca(pokemon2);
                        break;
                }

                pokemon2.visualizzaStato();
                if (!pokemon2.èVivo()) {
                    System.out.println(pokemon2.nome + " è stato sconfitto!");
                    allenatore2.rimuoviPokemon(pokemon2); 
                    if (allenatore2.haPokemonDisponibili()) {
                        pokemon2 = allenatore2.scegliPokemon(); 
                        System.out.println("L'allenatore 2 ha scelto " + pokemon2.nome);
                    }
                    break;
                }

               
                System.out.println("\nCosa vuole fare " + pokemon2.nome + " (contro " + pokemon1.nome + ")?");
                System.out.println("1. Attaccare");
                System.out.println("2. Eseguire Mossa Speciale");

              
                if (pokemon2 instanceof ICorazzato) {
                    System.out.println("3. Difendersi (Attiva Corazza)");
                }

                System.out.print("Scegli un'azione: ");
                int scelta2 = scanner.nextInt();
                switch (scelta2) {
                    case 1:
                        pokemon2.attacca(pokemon1);
                        break;
                    case 2:
                        pokemon2.eseguiMossaSpeciale(pokemon1);
                        break;
                    case 3:
                        if (pokemon2 instanceof ICorazzato) {
                            ((ICorazzato) pokemon2).attivaCorazza();
                        } else {
                            System.out.println(pokemon2.nome + " non può attivare la Corazza!");
                        }
                        break;
                    default:
                        System.out.println("Azione non valida. L'allenatore ha scelto di attaccare.");
                        pokemon2.attacca(pokemon1);
                        break;
                }

                pokemon1.visualizzaStato();
                if (!pokemon1.èVivo()) {
                    System.out.println(pokemon1.nome + " è stato sconfitto!");
                    allenatore1.rimuoviPokemon(pokemon1);
                    if (allenatore1.haPokemonDisponibili()) {
                        pokemon1 = allenatore1.scegliPokemon();
                        System.out.println("L'allenatore 1 ha scelto " + pokemon1.nome);
                    }
                    break;
                }
            }

            if (pokemon1.èVivo()) {
                pokemon1.incrementaVittorie();
                pokemon1.evolvi();
            } else if (pokemon2.èVivo()) {
                pokemon2.incrementaVittorie();
                pokemon2.evolvi();
            }
        }

        if (allenatore1.haPokemonDisponibili()) {
            System.out.println("L'allenatore 1 ha vinto!");
        } else if (allenatore2.haPokemonDisponibili()) {
            System.out.println("L'allenatore 2 ha vinto!");
        } else {
            System.out.println("Pareggio!");
        }

        scanner.close();
    }
}
