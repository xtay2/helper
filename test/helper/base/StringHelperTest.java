package helper.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringHelperTest {

	@Test
	public void testOcc() {
		assertEquals(2, StringHelper.occ("na", "banana"));
		assertEquals(3, StringHelper.occ("a", "banana"));
		assertEquals(3, StringHelper.occ('a', "banana"));
		assertEquals(0, StringHelper.occ("a", "b"));
		assertEquals(0, StringHelper.occ("a", ""));
		assertEquals(0, StringHelper.occ("", "b"));
	}

	@Test
	public void testOccAtStart() {
		assertEquals(4, StringHelper.occAtStart('a', "aaaab"));
		assertEquals(0, StringHelper.occAtStart('a', "baaaab"));
		assertEquals(0, StringHelper.occAtStart('a', "b"));
		assertEquals(0, StringHelper.occAtStart('a', ""));
	}

	@Test
	public void testOccAtEnd() {
		assertEquals(4, StringHelper.occAtEnd('a', "baaaa"));
		assertEquals(0, StringHelper.occAtEnd('a', "baaaab"));
		assertEquals(0, StringHelper.occAtEnd('a', "b"));
		assertEquals(0, StringHelper.occAtEnd('a', ""));
	}

	@Test
	public void testOccAfter() {
		assertEquals(0, StringHelper.occAfter('a', 0, "xaaxaa"));
		assertEquals(2, StringHelper.occAfter('a', 1, "xaaxaa"));
		assertEquals(1, StringHelper.occAfter('a', 2, "xaaxaa"));
		assertEquals(0, StringHelper.occAfter('a', 3, "xaaxaa"));
	}

	@Test
	public void testOccBefore() {
		assertEquals(2, StringHelper.occBefore('a', 5, "xaaxaa"));
		assertEquals(1, StringHelper.occBefore('a', 4, "xaaxaa"));
		assertEquals(0, StringHelper.occBefore('a', 3, "xaaxaa"));
		assertEquals(2, StringHelper.occBefore('a', 2, "xaaxaa"));
	}

	@Test
	public void testRemove() {
		assertEquals("buge", StringHelper.remove("burger", 'r'));
		assertEquals("uge", StringHelper.remove("burger", 'b', 'r'));
		assertEquals("burger", StringHelper.remove("burger", 'x'));
		assertEquals("burger", StringHelper.remove("burger"));
	}

	@Test
	public void testRemoveAtStart() {
		assertEquals("baaa", StringHelper.removeLeading("aaabaaa", 'a'));
		assertEquals("baaa", StringHelper.removeLeading("baaa", 'a'));
		assertEquals("aaa", StringHelper.removeLeading("baaa", 'b'));
	}

	@Test
	public void testRemoveTrailing() {
		assertEquals("aaab", StringHelper.removeTrailing("aaabaaa", 'a'));
		assertEquals("b", StringHelper.removeTrailing("baaa", 'a'));
		assertEquals("baaa", StringHelper.removeTrailing("baaa", 'b'));
	}

	@Test
	public void testAppend() {
		assertTrue("aaaba".contentEquals(StringHelper.append("aaab", 'a')));
		assertTrue("ba".contentEquals(StringHelper.append("b", 'a')));
		assertTrue("baaab".contentEquals(StringHelper.append("baaa", 'b')));
	}

	@Test
	public void testStartsWith() {
		assertTrue(StringHelper.startsWith("baa", ""));
		assertTrue(StringHelper.startsWith("baa", "ba"));
		assertTrue(StringHelper.startsWith("baa", "baa"));
		assertTrue(StringHelper.startsWith("baa", "baaa"));
	}

	@Test
	public void testCommonPrefix() {
		assertEquals("baa", StringHelper.commonPrefix("baa", "baa"));
		assertEquals("ba", StringHelper.commonPrefix("baa", "ba"));
		assertEquals("ba", StringHelper.commonPrefix("ba", "baa"));
		assertEquals("ba", StringHelper.commonPrefix("ba", "ba"));
		assertEquals("", StringHelper.commonPrefix("ba", "aa"));
		assertEquals("", StringHelper.commonPrefix("ba", ""));
		assertEquals("", StringHelper.commonPrefix("", "aa"));
		assertEquals("", StringHelper.commonPrefix("", ""));
	}

	@Test
	public void testSpacesAfter() {
		assertEquals(3, StringHelper.spacesAfter("   ", 0));
		assertEquals(2, StringHelper.spacesAfter("   ", 1));
		assertEquals(1, StringHelper.spacesAfter("   ", 2));
		assertEquals(0, StringHelper.spacesAfter("   ", 3));
		assertEquals(1, StringHelper.spacesAfter("  x  ", 1));
	}

	@Test
	public void testSpacesBefore() {
		assertEquals(3, StringHelper.spacesBefore("   ", 3));
		assertEquals(2, StringHelper.spacesBefore("   ", 2));
		assertEquals(1, StringHelper.spacesBefore("   ", 1));
		assertEquals(0, StringHelper.spacesBefore("   ", 0));
		assertEquals(2, StringHelper.spacesBefore("  x  ", 2));
	}

	@Test
	public void testLeadingSpaces() {
		assertEquals(3, StringHelper.leadingSpaces("   "));
		assertEquals(1, StringHelper.leadingSpaces(" x   "));
		assertEquals(0, StringHelper.leadingSpaces(""));
	}

	@Test
	public void testTrailingSpaces() {
		assertEquals(3, StringHelper.trailingSpaces("   "));
		assertEquals(1, StringHelper.trailingSpaces("   x "));
		assertEquals(0, StringHelper.trailingSpaces(""));
	}
}
