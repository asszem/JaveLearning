package ClassesAndObjects.Practice.H_Ch13_GenericTypes.BinaryTree.BinaryTreeFlexible;

/**
 *
 * @author Andras Olah (olahandras78@gmail.com)
 */
public class TryParameterizedMethodsBinaryTree {

	public static void main(String[] args) {

		FlexibleAscDescSortableBinaryTree<Person> people = new FlexibleAscDescSortableBinaryTree<>();

		// Create and add some Manager objects
		Manager[] managers = {new Manager("Jane", 1), new Manager("Joe", 3),
			new Manager("Freda", 3)};
		for (Manager manager : managers) {
			people.add(manager);
		}

		// Create and add some Person objects
		Person[] persons = {new Person("Will"), new Person("Ann"), new Person("Mary"),
			new Person("Tina"), new Person("Stan")};
		for (Person person : persons) {
			people.add(person);
		}

		final boolean ASCENDING = true;
		listAll(people.sort(ASCENDING));  // List the sorted contents of the tree
	}

	// Parameterized method to list the elements in any linked list
	public static <T> void listAll(LinkedList<T> list) {
		for (T obj : list) {
			System.out.println(obj);
		}
	}
}
