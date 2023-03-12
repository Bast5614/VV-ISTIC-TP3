# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

Méthode Date(int day, int month, int year)
- (1, 1, 1) : jour minimum, mois minimum, année minimum
- (1, 1, 1582) : jour minimum, mois minimum, année d'introduction du calendrier grégorien
- (31, 12, 9999) : jour maximum, mois maximum, année maximum
- (29, 2, 2020) : cas valide pour année bissextile
- (29, 2, 2021) : cas invalide pour année non-bissextile
- (30, 2, 2020) : cas invalide pour février (mois avec maximum de 29 jours)
- (31, 4, 2020) : cas invalide pour avril (mois avec maximum de 30 jours)

Méthode isValidDate(int day, int month, int year)
- (1, 1, 1) : jour minimum, mois minimum, année minimum
- (1, 1, 1582) : jour minimum, mois minimum, année d'introduction du calendrier grégorien
- (31, 12, 9999) : jour maximum, mois maximum, année maximum
- (29, 2, 2020) : cas valide pour année bissextile
- (29, 2, 2021) : cas invalide pour année non-bissextile
- (30, 2, 2020) : cas invalide pour février (mois avec maximum de 29 jours)
- (31, 4, 2020) : cas invalide pour avril (mois avec maximum de 30 jours)

Méthode isLeapYear(int year)
- 1 : année non-bissextile
- 4 : année bissextile
- 100 : année non-bissextile
- 400 : année bissextile

Méthode compareTo(Date other)
- date égale à other
- date antérieure à other
- date postérieure à other


1er essais avec PIT : Line Coverage: 29/59 (49%)

Pour augmenter ce taux on peut :
Pour Date : Ajouter des valeurs négatives
Pour compareTo(Date other) :
- Tester la comparaison de deux dates ayant des années différentes mais des mois et des jours identiques
- Tester la comparaison de deux dates ayant des mois différents mais des années et des jours identiques
- Tester la comparaison de deux dates ayant des jours différents mais des mois et des années identiques
- Tester la comparaison de deux dates avec des dates null
- Tester la comparaison de deux dates avec une date null et une date non-null
- Tester la comparaison de deux dates avec des années négatives.

Nous sommes passé a une couverture de 53%