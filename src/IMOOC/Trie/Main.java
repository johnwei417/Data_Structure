package IMOOC.Trie;

/**
 * honglinwei created on 4/29/20 inside the package - IMOOC.Trie
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("Honglin");

        System.out.println(trie.contains("Honglin"));
        System.out.println(trie.isPrefix("Hong"));
    }
}
