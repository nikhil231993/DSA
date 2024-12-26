package leetcode.designPatterns.oopsConcepts.cloningTest;

interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}
