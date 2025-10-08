package com.epam.practice;

public class PrivateInnerClassTest {
    private class InnerPrivateClass {
        public InnerPrivateClass() {
        }

        private InnerPrivateClass(int s) {
        }

        private static void f(){
        }

        private void g(){
        }

        public void h(){
        }

        protected void i(){}

        void j(){}

    }

    private static class InnerPrivateStaticClass {
        public InnerPrivateStaticClass() {
            InnerPrivateClass.f();
        }

        private InnerPrivateStaticClass(int s) {
        }

        private static void f(){
        }

        private void g(){
        }

        public void h(){
        }

        protected void i(){}

        void j(){}

    }

    public class InnerPublicClass {
        public InnerPublicClass() {
            InnerPrivateClass innerPrivateClass=new InnerPrivateClass(2);
        }

        private InnerPublicClass(int s) {
        }

        public static void e(){
        }

        private static void f(){
        }

        private void g(){
        }

        public void h(){
        }

        protected void i(){}

        void j(){}

    }

    public static class InnerPublicStaticClass {
        public InnerPublicStaticClass() {
           // InnerPrivateClass innerPrivateClass=new InnerPrivateClass(2);
        }

        private InnerPublicStaticClass(int s) {
        }

        public static void e(){
        }

        private static void f(){
        }

        private void g(){
        }

        public void h(){
        }

        protected void i(){}

        void j(){}

    }

}

