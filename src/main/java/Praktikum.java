public class Praktikum {
    public static void main(String[] args) {
        String name = "Малыш Котопёс";
        //Задаём имя из 13 символов с единственным пробелом между ними
        Account account = new Account(name);
        account.checkNameToEmboss(name);
    }
}