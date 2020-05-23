package com.dream.ltl.app.iterator;

public class App {
    public static void main(String[] args) {
        Course course = new Course("Java");
        Course python = new Course("python");
        Course ai = new Course("AI");

        ICourseAggregate aggregate = new CourseAggregateImpl();
        aggregate.add(course);
        aggregate.add(python);
        aggregate.add(ai);

        System.out.println("===========课程列表=========");
        printCourse(aggregate);
        System.out.println("===========删除java后课程列表=========");
        aggregate.remove(course);
        printCourse(aggregate);
    }

    private static void printCourse(ICourseAggregate aggregate) {
        Iterator<Course> iterator = aggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
