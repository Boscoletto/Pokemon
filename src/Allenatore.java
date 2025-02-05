import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Allenatore {
    private List<Pokemon> pokemons;
    private Random random;

    public Allenatore() {
        pokemons = new ArrayList<>();
        random = new Random();
    }

    public void aggiungiPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Pokemon scegliPokemon() {
        return pokemons.get(random.nextInt(pokemons.size()));
    }

    public boolean haPokemonDisponibili() {
        return pokemons.size() > 0;
    }

    public void rimuoviPokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }
}
