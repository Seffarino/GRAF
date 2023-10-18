package m1graf2023;

public interface edge_interface {
    Node getFrom(); // Récupérer le nœud source de l'arête.
    Node getTo();   // Récupérer le nœud cible de l'arête.
    int getWeight(); // Récupérer le poids de l'arête.
    Node from(); // Récupérer le nœud source de l'arête.
    Node to();   // Récupérer le nœud cible de l'arête.
    Edge getSymmetric(); // Obtenir le symétrique de l'arête en tant qu'instance Edge.
    boolean isSelfLoop(); // Vérifier si l'arête est une boucle (self-loop).
    boolean isWeighted(); // Vérifier si l'arête est pondérée.

}