package estruturadados.mapa;

public class Mapa<K, V> {
  private ListaEncadeada<Associacao<K, V>> lista;

  public Mapa() {
    this.lista = new ListaEncadeada<>();
  }

  public boolean estaVazio() {
    return this.lista.getTamanho() == 0;
  }

  public int tamanho() {
    return this.lista.getTamanho();
  }

  public V inserir(K chave, V valor) {
    // Percorre a lista para ver se a chave já existe
    for (int i = 0; i < lista.getTamanho(); i++) {
      Associacao<K, V> associacao = lista.buscaPorPosicao(i);
      if (associacao.getChave().equals(chave)) {
        V valorAntigo = associacao.getValue();
        associacao.setValue(valor); // Atualiza o valor se a chave já existir
        return valorAntigo;
      }
    }
    // Se a chave não existir, adiciona uma nova associação no final
    lista.adiciona(new Associacao<>(chave, valor));
    return null;
  }

  public V buscar(K chave) {
    for (int i = 0; i < lista.getTamanho(); i++) {
      Associacao<K, V> associacao = lista.buscaPorPosicao(i);
      if (associacao.getChave().equals(chave)) {
        return associacao.getValue();
      }
    }
    return null; // Retorna null se não encontrar
  }

  public V remover(K chave) {
    for (int i = 0; i < lista.getTamanho(); i++) {
      Associacao<K, V> associacao = lista.buscaPorPosicao(i);
      if (associacao.getChave().equals(chave)) {
        Associacao<K, V> removida = lista.remove(i);
        return removida.getValue();
      }
    }
    return null;
  }

  public ListaEncadeada<K> chaves() {
    ListaEncadeada<K> chaves = new ListaEncadeada<>();
    for (int i = 0; i < lista.getTamanho(); i++) {
      chaves.adiciona(lista.buscaPorPosicao(i).getChave());
    }
    return chaves;
  }

  public ListaEncadeada<V> valores() {
    ListaEncadeada<V> valores = new ListaEncadeada<>();
    for (int i = 0; i < lista.getTamanho(); i++) {
      valores.adiciona(lista.buscaPorPosicao(i).getValue());
    }
    return valores;
  }

  @Override
  public String toString() {
    return lista.toString();
  }
}