package me.arui.datastruct.skiplist;


import org.junit.Test;

public class SkipListTest {

    @Test
    public void testInsertNode() {
        SkipList skipList = new SkipList();
        skipList.put(1, "2");
        System.out.println(skipList);
    }

}
