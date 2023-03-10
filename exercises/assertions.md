# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. La multiplication 3 * .4 produit le nombre 1.2000000000000002 au lieu de 1.2, ce qui met a false l'assertion.

2. La méthode assertEquals compare la valeur de deux objets en utilisant leur méthode equals. Elle considère que deux objets sont égaux s'ils ont la même valeur. En revanche la méthode assertSame, compare deux objets en vérifiant qu'ils sont exactement les mêmes objets en mémoire. 

3. On peut l'utiliser pour : 
- marquer une section de code qui doit être implémentée : on peut utiliser fail pour signaler qu'une méthode n'a pas encore été implémenté
- signaler qu'un test est invalide
- signaler qu'un comportement inattendu a été observé

4. assertThrows permet en plus de vérifier le type d'exception levé ainsi que de vérifier le message d'erreur.