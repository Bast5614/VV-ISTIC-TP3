# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

Implémentation de isBalenced :

```
public static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);

        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();

            if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
```


1. 
Deux parametres peuvent être pris en compte :

La Taille de la chaîne d'entrée:
- Chaîne vide ("")
- Chaîne de longueur impaire
- Chaîne de longueur paire 

Types de symboles :
- Chaîne contenant uniquement un type de symbole 
- Chaîne contenant plusieurs types de symboles mélangés
- Chaîne contenant des symboles et d'autres caractères


2. La taille de la chaîne d'entrée permeterons notament de tester les condition isEmpty())
Les types de symboles permetterons de passer dans tous les cas des if. Pour cela il faut créée autant de cas de test que de symbole disponible.
```
@Test
public void testEmptyString() {
assertTrue(isBalanced(""));
}

@Test
public void testOddLengthString() {
assertFalse(isBalanced("()()("));
}

@Test
public void testEvenLengthString() {
assertTrue(isBalanced("()()"));
}

@Test
public void testSingleSymbolType() {
assertTrue(isBalanced("()[]{}"));
}

@Test
public void testMixedSymbolType() {
assertTrue(isBalanced("({[]})"));
assertFalse(isBalanced("({[})"));
}

@Test
public void testMixedSymbolAndOtherCharacters() {
assertTrue(isBalanced("a(b[c]d)e{f}"));
assertFalse(isBalanced("a(b[c]d}e{f}"));
}
```

4.   Resultat de PIT
```
Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 14 Killed 14 (100%)
> KILLED 14 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
================================================================================
- Timings
  ================================================================================
> pre-scan for mutations : < 1 second
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : < 1 second
--------------------------------------------------------------------------------
> Total  : 1 seconds
--------------------------------------------------------------------------------
================================================================================
- Statistics
  ================================================================================
>> Line Coverage: 11/13 (85%)
>> Generated 19 mutations Killed 18 (95%)
>> Mutations with no coverage 1. Test strength 100%
>> Ran 28 tests (1.47 tests per mutation)
Enhanced functionality available at https://www.arcmutate.com/
```

Pour augmenter le score de 85% j'ai ajouté ces tests.
```
@Test
public void testNegateConditionalsMutant() {
assertFalse(isBalanced("]"));
}

@Test
public void testReplaceGreaterThanMutant() {
assertFalse(isBalanced("{(])"));
}

@Test
public void testRemoveConditionalMutant1() {
assertFalse(isBalanced("("));
}

@Test
public void testRemoveConditionalMutant2() {
assertFalse(isBalanced("}"));
}

@Test
public void testReplaceAssignmentWithIncrementMutant() {
assertFalse(isBalanced("([)"));
}
```

Je suis passé à 92%.