package simpleTest;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SimpleTest {

	public SimpleTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	private void paralleSteam() {

		Arrays.asList("a1", "a2", "b1", "c2", "c1").stream().filter(s-> {
			return s.length()>1;}).forEach(s->System.out.println(s));	// plus sorted
		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).sorted((s1, s2) -> {
			System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}

	@Test
	public void simple() {
		int i= 1;
		int j=2;
		assertTrue(i+j==3);
	}
	@Test
	public void simpleFail() {
		int i= 1;
		int j=2;
		assertTrue(i+j==4);
	}
	@Test
	public void simpleFail2() {
		int i= 1;
		int j=2;
		assertTrue(i+j==4);
	}
}
