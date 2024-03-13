## Домашнее задание по теме Разбор алгоритмов (д/з 11)
Даны два класса
public enum Position {
MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER
}
Написать класс PersonDataBase, содержащий список Person, и имеющий следующие методы, со
следующей асимптотической сложностью (методу и конструктор класса Person реализовать
самостоāтельно)
* Person findById(Long id) - найти Person по id - O(1)
* void add(Person person) - добавить Person - O(1)
* isManager(Person person) - O(1) - true если Position : MANAGER, DIRECTOR,
  BRANCH_DIRECTOR или SENIOR_MANAGER
* isEmployee(Long id) - O(1) - true если Employee имеет любой другой Position

Написать класс со статическим методом, реализующим сортировку массива
* bubbleSort(int array[]) - методом пузырька