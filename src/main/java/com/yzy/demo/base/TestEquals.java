package com.yzy.demo.base;

import java.util.Objects;

/**
 * @author young
 * @date 2019/10/16 10:07
 */
public class TestEquals {
    private int a;
    private String b;

    public TestEquals(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestEquals)) return false;
        TestEquals that = (TestEquals) o;
        return a == that.a &&
                Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void main(String[] args) {
        TestEquals obj1 = new TestEquals(1, "a");
        TestEquals obj2 = new TestEquals(1, "a");
        if (obj1.equals(obj2)) {
            System.out.println("equals");
        }
    }
}

